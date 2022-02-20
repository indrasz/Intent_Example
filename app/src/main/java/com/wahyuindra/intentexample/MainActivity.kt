package com.wahyuindra.intentexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahyuindra.intentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val phoneNumber = binding.edtPhone.text.toString()

            val user = User(
                name,
                email,
                phoneNumber
            )

            val intent = Intent(this@MainActivity, PageTwo::class.java).apply {
                putExtra(PageTwo.USER, user)
            }
            startActivity(intent)
        }
    }
}