package com.example.storiesandposts.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storiesandposts.R
import com.example.storiesandposts.data.model.Post
import com.example.storiesandposts.databinding.ItemPostBinding
import com.example.storiesandposts.ui.utils.bindings

class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts : ArrayList<Post> = arrayListOf()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostAdapter.PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = posts[position]
        try {
            holder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addPostList(_posts : ArrayList<Post>) {
        posts.clear()
        posts.addAll(_posts)
        this.notifyDataSetChanged()
    }

    override fun getItemCount() : Int {
        return posts.size
    }


    inner class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var data: Post
        private val binding: ItemPostBinding by bindings(view)

        fun bindData(data: Any) {
            if (data is Post) {
                this.data = data
                drawItemUI()
            }
        }

        private fun drawItemUI() {
            binding.apply {
                post = data
                executePendingBindings()
            }
        }

    }

}