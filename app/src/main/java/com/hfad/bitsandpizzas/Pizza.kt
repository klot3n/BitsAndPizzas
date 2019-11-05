package com.hfad.bitsandpizzas

import com.hfad.bitsandpizzas.R.drawable.diavolo

class Pizza (var name:String,var imageResourceId:Int){
    companion object {
        val pizza = arrayOf(
            Pizza("Diavolo", R.drawable.diavolo),
            Pizza("Funghi", R.drawable.funghi)
        )
    }
}