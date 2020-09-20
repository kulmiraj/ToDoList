package com.sobha.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class AddItemActivity : AppCompatActivity() {

    private lateinit var  todoName : EditText
    private lateinit var todoDescription:EditText
    private lateinit var chkPriority:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        todoName=findViewById(R.id.txttodoName)
        todoDescription=findViewById(R.id.txtDescription)
        chkPriority=findViewById(R.id.chkPriority)
    }

    public fun SaveItemAction(view:View)
    {

    }
    public fun CancelItemAction(view:View)
    {
        val intent: Intent = Intent(this ,MainActivity::class.java)
        startActivity(intent)
    }
}