package com.example.notes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.Task
import com.example.notes.room.TasksRepository
import com.example.notes.states.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditTaskViewModel(
    savedStateHandle: SavedStateHandle,
    private val tasksRepository: TasksRepository,
) : ViewModel() {

    private val _taskState = MutableStateFlow(TaskState())
    val taskState: StateFlow<TaskState> = _taskState.asStateFlow()

    private val taskId: Int = savedStateHandle.get<Int>("id") ?: -1

    init {
        viewModelScope.launch {
            tasksRepository.getTask(taskId).collect {
                _taskState.update { currentState ->
                    currentState.copy(
                        task = it
                    )
                }
            }

        }
    }

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

    suspend fun updateTask(task: Task) {
        tasksRepository.updateTask(task = task)
    }
}