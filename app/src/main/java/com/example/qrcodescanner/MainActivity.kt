package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    private lateinit var buttonScan : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonScan = findViewById(R.id.buttonScan)
        buttonScan.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this@MainActivity)
            intentIntegrator.setOrientationLocked(false) // Imposta l'orientamento libero
            intentIntegrator.setPrompt("Scansiona il QR code")
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            intentIntegrator.setCameraId(0)
            intentIntegrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                // Avvia l'activity TodoListActivity passando il contenuto dello scan come extra
                val intent = Intent(this, TodoList::class.java)
                intent.putExtra("qr_content", result.contents)
                startActivity(intent)
            }
        }
    }
}
