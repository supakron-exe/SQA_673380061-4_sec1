package edu.kku.sqa.lab8;

public final class LengthConverter implements UnitConverter {
    @Override
    public double convert(double value, Unit from, Unit to) {
        requireCategory(from, to, UnitCategory.LENGTH);
        return value * from.baseFactor() / to.baseFactor();
    }

    private static void requireCategory(Unit from, Unit to, UnitCategory category) {
        if (from.category() != category || to.category() != category) {
            throw new IllegalArgumentException("Length converter only accepts length units");
        }
    }
}
