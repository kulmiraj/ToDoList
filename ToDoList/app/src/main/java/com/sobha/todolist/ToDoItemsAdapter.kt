package com.sobha.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ToDoItemsAdapter(private val todoItemList: ArrayList<TodoItem>)
    :RecyclerView.Adapter<ToDoItemsAdapter.ViewHolder>()
{
class ViewHolder(val constraintLayout: ConstraintLayout):RecyclerView.ViewHolder(constraintLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val constraintLayout=LayoutInflater.from(parent.context).inflate(
        R.layout.to_do_item_layout,parent,false) as ConstraintLayout
        return ViewHolder(constraintLayout)
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val constraintLayout=holder.constraintLayout
        val NameTextView=constraintLayout.getChildAt(0) as TextView
        val DesccTextView=constraintLayout.getChildAt(1)as TextView
        NameTextView.text=todoItemList[position].Name
        DesccTextView.text=todoItemList[position].Desc + if ( todoItemList[position].isUrgent)  "!!" else ""

        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return  todoItemList.size
        TODO("Not yet implemented")
    }
}