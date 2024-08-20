package com.student.listadecontatos_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.student.listadecontatos_main.databinding.FragmentListaBinding


class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private val lista = ArrayList<Usuario>()
    private lateinit var adapter: ArrayAdapter<Usuario>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaBinding.inflate(layoutInflater)

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, lista)

        if (lista.isEmpty()) {
            lista.add(Usuario("Rhaenyra Targaryen", "rhaenyra@gmail.com", "rhaenyra123"));
            lista.add(Usuario("Daemon Targaryen", "daemon@gmail.com", "daemon123"));
            lista.add(Usuario("Viserys I Targaryen", "viserys@gmail.com", "viserys123"));
            lista.add(Usuario("Alicent Hightower", "alicent@gmail.com", "alicent123"));
            lista.add(Usuario("Otto Hightower", "otto@gmail.com", "otto123"));
            lista.add(Usuario("Corlys Velaryon", "corlys@gmail.com", "corlys123"));
            lista.add(Usuario("Rhaenys Targaryen", "rhaenys@gmail.com", "rhaenys123"));
            lista.add(Usuario("Laenor Velaryon", "laenor@gmail.com", "laenor123"));
            lista.add(Usuario("Aemond Targaryen", "aemond@gmail.com", "aemond123"));
            lista.add(Usuario("Aegon II Targaryen", "aegon@gmail.com", "aegon123"));
        }

        binding.listacontatos.adapter = adapter


        binding.listacontatos.setOnItemClickListener { parent, view, position, id ->
            val bundle = Bundle()

            bundle.putSerializable("usuario", lista[position])

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_listaFragment_to_detalhesFragment, bundle)
        }

        return binding.root
    }

}