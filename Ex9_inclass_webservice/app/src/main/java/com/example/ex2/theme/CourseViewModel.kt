package com.example.ex2.theme

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class CourseViewModel : ViewModel() {
    var courseList by mutableStateOf(listOf<Course>())
        private set

    private var database = mutableListOf<Course>()
    private var nextId = 1

    // Thêm khóa học
    fun addCourse(name: String, description: String) {
        val newCourse = Course(nextId++, name, description)
        database.add(newCourse)
        courseList = database.toList()
    }

    // Cập nhật khóa học
    fun updateCourse(id: Int, name: String, description: String) {
        val index = database.indexOfFirst { it.id == id }
        if (index != -1) {
            database[index] = Course(id, name, description)
            courseList = database.toList()
        }
    }

    // Xóa khóa học
    fun deleteCourse(id: Int) {
        database.removeAll { it.id == id }
        courseList = database.toList()
    }
}