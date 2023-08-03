package com.jsalin.oompaloompaapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsalin.oompaloompaapp.domain.item.OompaLoompaItem
import com.jsalin.oompaloompaapp.domain.usecase.GetOompaLoompasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getOompaLoompasUseCase: GetOompaLoompasUseCase
): ViewModel() {

    private val _oompaLoompas = MutableStateFlow(emptyList<OompaLoompaItem>())
    val oompaLoompas: StateFlow<List<OompaLoompaItem>> get() = _oompaLoompas

    init {
        getOompaLoompas()
    }

    private fun getOompaLoompas() {
        viewModelScope.launch {
            try {
                val oLoompas = getOompaLoompasUseCase()
                _oompaLoompas.value = oLoompas
            } catch(e: Exception) {
                e.printStackTrace()
            }
        }
    }
}