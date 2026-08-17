package edu.kku.sqa.lab8.support;

import edu.kku.sqa.lab8.ConverterFactory;
import edu.kku.sqa.lab8.Unit;

public final class ConverterDriver {
    private final ConverterFactory factory;

    public ConverterDriver(ConverterFactory factory) {
        this.factory = factory;
    }

    public double run(double value, Unit from, Unit to) {
        return factory.getConverter(from, to).convert(value, from, to);
    }
}
