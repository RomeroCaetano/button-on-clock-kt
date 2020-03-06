package com.example.diversos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var btnHTML : Button
    private lateinit var btnDial : Button
    private lateinit var btnCall : Button
    private lateinit var btnShare : Button
    private lateinit var btnEmail : Button
    private lateinit var btnPMapa : Button
    private lateinit var btnRMapa : Button
    private lateinit var btnSMS : Button
    private lateinit var btnYoutube : Button
    private lateinit var btnFoto : Button
    private val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btnHTML = findViewById(R.id.btnHTML)
        this.btnDial = findViewById(R.id.btnDial)
        this.btnCall = findViewById(R.id.btnCall)
        this.btnShare = findViewById(R.id.btnShare)
        this.btnEmail = findViewById(R.id.btnEmail)
        this.btnPMapa = findViewById(R.id.btnPMapa)
        this.btnRMapa = findViewById(R.id.btnRMapa)
        this.btnSMS = findViewById(R.id.btnSMS)
        this.btnYoutube = findViewById(R.id.btnYoutube)
        this.btnFoto = findViewById(R.id.btnFoto)

        this.btnHTML.setOnClickListener{html()}
        this.btnDial.setOnClickListener{discar()}
        this.btnCall.setOnClickListener{ligar()}
        this.btnShare.setOnClickListener{compartilhar()}
        this.btnEmail.setOnClickListener{email()}
        this.btnPMapa.setOnClickListener{ponto()}
        this.btnRMapa.setOnClickListener{rota()}
        this.btnSMS.setOnClickListener{sms()}
        this.btnYoutube.setOnClickListener{youtube()}
        this.btnFoto.setOnClickListener{foto()}

    }
    fun foto(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
        startActivity(intent)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val janela = AlertDialog.Builder(this)
            janela.setTitle("Minha Foto")
            janela.setIcon(R.mipmap.ic_launcher)
            janela.setPositiveButton("ok", null)
            val imageView = ImageView(this)
            imageView.setImageBitmap(imageBitmap)
            janela.setView(imageView)
            janela.create().show()
        }
    }
    fun html(){
        val uri = Uri.parse("http://www.ifpb.edu.br")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    fun discar(){
        val uri = Uri.parse("tel:36121392")

        val intent = Intent(Intent.ACTION_DIAL, uri)

        startActivity(intent)
    }
    fun ligar(){
        val uri = Uri.parse("tel:36121392")

        val intent = Intent(Intent.ACTION_CALL, uri)

        val call = Manifest.permission.CALL_PHONE

        val granted = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(this, call) == granted){
            startActivity(intent)
        }else{
            Toast.makeText(this,"Recurso Não Disponivel", Toast.LENGTH_SHORT).show()
        }
    }
    fun compartilhar(){
        val intent = Intent(Intent.ACTION_SEND)

        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,"Texto para compartilhar")

        // intent.setPackage("com.whatsapp")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(intent, "Compartilhar"))
        }
    }
    fun email(){
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")

        val intent = Intent(Intent.ACTION_SENDTO, uri)

        intent.putExtra(Intent.EXTRA_SUBJECT,"Assunto")

        intent.putExtra(Intent.EXTRA_TEXT,"Texto")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    fun ponto(){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    fun rota(){
        val origem = "-7.1356496,-34.8760932"

        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"

        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
    fun sms(){
        val uri = Uri.parse("sms:36121392")

        val intent = Intent(Intent.ACTION_SENDTO, uri)

        intent.putExtra("sms_body"
            ,
            "Mensagem")

        startActivity(intent)
    }
    fun youtube(){
        val uri = Uri.parse("vnd.youtube://dglqGGyWbVo")

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}
