package com.example.examapplication2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Grade")
data class Grade(

    @PrimaryKey(autoGenerate = true)
    var IDcourse : Long = 0L,

    @ColumnInfo(name = "courseName")
    var courseName : String = "",

    @ColumnInfo(name = "courseGrade")
    var courseGrade: String = "",

)
