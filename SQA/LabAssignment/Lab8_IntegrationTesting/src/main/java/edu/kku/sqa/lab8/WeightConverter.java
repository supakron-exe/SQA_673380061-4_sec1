package edu.kku.sqa.lab8;

public final class WeightConverter implements UnitConverter {
    @Override
    public double convert(double value, Unit from, Unit to) {
        if (from.category() != UnitCategory.WEIGHT || to.category() != UnitCategory.WEIGHT) {
            throw new IllegalArgumentException("Weight converter only accepts weight units");
        }
        return value * from.baseFactor() / to.baseFactor();
    }
}
