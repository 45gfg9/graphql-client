package net.im45.lib.graphql;

import java.util.stream.Collectors;

public final class Query extends GraphQLContainer<Query> {
    private final String name;

    public Query() {
        this(null);
    }

    public Query(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String prefix = "query " + (name == null ? "" : name + " ") + "{";

        return child.stream()
                .map(GraphQLType::toString)
                .collect(Collectors.joining(", ", prefix, "}"));
    }
}
