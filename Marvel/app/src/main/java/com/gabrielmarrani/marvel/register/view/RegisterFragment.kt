package com.gabrielmarrani.marvel.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.gabrielmarrani.marvel.R
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnSave).setOnClickListener {

            val senha = view.findViewById<TextInputEditText>(R.id.txtSenhaRegister)
            val email = view.findViewById<TextInputEditText>(R.id.txtEmailRegister)
            val nome = view.findViewById<TextInputEditText>(R.id.txtNomeRegister)


            if(nome.text.toString().isEmpty()){
                nome.setError("Favor preencher campo e-mail")

            } else if(email.text.toString().isEmpty()){
                email.setError("Favor preencher campo senha")
            } else if (senha.text.toString().isEmpty()){
                senha.setError("Favor preencher campo nome")
            } else {
                navController.navigate(R.id.homeActivity)
            }

        }
    }

}