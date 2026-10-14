package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceExercisesTest {

    @Test
    void copyArrayCreatesIndependentCopy() {
        int[] original = {10, 20, 30};
        int[] copy = ReferenceExercises.copyArray(original);

        assertNotSame(original, copy);
        assertArrayEquals(original, copy);

        copy[0] = 999;
        assertEquals(10, original[0]);
    }

    @Test
    void copyArrayRejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.copyArray(null));
    }

    @Test
    void incrementFirstMutatesPassedArray() {
        int[] values = {10, 20, 30};

        ReferenceExercises.incrementFirst(values);

        assertArrayEquals(new int[]{11, 20, 30}, values);
    }

    @Test
    void incrementFirstRejectsNullAndEmptyArrays() {
        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.incrementFirst(null));
        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.incrementFirst(new int[0]));
    }

    @Test
    void sameReferenceChecksIdentityRatherThanLogicalEquality() {
        Object object = new Object();

        assertTrue(ReferenceExercises.sameReference(object, object));
        assertFalse(ReferenceExercises.sameReference(new String("java"), new String("java")));
        assertTrue(ReferenceExercises.sameReference(null, null));
    }
}
