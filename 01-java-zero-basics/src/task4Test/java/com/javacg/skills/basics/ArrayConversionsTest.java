package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayConversionsTest {

    @Test
    void toListPreservesOrderAndCreatesIndependentResult() {
        int[] source = {1, 2, 3};
        List<Integer> result = ArrayConversions.toList(source);

        assertEquals(List.of(1, 2, 3), result);

        source[0] = 99;
        assertEquals(1, result.get(0));
    }

    @Test
    void toListHandlesEmptyArrayAndRejectsNull() {
        assertEquals(List.of(), ArrayConversions.toList(new int[0]));
        assertThrows(IllegalArgumentException.class, () -> ArrayConversions.toList(null));
    }

    @Test
    void toPrimitiveArrayPreservesOrderAndCreatesIndependentResult() {
        List<Integer> source = new ArrayList<>(Arrays.asList(4, 5, 6));
        int[] result = ArrayConversions.toPrimitiveArray(source);

        assertArrayEquals(new int[]{4, 5, 6}, result);

        source.set(0, 99);
        assertEquals(4, result[0]);
    }

    @Test
    void toPrimitiveArrayHandlesEmptyListAndRejectsInvalidInput() {
        assertArrayEquals(new int[0], ArrayConversions.toPrimitiveArray(List.of()));
        assertThrows(IllegalArgumentException.class, () -> ArrayConversions.toPrimitiveArray(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayConversions.toPrimitiveArray(Arrays.asList(1, null, 3))
        );
    }
}
