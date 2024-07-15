package com.example.compositionexamples.task4

class Genre (val genreName : String) {

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