package com.example.narcinglotapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.offender_pg.*




// Creates the Offender instance and is required for an activity
class OffenderPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offender_pg)

        // stores values from other pages and creates a variable to reset the values for this page
        val setMake = intent.getStringExtra("Make")
        val setModel = intent.getStringExtra("Model")
        val setColor = intent.getStringExtra("Color")
        val setPlate = intent.getStringExtra("Plate")

        // stores values from other pages
        val oLocation = intent.getStringExtra("Location")
        val oAddress = intent.getStringExtra("Address")
        val oCity = intent.getStringExtra("City")
        val oZip = intent.getStringExtra("Zip")

        // stores values from other pages
        val oFirst = intent.getStringExtra("FirstN")
        val oLast = intent.getStringExtra("LastN")
        val oHaddress = intent.getStringExtra("HAddress")
        val oHcity = intent.getStringExtra("HCity")
        val oHzip = intent.getStringExtra("HZIP")
        val oDLnum = intent.getStringExtra("DLnum")
        val oDLstate = intent.getStringExtra("DLstate")

        val spinnerL = intent.getStringExtra("SpinnerL")
        //val spinnerO = intent.getStringExtra("SpinnerO")
        val spinnerS = intent.getStringExtra("SpinnerS")

        // sets the text fields to the stored values
        MakeEnter.setText(setMake)
        ModelEnter.setText(setModel)
        ColorEnter.setText(setColor)
        PlateEnter.setText(setPlate)


        // Sends user to Location Page
        NextPgbtn.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)


            // turns the entered text into a variable to be used
            val make = MakeEnter.text.toString()
            val model = ModelEnter.text.toString()
            val color = ColorEnter.text.toString()
            val plate = PlateEnter.text.toString()

            val spinnerO = Offspinner.getSelectedItem().toString()

            // sends offender values to next page
            intent.putExtra("Make", make)
            intent.putExtra("Model", model)
            intent.putExtra("Color", color)
            intent.putExtra("Plate", plate)

            // sends location values to next page
            intent.putExtra("Location", oLocation)
            intent.putExtra("Address", oAddress)
            intent.putExtra("City", oCity)
            intent.putExtra("ZIP", oZip)

            // sends submitter values to next page
            intent.putExtra("FirstN", oFirst)
            intent.putExtra("LastN", oLast)
            intent.putExtra("HAddress", oHaddress)
            intent.putExtra("HCity", oHcity)
            intent.putExtra("HZIP", oHzip)
            intent.putExtra("DLnum", oDLnum)
            intent.putExtra("DLstate", oDLstate)

            intent.putExtra("SpinnerL", spinnerL)
            intent.putExtra("SpinnerO", spinnerO)
            intent.putExtra("SpinnerS", spinnerS)

            //FORM COMPLETION
            if(MakeEnter.text.toString()=="" ||
                ModelEnter.text.toString()=="" ||
                ColorEnter.text.toString()=="" ||
                PlateEnter.text.toString()=="" ||
                Offspinner.selectedItem.equals("Select One")){
                    val builder = AlertDialog.Builder(this@OffenderPgActivity)
                    builder.setTitle("FORM INCOMPLETE")
                    builder.setMessage("Please complete all fields before moving to the next page.")
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
            }else {
                startActivity(intent)
            }
        }

        // Sets the entry fields to nothing
        resetButton.setOnClickListener{
            MakeEnter.setText("")
            ModelEnter.setText("")
            ColorEnter.setText("")
            PlateEnter.setText("")

        }

        // creates an on click listener for the open camera button that calls the open camera function
        button.setOnClickListener{
            // this opens up the default camera app on the phone
            var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 142)
        }

        // creates an on click listener for the pick picture button that opens the gallery
        button2.setOnClickListener{
            // opens the gallery to get a picture
            val pickPictureIntent = Intent(Intent.ACTION_PICK)
            pickPictureIntent.type = "image/*"
            startActivityForResult(pickPictureIntent, 150)
        }

    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // checks if it is using the camera
        if(requestCode == 142){
            var bmp1=data?.extras?.get("data") as Bitmap
            imageViewO.setImageBitmap(bmp1)
        }
        // checks if it is using the gallery
        if(requestCode == 150){
            imageViewO.setImageURI(data?.data)
        }

    }*/


}