package com.gabrielmarrani.marvel.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.Navigation
import com.gabrielmarrani.marvel.R
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnRegister).setOnClickListener {

            navController.navigate(R.id.registerActivity)
        }

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val senha = view.findViewById<TextInputEditText>(R.id.txtSenhaLogin)
            val email = view.findViewById<TextInputEditText>(R.id.txtEmailLogin)
            val check = view.findViewById<MaterialCheckBox>(R.id.checkRemember)

            if(email.text.toString().isEmpty()){
                email.setError("Favor preencher campo e-mail")

            } else if(senha.text.toString().isEmpty()){
                senha.setError("Favor preencher campo senha")
            } else if (!check.isChecked){
                check.setError("Favor marcar o check")
            } else {
                navController.navigate(R.id.homeActivity)
            }

        }


    }


    }
