package com.example.examapplication2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class, Grade::class], version = 7, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val studentDao:StudentDao
    abstract val gradeDao: GradeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "apps_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}