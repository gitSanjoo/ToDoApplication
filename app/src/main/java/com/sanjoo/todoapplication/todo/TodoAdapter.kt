package com.sanjoo.todoapplication.todo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sanjoo.todoapplication.R

class TodoAdapter(private val todoList:MutableList<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            val tv:TextView=itemView.findViewById(R.id.tvItemText)
            val cb:CheckBox=itemView.findViewById(R.id.cbItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
      holder.tv.text=todoList[position].title
      holder.cb.isChecked=todoList[position].isChecked
        toggleStrikeThrogh(holder.tv,holder.cb.isChecked)
        holder.cb.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrogh(holder.tv,isChecked)
            holder.cb.isChecked=! todoList[position].isChecked
        }
    }

    private fun toggleStrikeThrogh(tvTodoTitle:TextView,isChecked:Boolean){
        if(isChecked){
            tvTodoTitle.paintFlags=tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags=tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }

    }
    fun addTodo(todo: Todo){
        todoList.add(todo)
        notifyItemInserted(todoList.size-1)
    }
    fun deleteTodo(){
        todoList.removeAll{todo->
            todo.isChecked
        }
        notifyDataSetChanged()
    }
}