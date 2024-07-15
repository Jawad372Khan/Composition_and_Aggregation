package com.example.compositionexamples.task4

import com.example.compositionexamples.task5.Review

class Book (val title : String, val author: Authors, val publisher : Publishers, val genre : Genre)
{
    private val reviews = mutableListOf<Review>()

    fun addReview(review: Review) {
        reviews.add(review)
    }

    fun listReviews(): List<Review> {
        return reviews.toList()
    }
}
