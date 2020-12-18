package com.portfolio.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.portfolio.hilt.adapters.PostPagedListAdapter
import com.portfolio.hilt.databinding.ActivityMainBinding
import com.portfolio.hilt.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    val postViewModel: PostViewModel by viewModels()

    lateinit var mainActivityBinding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = PostPagedListAdapter(postViewModel)
        postViewModel.posts.observe(this, Observer {
            if (it.size > 0 ){
//                adapter.submitList(it)
            }
        })

    }
}