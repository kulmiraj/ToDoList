package com.sobha.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoItemRecylerView :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoItemRecylerView=findViewById(R.id.todo_item_recycler_view)

    }
    public  fun navToAddItenmAction(view:View)
    {
        val intent:Intent = Intent(this ,AddItemActivity::class.java)
        startActivity(intent)
    }
}