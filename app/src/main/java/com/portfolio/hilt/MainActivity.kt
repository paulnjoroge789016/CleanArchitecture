package com.portfolio.hilt

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.portfolio.hilt.adapters.PostPagedListAdapter
import com.portfolio.hilt.databinding.ActivityMainBinding
import com.portfolio.hilt.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

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


        val errorView = layoutInflater.inflate(R.layout.popup_error, null)
        val alertDialogBuilder =  AlertDialog.Builder(this@MainActivity)
        alertDialogBuilder.apply {
            setView(errorView)
            setFinishOnTouchOutside(false)
        }

        val alertDialog  =  alertDialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()
        val btnTryAgain =  errorView.findViewById<LinearLayout>(R.id.layout_try_again)
        val tvErrorMessage = errorView.findViewById<TextView>(R.id.tv_error_message)

        btnTryAgain.setOnClickListener {
            postViewModel.getAllPosts()
            Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
            alertDialog.hide()
        }

        tvErrorMessage.text = errorMessage


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = MenuInflater(this@MainActivity)
        menuInflater.inflate(R.menu.testmenu, menu)
        return true
    }
}