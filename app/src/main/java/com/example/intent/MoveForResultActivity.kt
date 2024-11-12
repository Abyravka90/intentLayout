package com.example.intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveForResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendData.setOnClickListener{
            val resultIntent = Intent()
            val nameStuff = binding.edtNameStuff.text.toString()
            val amountStuff = binding.edtAmountStuff.text.toString()
            resultIntent.putExtra(EXTRA_NAME_STUFF, nameStuff)
            resultIntent.putExtra(EXTRA_AMOUNT_STUFF, amountStuff)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME_STUFF = "extra_name_stuff"
        const val EXTRA_AMOUNT_STUFF = "extra_amount_stuff"
        const val RESULT_CODE = 110
    }
}