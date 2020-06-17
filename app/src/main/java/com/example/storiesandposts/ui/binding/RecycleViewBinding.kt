package com.example.storiesandposts.ui.binding


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

//Used to bind the the adapter to the recycleview
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    view.adapter = adapter
}
