package com.example.examapplication2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(

    @PrimaryKey(autoGenerate = true)
    var IDstd:Long = 0L,

    @ColumnInfo(name = "firstName")
    var firstName:String = "",

    @ColumnInfo(name = "familyName")
    var familyName: String = ""

)


