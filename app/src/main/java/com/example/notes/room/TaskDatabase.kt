package com.example.notes.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.model.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}