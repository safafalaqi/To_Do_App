package com.example.todoapp

import com.example.a2in1app.RecyclerViewAdapter

class ToDoItem (){
     private var checked= false
     private var item = ""

    fun getItem(): String {
        return item
    }
    fun setItem(i:String) {
        item= i
    }
    fun getChecked(): Boolean {
        return checked
    }
    fun setChecked(b:Boolean) {
        checked= true
    }

}