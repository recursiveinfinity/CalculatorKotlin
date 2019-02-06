package com.example.sidd.calculatorkotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val logs = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener(this)
        btnSave.setOnClickListener(this)
        btnLogs.setOnClickListener(this)
        readName()
    }

    private fun handleAdd() {
        val a = etNumberOne.text.toString()
        val b = etNumberTwo.text.toString()
        if (a.isNotEmpty() && b.isNotEmpty()) {
            val result = (a.toInt() + b.toInt()).toString()
            tvResult.text = result
            logs.add(result)
        }
    }


    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnAdd -> handleAdd()
            R.id.btnLogs -> handleLogs()
            R.id.btnSave -> handleSaveClick()
        }
    }

    private fun handleSaveClick() {
        val sharedPreferences = getSharedPreferences("MySharedPreferences",
            Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Name", etName.text.toString())
        editor.apply()
        readName()
    }

    private fun readName() {
        val sharedPreferences = getSharedPreferences("MySharedPreferences",
            Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("Name", "")
        if(name.isNotEmpty()) {
            tvResult.text = getString(R.string.greeting, name)
        }
    }

    private fun handleLogs() {
        val intent = Intent(this, LogsActivity::class.java)
        intent.putStringArrayListExtra("Logs", logs)
        startActivity(intent)
    }
}
