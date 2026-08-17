package edu.kku.sqa.lab8;

import java.util.Objects;

public final class ConversionController {
    private final ConverterFactory factory;

    public ConversionController(ConverterFactory factory) {
        this.factory = Objects.requireNonNull(factory, "factory");
    }

    public double convert(double value, Unit from, Unit to) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units are required");
        }
        return factory.getConverter(from, to).convert(value, from, to);
    }
}
