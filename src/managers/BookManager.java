/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;
import enttity.Author;
import enttity.Book;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tooks.InputFromKeyboard;

public class BookManager {
       
    private final Scanner scanner;

    public BookManager(Scanner scanner) {
            this.scanner = scanner;
    }
       
    public Book addBook() {
            System.out.println("------------ Adding new book --------------");
            Book book;
            book = new Book();
            System.out.print("Enter title: ");
            book.setTitle(scanner.nextLine());
            System.out.print("Enter published year: ");
            book.setPublishedYear(InputFromKeyboard.inputNumberFromRange(1800,
                    2050));
            System.out.print("How many authors: ");
            int countAuthors = InputFromKeyboard.inputNumberFromRange(1, 5);
            for (int i = 0; i < countAuthors; i++) {
                System.out.printf("Author %d: %n", i+1);
                System.out.print("Enter firstname: ");
                String authorFirstname = scanner.nextLine();
                System.out.print("Enter lastname: ");
                String authorLastname = scanner.nextLine();
                book.addAuthor(new Author(authorFirstname, authorLastname));
            }
            System.out.print("Enter quantity exempar: ");
            book.setQuantity(InputFromKeyboard.inputNumberFromRange(1,10));
            book.setCount(book.getQuantity());
            System.out.println("Added book: " + book.toString());
            return book;
    }

    public int printListBooks(List<Book> books) {
    int count = 0;
    System.out.println("------List books------"); 

    for (int i = 0; i < books.size(); i++) { 
        Book currentBook = books.get(i); 
        System.out.printf("%d. %s. %d. %s. In stock: %d%n", 
            i + 1, 
            currentBook.getTitle(),
            currentBook.getPublishedYear(),
            Arrays.toString(currentBook.getAuthors()),
            currentBook.getCount());
        count++;
    }
    return count;
    }

    public void addCopyOfExistingBookInLibrary(List<Book> books) {
        this.printListBooks(books);
        System.out.println("Enter the book number to add copies: ");
        int bookNumber = InputFromKeyboard.inputNumberFromRange(1, books.size());
        System.out.println("How many copies of the book should I add?: "); 
        int copyNumber = InputFromKeyboard.inputNumberFromRange(1, 10);
        books.get(bookNumber-1).setQuantity(books.get(bookNumber-1).getQuantity()
                + copyNumber);
        books.get(bookNumber-1).setCount(books.get(bookNumber-1).getCount() 
                + copyNumber);
    }
}