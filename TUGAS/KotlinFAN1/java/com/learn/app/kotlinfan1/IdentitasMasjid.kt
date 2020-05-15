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
import org.json.JSONArray
import org.json.JSONObject

class IdentitasMasjid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas_masjid)

        getnama()
        getalamat()

        val context = this

        btnUpdateIdentitas.setOnClickListener {

            var data_namaMasjid:String = editNama.text.toString()
            var data_alamatMasjid:String = editAlamat.text.toString()

            postidentitas(data_namaMasjid, data_alamatMasjid)

            val intent = Intent(context, IdentitasMasjid::class.java)
            startActivity(intent)
        }

        back1.setOnClickListener{
            val home = Intent(context, HomeActivity::class.java)
            startActivity(home)
        }

    }

    fun getnama(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/indentitas-masjid-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray: JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_masjid"))

                        nama1.setText(jsonObject.optString("nama_masjid"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun getalamat(){
        AndroidNetworking.get("https://tikasukraa.000webhostapp.com/indentitas-masjid-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray:JSONArray = response.getJSONArray("result")
                    for (i:Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("alamat_masjid"))

                        alamat1.setText(jsonObject.optString("alamat_masjid"))
                    }
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }

            })
    }

    fun postidentitas(data1:String, data2:String){

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
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
