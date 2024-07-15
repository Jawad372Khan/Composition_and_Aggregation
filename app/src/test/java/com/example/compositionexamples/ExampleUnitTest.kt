package com.example.compositionexamples

import androidx.annotation.RequiresPermission
import com.example.compositionexamples.task1.Author
import com.example.compositionexamples.task1.Books
import com.example.compositionexamples.task1.Library
import com.example.compositionexamples.task1.Publisher
import com.example.compositionexamples.task2.Reader
import com.example.compositionexamples.task4.Authors
import com.example.compositionexamples.task4.Book
import com.example.compositionexamples.task4.Genre
import com.example.compositionexamples.task4.Libraries
import com.example.compositionexamples.task4.Publishers
import com.example.compositionexamples.task5.Review
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun task1()
    {
        val author = Author("Amit Garg")
        val publisher = Publisher(" Reader's Zone ")
        val book1 : Books = Books("Junior Level Books Introduction to Computer",author,publisher)
        val book2 : Books = Books("Publish News Letterr",author,publisher)

        val library = Library("Mumbai Library")
        library.addBook(book1)
        library.addBook(book2)

        println("Books in Library")
        library.booksList().forEach { (println(it.title)) }

        println("Books by ${author.authorName}")
        author.books.forEach{ println(it.title) }

        println("Books by ${publisher.publisherName}")
        publisher.books.forEach { println(it.title) }


        library.removeBook(book1)

        println("Books in Library")
        library.booksList().forEach { (println(it.title)) }

        println("Books by ${author.authorName}")
        author.books.forEach{ println(it.title) }

        println("Books by ${publisher.publisherName}")
        publisher.books.forEach { println(it.title) }


        println("Books published by ${publisher.publisherName} ")
        library.findBooksByPublisher(publisher).forEach { println(it.title) }

    }
    @Test
    fun task2()
    {
        val author = Author("Amit Garg")
        val publisher = Publisher(" Reader's Zone ")
        val book1 : Books = Books("Junior Level Books Introduction to Computer",author,publisher)
        val book2 : Books = Books("Publish News Letterr",author,publisher)

        val library = Library("Mumbai Library")
        library.addBook(book1)
        library.addBook(book2)

        val reader1 = Reader("Jawad")
        val reader2 = Reader("Imran")

        println("Books in Library")
        library.booksList().forEach { println(it.title) }

        if(library.borrowBook(reader1,book1))
        {
            println("${reader1.readerName} borrow ${book1.title}")
        }
        else
        {
            println("${book1.title} not available to borrow")
        }

        if(library.borrowBook(reader2,book1))
        {
            println("${reader2.readerName} borrow ${book1.title}")
        }
        else
        {
            println("${book1.title} not available to borrow")
        }


        println("${reader1.readerName}'s borrowed books:")
        reader1.borrowedBooks.forEach { println(it.title) }

        println("${reader2.readerName}'s borrowed books:")
        reader2.borrowedBooks.forEach { println(it.title) }

        if (library.returnBook(reader1, book1)) {
            println("${reader1.readerName} returned ${book1.title}")
        } else {
            println("${reader1.readerName} could not return ${book1.title}")
        }

        if (library.borrowBook(reader2, book1)) {
            println("${reader2.readerName} borrowed ${book1.title}")
        } else {
            println("${reader2.readerName} could not borrow ${book1.title}")
        }

    }

    @Test
    fun task3()
    {
        val author = Author("Amit Garg")
        val publisher = Publisher(" Reader's Zone ")
        val book1 : Books = Books("Junior Level Books Introduction to Computer",author,publisher)
        val book2 : Books = Books("Publish News Letterr",author,publisher)

        val library = Library("Mumbai Library")
        library.addBook(book1)
        library.addBook(book2)

        println("Books in Library")
        library.booksList().forEach { (println(it.title)) }

        println("Books by ${author.authorName}")
        author.books.forEach{ println(it.title) }

        println("Books by ${publisher.publisherName}")
        publisher.books.forEach { println(it.title) }


        library.removeBook(book1)

        println("Books in Library")
        library.booksList().forEach { (println(it.title)) }

        println("Books by ${author.authorName}")
        author.books.forEach{ println(it.title) }

        println("Books by ${publisher.publisherName}")
        publisher.books.forEach { println(it.title) }


        println("Books published by ${publisher.publisherName} ")
        library.findBooksByPublisher(publisher).forEach { println(it.title) }

    }

    @Test
    fun task4()
    {
        val genre1 = Genre("Education")
        val genre2 = Genre("Crime")
        val author = Authors("Amit Garg")
        val publisher = Publishers(" Reader's Zone ")
        val book1 : Book = Book("Junior Level Books Introduction to Computer",author,publisher,genre1)
        val book2 : Book = Book("Publish News Letterr",author,publisher,genre2)

        val library = Libraries("Mumbai Library")
        library.addBook(book1)
        library.addBook(book2)

        println("Books in library:")
        library.booksList().forEach { println(it.title) }

        println("Education books:")
        library.listBooksByGenre(genre1).forEach { println(it.title) }

        println("Number of books by genre:")
        library.countBooksByGenre().forEach { (genre, count) ->
            println("${genre.genreName}: $count")
        }

    }

    @Test
    fun task5()
    {
        val fantasy = Genre("Fantasy")
        val author = Authors("J.K. Rowling")
        val publisher = Publishers("Bloomsbury")
        val book1 : Book = Book("Harry Potter and the Philosopher's Stone", author, publisher, fantasy)


        book1.addReview(Review("Alice", "An amazing start to a magical series!"))
        book1.addReview(Review("Bob", "A great read for all ages."))


        println("Reviews for ${book1.title}:")
        val reviews = book1.listReviews()
        if (reviews.isEmpty()) {
            println("No reviews yet.")
        } else {
            reviews.forEach { review ->
                println("Reviewer: ${review.reviewName}, Review: ${review.content}")
            }
        }
    }
}