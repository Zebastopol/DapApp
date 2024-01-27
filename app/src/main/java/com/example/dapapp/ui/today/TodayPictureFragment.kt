package com.example.dapapp.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.dapapp.databinding.FragmentTodayPictureBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodayPictureFragment : Fragment() {

    private var _binding: FragmentTodayPictureBinding? = null
    private val binding get() = _binding!!
    private val todayPictureViewModel by viewModels <TodayPictureViewModel>()
    //private val args: TodayPictureFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        //todayPictureViewModel.getApod(args.date)
    }

    private fun initUi() {
        initListeners()
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                todayPictureViewModel.state.collect {
                    when (it) {
                        AstronomicTodayState.Loading -> loadingState()
                        is AstronomicTodayState.Error -> errorState()
                        is AstronomicTodayState.Success -> successState(it)

                    }
                }
            }
        }
    }

    private fun successState(state: AstronomicTodayState.Success) {
        val image = state.hdurl
        binding.tvToday.text = state.explanation
        binding.todayImage.setImageURI(image.toUri())
    }

    private fun errorState() {

    }

    private fun loadingState() {

    }

    private fun initListeners() {

    }
}