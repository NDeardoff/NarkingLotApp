package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.location_pg.*
import java.util.zip.ZipEntry

// Creates the Location instance and is required for an activity
class LocationPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_pg)

        // stores values from other pages
        val lMake = intent.getStringExtra("Make");
        val lModel = intent.getStringExtra("Model")
        val lColor = intent.getStringExtra("Color")
        val lPlate = intent.getStringExtra("Plate")
        val lVin = intent.getStringExtra("VIN")

        // stores values from other pages and creates a variable to reset the values for this page
        val setLocation = intent.getStringExtra("Location")
        val setAddress = intent.getStringExtra("Address")
        val setCity = intent.getStringExtra("City")
        val setZip = intent.getStringExtra("Zip")

        // stores values from other pages
        val lFirst = intent.getStringExtra("FirstN")
        val lLast = intent.getStringExtra("LastN")
        val lHaddress = intent.getStringExtra("HAddress")
        val lHcity = intent.getStringExtra("HCity")
        val lHzip = intent.getStringExtra("HZIP")
        val lDLnum = intent.getStringExtra("DLnum")
        val lDLstate = intent.getStringExtra("DLstate")

        //val spinnerL = intent.getStringExtra("SpinnerL")
        val spinnerO = intent.getStringExtra("SpinnerO")
        val spinnerS = intent.getStringExtra("SpinnerS")

        // sets the text fields to the stored values
        locationEnter.setText(setLocation)
        streetEnter.setText(setAddress)
        cityEnter.setText(setCity)
        zipEnter.setText(setZip)



        // Sends user to Submitter Page
        nextButton.setOnClickListener{
            val intent = Intent(this, SubmitterPgActivity :: class.java)


            // turns the entered text into a variable to be used
            val location = locationEnter.text.toString()
            val address = streetEnter.text.toString()
            val city = cityEnter.text.toString()
            val zip = zipEnter.text.toString()

            val spinnerL = Statespinner.getSelectedItem().toString()

            // sends location values to next page
            intent.putExtra("Location", location)
            intent.putExtra("Address", address)
            intent.putExtra("City", city)
            intent.putExtra("ZIP", zip)

            // sends offender values to next page
            intent.putExtra("Make", lMake)
            intent.putExtra("Model", lModel)
            intent.putExtra("Color", lColor)
            intent.putExtra("Plate", lPlate)

            // sends submitter values to next page
            intent.putExtra("FirstN", lFirst)
            intent.putExtra("LastN", lLast)
            intent.putExtra("HAddress", lHaddress)
            intent.putExtra("HCity", lHcity)
            intent.putExtra("HZIP", lHzip)
            intent.putExtra("DLnum", lDLnum)
            intent.putExtra("DLstate", lDLstate)

            intent.putExtra("SpinnerL", spinnerL)
            intent.putExtra("SpinnerO", spinnerO)
            intent.putExtra("SpinnerS", spinnerS)


            //FORM COMPLETION
            if(locationEnter.text.toString()=="" ||
               streetEnter.text.toString()=="" ||
               cityEnter.text.toString()=="" ||
               zipEnter.text.toString()=="" ||
               Statespinner.selectedItem.equals("Select One")){
                        val builder = AlertDialog.Builder(this@LocationPgActivity)
                        builder.setTitle("FORM INCOMPLETE")
                        builder.setMessage("Please complete all fields before moving to the next page.")
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                }else {
                    startActivity(intent)
                }

        }

        // Sends user back to Offender Page
        preButton.setOnClickListener{
            val intent = Intent(this, OffenderPgActivity :: class.java)

            // turns the entered text into a variable to be used
            val location = locationEnter.text.toString()
            val address = streetEnter.text.toString()
            val city = cityEnter.text.toString()
            val zip = zipEnter.text.toString()

            val spinnerValL = Statespinner.getSelectedItem().toString()

            // sends location values  to previous page
            intent.putExtra("Location", location)
            intent.putExtra("Address", address)
            intent.putExtra("City", city)
            intent.putExtra("ZIP", zip)

            // sends offender values to previous page
            intent.putExtra("Make", lMake)
            intent.putExtra("Model", lModel)
            intent.putExtra("Color", lColor)
            intent.putExtra("Plate", lPlate)
            intent.putExtra("Vin", lVin)

            // sends submitter values to previous page
            intent.putExtra("FirstN", lFirst)
            intent.putExtra("LastN", lLast)
            intent.putExtra("HAddress", lHaddress)
            intent.putExtra("HCity", lHcity)
            intent.putExtra("HZIP", lHzip)
            intent.putExtra("DLnum", lDLnum)
            intent.putExtra("DLstate", lDLstate)

            intent.putExtra("SpinnerL", spinnerValL)
            intent.putExtra("SpinnerO", spinnerO)
            intent.putExtra("SpinnerS", spinnerS)

            startActivity(intent)
        }

        // Sets the entry fields to nothing
        resetbuttonL.setOnClickListener{
            locationEnter.setText("")
            streetEnter.setText("")
            cityEnter.setText("")
            zipEnter.setText("")
        }
    }
}