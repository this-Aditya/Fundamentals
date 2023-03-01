package com.example.retrofitpractice.data.model

data class SearchResponse(
    val incomplete_results: Boolean,
    val items: List<Users>,
    val total_count: Int
)