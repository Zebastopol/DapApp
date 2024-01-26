package com.example.dapapp.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dapapp.databinding.FragmentTodayPictureBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodayPictureFragment : Fragment() {

    private var _binding: FragmentTodayPictureBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayPictureBinding.inflate(inflater, container, false)
        return binding.root
    }


}