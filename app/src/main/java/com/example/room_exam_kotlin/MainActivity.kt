package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase :: class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        tv.text = db.todoDao().getAll().toString()

        btn.setOnClickListener {
            db.todoDao().insert(Todo(edt.text.toString()))
            tv.text = db.todoDao().getAll().toString()
        }

    }
}