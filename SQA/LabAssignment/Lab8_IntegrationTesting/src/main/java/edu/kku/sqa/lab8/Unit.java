package edu.kku.sqa.lab8;

public enum Unit {
    KILOMETER(UnitCategory.LENGTH, 1000.0),
    METER(UnitCategory.LENGTH, 1.0),
    KILOGRAM(UnitCategory.WEIGHT, 1000.0),
    GRAM(UnitCategory.WEIGHT, 1.0),
    CELSIUS(UnitCategory.TEMPERATURE, 1.0),
    FAHRENHEIT(UnitCategory.TEMPERATURE, 1.0);

    private final UnitCategory category;
    private final double baseFactor;

    Unit(UnitCategory category, double baseFactor) {
        this.category = category;
        this.baseFactor = baseFactor;
    }

    public UnitCategory category() {
        return category;
    }

    public double baseFactor() {
        return baseFactor;
    }
}
