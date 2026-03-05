package com.example.sqlitecrud

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "StudentDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = "CREATE TABLE student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT)"

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS student")
        onCreate(db)
    }

    // INSERT
    fun insertData(name: String, email: String): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put("name", name)
        values.put("email", email)

        val result = db.insert("student", null, values)

        return result != -1L
    }

    // READ
    fun getAllData() = readableDatabase.rawQuery("SELECT * FROM student", null)

    // UPDATE
    fun updateData(id: String, name: String, email: String): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put("name", name)
        values.put("email", email)

        db.update("student", values, "id=?", arrayOf(id))
        return true
    }

    // DELETE
    fun deleteData(id: String): Int {
        val db = this.writableDatabase
        return db.delete("student", "id=?", arrayOf(id))
    }
}