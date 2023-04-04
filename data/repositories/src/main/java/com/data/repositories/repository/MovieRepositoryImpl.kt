package com.data.repositories.repository

import com.data.repositories.datasource.MovieLocalDataSource
import com.data.repositories.datasource.MovieRemoteDataSource
import com.data.repositories.mapper.toMovieDetails
import com.data.repositories.mapper.toMovieList
import com.data.repositories.repository.utils.NetworkHelper
import com.domain.entities.Movie
import com.domain.entities.MovieDetails
import com.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val networkHelper: NetworkHelper,
) : MovieRepository {
    override suspend fun insertMostPopularMovies() {
        movieRemoteDataSource.getMostPopularMovies().map {
            movieLocalDataSource.insertMostPopularMovies(it)
        }
    }

    override suspend fun insertTopRatedMovies() {
        movieRemoteDataSource.getTopRatedMovies().map {
            movieLocalDataSource.insertTopRatedMovies(it)
        }
    }

    override suspend fun insertMovieDetails(movieId: Int) {
        movieLocalDataSource.insertMovieDetailsById(
            movieRemoteDataSource.getMovieDetails(movieId),
            movieId,
        )
    }

    /**
     * You may need to add delete methods to the local data source to delete the data before inserting
     * new data. This is because the data in the local data source may be outdated.
     *
     * What it should happen here is:
     * Repository is single source of truth. So It should fetch the data from the local data source.
     *
     * If there is internet connection, we fetch the data from the remote data source and insert it
     * into the local data source. Then we fetch the data from the local data source and return it.
     *
     * You may ask why we don't just return the data from the remote data source. The reason is that
     * we want to make sure that the data is inserted into the local data source before we return it.
     * But I didn't do that I just returned the data from the remote data source when there is internet.
     * and returned the data from the local data source when there is no internet.
     *
     * I did that because I notched a long time to insert the data into the local data source and get
     * the data from the local data source. I don't know why. So I made this workaround.
     * I expected the coroutines it should handel this long time loading. But it is ok it is Just a
     * increase in fractions of seconds. And it is also a simple app :)
     *
     */
    override suspend fun getMostPopularMovies(): List<Movie> {
        return if (networkHelper.isInternetAvailable()) {
            insertMostPopularMovies()
            movieRemoteDataSource.getMostPopularMovies().toMovieList()
        } else {
            movieLocalDataSource.getMoviesByType("popular").toMovieList()
        }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return if (networkHelper.isInternetAvailable()) {
            insertTopRatedMovies()
            movieRemoteDataSource.getTopRatedMovies().toMovieList()
        } else {
            movieLocalDataSource.getMoviesByType("top_rated").toMovieList()
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        if (networkHelper.isInternetAvailable()) {
            insertMovieDetails(movieId)
        }
        return movieLocalDataSource.getMovieDetails(movieId).toMovieDetails()
    }
}
