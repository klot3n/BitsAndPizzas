package com.hfad.bitsandpizzas

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.support.v7.widget.ShareActionProvider
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.Menu
import android.support.v4.view.MenuItemCompat
import android.support.v4.view.ViewPager
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    lateinit var shareActionProvider: ShareActionProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.setAdapter(pagerAdapter)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)
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

    private inner class SectionsPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){

        override fun getCount(): Int {
            return 4
        }

        override fun getItem(p0: Int): Fragment? {
            return when (p0) {
                0 -> TopFragment()
                1 -> PizzaFragment()
                2 -> PastaFragment()
                3 -> StoreFragment()
                else -> null
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 ->  getString(R.string.home_tab)//resources.getText(R.string.home_tab)
                1 -> getString(R.string.pizza_tab)//resources.getText(R.string.pizza_tab)
                2 -> resources.getText(R.string.pasta_tab)
                3 -> resources.getText(R.string.store_tab)
                else -> null
            }
        }
    }
}
