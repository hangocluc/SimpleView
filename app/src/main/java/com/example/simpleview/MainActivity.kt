package com.example.simpleview

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.ForegroundColorSpan
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animal = arrayOf( "", "phú thọ", "phúc thọ", "đà lạt")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, animal)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener


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
}

