package com.example.a2in1app

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.AlertDialog
import com.example.todoapp.ToDoItem
import com.example.todoapp.databinding.ItemRowBinding


class RecyclerViewAdapter(private var todo: MutableList<ToDoItem>, val context:Context): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val t=todo[position]
        holder.binding.apply {
            tvText.text = t.getItem()
            checkBox.setOnClickListener {
                //if checked change color to gray
                if (checkBox.isChecked) {
                    t.setChecked(true)
                    tvText.setTextColor(Color.GRAY)
                }//otherwise leave it black
                else
                    tvText.setTextColor(Color.BLACK)
              }
            checkBox.isChecked=false
            tvText.setTextColor(Color.BLACK)
            }
    }
    fun removeChecked()
    {
        todo.removeAll{ item -> item.getChecked() }
        notifyDataSetChanged()

    }

   /* fun getTodo(): MutableList<ToDoItem>
    {
        return todo
    }
    fun setTodo(td:MutableList<ToDoItem>)
    {
        todo=td
    }
    */
    override fun getItemCount()= todo.size


}