package com.example.trackerapp.repositories

import com.example.trackerapp.db.Run
import com.example.trackerapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor( //13
    val runDAO: RunDAO
) { //14
    suspend fun insertRun(run: Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getAllRunsByDate() = runDAO.getAllRunsByDate()

    fun getAllRunsByDistance() = runDAO.getAllRunsByDistance()

    fun getAllRunsByTimeInMillis() = runDAO.getAllRunsByTimeInMillis()

    fun getAllRunsByAvgSpeed() = runDAO.getAllRunsByAvgSpeed()

    fun getAllRunsByCalories() = runDAO.getAllRunsByCalories()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()
}