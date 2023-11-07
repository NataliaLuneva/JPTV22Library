/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import enttity.Book;
import enttity.History;
import enttity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tooks.InputFromKeyboard;

/**
 *
 * @author pupil
 */
public class HistoryManager {

    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    
    public HistoryManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);  
    }

    public History giveBookToReader(Reader[] readers, Book[] books) {
        System.out.println("------Give the book to the reader-----");
        History history = new History();
        /*
         * 1. Выводим нумерованный список читателей
         * 2. Просим ввести номер читателя
         * 3. Получим по индексу читателя из массива читателей
         * 4. Инициируем поле в history.setReader(reader)
         * 5-9. Повторить действия 1-4 с книгой
         * 10. Инициируем дату выдачи книги текущем временем        
         */
        int countReadersInList = readerManager.printListReaders(readers);
        System.out.print("Enter number reader:");
        int readerNumber = InputFromKeyboard.importNumberFromRange(1, 
                countReadersInList);
        history.setReader(readers[readerNumber - 1]);
        
        int countBooksInList = bookManager.printListBooks(books);
        System.out.print("Enter number book:");
        int bookNumber = InputFromKeyboard.importNumberFromRange(1, 
                countReadersInList);
        if(books[bookNumber-1].getCount() > 0){
            history.setBook(books[bookNumber - 1]);
            books[bookNumber-1].setCount(books[bookNumber-1].getCount() - 1);
            history.setGiveBookToReaderDate(new GregorianCalendar().getTime());
        }else{
            System.out.println("All books are read");
            return null;
        }      
        return history;
    }

    public void returnBook(History[] histories) {
        System.out.println("------Return book to library-----");
        int countBooksInList;
        if((countBooksInList = this.printListReadingBooks(histories))<1){
            System.out.println("Not books");
            return;
        }
        System.out.println("Enter number book:");
        int historyNumber = InputFromKeyboard.importNumberFromRange(1, 
                null);
        if(histories[historyNumber-1].getBook().getCount() 
                < histories[historyNumber - 1].getBook().getQantity()){;
            histories[historyNumber-1].setReturnBook
        (new GregorianCalendar().getTime());
            histories[historyNumber-1].getBook().setCount
        (histories[historyNumber-1].getBook().getCount()+1);
            System.out.printf("Book \"%s\"returned%n",
                    histories[historyNumber-1].getBook().getTitle());
        }else{
                System.out.println("All books are already in stock");
        }
    }

    public int printListReadingBooks(History[] histories) {
        int countReadingBooks = 0;
        System.out.println("------List reading books-----");
        for (int i = 0; i < histories.length; i++){
            if(histories[i].getReturnBook() == null){
                System.out.printf("%d. %s. reading %s %s%n",
                    i+1,
                    histories[i].getBook().getTitle(),
                    histories[i].getReader().getFirstname(),
                    histories[i].getReader().getLastname()
                );
                countReadingBooks ++;
            }
        }
        if(countReadingBooks <1){
            System.out.println("\t No books to read");
        }
        return countReadingBooks;
    }

}

