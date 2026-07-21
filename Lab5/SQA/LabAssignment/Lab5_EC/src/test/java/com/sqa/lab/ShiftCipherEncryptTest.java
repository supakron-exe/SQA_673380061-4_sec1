package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#5.1 - Equivalence Class Testing : ShiftCipher.encrypt()
 * Strategy: Weak Robust Equivalence Class Testing
 *
 * Valid EC
 *  V1: plainText length = 1 (A-Z, case-insensitive)
 *  V2: plainText length > 1 (A-Z, case-insensitive)
 *  V3: key = positive integer
 *  V4: key = negative integer
 *  V5: key = 0
 *
 * Invalid EC
 *  I1: plainText contains digit(s)
 *  I2: plainText contains space
 *  I3: plainText contains other special character(s)
 *  I4: plainText is empty string
 *  I5: plainText is null
 */
class ShiftCipherEncryptTest {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }

 
    @DisplayName("Valid EC: encrypt() with valid plainText and key")
    @ParameterizedTest(name = "{0}: encrypt(\"{1}\", {2}) -> \"{3}\"")
    @CsvSource({
        "TC001, A,      17, R",
        "TC002, ATTACK, -5, VOOVXF",
        "TC003, Z,       0, Z"
    })
    void testEncrypt_validCases(String tcId, String plainText, int key, String expected) {
        assertEquals(expected, cipher.encrypt(plainText, key));
    }


    @DisplayName("Valid EC: lowercase plainText is auto-converted to uppercase")
    @ParameterizedTest(name = "{0}: encrypt(\"{1}\", {2}) -> \"{3}\"")
    @CsvSource({
        "TC004, attack, 17, RKKRTB"
    })
    void testEncrypt_lowercaseIsAccepted(String tcId, String plainText, int key, String expected) {
        assertEquals(expected, cipher.encrypt(plainText, key));
    }

  
    @DisplayName("Invalid EC: plainText contains a non A-Z character")
    @ParameterizedTest(name = "{0}: encrypt(\"{1}\", 17) should throw IllegalArgumentException")
    @CsvSource({
        "TC005, AT7ACK",  
        "TC006, AT ACK",  
        "TC007, AT@ACK"   
    })
    void testEncrypt_invalidCharacters(String tcId, String plainText) {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt(plainText, 17));
    }

   
    @DisplayName("TC008 - Invalid EC: plainText is an empty string")
    @org.junit.jupiter.api.Test
    void testEncrypt_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("", 17));
    }

    
    @DisplayName("TC009 - Invalid EC: plainText is null")
    @org.junit.jupiter.api.Test
    void testEncrypt_nullPlainText() {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt(null, 17));
    }
}