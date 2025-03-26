package dk.howards.drawerapp.model

import java.time.LocalDate

enum class Genre {
    FICTION,
    NON_FICTION,
    SCIENCE_FICTION,
    FANTASY,
    MYSTERY,
    ROMANCE,
}

data class BookOverview(
    val id: String,
    val title: String,
    val author: String,
    val genre: Genre,
    val releaseYear: Int,
    val coverImageId: Int
)

data class Book(
    val bookOverview: BookOverview,
    val isbn: String,
    val publisher: String,
    val pageCount: Int,
    val price: Double,
    val description: String,
    val rating: Float,
    val publicationDate: LocalDate,
    val reviews: List<Review>
)

data class Review(
    val reviewer: String,
    val rating: Float,
    val comment: String,
    val date: LocalDate
) 