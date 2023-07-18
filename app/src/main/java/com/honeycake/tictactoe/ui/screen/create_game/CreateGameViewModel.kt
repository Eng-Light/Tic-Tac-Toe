package com.honeycake.tictactoe.ui.screen.create_game

import androidx.lifecycle.viewModelScope
import com.honeycake.tictactoe.data.GameSession
import com.honeycake.tictactoe.domain.repository.XORepository
import com.honeycake.tictactoe.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CreateGameViewModel @Inject constructor(
    private val xORepository: XORepository
) : BaseViewModel<CreateGameUiState>(CreateGameUiState()), CreateGameInteractionListeners {

    fun onChangePlayerName(newValue: String) {
        updateState { it.copy(firstPlayerName = newValue, isButtonEnabled = true) }
    }

    override fun onCreateGameClicked() {
        if (state.value.firstPlayerName.isNotEmpty()) {
            updateState { it.copy(navigate = saveGameSession()) }
        } else
            "Dummy"
            // must be replaced with toast show that he must enter a name
    }

    private fun saveGameSession(): Boolean {
        updateState { it.copy(gameId = generateUniqueKey()) }
        val gameSession = GameSession(
            _state.value.firstPlayerName,
            "",
            false,
            _state.value.gameId
        )
        viewModelScope.launch {
         return@launch  xORepository.saveGameSession(gameSession)
        }
        return false
    }

    private fun generateUniqueKey(): String {
        val dateFormat = SimpleDateFormat("MMddHHmmss", Locale.getDefault())
        val timestamp = dateFormat.format(Date())
        val randomNumber = (0..99999).random().toString().padStart(5, '0')
        return "$timestamp$randomNumber"
    }
}