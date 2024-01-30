package com.sanjoo.todoapplication.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanjoo.todoapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var rv:RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var btnAdd:Button
    private lateinit var btnDelete:Button
    private lateinit var et:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd=findViewById(R.id.btnAddTodo)
        btnDelete=findViewById(R.id.btnDeleteTodo)
        et=findViewById(R.id.etAddText)

        rv=findViewById(R.id.rvTodoList)
        todoAdapter= TodoAdapter(mutableListOf())
        rv.adapter=todoAdapter
        rv.layoutManager=LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val todoTitle=et.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo= Todo(todoTitle)
                todoAdapter.addTodo(todo)
                et.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            todoAdapter.deleteTodo()
        }

    }
}