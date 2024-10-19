package com.example.notes.states

import com.example.notes.model.Task

data class TaskState(
    val task: Task = Task(title = "", details = "")
)