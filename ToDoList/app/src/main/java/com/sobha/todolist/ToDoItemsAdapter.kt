package com.sobha.todolist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ToDoItemsAdapter(private val todoItemList: ArrayList<TodoItem>,val activity: MainActivity)
    :RecyclerView.Adapter<ToDoItemsAdapter.ViewHolder>()
{
class ViewHolder(val constraintLayout: ConstraintLayout):RecyclerView.ViewHolder(constraintLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val constraintLayout=LayoutInflater.from(parent.context).inflate(
        R.layout.to_do_item_layout,parent,false) as ConstraintLayout
        return ViewHolder(constraintLayout)
     //   TODO("Not yet implemented")

        constraintLayout.setOnClickListener(View.OnClickListener {
            val nameTextView=constraintLayout.getChildAt(0) as TextView
            val descTextView=constraintLayout.getChildAt(1) as TextView
            var Name=nameTextView.text
            val textFromDescct=descTextView.text.split("'").toTypedArray()
            val Desc=textFromDescct[0]
            val isUrgent=if(textFromDescct[1]=="!!")true else false
            val intent: Intent = Intent(parent.context ,AddItemActivity::class.java)
            intent.putExtra("ITEM_NAME",Name)
            intent.putExtra("ITEM_DESC",Desc)
            intent.putExtra("ITEM_ISURGENT",isUrgent)
            activity.startActivity(intent)
        })
        constraintLayout.setOnLongClickListener(View.OnLongClickListener {
            val position:Int=parent.indexOfChild(it)
            activity.todoItemsList.removeAt(position)
            notifyItemRemoved(position)
            true
            //OnLongClickListener true
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val constraintLayout=holder.constraintLayout
        val NameTextView=constraintLayout.getChildAt(0) as TextView
        val DesccTextView=constraintLayout.getChildAt(1)as TextView
        NameTextView.text=todoItemList[position].Name
        DesccTextView.text=todoItemList[position].Desc +"'"+ if ( todoItemList[position].isUrgent)  "!!" else ""


    }

    override fun getItemCount(): Int {
        return  todoItemList.size
      
    }
}