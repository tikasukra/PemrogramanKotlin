package com.learn.app.kotlinfloatingactionbutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var snack: Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowSnack()
    }

    fun OnCLick(view : View){
        ShowSnack()
    }

    fun ShowSnack(){
        val activityView: View = findViewById(R.id.activity_main)
        snack = Snackbar.make(activityView, "this is my snackbar test", Snackbar.LENGTH_SHORT)
        snack.setAction("Dismiss") {
            snack.dismiss()
        }
        val snackbarLayout:View = snack.view
        snackbarLayout.setBackgroundColor(resources.getColor(R.color.colorAccent))
        val sntextView:TextView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_text)
        val snAction:TextView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_action)
        sntextView.setTextColor(Color.WHITE)
        snAction.setTextColor(Color.GRAY)
        sntextView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_attach, 0, 0, 0)
        sntextView.compoundDrawablePadding = 12
                snack.show()
    }
}

