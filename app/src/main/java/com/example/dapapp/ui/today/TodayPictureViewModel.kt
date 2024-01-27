package com.example.dapapp.ui.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dapapp.domain.model.AstronomicItemModel
import com.example.dapapp.domain.usecase.GetAstronomicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TodayPictureViewModel @Inject constructor(private val getAstronomicUseCase: GetAstronomicUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<AstronomicTodayState>(AstronomicTodayState.Loading)
    val state: StateFlow<AstronomicTodayState> = _state

    lateinit var today: AstronomicItemModel

    fun getApod(date: AstronomicItemModel) {
        today = date
        viewModelScope.launch {
            _state.value = AstronomicTodayState.Loading
            val result =
                withContext(Dispatchers.IO) { getAstronomicUseCase(date.toString()) }
            if (result != null) {
                _state.value = AstronomicTodayState.Success(
                    result.date,
                    result.explanation,
                    result.title,
                    result.url,
                    result.copyright,
                    result.hdurl,
                    today
                )
            } else {
                _state.value = AstronomicTodayState.Error("Has been an Error, Try again later")
            }
        }
        /*getAstronomicUseCase(date).collect {
            _state.value = AstronomicItemState.success(it)
        }*/
    }


}