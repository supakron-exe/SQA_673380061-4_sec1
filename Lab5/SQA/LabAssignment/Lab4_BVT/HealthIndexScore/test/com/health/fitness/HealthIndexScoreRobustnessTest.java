package com.health.fitness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.health.fitness.HealthIndexScore.FitnessLevel;

class HealthIndexScoreRobustnessTest {

    @ParameterizedTest(name = "{0}: VO2={1}, RHR={2}, HRR={3} -> {4}")
    @CsvSource({
        "TC001, 42, 130, 21, STANDARD",
        "TC002, 24, 130, 21, POOR",
        "TC003, 25, 130, 21, STANDARD",
        "TC004, 26, 130, 21, STANDARD",
        "TC005, 59, 130, 21, STANDARD",
        "TC006, 60, 130, 21, STANDARD",
        "TC007, 61, 130, 21, STANDARD",
        "TC009, 42, 40, 21, EXCELLENT",
        "TC010, 42, 41, 21, EXCELLENT",
        "TC011, 42, 219, 21, STANDARD",
        "TC012, 42, 220, 21, STANDARD",
        "TC014, 42, 130, 11, POOR",
        "TC015, 42, 130, 12, STANDARD",
        "TC016, 42, 130, 13, STANDARD",
        "TC017, 42, 130, 29, STANDARD",
        "TC018, 42, 130, 30, STANDARD",
        "TC019, 42, 130, 31, STANDARD"
    })
    void classifiesRobustBoundaryValues(
            String testCaseId,
            double vo2Max,
            int restingHeartRate,
            int heartRateRecovery,
            FitnessLevel expectedLevel) {
        HealthIndexScore healthIndex =
                new HealthIndexScore(vo2Max, restingHeartRate, heartRateRecovery);

        assertEquals(expectedLevel, healthIndex.getFitnessLevel(), testCaseId);
    }

    @ParameterizedTest(name = "{0}: RHR={2} is outside 40-220")
    @CsvSource({
        "TC008, 42, 39, 21",
        "TC013, 42, 221, 21"
    })
    void rejectsRestingHeartRateOutsideSupportedRange(
            String testCaseId,
            double vo2Max,
            int restingHeartRate,
            int heartRateRecovery) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthIndexScore(vo2Max, restingHeartRate, heartRateRecovery),
                testCaseId);
    }
}
