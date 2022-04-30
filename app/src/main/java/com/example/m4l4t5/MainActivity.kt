package com.example.m4l4t5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.app.Activity
import android.content.Intent

import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        textView = findViewById(R.id.result)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val user = User("SHodiyor","Xurramov","Meyli o'g'li")
            shareInfoToSecondActivity(user)
        }
    }

    private fun shareInfoToSecondActivity(user: User) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("user", user)
        getResponseFromSecondActivity.launch(intent)
    }

    var getResponseFromSecondActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            textView.text = data!!.getParcelableExtra<Member>("respond").toString()
        }
    }

}