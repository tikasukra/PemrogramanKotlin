package com.learn.app.kotlinfan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pengumuman_masjid.*
import org.json.JSONArray
import org.json.JSONObject

class PengumumanMasjid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman_masjid)

        getjudul()
        getisi()

        val context = this

        back4.setOnClickListener{
            val home = Intent(context, HomeActivity::class.java)
            startActivity(home)
        }

        btnUpdatePengumuman.setOnClickListener {

            var data_judul:String = editJudul.text.toString()
            var data_isi:String = editIsi.text.toString()

            postpengumuman(data_judul, data_isi)

            val intent = Intent(context, PengumumanMasjid::class.java)
            startActivity(intent)
        }

    }

    fun getjudul(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/pengumuman-masjid-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray: JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("judul_pengumuman"))

                        judul.setText(jsonObject.optString("judul_pengumuman"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getisi(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/pengumuman-masjid-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray: JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("isi_pengumuman"))

                        isipengumuman.setText(jsonObject.optString("isi_pengumuman"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }


    fun postpengumuman(data1:String, data2:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

}
