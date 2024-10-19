package com.example.notes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notes.model.Task
import com.example.notes.room.TasksRepository
import com.example.notes.states.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddTaskViewModel(
    private val tasksRepository: TasksRepository,
) : ViewModel() {

    private val _taskState = MutableStateFlow(TaskState())
    val taskState: StateFlow<TaskState> = _taskState.asStateFlow()

    fun setTittle(titlte: String) {
        _taskState.update { currentState ->
            currentState.copy(
                task = currentState.task.copy(title = titlte)
            )
        }
    }

    fun setDetails(details: String) {
        _taskState.update { currentState ->
            currentState.copy(
                task = currentState.task.copy(details = details)
            )
        }
    }

    suspend fun addTask(task: Task) {
        tasksRepository.addTask(task)
    }

}