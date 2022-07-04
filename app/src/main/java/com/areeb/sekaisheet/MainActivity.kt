package com.areeb.sekaisheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.areeb.sekaisheet.Fragments.Catogries
import com.areeb.sekaisheet.Fragments.HomeFagment
import com.areeb.sekaisheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        loadFragment(HomeFagment())

        mainBinding.nav.setOnItemSelectedListener { fragment ->
            when (fragment.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFagment())
                   return@setOnItemSelectedListener  true

                }
                R.id.cateFragment -> {
                    loadFragment(Catogries())
                   return@setOnItemSelectedListener true

                }
            }
            true

        }


    }

    private fun loadFragment(Current_fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.FragmentContainer,Current_fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}