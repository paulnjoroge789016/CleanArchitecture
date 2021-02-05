package com.portfolio.hilt

import android.graphics.Point
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.amlcurran.showcaseview.ShowcaseView
import com.github.amlcurran.showcaseview.targets.ActionViewTarget
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
        mainActivityBinding.lifecycleOwner = this
        mainActivityBinding.viewModel = postViewModel

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


        postViewModel.errorMessage.observe(this, { errorMessage ->
            createErrorPopupDialog(errorMessage)
        })



    }

    private fun createErrorPopupDialog(errorMessage: String?) {

        val alertDialogBuilder =  AlertDialog.Builder(this@MainActivity)
        alertDialogBuilder.apply {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = MenuInflater(this@MainActivity)
        menuInflater.inflate(R.menu.testmenu, menu)
        return true
    }
}