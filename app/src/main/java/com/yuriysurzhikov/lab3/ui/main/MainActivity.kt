package com.yuriysurzhikov.lab3.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yuriysurzhikov.lab3.R

class MainActivity : AppCompatActivity() {

    private val adapter = ContactsRecyclerAdapter()
    private lateinit var recyclerView: TextView
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        recyclerView = findViewById(R.id.recycler_view)
        addButton = findViewById(R.id.add_fab)
    }

    private val addClickListener = View.OnClickListener {

    }

    private val
}