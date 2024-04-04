package com.example.qrcodescanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(private val todoItems: List<String>) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todoItem = todoItems[position]
        holder.bind(todoItem)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkBoxTodoItem: CheckBox = itemView.findViewById(R.id.checkBoxTodoItem)
        private val textViewTodoItem: TextView = itemView.findViewById(R.id.textViewTodoItem)

        fun bind(todoItem: String) {
            textViewTodoItem.text = todoItem

            checkBoxTodoItem.setOnCheckedChangeListener(null) // Importante per evitare loop infiniti
            checkBoxTodoItem.isChecked = false // Imposta lo stato iniziale del CheckBox

            checkBoxTodoItem.setOnCheckedChangeListener { _, isChecked ->
                // Modifica lo stato dell'elemento nella lista quando il CheckBox viene spuntato
                // Se vuoi aggiungere uno stato "fatto" o "non fatto" all'elemento, puoi farlo qui.
            }
        }
    }
}

