package com.example.examapplication2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GradeDao {

    @Insert
    suspend fun insert(grade: Grade)

    @Delete
    suspend fun delete(grade: Grade)

    @Update
    suspend fun update(grade: Grade)

    @Query("SELECT * FROM Grade WHERE IDcourse = :key")
    fun get(key: Long): LiveData<Grade>

    @Query("SELECT * FROM Grade ORDER BY IDcourse DESC")
    fun getAll():LiveData<List<Grade>>

    @Query("DELETE FROM Grade")
    suspend fun deleteAll()

    @Query("DELETE FROM Grade WHERE courseName = :name")
    suspend fun deleteByCourseName(name: String)

}