package com.sobha.todolist

import android.provider.BaseColumns

object DatabaseInfo {
//Query to create table
    const val SQL_CREATE_TABLE_QUERY="CREATE TABLE ${TableInfo.TABLE_NAME} ("+
            "${BaseColumns._ID} Integer Primary Key,"+
            "${TableInfo.COLUMN_NAME} TEXT,"+
            "${TableInfo.COLUMN_DESC} TEXT,"+
            "${TableInfo.COLUMN_ISURGENT} INTEGER,"+
            "${TableInfo.COLUMN_DATE} TEXT)"
    //Query to drop table if exists
    const val SQL_DELETE_TABLE_QUERY="DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"
    //Define Table and Column Name
            object TableInfo:BaseColumns
    {
        const val TABLE_NAME="todoItemTable"
        const val COLUMN_NAME="name"
        const val COLUMN_DESC="desc"
        const val COLUMN_ISURGENT="isurgent"
        const val COLUMN_DATE="itemDate"
    }
}