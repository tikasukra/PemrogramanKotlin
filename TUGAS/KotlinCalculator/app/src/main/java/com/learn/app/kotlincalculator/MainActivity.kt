package com.learn.app.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumlah.setOnClickListener {
            tambah()
        }

        kurang.setOnClickListener(){
            kurang()
        }

        kali.setOnClickListener(){
           kali()
        }

        bagi.setOnClickListener(){
            bagi()
        }
    }


    fun tambah(){
        var bilangan1:String = bil1.text.toString()
        var bilangan2:String = bil2.text.toString()

        var a:Int = bilangan1.toInt()
        var b:Int = bilangan2.toInt()

        var c:Int = a + b
        hasil.setText(c.toString())
    }

    fun kurang () {
        var bilangan1:String = bil1.text.toString()
        var bilangan2:String = bil2.text.toString()

        var a:Int = bilangan1.toInt()
        var b:Int = bilangan2.toInt()

        var d:Int = a - b

        hasil.setText(d.toString())
    }

    fun kali () {
        var bilangan1:String = bil1.text.toString()
        var bilangan2:String = bil2.text.toString()

        var a:Int = bilangan1.toInt()
        var b:Int = bilangan2.toInt()

        var e:Int = a * b

        hasil.setText(e.toString())
    }

    fun bagi () {
        var bilangan1:String = bil1.text.toString()
        var bilangan2:String = bil2.text.toString()

        var a:Double = bilangan1.toDouble()
        var b:Double = bilangan2.toDouble()

        var f:Double = a / b

        hasil.setText(f.toString())
    }

}
