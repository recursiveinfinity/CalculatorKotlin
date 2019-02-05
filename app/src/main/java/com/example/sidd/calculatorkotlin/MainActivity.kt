package com.example.sidd.calculatorkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val hello: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        btnAdd.setOnClickListener { handleAdd() }
    }

    private fun handleAdd() {
        hello?.length
        hello?.length!!
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnAdd -> handleAdd()
            R.id.btnLogs -> handleLogs()
        }
    }

    private fun handleLogs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
