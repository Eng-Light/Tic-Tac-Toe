package com.honeycake.tictactoe.data

import kotlinx.coroutines.flow.Flow

interface Firebase {

    suspend fun write(gameSession: GameSession)
    suspend fun read(id: String): String
    suspend fun update(gameSession: GameSession): Boolean

    fun getNotify(id: String):  Flow<GameSession>

}