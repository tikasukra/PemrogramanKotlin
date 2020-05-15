package com.learn.app.kotlinuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_data_penduduk.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class DataPenduduk : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_penduduk)
        val context = this

        btnKembali.setOnClickListener {
            val kembali = Intent(context, MainActivity::class.java)
            startActivity(kembali)
        }

        btnPindah.setOnClickListener {
            val pindah = Intent(context, InsertActivity::class.java)
            startActivity(pindah)
        }

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<User>()

        AndroidNetworking.get("http://192.168.43.232/uts-kotlin/penduduk-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_penduduk"))

                        var isi1 = jsonObject.optString("nama_penduduk").toString()
                        var isi2 = jsonObject.optString("ttl_penduduk").toString()
                        var isi3 = jsonObject.optString("hp_penduduk").toString()
                        var isi4 = jsonObject.optString("alamat_penduduk").toString()

                        users.add(User("$isi1", "$isi2", "$isi3", "$isi4"))
                    }

                    val adapter = CustomAdapter(users)
                    recyclerView.adapter = adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })


    }
}