package com.example.dapapp.ui.dap.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dapapp.databinding.FragmentCalendarPictureBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarPictureFragment : Fragment() {

    private var _binding: FragmentCalendarPictureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

}