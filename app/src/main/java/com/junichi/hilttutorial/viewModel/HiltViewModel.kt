package com.junichi.hilttutorial.viewModel

import androidx.lifecycle.ViewModel
import com.junichi.hilttutorial.model.User
import com.junichi.hilttutorial.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableStateFlow(userRepository.getUsers())
    val users: StateFlow<List<User>> = _users
}