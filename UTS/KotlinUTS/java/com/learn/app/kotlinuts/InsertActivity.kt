package com.learn.app.kotlinuts

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
            var input_nama:String = inputNama.text.toString()
            var input_ttl:String = inputTTL.text.toString()
            var input_hp:String = inputHP.text.toString()
            var input_alamat:String = inputAlamat.text.toString()

            inputdata(input_nama, input_ttl, input_hp, input_alamat)

            val intent = Intent(context, DataPenduduk::class.java)
            startActivity(intent)
        }
    }

    fun inputdata(data1: String, data2: String, data3: String, data4: String) {
        AndroidNetworking.post("http://192.168.43.232/uts-kotlin/tambah-penduduk.php")
            .addBodyParameter("nama_penduduk", data1)
            .addBodyParameter("ttl_penduduk", data2)
            .addBodyParameter("hp_penduduk", data3)
            .addBodyParameter("alamat_penduduk", data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }

}
