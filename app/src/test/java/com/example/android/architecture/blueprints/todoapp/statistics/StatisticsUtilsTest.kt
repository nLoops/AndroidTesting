package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf(Task(title = "title", description = "description", isCompleted = false))
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf(
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = false),
                Task(title = "title", description = "description", isCompleted = false),
                Task(title = "title", description = "description", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_allCompleted_returnsHundredZero() {
        val tasks = listOf(
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = true),
                Task(title = "title", description = "description", isCompleted = true)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(100f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZero() {
        val tasks = emptyList<Task>()
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZero() {
        val result = getActiveAndCompletedStats(null)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

}