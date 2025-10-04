package com.example.examapplication2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Query("SELECT * FROM Student ")
    fun getAll():LiveData<List<Student>>


}