package com.learn.app.kotlinloginmhs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
        val stat = sharedPreferences.getString("STATUS", "")

        if (stat=="1") {

            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()

        } else {

            btnLogin.setOnClickListener {

                var username = editUsername.text.toString()
                var password = editPassword.text.toString()

                postkeserver(username, password)

            }
        }
    }

    fun postkeserver(data1: String, data2: String) {

        AndroidNetworking.post("https://tikasukraa.000webhostapp.com/ceklogin.php")
            .addBodyParameter("username", data1)
            .addBodyParameter("password", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("status"))
                        var statusLogin = jsonObject.optString("status")

                        if(statusLogin=="1") {
                            val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()

                            editor.putString("STATUS", statusLogin)
                            editor.apply()

                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        } else {
                            txt.setText("Username atau Password Salah!")
                        }

                    }

                }

                override fun onError(anError: ANError?) {

                }

            })

    }

}
