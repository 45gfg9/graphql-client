package net.im45.lib.graphql;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import static net.im45.lib.graphql.Scalar.scalar;

abstract class GraphQLContainer<T extends GraphQLContainer<T>> {
    private static final Pattern NAMING = Pattern.compile("[_A-Za-z][_0-9A-Za-z]+");

    protected final List<GraphQLType> child = new LinkedList<>();

    protected void checkName(String... names) {
        for (String name : names)
            if (!NAMING.matcher(name).matches())
                throw new IllegalArgumentException("Given name \"" + name + "\" is not a legal GraphQL identifier.");
    }

    @SuppressWarnings("unchecked")
    public T add(String... scalars) {
        for (String s : scalars) {
            add(scalar(s));
        }

        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T add(GraphQLType item) {
        child.add(item);

        return (T) this;
    }

    @Override
    public abstract String toString();
}
