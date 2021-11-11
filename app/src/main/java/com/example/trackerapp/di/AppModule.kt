package com.example.trackerapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.trackerapp.data.data_source.RunningDatabase
import com.example.trackerapp.domain.util.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.trackerapp.domain.util.Constants.KEY_NAME
import com.example.trackerapp.domain.util.Constants.KEY_WEIGHT
import com.example.trackerapp.domain.util.Constants.RUNNING_DATABASE_NAME
import com.example.trackerapp.domain.util.Constants.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //To tell dagger this a module, to find the functions inside de module
@InstallIn(SingletonComponent::class) //Install this module in SingletonComponent class, the objects(instances) we create live as long as the application does.
//Determine when the dependecies will be created or destroyed.
object AppModule {

    //Each class in the app that need the RunningDatabase will get the same instance (Its a scope.)
    @Singleton
    //Tells dagger the result of the function can be used to create other dependencies and be injected to classes
    @Provides
    //Determines how the objects we want to inject are created.
    fun provideRunningDb(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(SharedPref: SharedPreferences) = SharedPref.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(SharedPref: SharedPreferences) = SharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(SharedPref: SharedPreferences) =
        SharedPref.getBoolean(KEY_FIRST_TIME_TOGGLE, true)
}