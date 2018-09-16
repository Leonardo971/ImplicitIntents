package com.example.leona.implicitintents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val website_edittext=findViewById<EditText>(R.id.website_edittext)

    val location_edittext=findViewById<EditText>(R.id.location_edittext)

    val share_edittext=findViewById<EditText>(R.id.share_edittext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


    fun OpenWebsite(v:View)
     {
         val url=website_edittext.toString()

         val webpage=Uri.parse(url)
         val intent=Intent(Intent.ACTION_VIEW,webpage)

         if (intent.resolveActivity(packageManager)!=null)
         {
             startActivity(intent)
         }
         else
         {
             Log.d("Implicitenst","No se puede manejar esta intencion")
         }
     }

    fun openLocation(v:View)
    {
        val loc=location_edittext.text.toString()
        val addressUri=Uri.parse("geo:0,0?q="+loc)
        val intent=Intent(Intent.ACTION_VIEW,addressUri)

        if (intent.resolveActivity(packageManager)!=null)
        {
            startActivity(intent)
        }
        else
        {
            Log.d("Implicitentes","No se pude manejar esta intencion")
        }

    }

    fun shareText(v:View)
    {
        val txt=share_edittext.text.toString()

        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text whit:")
                .setText(txt)
                .startChooser()

    }


}
