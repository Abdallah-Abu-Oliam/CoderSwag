package com.example.coderswag.controller

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R

import com.example.coderswag.adapters.CategoryRecycleAdapter
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        adapter = CategoryRecycleAdapter(this , DataService.categories)
        binding.categorieListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.categorieListView.layoutManager=layoutManager
        binding.categorieListView.setHasFixedSize(true)

    }
}