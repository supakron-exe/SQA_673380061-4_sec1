package edu.kku.sqa.lab8;

public final class UniversalConverterApp {
    private UniversalConverterApp() {
    }

    public static void main(String[] args) {
        ConversionController controller = new ConversionController(new DefaultConverterFactory());
        System.out.println("1.25 km = " + controller.convert(1.25, Unit.KILOMETER, Unit.METER) + " m");
        System.out.println("25 C = " + controller.convert(25, Unit.CELSIUS, Unit.FAHRENHEIT) + " F");
    }
}
