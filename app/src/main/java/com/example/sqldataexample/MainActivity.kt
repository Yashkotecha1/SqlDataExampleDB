package com.example.sqldataexample

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlitecrud.DatabaseHelper

class MainActivity : AppCompatActivity() {

    lateinit var db: DatabaseHelper
    lateinit var etId: EditText
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var btnInsert: Button
    lateinit var btnView: Button
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)

        etId = findViewById(R.id.etId)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)

        btnInsert = findViewById(R.id.btnInsert)
        btnView = findViewById(R.id.btnView)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        // INSERT
        btnInsert.setOnClickListener {

            val result = db.insertData(
                etName.text.toString(),
                etEmail.text.toString()
            )

            if (result)
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }

        // VIEW
        btnView.setOnClickListener {

            val cursor = db.getAllData()

            if (cursor.count == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var data = ""

            while (cursor.moveToNext()) {
                data += "ID: ${cursor.getString(0)}\n"
                data += "Name: ${cursor.getString(1)}\n"
                data += "Email: ${cursor.getString(2)}\n\n"
            }

            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }

        // UPDATE
        btnUpdate.setOnClickListener {

            db.updateData(
                etId.text.toString(),
                etName.text.toString(),
                etEmail.text.toString()
            )

            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
        }

        // DELETE
        btnDelete.setOnClickListener {

            val deletedRows = db.deleteData(etId.text.toString())

            if (deletedRows > 0)
                Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show()
        }
    }
}