package com.andressantibanez.conociendoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    var balanceView: TextView? = null
    var progressBar: ProgressBar? = null
    var confirmButton: Button? = null
    var cancelButton: Button? = null

    var balance: Double = 0.0
    var balanceLoaded: Boolean = false

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean("balance_loaded", balanceLoaded)
        outState?.putDouble("balance", balance)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Nueva Transferencia"

        balanceView = findViewById(R.id.balance)
        progressBar = findViewById(R.id.progressBar)
        confirmButton = findViewById(R.id.confirm)
        cancelButton = findViewById(R.id.cancel)

        if (savedInstanceState != null) {
            balanceLoaded = savedInstanceState.getBoolean("balance_loaded")
            balance = savedInstanceState.getDouble("balance")
        }

        // Start
        if (!balanceLoaded) {
            Thread(Runnable {
                runOnUiThread {
                    confirmButton?.visibility = View.GONE
                    cancelButton?.visibility = View.GONE
                    progressBar?.visibility = View.VISIBLE
                }

                sleep(5000)

                balance = 4500.0
                balanceLoaded = true

                runOnUiThread {
                    balanceView?.text = "$ $balance"

                    confirmButton?.visibility = View.VISIBLE
                    cancelButton?.visibility = View.VISIBLE
                    progressBar?.visibility = View.GONE
                }
            }).start()
        } else {
            balanceView?.text = "$ $balance"
        }


        // Confirm
        confirmButton?.setOnClickListener {
            Thread(Runnable {
                runOnUiThread {
                    confirmButton?.visibility = View.GONE
                    cancelButton?.visibility = View.GONE
                    progressBar?.visibility = View.VISIBLE
                }

                sleep(5000)

                runOnUiThread {
                    confirmButton?.visibility = View.VISIBLE
                    cancelButton?.visibility = View.VISIBLE
                    progressBar?.visibility = View.GONE

                    balanceView?.text = " $ $balance - X"
                    Toast.makeText(this, "Transferencia Realizada", Toast.LENGTH_LONG).show()
                }
            }).start()
        }

        // Cancel
        cancelButton?.setOnClickListener {
            Toast.makeText(this, "Transferencia Cancelada", Toast.LENGTH_LONG).show()
        }
    }
}
