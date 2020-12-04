package com.gabrielmarrani.marvel.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabrielmarrani.marvel.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(
            R.id.containerRegister,
            RegisterFragment()
        )
        transaction.commit()




    }


}