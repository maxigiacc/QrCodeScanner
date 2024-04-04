package com.example.qrcodescanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoList : AppCompatActivity() {

    private val todoItems = mutableListOf<String>()
    private lateinit var adapter: TodoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)

        val recyclerViewTodoList: RecyclerView = findViewById(R.id.recyclerViewTodoList)
        recyclerViewTodoList.layoutManager = LinearLayoutManager(this)

        adapter = TodoListAdapter(todoItems)
        recyclerViewTodoList.adapter = adapter

        val editTextNewItem: EditText = findViewById(R.id.editTextNewItem)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            val newItem = editTextNewItem.text.toString().trim()
            if (newItem.isNotEmpty()) {
                todoItems.add(newItem)
                adapter.notifyDataSetChanged()
                editTextNewItem.text.clear()
            }
        }

        // Imposta il contenuto del QR code nella TextView appropriata
        val qrContent = intent.getStringExtra("qr_content")
        val textViewQrContentValue: TextView = findViewById(R.id.textViewQrContentValue)
        textViewQrContentValue.text = qrContent
    }
}
