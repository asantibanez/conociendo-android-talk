package com.andressantibanez.conociendoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message: TextView = findViewById(R.id.message)
        val sayByeButton: Button = findViewById(R.id.sayByeButton)

        sayByeButton.setOnClickListener {
            Thread(Runnable {
                sleep(3000)
                runOnUiThread {
                    message.text = "Say Bye!"
                }
            }).start()
        }
    }

}
