/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enttity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
/**
 *
 * @author pupil
 */
   public class Book implements Serializable{
        private String title;
        private int publishedYear;
        private Author[] authors = new Author[0];
        private int qantity; // Всего закупленных в библиотеку экземпляров.
        private int count; // Экземпляров в наличии.

    public Book() {
    }

    public Book(String title, int publishedYear, int qantity, int count) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.qantity = qantity;
        this.count = count;
    }
    

        @Override
        public String toString() {
            return "Book{"
                    + "title " + title
                    + ", publishedYear"
                    + "" + publishedYear
                    + ", authors " + Arrays.toString(authors)
                    + ", qantity =" + qantity
                    + ", count =" + count
                    + '}';
        }

    public void addAuthor(Author author) {
        /*
        *1.создать копию authors с дополнительной пустой ячейкой
        *2. Добавить в пустую ячейку ссылку author полученный из параметра
        */
        this.authors = Arrays.copyOf(this.authors, this.authors.length + 1);
        this.authors[this.authors.length - 1] = author;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.title);
        hash = 43 * hash + this.publishedYear;
        hash = 43 * hash + Arrays.deepHashCode(this.authors);
        hash = 43 * hash + this.qantity;
        hash = 43 * hash + this.count;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        if (this.qantity != other.qantity) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Arrays.deepEquals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }
}
