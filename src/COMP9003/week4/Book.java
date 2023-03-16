package COMP9003.week4;

public class Book {
    private String name;
    private Author author;
    private Publisher publisher;
    private int publishYear;
    private String genre;

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishingLocation() {
        return getPublisher().getLocation();
    }

    public Boolean copyrighted() {
        if (getAuthor().getDeathYear() == -1){
            return true;
        }
        return (2022 - 75)<getAuthor().getDeathYear();
    }

    public Book(String name, Author author, Publisher publisher, int publishYear, String genre) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.genre = genre;
    }
}
