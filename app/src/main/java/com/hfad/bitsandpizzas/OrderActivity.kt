package com.hfad.bitsandpizzas

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast


class OrderActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickDone(view:View){
        val text="Your order has been updated"
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById(R.id.coordinator),text,duration)
        snackbar.setAction("Undo",View.OnClickListener {
            val toast = Toast.makeText(this, "Undone!",Toast.LENGTH_SHORT).show()
        })
        snackbar.show()
    }


}