package com.learn.app.kotlinloginmhs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_insert.*
import org.json.JSONArray

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val context = this
        btnInput.setOnClickListener {
            var input_nim:String = inputNIM.text.toString()
            var input_nama:String = inputNama.text.toString()
            var input_prodi:String = inputProdi.text.toString()

            inputdata(input_nim, input_nama, input_prodi)

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun inputdata(data1: String, data2: String, data3: String) {
        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/tambah-mahasiswa.php")
            .addBodyParameter("nim_mhs", data1)
            .addBodyParameter("nama_mhs", data2)
            .addBodyParameter("prodi", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener{
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }

}



