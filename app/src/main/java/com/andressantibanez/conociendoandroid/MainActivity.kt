package com.andressantibanez.conociendoandroid

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Thread.sleep

@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity() {

    private var message: TextView? = null
    private var sayByeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.message)
        sayByeButton = findViewById(R.id.sayByeButton)

        sayByeButton?.setOnClickListener {
            SayByeTask().execute()
        }
    }

    inner class SayByeTask : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit) {
            sleep(3000)
            return
        }

        override fun onPostExecute(result: Unit) {
            message?.text = "Say Bye!"
        }
    }
}
