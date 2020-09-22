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

    private lateinit var todoName: EditText
    private lateinit var todoDescription: EditText
    private lateinit var titleText: TextView
    private lateinit var chkPriority: CheckBox

    private var isNewItem = true
    private lateinit var oldItems: TodoItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        todoName = findViewById(R.id.txttodoName)
        todoDescription = findViewById(R.id.txtDescription)
        chkPriority = findViewById(R.id.chkPriority)
        titleText = findViewById(R.id.home_title_text_view)

        val Name = intent.getStringExtra("ITEM_NAME")
        val Desc = intent.getStringExtra("ITEM_DESC")
        val isUrgent = intent.getBooleanExtra("ITEM_ISURGENT", false)

        if (Name != null) {
            val Title = titleText.text
            titleText.setText(Title.toString() + ": Edit")
            todoName.setText(Name)

            oldItems = TodoItem(Name, Desc)
            isNewItem = false
        }
        if (Desc != null) {
            todoDescription.setText(Desc)
            oldItems.Desc = Desc
        }
        if (isUrgent == true) {
            chkPriority.isChecked = true
            oldItems.isUrgent = isUrgent
        }
    }

    public fun SaveItemAction(view: View) {
        val ItemName = todoName.text.toString()
        val ItemDesc = todoDescription.text.toString()
        val ItemUrgency=chkPriority.isChecked

        val newTodoItem=TodoItem(ItemName,ItemDesc,ItemUrgency)

        val dbo=DatabaseOpener(this)
        if(isNewItem)
        {
            dbo.AddItem(dbo,newTodoItem)
        }
        else
        {
            dbo.UpdateItem(dbo,this.oldItems,newTodoItem)
        }

    }

    public fun CancelItemAction(view: View) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}