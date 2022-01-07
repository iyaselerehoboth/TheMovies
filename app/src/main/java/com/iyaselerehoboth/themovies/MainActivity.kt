package com.iyaselerehoboth.themovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.iyaselerehoboth.themovies.databinding.ActivityMainBinding
import com.iyaselerehoboth.themovies.workers.DiscoverMoviesWorker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory((application as BaseApplication).movieRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Handle the splash screen transition
        val splashScreen = installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.tvHeading.text = "List of Discovered movies"

        val adapter = MovieListAdapter()
        binding.rcvMovies.adapter = adapter
        binding.rcvMovies.layoutManager = LinearLayoutManager(this)

        val getDiscoverMovies: WorkRequest =
            OneTimeWorkRequestBuilder<DiscoverMoviesWorker>()
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(getDiscoverMovies)

        mainViewModel.allMovies.observe(this, Observer { movieList ->
            Log.d("CHECK", movieList.toString())
            adapter.submitList(movieList)
        })
    }
}