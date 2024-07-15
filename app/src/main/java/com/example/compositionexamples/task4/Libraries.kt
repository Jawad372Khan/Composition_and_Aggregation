package com.example.compositionexamples.task4

class Libraries(val libraryName : String) {
    private val books = mutableListOf<Book>()
    private val borrowedBooks = mutableListOf<Book>()
    private val genres = mutableSetOf<Genre>()

    fun addBook(book: Book)
    {
        books.add(book)
        book.author.addBook(book)
        book.publisher.addBook(book)
        book.genre.addBook(book)
        genres.add(book.genre)
    }

    fun removeBook(book: Book)
    {
        books.remove(book)
        book.author.removeBook(book)
        borrowedBooks.remove(book)
        book.genre.removeBook(book)
        genres.remove(book.genre)
    }

    fun booksList():List<Book>
    {
        return books
    }

    fun borrowBook(readers : Readers, book : Book) : Boolean
    {
        return if(books.contains(book) && !borrowedBooks.contains(book))
        {
            borrowedBooks.add(book)
            readers.borrowBook(book)
            true
        }
        else
        {
            false
        }
    }
    fun returnBook(readers : Readers, book : Book) : Boolean
    {
        return if (borrowedBooks.contains(book) && readers.borrowedBooks.contains(book))
        {
            borrowedBooks.remove(book)
            readers.returnBook(book)
            true
        }
        else
        {
            false
        }
    }

    fun findBooksByPublisher(publisher: Publishers): List<Book> {
        return publisher.books.toList()
    }

    fun listBooksByGenre(genre: Genre): List<Book> {
        return genre.books.toList()
    }

    fun countBooksByGenre(): Map<Genre, Int> {
        return genres.associateWith { it.books.size }
    }
}