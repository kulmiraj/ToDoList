package com.sobha.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.quicksettings.Tile
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class AddItemActivity : AppCompatActivity() {

    private lateinit var  todoName : EditText
    private lateinit var todoDescription:EditText
    private  lateinit var titleText:TextView
    private lateinit var chkPriority:CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        todoName=findViewById(R.id.txttodoName)
        todoDescription=findViewById(R.id.txtDescription)
        chkPriority=findViewById(R.id.chkPriority)
        titleText=findViewById(R.id.home_title_text_view)

        val Name=intent.getStringExtra("ITEM_NAME")
        val Desc=intent.getStringExtra("ITEM_DESC")
        val isUrgent=intent.getBooleanExtra("ITEM_ISURGENT",false)

        if(Name!=null)
        {
            val Title=titleText.text
            titleText.setText(Title.toString()+": Edit")
            todoName.setText(Name)
        }
        if(Desc!=null)
        {
            todoDescription.setText(Desc)
        }
        if(isUrgent==true)
        {
            chkPriority.isChecked=true
        }
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