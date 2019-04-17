package com.andressantibanez.conociendoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.kimo.lib.faker.Faker
import io.kimo.lib.faker.component.text.NameComponent

class MainActivity : AppCompatActivity() {

    var firstNameView: TextView? = null
    var lastNameView: TextView? = null
    var occupationView: TextView? = null
    var changeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameView = findViewById(R.id.firstName)
        lastNameView = findViewById(R.id.lastName)
        occupationView = findViewById(R.id.occupation)
        changeButton = findViewById(R.id.change)

        changeButton?.setOnClickListener {
            firstNameView?.text = NameComponent(this).firstName()
            lastNameView?.text = NameComponent(this).lastName()
            occupationView?.text = NameComponent(this).title()
        }
    }
}
