package com.example.popup

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btMessage : Button = findViewById(R.id.btMessage)
        val btInput : Button = findViewById(R.id.btInput)
        val btDate : Button = findViewById(R.id.btDate)
        val btHour : Button = findViewById(R.id.btHour)
        val btValues : Button = findViewById(R.id.btValues)
        val btSwitch : Button = findViewById(R.id.btSwitch)
        val btUnique : Button  = findViewById(R.id.btUnique)
        val btVarios : Button = findViewById(R.id.btVarios)

        btMessage.setOnClickListener{message()}
        btInput.setOnClickListener{input()}
        btDate.setOnClickListener{date()}
        btHour.setOnClickListener{hour()}
        btValues.setOnClickListener{values()}
        btSwitch.setOnClickListener{switch()}
        btUnique.setOnClickListener{unique()}
        btVarios.setOnClickListener{varios()}

    }
    fun message(){
        val janela = AlertDialog.Builder(this)
        janela.setTitle("Mensagem")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Que Bom !")
        janela.setPositiveButton("Ok") {_, _ ->
            Toast.makeText(this, "Passou OK", Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun input(){
        val janela = AlertDialog.Builder(this)
        val view : View = EditText(this)
        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val msg = (view as EditText).text.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun date(){
        val janela = AlertDialog.Builder(this)
        val view : View = DatePicker(this)
        janela.setTitle("Data")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Selecione uma data !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val dp = view as DatePicker
            val msg = "${dp.dayOfMonth}/${dp.month+1}/${dp.year}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun hour(){
        val janela = AlertDialog.Builder(this)
        val view : View = TimePicker(this)
        (view as TimePicker).is24HourView
        janela.setTitle("Hora")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val tp = view as TimePicker
            var msg = ""
            if(Build.VERSION.SDK_INT < 23){
                msg = "${tp.currentHour}:${tp.currentMinute}"
            }else{
                msg = "${tp.hour}:${tp.minute}"
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun values(){
        val janela = AlertDialog.Builder(this)
        val view : View = SeekBar(this)
        (view as SeekBar).max = 100
        janela.setTitle("Faixa de Valores")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val sb = view as SeekBar
            val msg = sb.progress.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun switch(){
        val janela = AlertDialog.Builder(this)
        val view : View = Switch(this)
        janela.setTitle("Escolha")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val sw = view as Switch
            val msg = sw.isChecked.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun unique(){
        val janela = AlertDialog.Builder(this)
        val view : View = RadioGroup(this)
        val rg = view as RadioGroup
        val rb1 = RadioButton(this)
        rb1.text = "Teste1"
        val rb2 = RadioButton(this)
        rb2.text = "Teste2"
        rg.addView(rb1)
        rg.addView(rb2)
        janela.setTitle("Único")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            var msg = "Nenhum Item Selecionado!"
            if(rg.checkedRadioButtonId !== -1)
                msg = rg.findViewById<RadioButton>(rg.checkedRadioButtonId).text.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passed Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passed Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun varios(){
        val janela = AlertDialog.Builder(this)
        val view : View = LinearLayout(this)
        val ly = view as LinearLayout
        val cb1 = CheckBox(this)
        cb1.text = "Teste1"
        val cb2 = CheckBox(this)
        cb2.text = "Teste2"
        ly.addView(cb1)
        ly.addView(cb2)
        janela.setTitle("Varios")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase !")
        janela.setView(view)
        janela.setPositiveButton("Ok") {_, _ ->
            val checkBoxes : ArrayList<CheckBox> = ArrayList()
            val countChild : Int = ly.childCount
            for (i in 0 until countChild) {
                var view: View = ly.getChildAt(i)
                if (view is CheckBox) {
                    view = view
                    if(view.isChecked){
                        checkBoxes.add(view)
                    }
                }
            }
            var msg = ""
            for (checkbox in checkBoxes) {
                msg += checkbox.text.toString() + "; "
            }
            if(msg.length !== 0){
                msg = msg.substring(0, msg.length-2)
            }else{
                msg = "Nenhum Selecionado!"
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancel") {_, _ ->
            Toast.makeText(this, "Passou Cancel", Toast.LENGTH_SHORT).show()
        }
        janela.setNeutralButton("Neutral") {_, _ ->
            Toast.makeText(this, "Passou Neutral", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }
}
