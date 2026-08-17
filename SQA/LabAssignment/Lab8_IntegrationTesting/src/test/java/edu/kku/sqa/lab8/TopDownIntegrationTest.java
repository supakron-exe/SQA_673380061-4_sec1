package edu.kku.sqa.lab8;

import edu.kku.sqa.lab8.support.StubConverterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TopDownIntegrationTest {
    @Test
    void controllerUsesStubForLengthConversion() {
        StubConverterFactory stub = new StubConverterFactory(1250.0);
        ConversionController controller = new ConversionController(stub);

        assertEquals(1250.0, controller.convert(1.25, Unit.KILOMETER, Unit.METER));
        assertEquals(Unit.KILOMETER, stub.requestedFrom());
        assertEquals(Unit.METER, stub.requestedTo());
    }

    @Test
    void controllerUsesStubForTemperatureConversion() {
        StubConverterFactory stub = new StubConverterFactory(77.0);
        ConversionController controller = new ConversionController(stub);

        assertEquals(77.0, controller.convert(25.0, Unit.CELSIUS, Unit.FAHRENHEIT));
    }

    @Test
    void controllerRejectsNonFiniteInputBeforeCallingStub() {
        ConversionController controller = new ConversionController(new StubConverterFactory(0.0));

        assertThrows(IllegalArgumentException.class,
                () -> controller.convert(Double.NaN, Unit.KILOGRAM, Unit.GRAM));
    }
}
