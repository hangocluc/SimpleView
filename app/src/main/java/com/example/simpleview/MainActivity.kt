package com.example.simpleview

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
lateinit var  filepath:Uri
    lateinit var animal:Spinner
    lateinit var result:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animal = arrayOf( "phú thọ", "phúc thọ", "đà lạt")

        val arrayAdapter = ArrayAdapter(this, R.layout.spinner, animal)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener

        image.setOnClickListener {
            startFileChooser()
        }



        val spannable_name = SpannableString("Tình Trạng Hôn Nhân *")
        spannable_name.setSpan(
            ForegroundColorSpan(Color.RED),
            20, 21,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txt.text = spannable_name

        val spannable_b = SpannableString("Giới Tính *")
        spannable_b.setSpan(
            ForegroundColorSpan(Color.RED),
            10,11,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

        )
        txt2.text= spannable_b

        val spannable_c = SpannableString("Nơi Sinh *")
        spannable_c.setSpan(
            ForegroundColorSpan(Color.RED),
            9,10,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txt3.text =spannable_c
    }



    private fun startFileChooser() {
       var i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i,"choose pictuare"),111)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK && data != null){
//            filepath = data.data!!
//            var bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filepath)
//            image.setImageBitmap(bitmap)
            data.data?.let {
                image.setImageURI(it)
            }

        }
    }
}

