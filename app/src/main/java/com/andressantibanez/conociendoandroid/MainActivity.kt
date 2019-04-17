package com.andressantibanez.conociendoandroid

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.andressantibanez.conociendoandroid.databinding.ActivityMainBinding
import io.kimo.lib.faker.Faker
import io.kimo.lib.faker.component.text.NameComponent

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.viewState = MainActivityViewState()

        binding?.change?.setOnClickListener {
            binding?.viewState = MainActivityViewState(
                firstName = NameComponent(this).firstName(),
                lastName = NameComponent(this).lastName(),
                occupation = NameComponent(this).title()
            )
        }
    }
}
