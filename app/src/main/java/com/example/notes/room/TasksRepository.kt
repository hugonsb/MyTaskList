package com.example.notes.room

import com.example.notes.model.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {

    fun getTasks(): Flow<List<Task>>

    fun getTask(id: Int): Flow<Task>

    suspend fun addTask(task: Task)

    suspend fun removeTask(task: Task)

    suspend fun updateTask(task: Task)
}