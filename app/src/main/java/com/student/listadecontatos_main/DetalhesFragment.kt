package com.student.listadecontatos_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.student.listadecontatos_main.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    private lateinit var binding: FragmentDetalhesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetalhesBinding.inflate(layoutInflater)

        val usuario = arguments?.getSerializable("usuario") as Usuario

        binding.tvUsername.setText(usuario.username)
        binding.tvEmail.setText(usuario.email)


        return binding.root
    }

}