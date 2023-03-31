package com.hostelmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hostelmanagement.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.hostelmanagement.accountService.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser != null) {
            firebaseAuth.currentUser?.let {
                binding.tvUserEmailMainActivity.text = it.email
            }
        }
        binding.btnLogoutMainActivity.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
            finish()
        }
    }
}