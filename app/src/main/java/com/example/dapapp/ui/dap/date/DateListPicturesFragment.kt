package com.example.dapapp.ui.dap.date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dapapp.databinding.FragmentDateListPicturesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DateListPicturesFragment : Fragment() {

    private val dateListViewModel by viewModels<DateListViewModel>()
    private var _binding: FragmentDateListPicturesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDateListPicturesBinding.inflate(inflater, container, false)
        return binding.root
    }


}