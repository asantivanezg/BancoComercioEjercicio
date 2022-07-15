package com.banco.comercio.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banco.comercio.databinding.FragmentDetailBinding
import com.banco.comercio.domain.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = GsonBuilder().create().fromJson(arguments?.getString(USER_BUNDLE), User::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        with(binding) {
            tvNombre.text = user.nombre
            tvEmail.text = user.email
            tvTelefono.text = user.telefono
            tvPaginaWeb.text = user.paginaWeb
        }
    }

    companion object {
        val USER_BUNDLE = "USER_BUNDLE"
    }
}