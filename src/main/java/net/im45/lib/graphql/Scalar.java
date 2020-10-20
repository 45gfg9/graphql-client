package net.im45.lib.graphql;

import java.util.Objects;

public final class Scalar implements GraphQLType {
    private final String name;

    private Scalar(String name) {
        this.name = name;
    }

    public static Scalar scalar(String name) {
        return new Scalar(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scalar scalar = (Scalar) o;
        return Objects.equals(name, scalar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
