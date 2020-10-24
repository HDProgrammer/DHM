package com.ihdovanay.dhm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun hesapla(v : View){
        try {
            var i : Double
            var deger1:String = editNumber1.text.toString()
            var deger2:String = editNumber2.text.toString()

            if (deger1 == "" || deger2 == ""){throw Exception()}
            when {
                radioButton_arti.isChecked -> {
                    i = (deger1.toDouble() + deger2.toDouble())
                    if (i-i.toInt()>0){
                        textView_sonuc.text = i.toString()
                    }else{textView_sonuc.text = i.toInt().toString()}
                }
                radioButton_eksi.isChecked -> {
                    i = (deger1.toDouble() - deger2.toDouble())
                    if (i-i.toInt()>0){
                        textView_sonuc.text = i.toString()
                    }else{textView_sonuc.text = i.toInt().toString()}
                }
                radioButton_bolu.isChecked -> {
                    if(editNumber2.text.toString().toInt() == 0){
                        throw Exception()
                    }else{
                        i = (deger1.toDouble() / deger2.toDouble())
                        if (i-i.toInt()>0){
                            textView_sonuc.text = i.toString()
                        }else{textView_sonuc.text = i.toInt().toString()}
                    }
                }
                radioButton_carpi.isChecked -> {
                    i = (deger1.toDouble() * deger2.toDouble())
                    if (i-i.toInt()>0){
                        textView_sonuc.text = i.toString()
                    }else{textView_sonuc.text = i.toInt().toString()}
                }
                else -> {throw Exception()}
            }
        }catch (e: Exception){
            textView_sonuc.text = "Yanlış/Eksik Değer Girdiniz."
        }
    }
}