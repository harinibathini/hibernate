package org.example;

import dao.BookDaoImpl;

import javax.persistence.*;

@Entity
@Table(name = "deletedbookcrud")
public class DeletedBook {

        @Id
        @Column(name = "bookId")
        private int id;
        private String bookName;
        private String authorName;
        private String publisherName;
        private int publishYear;
        private float price;

        public DeletedBook() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public int getPublishYear() {
            return publishYear;
        }

        public void setPublishYear(int publishYear) {
            this.publishYear = publishYear;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", bookName='" + bookName + '\'' +
                    ", authorName='" + authorName + '\'' +
                    ", publisherName='" + publisherName + '\'' +
                    ", publishYear=" + publishYear +
                    ", price=" + price +
                    '}';
        }


}
