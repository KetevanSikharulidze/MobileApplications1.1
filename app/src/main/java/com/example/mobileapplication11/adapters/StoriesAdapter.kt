package com.example.mobileapplication11.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapplication11.R
import com.example.mobileapplication11.databinding.ItemStoryBinding
import com.example.mobileapplication11.models.Highlights

class StoriesAdapter : ListAdapter<Highlights, StoriesAdapter.Holder>(Comparator()) {

    companion object {
        private const val TYPE_FIRST_ITEM = 0
        private const val TYPE_NORMAL_ITEM = 1
    }
    
    class Holder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemStoryBinding.bind(view)

        fun bind(item: Highlights, position: Int)= with(binding){
            if (position == 0){
                btnAddNewStory.visibility = View.VISIBLE
                btnAddNewStory.setOnClickListener {
                    Toast.makeText(itemView.context, "Add button clicked!", Toast.LENGTH_SHORT).show()
                }
            } else {
                btnAddNewStory.visibility = View.GONE
            }

            tvHText.text = item.text

        }
    }

    class Comparator: DiffUtil.ItemCallback<Highlights>(){
        override fun areItemsTheSame(oldItem: Highlights, newItem: Highlights): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Highlights, newItem: Highlights): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return Holder(view)
    } // ქმნით

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_FIRST_ITEM else TYPE_NORMAL_ITEM
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position),position)
    } // ავსებთ

}