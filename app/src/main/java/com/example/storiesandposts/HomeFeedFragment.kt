package com.example.storiesandposts

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.preference.PreferenceActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.example.flow.base.DatabindingFragment
import com.example.storiesandposts.databinding.HomeFeedFragmentBinding
import com.example.storiesandposts.ui.adapters.HeaderAdapter
import com.example.storiesandposts.ui.adapters.PostAdapter

class HomeFeedFragment : DatabindingFragment() {

    private lateinit var feedViewModel: HomeFeedViewModel

    lateinit var binding : HomeFeedFragmentBinding

    lateinit var postAdapter: PostAdapter
    lateinit var headerAdapter: HeaderAdapter
   // lateinit var headerAdapter: HeaderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        feedViewModel =
            ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)

        observeData()

        return binding<HomeFeedFragmentBinding>(inflater, R.layout.home_feed_fragment, container).apply {

            val layoutMana=
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            postAdapter = PostAdapter()
            headerAdapter = HeaderAdapter(requireContext(), feedViewModel.stories)
            val mergeAdapter= MergeAdapter(headerAdapter, postAdapter)
            recyclerViews.apply{
                layoutManager = layoutMana
            }
            this.mergeAdapter = mergeAdapter
            viewModel = feedViewModel
            lifecycleOwner = this@HomeFeedFragment

        }.root
    }


    private fun observeData(){
        feedViewModel._postListLiveData.observe(viewLifecycleOwner, Observer {
            postAdapter.addPostList(it)
        })
    }

}