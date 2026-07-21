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
 * Lab#5.1 - Equivalence Class Testing : ShiftCipher.decrypt()
 * Strategy: Weak Robust Equivalence Class Testing
 *
 * Valid EC
 *  V1: cipherText length = 1 (A-Z, case-insensitive)
 *  V2: cipherText length > 1 (A-Z, case-insensitive)
 *  V3: key = positive integer
 *  V4: key = negative integer
 *  V5: key = 0
 *
 * Invalid EC
 *  I1: cipherText contains digit(s)
 *  I2: cipherText contains space
 *  I3: cipherText contains other special character(s)
 *  I4: cipherText is empty string
 *  I5: cipherText is null
 */
class ShiftCipherDecryptTest {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }

    
    @DisplayName("Valid EC: decrypt() with valid cipherText and key")
    @ParameterizedTest(name = "{0}: decrypt(\"{1}\", {2}) -> \"{3}\"")
    @CsvSource({
        "TC001, R,      17, A",       
        "TC002, VOOVXF, -5, ATTACK",  
        "TC003, Z,       0, Z"       
    })
    void testDecrypt_validCases(String tcId, String cipherText, int key, String expected) {
        assertEquals(expected, cipher.decrypt(cipherText, key));
    }

    
    @DisplayName("Valid EC: lowercase cipherText is auto-converted to uppercase")
    @ParameterizedTest(name = "{0}: decrypt(\"{1}\", {2}) -> \"{3}\"")
    @CsvSource({
        "TC004, rkkrtb, 17, ATTACK"
    })
    void testDecrypt_lowercaseIsAccepted(String tcId, String cipherText, int key, String expected) {
        assertEquals(expected, cipher.decrypt(cipherText, key));
    }

    
    @DisplayName("Invalid EC: cipherText contains a non A-Z character")
    @ParameterizedTest(name = "{0}: decrypt(\"{1}\", 17) should throw IllegalArgumentException")
    @CsvSource({
        "TC005, VO0VXF",   // I1: digit
        "TC006, VO OVXF",  // I2: space
        "TC007, VO@VXF"    // I3: special character
    })
    void testDecrypt_invalidCharacters(String tcId, String cipherText) {
        assertThrows(IllegalArgumentException.class, () -> cipher.decrypt(cipherText, 17));
    }

    
    @DisplayName("TC008 - Invalid EC: cipherText is an empty string")
    @Test
    void testDecrypt_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> cipher.decrypt("", 17));
    }

    
    @DisplayName("TC009 - Invalid EC: cipherText is null")
    @Test
    void testDecrypt_nullCipherText() {
        assertThrows(IllegalArgumentException.class, () -> cipher.decrypt(null, 17));
    }
}