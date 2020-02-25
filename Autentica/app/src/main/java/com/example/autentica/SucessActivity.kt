package com.example.autentica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SucessActivity : AppCompatActivity() {
    private lateinit var tvLogado : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        this.tvLogado = findViewById(R.id.tvLogado)
        val profileName=intent.getStringExtra("Username")
        tvLogado.text = "Bem vindo, "+profileName
    }
}
