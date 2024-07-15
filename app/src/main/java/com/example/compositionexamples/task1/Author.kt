package com.example.compositionexamples.task1

class Author (val authorName : String) {
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