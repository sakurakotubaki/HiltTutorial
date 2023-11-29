package com.junichi.hilttutorial

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.junichi.hilttutorial.repository.UserRepository
import com.junichi.hilttutorial.viewModel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // インスタンを返す関数を呼び出す
    val vm: HomeScreenViewModel = hiltViewModel()

    // インスタンを返す関数を代入した変数を使用する
    val users by vm.users.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Hiltを使ってみた?") }
            )
        }
    // LazyColumnで、依存性の注入をしたダミーのユーザーデータを表示する
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(users) { user ->
                Text(text = "ID: ${user.id}")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "お名前: ${user.name}")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "メールアドレス: ${user.email}")
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

// この関数は、HomeScreenViewModelのインスタンスを返す
fun hiltViewModel(): HomeScreenViewModel {
    return HomeScreenViewModel(UserRepository())
}