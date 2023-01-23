package com.example.androidtechnicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var products: ArrayList<Product>
    private lateinit var books: ArrayList<Book>
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initProducts()
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerProducts)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        productsAdapter = ProductsAdapter(products, books)
        recyclerView.adapter = productsAdapter

    }

    fun initProducts() {
        products = ArrayList()
        for (i in 0..20) {
            products.add(
                Product(
                    i,
                    "Products",
                    "100" + i
                )
            )
        }
        books = ArrayList()
        for (i in 0..5) {
            books.add(
                Book(
                    i,
                    "The Entreprenure",
                    200 + i,
                    "Writer - Sharad Tandale"
                )
            )
        }

    }
}