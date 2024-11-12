package com.example.intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMoveWithDataBinding
import com.example.intent.databinding.ActivityMoveWithObjectBinding

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithObjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Nama : ${person.nama}, Umur : ${person.umur}, Tinggi : ${person.tinggi}"

        binding.tvObjectReceived.text = text
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}