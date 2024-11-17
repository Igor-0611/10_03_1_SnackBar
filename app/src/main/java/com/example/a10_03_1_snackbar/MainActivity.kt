package com.example.a10_03_1_snackbar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputET: EditText
    private lateinit var outputTV: TextView
    private lateinit var saveBTN: Button
    private lateinit var clearBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputET = findViewById(R.id.inputET)
        outputTV = findViewById(R.id.outputTV)
        saveBTN = findViewById(R.id.saveBTN)
        clearBTN = findViewById(R.id.clearBTN)

        saveBTN.setOnClickListener { v ->
            outputTV.text = inputET.text
        }

        clearBTN.setOnClickListener { v ->
            val snackbar = Snackbar.make(v, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить") {
                    outputTV.text = resources.getString(R.string.outputTV)
                    Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_LONG).show()
                }
            snackbar.show()
        }
    }
}