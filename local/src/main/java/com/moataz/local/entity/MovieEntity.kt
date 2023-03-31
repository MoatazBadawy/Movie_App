package com.moataz.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moataz.local.entity.utils.EntityConstant.MOVIES_TABLE

@Entity(tableName = MOVIES_TABLE)
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val posterPath: String,
    val type: String,
)
