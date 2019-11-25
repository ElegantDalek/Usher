package com.example.usher

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), RecyclerFragment.OnFragmentInteractionListener,
    TicketFragment.OnFragmentInteractionListener, LockFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment1: Fragment = RecyclerFragment()
        val fragment2: Fragment = TicketFragment()
        val fragment3: Fragment = LockFragment()

        fragmentTransaction.add(R.id.fragment_container, fragment1).commit()

        val bottomView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomView.setOnNavigationItemSelectedListener {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.menu_1 -> ft.replace(R.id.fragment_container, fragment1).commit()
                R.id.menu_2 -> ft.replace(R.id.fragment_container, fragment2).commit()
                R.id.menu_3 -> ft.replace(R.id.fragment_container, fragment3).commit()
            }
            true
        }

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
