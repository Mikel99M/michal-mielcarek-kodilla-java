package com.kodilla.patterns.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Nested
    @DisplayName("Testing listBooksWithCondition")
    class TestingWithCondition {
        private List<Book> generateListOfBooks(int booksQuantity) {
            List<Book> resultList = new ArrayList<>();
            for (int i = 0; i < booksQuantity; i++) {
                Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
                resultList.add(theBook);
            }
            return resultList;
        }

        @Test
        void testListBooksWithConditionsReturnList() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            //Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfBooks(15);
            List<Book> resultListOf40Books = generateListOfBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBook")).thenReturn(resultListOf40Books);

            //When
            List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("FifteenBook");
            List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("FortyBook");
            //Then
            assertEquals(0, theListOf0Books.size());
            assertEquals(15, theListOf15Books.size());
            assertEquals(0, theListOf40Books.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Testing listBooksInHandsOf")
    class TestingListBooksInHandsOf {

        LibraryUser user = new LibraryUser("Andrzej", "Sapkowski", "123456789");
        List<Book> books = new ArrayList<>();


        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("Some book", "George Kowalski", 2000);

        @DisplayName("Testing scenario when user has no books")
        @Test
        void testFirstScenario() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(books);

            //When
            List<Book> booksInHands = bookLibrary.listBooksInHandsOf(user);
            int result = booksInHands.size();

            //Then
            assertEquals(0, result);
        }

        @DisplayName("Testing scenario when user has one book")
        @Test
        void testSecondScenario() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            books.add(book1);
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(books);

            //When
            List<Book> booksInHands = bookLibrary.listBooksInHandsOf(user);
            int result = booksInHands.size();

            //Then
            assertEquals(1, result);

        }

        @DisplayName("Testing scenario when user has 5 books")
        @Test
        void testThirdScenario() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);
            books.add(book5);

            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(books);

            //When
            List<Book> booksInHands = bookLibrary.listBooksInHandsOf(user);
            int result = booksInHands.size();

            //Then
            assertEquals(5, result);
        }
    }

}
