package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveExercisesTest {

    @Test
    void addReturnsSum() {
        assertEquals(7, PrimitiveExercises.add(3, 4));
        assertEquals(-1, PrimitiveExercises.add(3, -4));
    }

    @Test
    void multiplyUsesLongArithmeticBeforeOverflowCanOccur() {
        assertEquals(6_000_000_000L, PrimitiveExercises.multiply(2_000_000, 3_000));
    }

    @Test
    void averagePreservesFractionalPart() {
        assertEquals(2.5, PrimitiveExercises.average(2, 3), 0.000001);
    }

    @Test
    void isEvenHandlesZeroPositiveAndNegativeValues() {
        assertTrue(PrimitiveExercises.isEven(0));
        assertTrue(PrimitiveExercises.isEven(-4));
        assertFalse(PrimitiveExercises.isEven(7));
    }

    @Test
    void firstCharacterReturnsFirstCharacterAndRejectsInvalidInput() {
        assertEquals('J', PrimitiveExercises.firstCharacter("Java"));
        assertEquals('A', PrimitiveExercises.firstCharacter("A"));
        assertThrows(IllegalArgumentException.class, () -> PrimitiveExercises.firstCharacter(""));
        assertThrows(IllegalArgumentException.class, () -> PrimitiveExercises.firstCharacter(null));
    }
}
