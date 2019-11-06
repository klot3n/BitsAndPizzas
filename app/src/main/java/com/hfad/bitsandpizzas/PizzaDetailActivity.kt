package com.hfad.bitsandpizzas

import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView

class PizzaDetailActivity: AppCompatActivity() {
    val EXTRA_PIZZA_ID="pizzaId"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val pizzaId:Int=intent.getIntExtra(EXTRA_PIZZA_ID,213)
        val textView=findViewById<TextView>(R.id.pizza_text)
        textView.text=Pizza.pizza[pizzaId].name
        val imageView=findViewById<ImageView>(R.id.pizza_image)
        imageView.setImageDrawable(ContextCompat
            .getDrawable(this,Pizza.pizza[pizzaId].imageResourceId))

    }

}