package com.example.trackerapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao //data access object. Definition of it's actions.
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //No duplicate data, replaces previous
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsByDate(): LiveData<List<Run>> //not coroutine(suspend), because returns live data

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsByCalories(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}