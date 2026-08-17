package edu.kku.sqa.lab8;

public final class DefaultConverterFactory implements ConverterFactory {
    @Override
    public UnitConverter getConverter(Unit from, Unit to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units are required");
        }
        if (from.category() != to.category()) {
            throw new IllegalArgumentException("Units must use the same category");
        }
        return switch (from.category()) {
            case LENGTH -> new LengthConverter();
            case WEIGHT -> new WeightConverter();
            case TEMPERATURE -> new TemperatureConverter();
        };
    }
}
