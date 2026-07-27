package com.health.fitness;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.health.fitness.HealthIndexScore.FitnessLevel;

class HealthIndexScoreNormalBoundaryTest {

    @ParameterizedTest(name = "{0}: VO2={1}, RHR={2}, HRR={3} -> {4}")
    @CsvSource({
        "TC001, 42, 130, 21, STANDARD",
        "TC002, 25, 130, 21, STANDARD",
        "TC003, 26, 130, 21, STANDARD",
        "TC004, 59, 130, 21, STANDARD",
        "TC005, 60, 130, 21, STANDARD",
        "TC006, 42, 40, 21, EXCELLENT",
        "TC007, 42, 41, 21, EXCELLENT",
        "TC008, 42, 219, 21, STANDARD",
        "TC009, 42, 220, 21, STANDARD",
        "TC010, 42, 130, 12, STANDARD",
        "TC011, 42, 130, 13, STANDARD",
        "TC012, 42, 130, 29, STANDARD",
        "TC013, 42, 130, 30, STANDARD"
    })
    void classifiesNormalBoundaryValues(
            String testCaseId,
            double vo2Max,
            int restingHeartRate,
            int heartRateRecovery,
            FitnessLevel expectedLevel) {
        HealthIndexScore healthIndex =
                new HealthIndexScore(vo2Max, restingHeartRate, heartRateRecovery);

        assertEquals(expectedLevel, healthIndex.getFitnessLevel(), testCaseId);
    }
}
