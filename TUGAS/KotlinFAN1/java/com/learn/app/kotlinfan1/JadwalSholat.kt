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
import kotlinx.android.synthetic.main.activity_tagline.*
import org.json.JSONArray
import org.json.JSONObject

class JadwalSholat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getshubuh()
        getdhuhur()
        getashar()
        getmaghrib()
        getisya()
        getdhuha()

        val context = this

        back2.setOnClickListener{
            val home = Intent(context, HomeActivity::class.java)
            startActivity(home)
        }

        btnUpdateShubuh.setOnClickListener {

            var data_shubuh:String = editJadwalSholat.text.toString()

            postshubuh(data_shubuh)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        btnUpdateDhuhur.setOnClickListener {

            var data_dhuhur:String = editJadwalSholat.text.toString()

            postdhuhur(data_dhuhur)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        btnUpdateAshar.setOnClickListener {

            var data_ashar:String = editJadwalSholat.text.toString()

            postashar(data_ashar)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        btnUpdateMaghrib.setOnClickListener {

            var data_maghrib:String = editJadwalSholat.text.toString()

            postmaghrib(data_maghrib)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        btnUpdateIsha.setOnClickListener {

            var data_isha:String = editJadwalSholat.text.toString()

            postisha(data_isha)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        btnUpdateDhuha.setOnClickListener {

            var data_dhuha:String = editJadwalSholat.text.toString()

            postdhuha(data_dhuha)

            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

    }

    fun getshubuh(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("shubuh"))

                        txt1.setText(jsonObject.optString("shubuh"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getdhuhur(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("dhuhur"))

                        txt2.setText(jsonObject.optString("dhuhur"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getashar(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("ashar"))

                        txt3.setText(jsonObject.optString("ashar"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getmaghrib(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("maghrib"))

                        txt4.setText(jsonObject.optString("maghrib"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getisya(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("isha"))

                        txt5.setText(jsonObject.optString("isha"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getdhuha(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("dhuha"))

                        txt6.setText(jsonObject.optString("dhuha"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun postshubuh(data1:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-shubuh.php")
            .addBodyParameter("shubuh", data1)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

    fun postdhuhur(data2:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-dhuhur.php")
            .addBodyParameter("dhuhur", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

    fun postashar(data3:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-ashar.php")
            .addBodyParameter("ashar", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

    fun postmaghrib(data4:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-maghrib.php")
            .addBodyParameter("maghrib", data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

    fun postisha(data5:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-isha.php")
            .addBodyParameter("isha", data5)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }

            })

    }

    fun postdhuha(data6:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-dhuha.php")
            .addBodyParameter("dhuha", data6)
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
