package com.example.midterm_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.content.SharedPreferences
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var departmentSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        nameEditText = findViewById(R.id.etName)
        ageEditText = findViewById(R.id.etAge)
        genderEditText = findViewById(R.id.etGender)
        dobEditText = findViewById(R.id.etDOB)
        departmentSpinner = findViewById(R.id.spinnerDepartment) // Initialize the Spinner

        val saveButton = findViewById<Button>(R.id.btnSave)
        loadPreferences()

        saveButton.setOnClickListener { savePreferences() }
    }

    private fun savePreferences() {
        val editor = sharedPreferences.edit()
        val name = nameEditText.text.toString()
        val ageText = ageEditText.text.toString()
        val gender = genderEditText.text.toString()
        val dob = dobEditText.text.toString()
        val department = departmentSpinner.selectedItem.toString()


        if (name.isEmpty()) {
            nameEditText.error = "Name is required"
            return
        }

        if (ageText.isEmpty()) {
            ageEditText.error = "Age is required"
            return
        }

        val age = ageText.toIntOrNull()
        if (age == null || age <= 0) {
            ageEditText.error = "Invalid age"
            return
        }

        editor.putString("name", name)
        editor.putInt("age", age)
        editor.putString("gender", gender)
        editor.putString("dob", dob)
        editor.putString("department", department)

        if (editor.commit()) {
            Toast.makeText(this, "Preferences saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Failed to save preferences", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadPreferences() {
        nameEditText.setText(sharedPreferences.getString("name", ""))
        ageEditText.setText(sharedPreferences.getInt("age", 0).toString())
        genderEditText.setText(sharedPreferences.getString("gender", ""))
        dobEditText.setText(sharedPreferences.getString("dob", ""))

        val department = sharedPreferences.getString("department", "")
        val adapter = ArrayAdapter.createFromResource(this, R.array.departments, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        departmentSpinner.adapter = adapter

        if (department != null) {
            val position = adapter.getPosition(department)
            departmentSpinner.setSelection(position)
        } else {
            departmentSpinner.setSelection(0)
        }

    }
}
