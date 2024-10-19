package com.example.notes.states

import com.example.notes.model.Task

data class TaskListState(
    val taskList: List<Task> = emptyList()
)
