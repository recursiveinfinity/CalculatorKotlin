package com.example.sidd.calculatorkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_log.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class LogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        val logs = intent.getStringArrayListExtra("Logs")
        val stringBuilder = StringBuilder()
        for (log in logs) {
            stringBuilder.append(log)
            stringBuilder.append("\n")
        }
        tvLogs.text = stringBuilder.toString()
    }
}