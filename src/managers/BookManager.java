/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import enttity.Author;
import enttity.Book;
import java.util.Arrays;
import java.util.List;
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
        System.out.println("----- Add new book -----");
        Book book;
        book = new Book();
        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(InputFromKeyboard.inputNumberFromRange(1800, 2050));
        System.out.print("How many authors: ");
        int countAuthors = InputFromKeyboard.inputNumberFromRange(1, 5);
        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Author %d:%n",i+1);
            System.out.print("Enter firstname: ");
            String authorFirstname = scanner.nextLine();
            System.out.print("Enter lastname: ");
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname, authorLastname));
        }
        System.out.print("Enter quantity copy: ");
        book.setQantity(InputFromKeyboard.inputNumberFromRange(1, 10));
        book.setCount(book.getQantity());
        System.out.println("Added book: "+book.toString());
        return book;
    }

    public int pirntListBooks(List<Book> books) {
        int count = 0;
        System.out.println("List books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. %s. %d. %s. In stock: %d%n",
                    i+1,
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    Arrays.toString(books.get(i).getAuthors()),
                    books.get(i).getCount()
            );
            count++;
        }
        return count;
    }
    
}
   
