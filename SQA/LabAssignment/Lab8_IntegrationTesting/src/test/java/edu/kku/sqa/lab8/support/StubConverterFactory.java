package edu.kku.sqa.lab8.support;

import edu.kku.sqa.lab8.ConverterFactory;
import edu.kku.sqa.lab8.Unit;
import edu.kku.sqa.lab8.UnitConverter;

public final class StubConverterFactory implements ConverterFactory {
    private final double stubbedResult;
    private Unit requestedFrom;
    private Unit requestedTo;

    public StubConverterFactory(double stubbedResult) {
        this.stubbedResult = stubbedResult;
    }

    @Override
    public UnitConverter getConverter(Unit from, Unit to) {
        requestedFrom = from;
        requestedTo = to;
        return (value, ignoredFrom, ignoredTo) -> stubbedResult;
    }

    public Unit requestedFrom() {
        return requestedFrom;
    }

    public Unit requestedTo() {
        return requestedTo;
    }
}
