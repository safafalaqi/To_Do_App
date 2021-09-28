package com.example.todoapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class AlertDialog(val context: Context, var todoList: MutableList<ToDoItem>,var myRv: RecyclerView,) {

    fun customAlert( ) {
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(context)
        val input = EditText(context)
        var todItem =ToDoItem()

        // here we set the message of our alert dialog
        input.setHint("Enter a thing to do")

        dialogBuilder.setView(input)

        dialogBuilder
            // positive button text and action
            .setPositiveButton("Add", DialogInterface.OnClickListener {
                    dialog, id ->
                todItem.setItem(input.text.toString())
                todoList.add(todItem)
                myRv.scrollToPosition(todoList.size - 1)
            })
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("New Item")
        // show alert dialog
        alert.show()

    }
}