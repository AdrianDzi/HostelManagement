package com.hostelmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hostelmanagement.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.hostelmanagement.home.HomeFragment
import com.hostelmanagement.hostel.HostelFragment
import com.hostelmanagement.renting.RentingFragment
import com.hostelmanagement.user.UserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HostelFragment())
        firebaseAuth = FirebaseAuth.getInstance()

        binding.bnNavMainActivity.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.hostel -> replaceFragment(HostelFragment())
                R.id.user -> replaceFragment(UserFragment())
                R.id.renting -> replaceFragment(RentingFragment())
                else ->{

                }
            }
            true
        }

//        if (firebaseAuth.currentUser != null) {
//            firebaseAuth.currentUser?.let {
//                binding.tvUserEmailMainActivity.text = it.email
//            }
//        }
//        binding.btnLogoutMainActivity.setOnClickListener {
//            firebaseAuth.signOut()
//            startActivity(
//                Intent(
//                    this,
//                    LoginActivity::class.java
//                )
//            )
//            finish()
//        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_frameMainActivity, fragment)
        fragmentTransaction.commit()
    }
}