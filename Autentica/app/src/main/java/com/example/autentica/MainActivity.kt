package com.example.autentica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edUsuario : EditText
    private lateinit var edSenha : EditText
    private lateinit var btOk : Button
    private lateinit var btCancel : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.edUsuario = findViewById(R.id.edUsuario)
        this.edSenha = findViewById(R.id.edSenha)
        this.btOk = findViewById(R.id.btOk)
        this.btCancel = findViewById(R.id.btCancel)

        btCancel.setOnClickListener {
            Log.i("APP_AUTENTICA", "i- Cancelou")
            Toast.makeText(this, "Você Cancelou", Toast.LENGTH_SHORT).show()
            this.edUsuario.text.clear()
            this.edSenha.text.clear()
        }
        btOk.setOnClickListener(OnClickBotao())
    }
    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            var usuario = this@MainActivity.edUsuario.text.toString()
            var senha = this@MainActivity.edSenha.text.toString()

            Log.i("APP_AUTENTICA", "Login Usuário")
            if(usuario == "admin" && senha == "1234"){
                val intent = Intent(this@MainActivity, SucessActivity::class.java)
                intent.putExtra("Username", usuario)
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity, "Falha ao Login!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
