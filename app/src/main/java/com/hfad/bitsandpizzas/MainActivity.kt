package com.hfad.bitsandpizzas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.support.v7.widget.ShareActionProvider
import android.os.Bundle
import android.view.Menu
import android.support.v4.view.MenuItemCompat
import android.view.MenuItem
import android.view.View
import android.widget.ShareActionProvider
import android.widget.Toolbar
//import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var shareActionProvider: ShareActionProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu?.findItem(R.id.action_share)
        shareActionProvider= MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent("Want to join me for pizza?")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            R.id.action_create_order -> {
                var intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun setShareActionIntent(text: String){
        val i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_TEXT,text)
        shareActionProvider.setShareIntent(i)
    }
}
