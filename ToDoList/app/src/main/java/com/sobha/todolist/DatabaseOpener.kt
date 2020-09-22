package com.sobha.todolist

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DatabaseOpener(context: Context) : SQLiteOpenHelper(
    context, DATABSE_NAME, null, DATABASE_VERSION
) {
    companion object {
        const val DATABSE_NAME = "TodoItem.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DatabaseInfo.SQL_CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DatabaseInfo.SQL_DELETE_TABLE_QUERY)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    //function to add items to db /Table ===========================START=======================
    fun AddItem(dbo: DatabaseOpener, todoItem: TodoItem) {
        //intiliaze the db and get writable database
        val db = dbo.writableDatabase
        val ItemName = todoItem.Name
        val ItemDesc = todoItem.Desc
        val isUrgent = todoItem.isUrgent
        val Item_date = todoItem.getdateAsString()
        val ItemUrgency = if (isUrgent) 1 else 0
        //pass the values to columns
        val contentValues = ContentValues().apply {
            put(DatabaseInfo.TableInfo.COLUMN_NAME, ItemName)
            put(DatabaseInfo.TableInfo.COLUMN_DESC, ItemDesc)
            put(DatabaseInfo.TableInfo.COLUMN_ISURGENT, ItemUrgency)
            put(DatabaseInfo.TableInfo.COLUMN_DATE, Item_date)
        }
        val rowid = db.insert(DatabaseInfo.TableInfo.TABLE_NAME, null, contentValues)
    }
    //function to add items to db /Table ===========================END=======================

    //function to Get All Items from db /Table ===========================START=======================
    fun getAllItem(dbo: DatabaseOpener): Cursor {
        val db = dbo.readableDatabase
        val projection = arrayOf(
            BaseColumns._ID,
            DatabaseInfo.TableInfo.COLUMN_DESC,
            DatabaseInfo.TableInfo.COLUMN_ISURGENT,
            DatabaseInfo.TableInfo.COLUMN_DATE
        )
        val selection = ""
        val selectionArgs = null
        val SortOrder = null
        val cursor = db.query(
            DatabaseInfo.TableInfo.TABLE_NAME, projection,
            selection,
            selectionArgs,
            null,
            null,
            SortOrder
        )
        return cursor
    }
    //function to Get All Items from db /Table ===========================END=======================

    //function to Update items in  db /Table ===========================START=======================
    fun UpdateItem(dbo: DatabaseOpener, oldItem: TodoItem, NewItem: TodoItem) {
        val db = dbo.writableDatabase
        val ItemName = NewItem.Name
        val ItemDesc = NewItem.Desc
        val isUrgent = NewItem.isUrgent
        val Item_date = NewItem.getdateAsString()
        val ItemUrgency = if (isUrgent) 1 else 0

        //pass the values to columns
        val contentValues = ContentValues().apply {
            put(DatabaseInfo.TableInfo.COLUMN_NAME, ItemName)
            put(DatabaseInfo.TableInfo.COLUMN_DESC, ItemDesc)
            put(DatabaseInfo.TableInfo.COLUMN_ISURGENT, ItemUrgency)
            put(DatabaseInfo.TableInfo.COLUMN_DATE, Item_date)
        }
        val selection = "${DatabaseInfo.TableInfo.COLUMN_NAME} LIKE ?"
        val selectionArgs = arrayOf(oldItem.Name)
        //val SortOrder = null
       val count= db.update(DatabaseInfo.TableInfo.TABLE_NAME,contentValues,selection,selectionArgs)
    }
    //function to Update items in  db /Table ===========================END=======================

    //function to delete items in  db /Table ===========================START=======================
    fun deleteItem(dbo:DatabaseOpener,todoItem: TodoItem)
    {
        val db=dbo.writableDatabase
        val selection = "${DatabaseInfo.TableInfo.COLUMN_NAME} LIKE ?"
        val selectionArgs = arrayOf(todoItem.Name)
       val deletedRows= db.delete(DatabaseInfo.TableInfo.TABLE_NAME,selection,selectionArgs)
    }
    //function to delete items in  db /Table ===========================END=======================
}


