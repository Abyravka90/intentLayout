package com.example.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == MoveForResultActivity.RESULT_CODE){
            val nameStuff =  result.data?.getStringExtra(MoveForResultActivity.EXTRA_NAME_STUFF)
            val amountStuff = result.data?.getStringExtra(MoveForResultActivity.EXTRA_AMOUNT_STUFF)

            binding.tvNameStuff.text = nameStuff
            binding.tvAmountStuff.text = amountStuff
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveActivity.setOnClickListener{
            val intent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(intent)
        }

        binding.btnMoveActivityWithData.setOnClickListener{
            val intent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
            intent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Nama Saya Asep")
            startActivity(intent)
        }

        binding.btnMoveActivityWithObject.setOnClickListener{
            val person = Person(
                "Asep Cahya Nugraha",
                34,
                175.0
            )

            val intent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
            intent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)

            startActivity(intent)
        }

        binding.btnMoveActivityForResult.setOnClickListener{
            val intent = Intent( this@MainActivity, MoveForResultActivity::class.java)
            startForResult.launch(intent)
        }

        binding.btnDial.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:6281320106009"))
            startActivity(intent)
        }

    }
}