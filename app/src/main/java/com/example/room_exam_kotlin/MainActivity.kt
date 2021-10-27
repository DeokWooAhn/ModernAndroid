package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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

        // 관찰하면서 UI 변경
        db.todoDao().getAll().observe(this, Observer {
            tv.text = it.toString()
        })


        btn.setOnClickListener {
            db.todoDao().insert(Todo(edt.text.toString()))
        }
    }
}