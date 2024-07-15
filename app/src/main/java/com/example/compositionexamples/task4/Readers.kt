package com.example.compositionexamples.task4



class Readers (val readerName : String) {
    val borrowedBooks = mutableListOf<Book>()

    fun borrowBook(book : Book)
    {
        borrowedBooks.add(book)
    }
    fun returnBook(book : Book)
    {
        borrowedBooks.remove(book)
    }

}
