package edu.kku.sqa.lab8;

public final class IntegrationSmokeRunner {
    private IntegrationSmokeRunner() {
    }

    public static void main(String[] args) {
        ConversionController controller = new ConversionController(new DefaultConverterFactory());
        check(controller.convert(1.25, Unit.KILOMETER, Unit.METER), 1250.0, "length");
        check(controller.convert(2.0, Unit.KILOGRAM, Unit.GRAM), 2000.0, "weight");
        check(controller.convert(25.0, Unit.CELSIUS, Unit.FAHRENHEIT), 77.0, "temperature");
        try {
            controller.convert(1.0, Unit.METER, Unit.GRAM);
            throw new AssertionError("incompatible units should fail");
        } catch (IllegalArgumentException expected) {
            // expected validation result
        }
        System.out.println("Integration smoke checks passed");
    }

    private static void check(double actual, double expected, String name) {
        if (Math.abs(actual - expected) > 1e-9) {
            throw new AssertionError(name + ": expected " + expected + " but got " + actual);
        }
    }
}
