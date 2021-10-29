package com.example.trackerapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.trackerapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

//Colect data from repository and provide for all fragments
@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

}