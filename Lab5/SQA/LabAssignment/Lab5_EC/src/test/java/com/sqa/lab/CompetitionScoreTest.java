package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#5.2 - Equivalence Class Testing : CompetitionScore
 * Strategy: Strong Robust Equivalence Class Testing
 *
 * Valid EC (Range/Output based)
 *  V1: score1 มีค่ามากที่สุด (unique max)
 *  V2: score2 มีค่ามากที่สุด (unique max)
 *  V3: score3 มีค่ามากที่สุด (unique max)
 *  V4: คะแนนทั้ง 3 ครั้งเท่ากันทั้งหมด (all tie)
 *  V5: คะแนน 2 ใน 3 ครั้งเท่ากันและเป็นค่าสูงสุด (2-way tie)
 *
 * Invalid EC
 *  I1: score1 < 0
 *  I2: score2 < 0
 *  I3: score3 < 0
 *  I4: score > 500 (เกินคะแนนเต็ม)
 *  I5: ผิดเงื่อนไขพร้อมกันหลายค่า (multiple fault)
 */
class CompetitionScoreTest {

    private CompetitionScore competition;

    @BeforeEach
    void setUp() {
        competition = new CompetitionScore();
    }

    // =====================================================================
    // findMaxScore(int score1, int score2, int score3)
    // =====================================================================

    // ---------- Valid EC (TC001-TC006) ----------
    @DisplayName("Valid EC: findMaxScore(int,int,int) with valid scores")
    @ParameterizedTest(name = "{0}: findMaxScore({1},{2},{3}) -> {4}")
    @CsvSource({
        "TC001, 300, 150, 200, 300",  // V1: score1 สูงสุด
        "TC002, 100, 450, 300, 450",  // V2: score2 สูงสุด
        "TC003,  50,  60, 500, 500",  // V3: score3 สูงสุด
        "TC004, 250, 250, 250, 250",  // V4: ทุกค่าเท่ากัน
        "TC005, 400, 400, 300, 400",  // V5: 2-way tie (score1=score2)
        "TC006, 300, 400, 400, 400"   // V5: 2-way tie (score2=score3)
    })
    void testFindMaxScore_params_validCases(String tcId, int s1, int s2, int s3, int expected) {
        assertEquals(expected, competition.findMaxScore(s1, s2, s3));
    }

    // ---------- Invalid EC: score ติดลบ (TC007-TC009) ----------
    @DisplayName("Invalid EC: findMaxScore(int,int,int) - score ติดลบ ต้อง throw IllegalArgumentException")
    @ParameterizedTest(name = "{0}: findMaxScore({1},{2},{3})")
    @CsvSource({
        "TC007, -50, 100, 200",   // I1: score1 < 0
        "TC008, 100, -20, 200",   // I2: score2 < 0
        "TC009, 100, 200, -30"    // I3: score3 < 0
    })
    void testFindMaxScore_params_negativeScore(String tcId, int s1, int s2, int s3) {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(s1, s2, s3));
    }

    // ---------- Invalid EC: score เกิน 500 (TC010-TC011) ----------
    @DisplayName("Invalid EC: findMaxScore(int,int,int) - score > 500 ต้อง throw IllegalArgumentException")
    @ParameterizedTest(name = "{0}: findMaxScore({1},{2},{3})")
    @CsvSource({
        "TC010, 600, 100, 200",   // I4: score1 > 500
        "TC011, 100, 200, 600"    // I4: score3 > 500
    })
    void testFindMaxScore_params_scoreOverMax(String tcId, int s1, int s2, int s3) {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(s1, s2, s3));
    }

    // ---------- Invalid EC: multiple fault (TC012) ----------
    @DisplayName("TC012 - Invalid EC: findMaxScore(int,int,int) - ผิดเงื่อนไขพร้อมกันหลายค่า")
    @Test
    void testFindMaxScore_params_multipleFault() {
        // I5: score1 < 0 และ score2 > 500 พร้อมกัน
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(-10, 600, 200));
    }

    // ---------- Valid EC: boundary values (TC013) ----------
    @DisplayName("TC013 - Valid EC: findMaxScore(int,int,int) - boundary (min=0, max=500)")
    @Test
    void testFindMaxScore_params_boundaryValues() {
        assertEquals(500, competition.findMaxScore(0, 0, 500));
    }

    // =====================================================================
    // findMaxScore(int[] scores)
    // =====================================================================

    // ---------- Valid EC (TC001-TC006) ----------
    @DisplayName("Valid EC: findMaxScore(int[]) with valid scores")
    @ParameterizedTest(name = "{0}: findMaxScore([{1},{2},{3}]) -> {4}")
    @CsvSource({
        "TC001, 300, 150, 200, 300",  // V1
        "TC002, 100, 450, 300, 450",  // V2
        "TC003,  50,  60, 500, 500",  // V3
        "TC004, 250, 250, 250, 250",  // V4
        "TC005, 400, 400, 300, 400",  // V5
        "TC006, 300, 400, 400, 400"   // V5
    })
    void testFindMaxScore_array_validCases(String tcId, int s1, int s2, int s3, int expected) {
        assertEquals(expected, competition.findMaxScore(new int[]{s1, s2, s3}));
    }

    // ---------- Invalid EC: score ติดลบ (TC007-TC009) ----------
    @DisplayName("Invalid EC: findMaxScore(int[]) - score ติดลบ ต้อง throw IllegalArgumentException")
    @ParameterizedTest(name = "{0}: findMaxScore([{1},{2},{3}])")
    @CsvSource({
        "TC007, -50, 100, 200",
        "TC008, 100, -20, 200",
        "TC009, 100, 200, -30"
    })
    void testFindMaxScore_array_negativeScore(String tcId, int s1, int s2, int s3) {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(new int[]{s1, s2, s3}));
    }

    // ---------- Invalid EC: score เกิน 500 (TC010-TC011) ----------
    @DisplayName("Invalid EC: findMaxScore(int[]) - score > 500 ต้อง throw IllegalArgumentException")
    @ParameterizedTest(name = "{0}: findMaxScore([{1},{2},{3}])")
    @CsvSource({
        "TC010, 600, 100, 200",
        "TC011, 100, 200, 600"
    })
    void testFindMaxScore_array_scoreOverMax(String tcId, int s1, int s2, int s3) {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(new int[]{s1, s2, s3}));
    }

    // ---------- Invalid EC: multiple fault (TC012) ----------
    @DisplayName("TC012 - Invalid EC: findMaxScore(int[]) - ผิดเงื่อนไขพร้อมกันหลายค่า")
    @Test
    void testFindMaxScore_array_multipleFault() {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(new int[]{-10, 600, 200}));
    }

    // ---------- Valid EC: boundary values (TC013) ----------
    @DisplayName("TC013 - Valid EC: findMaxScore(int[]) - boundary (min=0, max=500)")
    @Test
    void testFindMaxScore_array_boundaryValues() {
        assertEquals(500, competition.findMaxScore(new int[]{0, 0, 500}));
    }

    // ---------- Extra: array ที่ขนาดไม่ใช่ 3 ----------
    @DisplayName("Extra - Invalid: findMaxScore(int[]) - array size != 3 ต้อง throw IllegalArgumentException")
    @Test
    void testFindMaxScore_array_wrongSize() {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(new int[]{100, 200}));
    }

    // ---------- Extra: null array ----------
    @DisplayName("Extra - Invalid: findMaxScore(int[]) - null ต้อง throw IllegalArgumentException")
    @Test
    void testFindMaxScore_array_null() {
        assertThrows(IllegalArgumentException.class,
                () -> competition.findMaxScore(null));
    }
}