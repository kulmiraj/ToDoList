package com.sobha.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoItemRecylerView :RecyclerView
    private lateinit var recycleAdapter: ToDoItemsAdapter
    private lateinit var recyclerLayoutManager:RecyclerView.LayoutManager
    var todoItemsList= ArrayList<TodoItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoItemRecylerView=findViewById(R.id.todo_item_recycler_view)

        val dbo=DatabaseOpener(this)
        val cursor= dbo.getAllItem(dbo)
        with(cursor)
        {
          //  cursor.moveToFirst()
            if(cursor != null) {

                if (cursor.moveToFirst()) {
                    while (cursor.moveToNext()) {
                        val itemName =
                            cursor.getString(1)
                        val itemDesc = getString(getColumnIndex(DatabaseInfo.TableInfo.COLUMN_DESC))
                        val itemUrgency =
                            getInt(getColumnIndex(DatabaseInfo.TableInfo.COLUMN_ISURGENT))
                        val isUrgent = if (itemUrgency == 0) false else true
                        todoItemsList.add(TodoItem(itemName, itemDesc, isUrgent))
                    }
                }
            }
        }


//        todoItemsList.add(TodoItem("Tea","Tea Green",true))
//        todoItemsList.add(TodoItem("Milk","Cow Milk"))
//        todoItemsList.add(TodoItem("Sugar","Sweet",false))

        recyclerLayoutManager=LinearLayoutManager(this)
        recycleAdapter= ToDoItemsAdapter(todoItemsList,this)
        todoItemRecylerView.apply {
            setHasFixedSize(true)
            layoutManager=recyclerLayoutManager
            adapter=recycleAdapter
        }

    }
    public  fun navToAddItenmAction(view:View)
    {
        val intent:Intent = Intent(this ,AddItemActivity::class.java)
        startActivity(intent)
    }
}