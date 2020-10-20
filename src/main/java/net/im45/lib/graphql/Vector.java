package net.im45.lib.graphql;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public final class Vector extends GraphQLContainer<Vector> implements GraphQLType {
    private final String name;
    private final Map<String, String> args = new HashMap<>();
    private final Map<String, Object> literals = new HashMap<>();

    private Vector(String name) {
        this.name = name;
    }

    public static Vector vector(String name) {
        return new Vector(name);
    }

    public Vector addParam(String k, Integer v) {
        literals.put(k, v);
        return this;
    }

    public Vector addParam(String k, Long v) {
        literals.put(k, v);
        return this;
    }

    public Vector addParam(String k, Double v) {
        literals.put(k, v);
        return this;
    }

    public Vector addParam(String k, Boolean v) {
        literals.put(k, v);
        return this;
    }

    public Vector addParam(String k, Option v) {
        literals.put(k, v);
        return this;
    }

    public Vector addParam(String k, String v) {
        args.put(k, v);
        return this;
    }

    public Vector addEnumParam(String k, String v) {
        literals.put(k, v);
        return this;
    }

    public Vector addAll(Map<String, String> map) {
        args.putAll(map);
        return this;
    }

    public Vector addEnumAll(Map<String, String> map) {
        literals.putAll(map);
        return this;
    }

    @Override
    public String toString() {
        String prefix = name;

        if (!(args.isEmpty() && literals.isEmpty())) {
            StringJoiner joiner = new StringJoiner(", ", "(", ")");

            args.forEach((k, v) -> {
                String str = k + ": \"" + v + "\"";
                joiner.add(str);
            });

            literals.forEach((k, v) -> {
                String str = k + ": " + v;
                joiner.add(str);
            });

            prefix += joiner;
        }

        prefix += " {";

        return child.stream()
                .map(GraphQLType::toString)
                .collect(Collectors.joining(" ", prefix, "}"));
    }
}
