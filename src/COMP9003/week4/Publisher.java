package COMP9003.week4;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private String name;
    private String location;
    private List<Library> libraries;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public Publisher(String name, String location) {
        this.name = name;
        this.location = location;
        libraries = new ArrayList<>();
    }
}
