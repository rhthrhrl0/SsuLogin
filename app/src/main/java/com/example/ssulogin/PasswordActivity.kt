package com.example.ssulogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.ssulogin.databinding.ActivityPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding
    val viewModel: PasswordCreateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.toastButton.setOnClickListener {
            if (!(viewModel.boxButtonIsDisable.value!!)) {
                val intent2 = Intent(this, ResultActivity::class.java)

                if (intent.hasExtra("email")) {
                    val email: String = intent.getStringExtra("email").toString()
                    intent2.putExtra("email", email)
                }
                val password: String = binding.inputfield.text.toString()
                intent2.putExtra("password", password)
                startActivity(intent2)
            }
        }

        binding.inputfield.addTextChangedListener(viewModel.textWatcher)

        binding.inputfieldX.setOnClickListener {
            binding.inputfield.text.clear()
        }

        binding.allX.setOnClickListener {
            finish()
        }

    }
}