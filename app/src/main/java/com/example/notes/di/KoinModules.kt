package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.room.OfflineTasksRepository
import com.example.notes.room.TaskDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.notes.viewmodel.TaskViewModel
import com.example.notes.viewmodel.EditTaskViewModel
import com.example.notes.viewmodel.AddTaskViewModel
import com.example.notes.viewmodel.ThemeViewModel
import com.example.notes.room.TasksRepository

val appModule = module {
    viewModelOf(::TaskViewModel)
    viewModelOf(::EditTaskViewModel)
    viewModelOf(::AddTaskViewModel)
    viewModelOf(::ThemeViewModel)
}

val dbModule = module {
    single { provideDatabase(androidContext()) }
    single { get<TaskDatabase>().taskDao() }
    single<TasksRepository> { OfflineTasksRepository(taskDao = get()) }
}

fun provideDatabase(androidContext: Context): TaskDatabase {
    return Room.databaseBuilder(
        androidContext,
        TaskDatabase::class.java, "db_task"
    )
        .fallbackToDestructiveMigration()
        .build()
}
