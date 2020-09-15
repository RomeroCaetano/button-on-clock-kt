package com.example.acerteonumero

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tvDica1 : TextView
    private lateinit var tvDica2 : TextView
    private lateinit var tvDica3 : TextView
    private lateinit var edTentativa : EditText
    private lateinit var btTentativa : Button
    private lateinit var tvPreResultText: TextView
    private lateinit var tvResultNumber: TextView
    private lateinit var tvResultText: TextView
    private lateinit var tvSorting: TextView
    private var randomValue: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.tvDica1 = findViewById(R.id.tvDica1)
        this.tvDica2 = findViewById(R.id.tvDica2)
        this.tvDica3 = findViewById(R.id.tvDica3)
        this.edTentativa = findViewById(R.id.edTentativa)
        this.btTentativa = findViewById(R.id.btTentativa)
        this.tvPreResultText = findViewById(R.id.tvPreResultText)
        this.tvResultText = findViewById(R.id.tvResultText)
        this.tvResultNumber = findViewById(R.id.tvResultNumber)
        this.tvSorting = findViewById(R.id.tvSorting)
        btTentativa.setOnClickListener{
            val tentativa = this.edTentativa.text
                this@MainActivity.tvPreResultText.setText("o Número Sorteado é:")
                this@MainActivity.tvResultNumber.setText(this.randomValue.toString())
            if(tentativa.toString().toIntOrNull() === this.randomValue){
                this@MainActivity.tvResultText.setText("Você Acertou!")
            }else{
                this@MainActivity.tvResultText.setText("Você Errou!")
            }
            for(x in 1..5){
                Handler().postDelayed(Runnable {
                    this@MainActivity.tvSorting.setText("Sorteando Novamente"+".".repeat(x))
                }, (1000*x).toLong())

            }
            Handler().postDelayed(Runnable {
                sortGame();
            }, 5000)
        }
    }


    override fun onResume(){
        super.onResume();
        this.sortGame();

    }
    private fun sortGame() {
        this.randomValue = Random.nextInt(1, 101)
        Log.i("APP_ACERTE", randomValue.toString())
        val divisibleNumbers = ArrayList<Int>();
        val isEven = randomValue % 2 == 0;
        var divisibleNumbersCount = 0;
        for(x in 1..11){
            if(randomValue % x == 0){
                divisibleNumbers.add(x)
            }
        }
        for(x in 2 until randomValue){
            if(randomValue % x == 0){
                divisibleNumbersCount += 1
            }
        }
        this@MainActivity.tvDica1.setText("De 1 a 10, é divisivel por: "+divisibleNumbers.joinToString(" "))
        this@MainActivity.tvDica2.setText(if(isEven) "É Par" else "O Número não é par")
        this@MainActivity.tvDica3.setText("Tem "+divisibleNumbersCount+" divisores")
        clearFields();
    }
    private fun clearFields(){
        this@MainActivity.edTentativa.setText("")
        this@MainActivity.tvResultText.text = ""
        this@MainActivity.tvResultNumber.text = ""
        this@MainActivity.tvPreResultText.text = ""
        this@MainActivity.tvSorting.text = ""
    }
}