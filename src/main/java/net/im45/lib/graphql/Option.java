package net.im45.lib.graphql;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Option {
    private final Map<String, Object> options = new HashMap<>();

    private Option() {
    }

    public static Option option() {
        return new Option();
    }

    public Option add(String k, String v) {
        options.put(k, v);
        return this;
    }

    @Override
    public String toString() {
        return options.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
