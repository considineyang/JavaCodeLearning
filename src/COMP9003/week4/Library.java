package COMP9003.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Library {
    private String name;

    public Library(String name, int openYear, String location) {
        this.name = name;
        this.openYear = openYear;
        this.location = location;
        books = new HashMap<>();
    }

    private int openYear;
    private String location;
    private HashMap<Book,Integer> books;

    public String getName() {
        return name;
    }

    public int getOpenYear() {
        return openYear;
    }

    public String getLocation() {
        return location;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (book==null){
            return;
        }
        if (getBooks().containsKey(book)){
            int num = getBooks().get(book) +1;
            getBooks().put(book, num);
        }else{
            getBooks().put(book, 1);
        }
    }

    public List<Book> getBooksByGenre(String genre) {
        if (genre == null){
            return null;
        }
        List<Book> list = new ArrayList<>();
        getBooks().forEach((key, value) -> {
            if (Objects.equals(key.getGenre(), genre)) {
                list.add(key);
            }
        });
        return list;
    }

    public List<Book> getBooksByAuthor(Author author) {
        if (author == null){
            return null;
        }
        List<Book> list = new ArrayList<>();
        getBooks().forEach((key, value) -> {
            if (Objects.equals(key.getAuthor(), author)) {
                list.add(key);
            }
        });
        return list;
    }
}
