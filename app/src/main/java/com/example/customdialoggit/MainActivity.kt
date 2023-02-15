package com.example.customdialoggit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customdialoggit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.basicDialog.setOnClickListener {
            basicDialog()
        }


    }

    private fun basicDialog() {

    }
}