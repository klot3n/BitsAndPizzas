package com.hfad.bitsandpizzas

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PizzaFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val pizzaName = mutableListOf<String>()
        val pizzaImage = mutableListOf<Int>()
        for(i in 0..Pizza.pizza.size-1){
            pizzaName.add(Pizza.pizza[i].name)
            pizzaImage.add(Pizza.pizza[i].imageResourceId)
        }
        val pizzaRecView=inflater.inflate(R.layout.fragment_pizza,container,false)
            .findViewById<RecyclerView>(R.id.pizza_recycler)
        val adapter=CaptionedImagesAdapter(pizzaName,pizzaImage)
        pizzaRecView.adapter=adapter
        pizzaRecView.layoutManager= GridLayoutManager(activity,2)

        return pizzaRecView
    }
}