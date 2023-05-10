package dao;

import org.example.Book;

import java.io.IOException;

public interface BookDao {
    public void insertRecord(Book book);
    public void updateRecord() throws IOException;
    public void deleteRecord() throws IOException;
    public void selectRecord();
}
