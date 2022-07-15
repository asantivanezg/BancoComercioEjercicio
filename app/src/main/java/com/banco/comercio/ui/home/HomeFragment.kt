package com.banco.comercio.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.banco.comercio.R
import com.banco.comercio.databinding.FragmentHomeBinding
import com.banco.comercio.domain.model.User
import com.banco.comercio.ui.detail.DetailFragment
import com.banco.comercio.util.Status
import com.banco.comercio.util.showToast
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), UserAdapter.UserAdapterListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        init()
        subscribe()
        setupRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        homeViewModel.getUserList()
    }

    private fun subscribe() {
        homeViewModel.userList.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    val res = it.data
                    if (res?.isNotEmpty() == true) {
                        userAdapter.updateList(res)
                    } else {
                        // Mostrar que no hay información
                    }
                }
                Status.ERROR -> {
                    showToast(getString(R.string.error), Toast.LENGTH_LONG)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(this)
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
            setHasFixedSize(false)
        }
    }

    override fun onCLickUserItem(user: User) {
        val bundle = Bundle()
        bundle.putString(DetailFragment.USER_BUNDLE, GsonBuilder().create().toJson(user))
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}