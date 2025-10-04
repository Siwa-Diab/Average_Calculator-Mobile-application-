package com.example.examapplication2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppViewModelFactory(private val studentDao: StudentDao,private val gradeDao: GradeDao):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AppViewModel1::class.java)){
            return AppViewModel1(studentDao,gradeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}