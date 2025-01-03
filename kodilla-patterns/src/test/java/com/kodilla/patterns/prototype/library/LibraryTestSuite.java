package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Biblioteka główna");
        Book book1 = new Book("The old man and the sea", "Ernest Hemingway", LocalDate.of(1930, 12, 2));
        Book book2 = new Book("Meditations", "Marcus Aurelius", LocalDate.of(300, 12, 2));
        Book book3 = new Book("Divine Comedy", "Dante Alighieri", LocalDate.of(1200, 12, 2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Filia nr 1");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Filia nr 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertEquals(library.getBooks().size(), 2);
        assertEquals(clonedLibrary.getBooks().size(), 2);
        assertEquals(deepClonedLibrary.getBooks().size(), 3);
        assertNotEquals(deepClonedLibrary.getBooks().size(), library.getBooks().size());

        library.getBooks().remove(book2);
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertEquals(clonedLibrary.getBooks().size(), 1);
    }
}
