package com.alfons.nmpspongebobquiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alfons.nmpspongebobquiz.databinding.ActivityLoginBinding
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    //Companion Object
    companion object{
        val NAMA_PLAYER = "nama_player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val namaPlayer = binding.txtPlayerName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(NAMA_PLAYER, "Selamat datang, $namaPlayer")
            startActivity(intent)
        }
    }
}