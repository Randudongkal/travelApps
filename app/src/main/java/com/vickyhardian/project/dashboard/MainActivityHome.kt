package com.vickyhardian.project.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vickyhardian.project.R
import com.vickyhardian.project.dsbexplore.exploreFragment
import com.vickyhardian.project.dsbfavorite.favoriteFragment
import com.vickyhardian.project.dsbhome.homeFragment
import com.vickyhardian.project.dsbprofile.profileFragment
import kotlinx.android.synthetic.main.activity_main_home.*

class MainActivityHome : AppCompatActivity() {

    private val homeFm = homeFragment()
    private val exploreFm = exploreFragment()
    private val favoriteFm = favoriteFragment()
    private val profileFm = profileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        replaceFragment(homeFm)

        btnNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFm)
                R.id.ic_explore -> replaceFragment(exploreFm)
                R.id.ic_favorite -> replaceFragment(favoriteFm)
                R.id.ic_profile -> replaceFragment(profileFm)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.commit()
    }
}