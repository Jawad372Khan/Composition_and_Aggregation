package com.example.compositionexamples.task1

import com.example.compositionexamples.task2.Reader

class Library(val libraryName : String) {
    private val books = mutableListOf<Books>()
    private val borrowedBooks = mutableListOf<Books>()

    fun addBook(book: Books)
    {
        books.add(book)
        book.author.addBook(book)
        book.publisher.addBook(book)
    }

    fun removeBook(book: Books)
    {
        books.remove(book)
        book.author.removeBook(book)
        borrowedBooks.remove(book)
    }

    fun booksList():List<Books>
    {
        return books
    }

    fun borrowBook(reader : Reader, book : Books ) : Boolean
    {
        return if(books.contains(book) && !borrowedBooks.contains(book))
        {
            borrowedBooks.add(book)
            reader.borrowBook(book)
            true
        }
        else
        {
            false
        }
    }
    fun returnBook(reader : Reader, book : Books ) : Boolean
    {
        return if (borrowedBooks.contains(book) && reader.borrowedBooks.contains(book))
        {
            borrowedBooks.remove(book)
            reader.returnBook(book)
            true
        }
        else
        {
            false
        }
    }

    fun findBooksByPublisher(publisher: Publisher): List<Books> {
        return publisher.books.toList()
    }
}