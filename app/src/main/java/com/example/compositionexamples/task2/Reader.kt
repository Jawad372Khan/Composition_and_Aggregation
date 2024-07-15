package com.example.compositionexamples.task2

import com.example.compositionexamples.task1.Books

class Reader (val readerName : String) {
    val borrowedBooks = mutableListOf<Books>()

    fun borrowBook(book : Books)
    {
        borrowedBooks.add(book)
    }
    fun returnBook(book : Books)
    {
        borrowedBooks.remove(book)
    }

}
