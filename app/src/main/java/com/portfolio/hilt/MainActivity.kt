package com.portfolio.hilt

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.portfolio.hilt.adapters.PostPagedListAdapter
import com.portfolio.hilt.databinding.ActivityMainBinding
import com.portfolio.hilt.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private val postViewModel: PostViewModel by viewModels()

    val TAG  = "Clean Architecture app"
    lateinit var mainActivityBinding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        postViewModel.getAllPosts()
        postViewModel.posts.observe(this, Observer {
            if (it.size > 0 ){
                it.forEach{post ->
                    Log.d(TAG,  post.toString())
                }
                val adapter = PostPagedListAdapter(postViewModel, it)
                mainActivityBinding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.VERTICAL, false)
                mainActivityBinding.rvPosts.adapter = adapter
            }
        })

    }
}