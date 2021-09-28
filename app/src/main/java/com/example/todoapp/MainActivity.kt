package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2in1app.RecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var myRv: RecyclerView
    private lateinit var rvAdapter: RecyclerViewAdapter
    private lateinit var floatButton: FloatingActionButton
    private var todoList: MutableList<ToDoItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRv = findViewById(R.id.rvMain)
        rvAdapter=RecyclerViewAdapter(todoList,this)
        myRv.adapter = rvAdapter
        myRv.layoutManager = LinearLayoutManager(this)

        var alert= AlertDialog(this,todoList,myRv)
        var todItem =ToDoItem()
        floatButton=findViewById(R.id.floatingActionButton)
        floatButton.setOnClickListener{
           alert.customAlert()
        }
        rvAdapter=RecyclerViewAdapter(todoList,this)
        myRv.adapter = rvAdapter
        myRv.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
                countChecked()
                rvAdapter.removeChecked()
        return super.onOptionsItemSelected(item)
    }

    //to get the number of checked items
    fun countChecked()
    {
        var count=0
       for(i in todoList)
       {
           if(i.getChecked())
               count++
       }
     Toast.makeText(this, "$count items deleted", Toast.LENGTH_LONG).show()

    }
}