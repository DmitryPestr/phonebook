package javaschool.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {
    private static int count = 0;
    private int id;
    private String name;
    private String email;
    private final List<String> phones = new ArrayList<>();

    public Record() {
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void addPhones(String... phones) {
        this.phones.addAll(Arrays.asList(phones));
    }


    @Override
    public String toString() {
        return id + " " + name + " " + email + " " + phones;
    }
}
