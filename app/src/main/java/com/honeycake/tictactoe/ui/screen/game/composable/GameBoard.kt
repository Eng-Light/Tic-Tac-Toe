package com.honeycake.tictactoe.ui.screen.game.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honeycake.tictactoe.R
import com.honeycake.tictactoe.ui.screen.game.GameUiState

/**
 * Created by Aziza Helmy on 7/14/2023.
 */


@Composable
fun GameBoard(
    state: GameUiState,
    onButtonClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_game_structure),
            contentDescription = "image structure"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            for (row in 0..2) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (col in 0..2) {
                        val index = row * 3 + col
                        Log.e("TAG", "GameBoard:$index ", )
                        val buttonState = state.gameState[index]
                        buttonState.image?.let {
                            GameCell(image = it, onButtonClicked = {
                                Log.e("TAG", "GameCell:${index} ")
                                        onButtonClicked(index)
                            })
                        }
                    }
                }
            }
        }
    }
}

