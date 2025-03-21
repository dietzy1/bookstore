package dk.howards.drawerapp.repository

import dk.howards.drawerapp.R
import dk.howards.drawerapp.model.Book
import dk.howards.drawerapp.model.BookOverview
import dk.howards.drawerapp.model.Genre
import dk.howards.drawerapp.model.Review
import java.time.LocalDate

object BookRepository {
    private val books = mapOf(
        "1" to Book(
            BookOverview(
                "1",
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                Genre.FICTION,
                1925,
                R.drawable.flag_of_japan
            ),
            "9780743273565",
            "Scribner",
            180,
            12.99,
            "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.",
            4.5f,
            LocalDate.of(1925, 4, 10),
            listOf(
                Review(
                    "John Smith",
                    5.0f,
                    "A timeless classic that captures the essence of the Roaring Twenties.",
                    LocalDate.of(2020, 5, 15)
                ),
                Review(
                    "Sarah Johnson",
                    4.0f,
                    "Beautifully written with complex characters.",
                    LocalDate.of(2021, 3, 22)
                )
            )
        ),
        "2" to Book(
            BookOverview(
                "2",
                "To Kill a Mockingbird",
                "Harper Lee",
                Genre.FICTION,
                1960,
                R.drawable.flag_tanzania
            ),
            "9780061120084",
            "HarperCollins",
            336,
            14.99,
            "To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old.",
            4.8f,
            LocalDate.of(1960, 7, 11),
            listOf(
                Review(
                    "Michael Brown",
                    5.0f,
                    "One of the most important American novels ever written.",
                    LocalDate.of(2019, 8, 3)
                ),
                Review(
                    "Emily Davis",
                    4.5f,
                    "A powerful story about race and justice in the American South.",
                    LocalDate.of(2022, 1, 17)
                )
            )
        ),
        "3" to Book(
            BookOverview(
                "3",
                "1984",
                "George Orwell",
                Genre.SCIENCE_FICTION,
                1949,
                R.drawable.earth
            ),
            "9780451524935",
            "Signet Classic",
            328,
            9.99,
            "1984 is a dystopian novel by George Orwell published in 1949. The novel is set in Airstrip One, a province of the superstate Oceania in a world of perpetual war, omnipresent government surveillance, and public manipulation.",
            4.7f,
            LocalDate.of(1949, 6, 8),
            listOf(
                Review(
                    "Robert Wilson",
                    5.0f,
                    "A chilling and prophetic novel that grows more relevant each year.",
                    LocalDate.of(2020, 11, 5)
                ),
                Review(
                    "Jennifer Lee",
                    4.5f,
                    "Orwell's masterpiece on totalitarianism and surveillance.",
                    LocalDate.of(2021, 7, 19)
                )
            )
        ),
        "4" to Book(
            BookOverview(
                "4",
                "Pride and Prejudice",
                "Jane Austen",
                Genre.ROMANCE,
                1813,
                R.drawable.flag_of_japan
            ),
            "9780141439518",
            "Penguin Classics",
            480,
            8.99,
            "Pride and Prejudice follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.",
            4.6f,
            LocalDate.of(1813, 1, 28),
            listOf(
                Review(
                    "Katherine Walker",
                    5.0f,
                    "The quintessential romance novel with wit and social commentary.",
                    LocalDate.of(2020, 2, 14)
                ),
                Review(
                    "David Thompson",
                    4.0f,
                    "Austen's sharp dialogue and character development are unmatched.",
                    LocalDate.of(2021, 9, 30)
                )
            )
        ),
        "5" to Book(
            BookOverview(
                "5",
                "The Hobbit",
                "J.R.R. Tolkien",
                Genre.FANTASY,
                1937,
                R.drawable.flag_tanzania
            ),
            "9780547928227",
            "Houghton Mifflin Harcourt",
            320,
            13.99,
            "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction.",
            4.9f,
            LocalDate.of(1937, 9, 21),
            listOf(
                Review(
                    "Thomas Clark",
                    5.0f,
                    "The perfect introduction to Middle-earth and fantasy literature.",
                    LocalDate.of(2019, 12, 9)
                ),
                Review(
                    "Jessica Martin",
                    4.8f,
                    "A timeless adventure that captivates readers of all ages.",
                    LocalDate.of(2022, 4, 5)
                )
            )
        )
    )

    fun getAllBooks(): List<BookOverview> {
        return books.values.map { it.bookOverview }
    }

    fun getBooksByGenre(genre: Genre): List<BookOverview> {
        return books.values
            .filter { it.bookOverview.genre == genre }
            .map { it.bookOverview }
    }

    fun getBookById(id: String): Book? {
        return books[id]
    }
} 