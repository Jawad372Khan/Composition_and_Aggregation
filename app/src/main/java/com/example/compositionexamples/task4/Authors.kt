package com.example.compositionexamples.task4

import com.example.compositionexamples.task1.Books

class Authors(val authorName : String) {
    val books = mutableListOf<Book>()

    fun addBook(book : Book)
    {
        books.add(book)
    }
    fun removeBook(book: Book)
    {
        books.remove(book)
    }

}