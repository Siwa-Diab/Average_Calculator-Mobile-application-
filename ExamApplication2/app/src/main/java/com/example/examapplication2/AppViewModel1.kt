package com.example.examapplication2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AppViewModel1(val studentDao: StudentDao,val gradeDao: GradeDao):ViewModel() {

    var newFirstName = ""
    var newFamilyName = ""

    fun addStudent() {
        viewModelScope.launch {
            val student = Student()
            student.firstName = newFirstName
            student.familyName = newFamilyName
            studentDao.insert(student)
        }
    }

    var newCourseName = ""
    var newCourseGrade = ""

    private val grades: LiveData<List<Grade>> = gradeDao.getAll()

    val gradesString: LiveData<String> = grades.map { grades ->
        formatGrades(grades)
    }

    fun addGrade() {
        viewModelScope.launch {
            val grade = Grade()
            grade.courseName = newCourseName
            grade.courseGrade = newCourseGrade
            gradeDao.insert(grade)
        }
    }

    fun deleteAllMaterials() {
        viewModelScope.launch {
            gradeDao.deleteAll()
            Log.d("AppViewModel1", "All materials deleted successfully")
        }
    }

    fun getAllGrades(): LiveData<List<Grade>> {
        return grades
    }


    fun formatGrades(grades: List<Grade>): String {
        return grades.fold("") { str, item ->
            str + '\n' + formatGrade(item)
        }
    }

    fun deleteMaterialByCourseName(courseName: String) {
        viewModelScope.launch {
            gradeDao.deleteByCourseName(courseName)
            Log.d("AppViewModel1", "Material with course name $courseName deleted successfully")
        }
    }

    fun formatGrade(grade: Grade): String {

        var str =  "- ${grade.courseName}" + " --> " +"${grade.courseGrade}" +" / "+"100 "+"\n"
        return str
    }
}