package com.example.trackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.trackerapp.db.RunningDatabase
import com.example.trackerapp.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //4//To tell dagger this a module, to find the functions inside de module
@InstallIn(SingletonComponent::class) //5//Install this module in SingletonComponent class, the objects(instances) we create live as long as the application does.
//Determine when the dependecies will be created or destroyed.
object AppModule {//3

    //Each class in the app that need the RunningDatabase will get the same instance (Its a scope.)
    @Singleton //8
    //Tells dagger the result of the function can be used to create other dependencies and be injected to classes
    @Provides
    //Determines how the objects we want to inject are created.
    //6
    fun provideRunningDb(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton //10
    @Provides //9
    fun provideRunDao(db: RunningDatabase) = db.getRunDao() //11

}