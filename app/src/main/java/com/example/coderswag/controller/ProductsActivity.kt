package com.example.coderswag.controller

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.databinding.ActivityProductsBinding
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapters.ProductsAdapter
import com.example.coderswag.services.DataService
import com.example.coderswag.utilites.EXTRA_CATEGORY
import com.example.coderswag.model.Product
class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)



         val  categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println("category recived : ${categoryType}" )
        val products = DataService.getProducts(categoryType.toString())
        println("Products count: ${products.size}") // Debug log
        adapter = ProductsAdapter(this , DataService.getProducts(categoryType.toString()))

        /**span count is the number of columns */

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount= 3
        }
        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720 ){
            spanCount = 3
        }
        val layoutManager = GridLayoutManager(this , spanCount)
        binding.productListView.layoutManager = layoutManager
        binding.productListView.adapter = adapter



    }
}