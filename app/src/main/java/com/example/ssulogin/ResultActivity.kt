package com.example.ssulogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.ssulogin.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        if (intent.hasExtra("email") && intent.hasExtra("password")) {
            binding.emailText.text = "email: ${intent.getStringExtra("email").toString()}"
            binding.passwordText.text = "password: ${intent.getStringExtra("password").toString()}"
        }

        binding.allX.setOnClickListener {
            finish()
        }
    }
}