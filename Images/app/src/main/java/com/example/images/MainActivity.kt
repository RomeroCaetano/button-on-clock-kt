package com.example.images

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var btCamera : Button
    private lateinit var btArquivo : Button
    private lateinit var btDownload: Button
    private lateinit var ivImagem : ImageView
    val CAMERA = 1
    var downloadValue : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btCamera = findViewById(R.id.btCamera)
        this.btArquivo = findViewById(R.id.btArquivo)
        this.btDownload = findViewById(R.id.btDownload)
        this.ivImagem = findViewById(R.id.ivImagem)

        this.btCamera.setOnClickListener{camera()}
        this.btArquivo.setOnClickListener{xml()}
        this.btDownload.setOnClickListener{download()}

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CAMERA){
            val imagem = data?.extras?.get("data") as Bitmap
            this.ivImagem.setImageBitmap(imagem)
        }
    }
    fun camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)

    }
    fun xml(){
        this.ivImagem.setImageResource(R.drawable.super_mario)
    }
    fun downloadImage(url:String) : Bitmap{
        URL(url).openStream().use{
            val imagem = BitmapFactory.decodeStream(it)
            return imagem
        }
    }
    fun download(){
        val builder = AlertDialog.Builder(this@MainActivity)
        val inflater = this@MainActivity.layoutInflater
        val mView : View = inflater.inflate(R.layout.dialog_radio_group, null)
        builder.setView(mView)
        builder.setPositiveButton("YES"){dialog, which ->
            val selectedId : Int = mView.findViewById<RadioGroup>(R.id.rgDialog).checkedRadioButtonId
            val selectedRadio = mView.findViewById<RadioButton>(selectedId)
            this@MainActivity.downloadAndExibes(selectedRadio.text.toString())

        }
        builder.create().show()

    }
    fun downloadAndExibes(selectedText :String){
        var downloadLink : String = "http://www.valeria.eti.br/sm/sm_"
        when(selectedText){
            "LDPI" ->  downloadLink += "ldpi.png"
            "MDPI" -> downloadLink += "mdpi.png"
            "HDPI" -> downloadLink += "hdpi.png"
            "XHDPI"-> downloadLink += "xhdpi.png"
            "XXHDPI"-> downloadLink += "xxhdpi.png"
            "XXXHDPI" -> downloadLink += "xxxhdpi.png"
            else -> downloadLink = "ldpi.png"
        }
        val handler = Handler()
        Thread{
            val imagem = this.downloadImage(downloadLink)
            handler.post{
                this.ivImagem.setImageBitmap(imagem)
            }
        }.start()
    }
}
