package edu.kku.sqa.lab8;

public final class TemperatureConverter implements UnitConverter {
    @Override
    public double convert(double value, Unit from, Unit to) {
        if (from.category() != UnitCategory.TEMPERATURE || to.category() != UnitCategory.TEMPERATURE) {
            throw new IllegalArgumentException("Temperature converter only accepts temperature units");
        }
        if (from == to) {
            return value;
        }
        if (from == Unit.CELSIUS && to == Unit.FAHRENHEIT) {
            return value * 9.0 / 5.0 + 32.0;
        }
        if (from == Unit.FAHRENHEIT && to == Unit.CELSIUS) {
            return (value - 32.0) * 5.0 / 9.0;
        }
        throw new IllegalArgumentException("Unsupported temperature conversion");
    }
}
