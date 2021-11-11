package com.example.trackerapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Converters::class)   //Where to find the typeConverters
//With dagger library we don't need to handle singleton functionalities of Room. Less boilerplate code.
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDAO
}
