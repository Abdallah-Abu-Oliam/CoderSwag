package com.example.coderswag.controller

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coderswag.R
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter : ArrayAdapter<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataService.categories)
        binding.categorieListView.adapter = adapter

    }
}