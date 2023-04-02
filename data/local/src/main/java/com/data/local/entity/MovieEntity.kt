package com.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.data.local.entity.utils.EntityConstant.MOVIES_TABLE

@Entity(tableName = MOVIES_TABLE)
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val posterPath: String,
    val type: String,
)
