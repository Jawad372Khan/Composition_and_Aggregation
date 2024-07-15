package com.example.compositionexamples.task4



class Publishers (val publisherName : String) {
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