package optional.model;

import java.util.Objects;

public class Country {

    private final String name;

    public Country(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
