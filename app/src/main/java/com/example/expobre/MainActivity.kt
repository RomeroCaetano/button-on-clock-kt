package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.expobre.Util.MegaSena

class MainActivity : AppCompatActivity() {
    private lateinit var tvNumbers : TextView
    private lateinit var btSort : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btSort = findViewById(R.id.btSort)
        this.tvNumbers = findViewById(R.id.tvNumbers)
        btSort.setOnClickListener{
            this.tvNumbers.text = MegaSena.getInstance().sorted()
                .joinToString(" ")
        }

    }
}
