package com.example.storiesandposts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storiesandposts.data.model.Post
import com.example.storiesandposts.data.model.Story

class HomeFeedViewModel : ViewModel() {

    val postListLiveData : MutableLiveData<ArrayList<Post>> = MutableLiveData()
    val _postListLiveData : LiveData<ArrayList<Post>>
        get() = postListLiveData


    val storyListLiveData : MutableLiveData<ArrayList<Story>> = MutableLiveData()
    val _storyListLiveData : LiveData<ArrayList<Story>>
        get() = storyListLiveData

    lateinit var stories : ArrayList<Story>

    init {
        makeAList()
    }


    fun makeAList(){ //used for testing as we don't have the data layer
        val list = ArrayList<Post>()

        for (i in 1..5){
            val post = Post(
                "John $i",
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png",
                "Baboons are great",
                "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
                10,
                2
            )
            list.add(post)
        }

        val list2 = ArrayList<Story>()
        for (i in 1..15){
            val story = Story(
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png")

            list2.add(story)
        }

        postListLiveData.value = list
        storyListLiveData.value = list2

        stories = list2

        //Log.d("TAG", list.toString())
    }
}