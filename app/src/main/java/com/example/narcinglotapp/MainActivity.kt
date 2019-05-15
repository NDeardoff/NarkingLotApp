package com.example.narcinglotapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//MAIN ACTIVITY IS THE HOME PAGE

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FORM COMPLETION


        //TESTING HOMESCREEN BRANCH

        // Sends user to Offender Page
        IVSplash.setOnClickListener{
            val intent = Intent(this, OffenderPgActivity :: class.java)
            startActivity(intent)
        }

        // Sends user to Offender Page

    }
}