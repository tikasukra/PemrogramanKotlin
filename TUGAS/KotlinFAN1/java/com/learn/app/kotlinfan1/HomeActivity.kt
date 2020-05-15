package com.learn.app.kotlinfan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val context = this

        jadwalSholat.setOnClickListener {
            val intent = Intent(context, JadwalSholat::class.java)
            startActivity(intent)
        }

        identitasMasjid.setOnClickListener {
            val intent = Intent(context, IdentitasMasjid::class.java)
            startActivity(intent)
        }

        marquee.setOnClickListener {
            val intent = Intent(context, Marquee::class.java)
            startActivity(intent)
        }

        pengumumanMasjid.setOnClickListener {
            val intent = Intent(context, PengumumanMasjid::class.java)
            startActivity(intent)
        }

        slideshow.setOnClickListener {
            val intent = Intent(context, Slideshow::class.java)
            startActivity(intent)
        }

        tagline.setOnClickListener {
            val intent = Intent(context, Tagline::class.java)
            startActivity(intent)
        }

    }
}
