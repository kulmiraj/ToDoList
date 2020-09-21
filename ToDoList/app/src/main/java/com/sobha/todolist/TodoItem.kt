package com.sobha.todolist

import  java.util.*
class TodoItem(var Name:String, var Desc :String) {

    var isUrgent=false
    var date=Calendar.getInstance()

    constructor(name: String ,desc :String ,isUrgent:Boolean):this(name,desc)
    {
        this.isUrgent=isUrgent
    }

    fun getdateAsString():String
    {
     val year=date.get(Calendar.YEAR).toString()
     val month=date.get(Calendar.MONTH).toString()
     val day=date.get(Calendar.DAY_OF_MONTH).toString()
     return  "$year/$month/$day"
    }
}