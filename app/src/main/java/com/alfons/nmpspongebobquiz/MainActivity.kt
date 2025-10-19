package com.alfons.nmpspongebobquiz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.alfons.nmpspongebobquiz.LoginActivity.Companion.NAMA_PLAYER
import com.alfons.nmpspongebobquiz.databinding.ActivityLoginBinding
import com.alfons.nmpspongebobquiz.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.content.Context
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var score = 0;

    companion object{
        val SCORE = "score"
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.txtScore.text = score.toString()
            displayQuestions()

            //Binding nama Player
            val namaPlayer = intent.getStringExtra(LoginActivity.NAMA_PLAYER)
            binding.txtWelcome.text = namaPlayer


            binding.btnTrue.setOnClickListener {
                if(BankSoal.pertanyaannya[pertanyaanSkrg].jawaban == true){
                    Toast.makeText(this, "Pilihanmu Benar!!!", Toast.LENGTH_SHORT).show()
                    score += 5
                }
                else{
                    Toast.makeText(this, "Pilihanmu Salah :(", Toast.LENGTH_SHORT).show()
                    score -= 3
                }
                gantiSoal()
                binding.txtScore.text = score.toString()
            }

            binding.btnFalse.setOnClickListener {
                if(BankSoal.pertanyaannya[pertanyaanSkrg].jawaban == true){
                    Toast.makeText(this, "Pilihanmu Salah :(", Toast.LENGTH_SHORT).show()
                    score -= 3
                }
                else{
                    Toast.makeText(this, "Pilihanmu Benar!!!", Toast.LENGTH_SHORT).show()
                    score += 5
                }
                binding.txtScore.text = score.toString()
                gantiSoal()
            }
        }
    var pertanyaanSkrg = 0
    fun displayQuestions() {
            binding.txtQuestion.text = BankSoal.pertanyaannya[pertanyaanSkrg].soal
        }

    fun gantiSoal(){
        if(pertanyaanSkrg < BankSoal.pertanyaannya.size - 1) {
            pertanyaanSkrg++
            displayQuestions()
        }
        else{
            Toast.makeText(this, "Terima Kasih telah bermain Spongebob Quiz!", Toast.LENGTH_LONG).show()
            //Definisikan nama filenya dulu
            var sharedFile = packageName

            // creating/accessing the SharedPreferences object
            var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

            //Access the object and create key-value pair and store it
            var editor: SharedPreferences.Editor = shared.edit()
            editor.putInt(SCORE, score)
            editor.apply()

            val intent = Intent(this, ResultActivity::class.java)
            finish()
            startActivity(intent)
        }
    }


}