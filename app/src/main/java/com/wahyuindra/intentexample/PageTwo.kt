package com.wahyuindra.intentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahyuindra.intentexample.databinding.ActivityPageTwoBinding

class PageTwo : AppCompatActivity() {
    private lateinit var binding : ActivityPageTwoBinding

    companion object  {
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra(USER)){
            val user = intent.getParcelableExtra<User>(USER) as User

            binding.tvName.text = user.name.toString()
            binding.tvEmail.text = user.email.toString()
            binding.tvPhone.text = user.phoneNumber

            binding.tvEmail.setOnClickListener {
                val mail = Intent(Intent.ACTION_SENDTO)
                mail.data = Uri.parse("mailto:${user.email.toString()}")
                startActivity(mail)
            }

            binding.tvPhone.setOnClickListener {
                val dialPhone = Intent(Intent.ACTION_DIAL)
                dialPhone.data = Uri.parse("tel:${user.phoneNumber}")
                startActivity(dialPhone)
            }
        }
    }
}