package com.example.ex2.theme

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//class kế thừa và mở rộng của SQLiteHeplper
class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "course.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_COURSES = "Courses"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
       //tao table
        val createTableStatement =  "CREATE TABLE $TABLE_COURSES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_DESCRIPTION TEXT)"
        db.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //xoa table
        db.execSQL("DROP TABLE IF EXISTS $TABLE_COURSES")
        onCreate(db)
    }

    fun addCourse(course: Course) : Boolean {
        val db = this.writableDatabase

        //get value
        val contentValues = ContentValues().apply {
            put(COLUMN_NAME, course.name)
            put(COLUMN_DESCRIPTION, course.description)
        }

        //insert
        val result = db.insert(TABLE_COURSES, null, contentValues)
        db.close()
        return result != -1L //return true if insert thành công
    }

    @SuppressLint("Range")
    fun getCourse() : List<Course> {
        val courseList  = mutableListOf<Course>()
        val db = this.readableDatabase

        //read course
        val cursor : Cursor = db.rawQuery("SELECT 8 FROM $TABLE_COURSES", null)

        //add to list
        if(cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return courseList
    }

    fun updateCourse(course: Course) : Boolean {
        val db = this.writableDatabase

        //get value
        val contentValues = ContentValues().apply {
            put(COLUMN_NAME, course.name)
            put(COLUMN_DESCRIPTION, course.description)
        }

        //update course
        val result = db.update(TABLE_COURSES, contentValues, "$COLUMN_ID = ?", arrayOf(course.id.toString()))

        db.close()
        return result > 0 //return true if result > 0
    }

    fun deleteCourse(id:Int): Boolean {
        val db = this.writableDatabase

        //delete course
        val result = db.delete(TABLE_COURSES, "$COLUMN_ID = ?", arrayOf(id.toString()))

        db.close()
        return  result > 0
    }
}