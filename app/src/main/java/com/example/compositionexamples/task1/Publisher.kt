package com.example.compositionexamples.task1

class Publisher (val publisherName : String) {
    val books = mutableListOf<Books>()

    fun addBook(book : Books)
    {
        books.add(book)
    }
    fun removeBook(book: Books)
    {
        books.remove(book)
    }
}