package com.iyaselerehoboth.themovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iyaselerehoboth.themovies.database.entity.Movie
import com.iyaselerehoboth.themovies.databinding.ListItemMovieBinding

class MovieListAdapter: ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(MovieDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(
        private val binding: ListItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                //OnClickListener goes here.
                //Reference: Android Sunflower project on Github
            }
        }

        fun bind(movie: Movie){
            binding.apply {
                tvMovieName.text = movie.originalTitle
                tvMovieRating.text = movie.voteAverage.toString() + "/10"
                tvMovieDesc.text = movie.overview

                executePendingBindings()
            }
        }
    }

    private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }

}