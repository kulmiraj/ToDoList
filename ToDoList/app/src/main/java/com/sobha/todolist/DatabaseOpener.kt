package com.sobha.todolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseOpener(context: Context):SQLiteOpenHelper(
    context, DATABSE_NAME,null, DATABASE_VERSION) {
companion object
{
    const val DATABSE_NAME="TodoItem.db"
    const val DATABASE_VERSION=1
}

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

}