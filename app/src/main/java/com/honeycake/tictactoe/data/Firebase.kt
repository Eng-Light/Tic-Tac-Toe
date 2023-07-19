package com.honeycake.tictactoe.data

import kotlinx.coroutines.flow.Flow

interface Firebase {

    suspend fun write(gameSession: GameSession)
    suspend fun read(id: String): GameSession
    suspend fun update(gameSession: GameSession): Boolean

    fun getNotify(id: String):  Flow<GameSession>

    suspend fun updateBoard(gameId: String, updatedBoard: List<List<Int>>)
    suspend fun readGameSession(gameId: String): GameSession
}