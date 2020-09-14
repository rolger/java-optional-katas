package optional.model;

public class Country {

    private final String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
