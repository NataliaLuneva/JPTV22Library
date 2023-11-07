/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;
import enttity.Author;
import enttity.Book;
import java.util.Arrays;
import java.util.Scanner;
import tooks.InputFromKeyboard;

/**
 *
 * @author pupil
 */
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
            book.setPublishedYear(InputFromKeyboard.importNumberFromRange(1800,
                    2050));
            System.out.print("How many authors: ");
            int countAuthors = InputFromKeyboard.importNumberFromRange(1, 5);
            for (int i = 0; i < countAuthors; i++) {
                System.out.printf("Author %d: %n", i+1);
                System.out.print("Enter firstname: ");
                String authorFirstname = scanner.nextLine(); 
                System.out.print("Enter lastname: ");
                String authorLastname = scanner.nextLine();
                book.addAuthor(new Author(authorFirstname, authorLastname));
            }
            System.out.print("Enter quantity exemplar: ");
            book.setQantity(InputFromKeyboard.importNumberFromRange(1,10));
            book.setCount(book.getQantity());
            System.out.println("Added book: " + book.toString());
            return book;
    }

    public int printListBooks(Book[] books) {
        int count = 0;
        System.out.println("------List books------");
        for(int i = 0; i < books.length; i++) {
            System.out.printf("%d. %s. %d. %s. In stock: %d%n ", 
                    i + 1, 
                    books[i].getTitle(), 
                    books [i].getPublishedYear(),
                    Arrays.toString(books [i].getAuthors()),
                    books[i].getCount());
            count++;
        }
        return count;

    
    } 
}
   