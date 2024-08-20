package com.student.listadecontatos_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.student.listadecontatos_main.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var lista = ArrayList<Usuario>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater)


        if (arguments != null) {
            val novalista = arguments?.getSerializable("lista") as ArrayList<Usuario>
            lista = novalista
        }

        binding.btnLogin.setOnClickListener {
            if (login(binding.etemail.text.toString(), binding.edPassword.text.toString())) {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_loginFragment_to_listaFragment)
            }
        }

        val bundle = Bundle()
        bundle.putSerializable("lista", lista)

        binding.btnCadastro.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_loginFragment_to_cadastroFragment, bundle)

        }
        return binding.root
    }

    private fun login(email: String, password: String): Boolean {
        val usuario = lista.filter { usuario ->
            usuario.email.equals(email)
        }

        if (email.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Por favor, insira um email",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else if (password.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Por favor, insira uma senha",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else if (usuario.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Usuário não encontrado",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else {
            val autenticado = usuario.size == 1 && usuario[0].password.equals(password)
            if (!autenticado) {
                Toast.makeText(
                    requireContext(),
                    "Senha incorreta",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return autenticado
        }

    }


}