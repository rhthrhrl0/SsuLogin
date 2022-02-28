package com.example.ssulogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.ssulogin.databinding.ActivityMainBinding
import com.yourssu.design.system.language.suffixTextField
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: IdCreateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.toastButton.setOnClickListener {
            if (!(viewModel.boxButtonIsDisable.value!!)) {
                val intent = Intent(this, PasswordActivity::class.java)
                val email: String = binding.inputfield.text.toString()
                intent.putExtra("email", email)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                startActivity(intent)
            }
        }

        binding.inputfield.addTextChangedListener(viewModel.textWatcher)

    }
}