package com.student.listadecontatos_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.student.listadecontatos_main.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding
    private var lista = ArrayList<Usuario>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroBinding.inflate(layoutInflater)

        if (arguments != null) {
            val novalista = arguments?.getSerializable("lista") as ArrayList<Usuario>
            lista = novalista
        }

        binding.btnCadastrar.setOnClickListener {

            if (validaCadastro(
                    binding.editusername.text.toString(),
                    binding.editemail.text.toString(),
                    binding.editpassword.text.toString(),
                    binding.editconfirmpassword.text.toString()
                )
            ) {

                Toast.makeText(
                    requireContext(),
                    "Usuário cadastrado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()

                val bundle = Bundle()

                lista.add(
                    Usuario(
                        binding.editusername.text.toString(),
                        binding.editemail.text.toString(),
                        binding.editpassword.text.toString()
                    )
                )

                bundle.putSerializable(
                    "lista",
                    lista
                )

                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_cadastroFragment_to_loginFragment, bundle)
            }
        }


        return binding.root

    }

    private fun validaCadastro(
        username: String,
        email: String,
        senha: String,
        confirmaSenha: String
    ): Boolean {

        if (username.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Por favor, insira um nome de usuário",
                Toast.LENGTH_SHORT
            ).show()
        } else if (email.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Por favor, insira um email",
                Toast.LENGTH_SHORT
            ).show()
        } else if (senha.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Por favor, insira uma senha",
                Toast.LENGTH_SHORT
            ).show()
        } else if (!senha.equals(confirmaSenha)) {
            Toast.makeText(
                requireContext(),
                "As senhas devem ser iguais",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            return true
        }
        return false;
    }

}