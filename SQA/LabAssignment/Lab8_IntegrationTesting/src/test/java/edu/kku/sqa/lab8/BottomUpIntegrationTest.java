package edu.kku.sqa.lab8;

import edu.kku.sqa.lab8.support.ConverterDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BottomUpIntegrationTest {
    private final ConverterDriver driver = new ConverterDriver(new DefaultConverterFactory());

    @Test
    void driverExecutesLengthConverters() {
        assertEquals(1250.0, driver.run(1.25, Unit.KILOMETER, Unit.METER));
        assertEquals(0.75, driver.run(750.0, Unit.METER, Unit.KILOMETER));
    }

    @Test
    void driverExecutesWeightConverters() {
        assertEquals(2000.0, driver.run(2.0, Unit.KILOGRAM, Unit.GRAM));
        assertEquals(0.5, driver.run(500.0, Unit.GRAM, Unit.KILOGRAM));
    }

    @Test
    void driverExecutesTemperatureConverters() {
        assertEquals(77.0, driver.run(25.0, Unit.CELSIUS, Unit.FAHRENHEIT));
        assertEquals(0.0, driver.run(32.0, Unit.FAHRENHEIT, Unit.CELSIUS));
    }

    @Test
    void driverRejectsIncompatibleCategories() {
        assertThrows(IllegalArgumentException.class,
                () -> driver.run(1.0, Unit.METER, Unit.GRAM));
    }
}
