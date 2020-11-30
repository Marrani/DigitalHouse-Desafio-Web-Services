package com.gabrielmarrani.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.containerRegister, RegisterFragment())
        transaction.commit()




    }


}