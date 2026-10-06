package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaZeroBasicsTest {

    @Test
    void primitiveExercisesFollowTheRequiredContract() {
        assertEquals(7, PrimitiveExercises.add(3, 4));
        assertEquals(-1, PrimitiveExercises.add(3, -4));

        assertEquals(6_000_000_000L, PrimitiveExercises.multiply(2_000_000, 3_000));
        assertEquals(2.5, PrimitiveExercises.average(2, 3), 0.000001);

        assertTrue(PrimitiveExercises.isEven(0));
        assertTrue(PrimitiveExercises.isEven(-4));
        assertFalse(PrimitiveExercises.isEven(7));

        assertEquals('J', PrimitiveExercises.firstCharacter("Java"));
        assertThrows(IllegalArgumentException.class, () -> PrimitiveExercises.firstCharacter(""));
        assertThrows(IllegalArgumentException.class, () -> PrimitiveExercises.firstCharacter(null));
    }

    @Test
    void referenceExercisesDistinguishIdentityMutationAndCopying() {
        int[] original = {10, 20, 30};
        int[] copy = ReferenceExercises.copyArray(original);

        assertNotSame(original, copy);
        assertArrayEquals(original, copy);

        copy[0] = 999;
        assertEquals(10, original[0]);

        ReferenceExercises.incrementFirst(original);
        assertArrayEquals(new int[]{11, 20, 30}, original);

        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.copyArray(null));
        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.incrementFirst(null));
        assertThrows(IllegalArgumentException.class, () -> ReferenceExercises.incrementFirst(new int[0]));

        Object object = new Object();
        assertTrue(ReferenceExercises.sameReference(object, object));
        assertFalse(ReferenceExercises.sameReference(new String("java"), new String("java")));
        assertTrue(ReferenceExercises.sameReference(null, null));
    }

    @Test
    void initializationOrderIsProducedByRealInitializationMechanisms() {
        assertEquals(
                List.of(
                        "static-field",
                        "static-block",
                        "instance-field",
                        "instance-block",
                        "constructor"
                ),
                InitializationOrderProbe.createAndGetEvents()
        );
    }

    @Test
    void primitiveArraysConvertToIndependentIntegerLists() {
        int[] source = {1, 2, 3};
        List<Integer> result = ArrayConversions.toList(source);

        assertEquals(List.of(1, 2, 3), result);

        source[0] = 99;
        assertEquals(1, result.get(0));

        assertEquals(List.of(), ArrayConversions.toList(new int[0]));
        assertThrows(IllegalArgumentException.class, () -> ArrayConversions.toList(null));
    }

    @Test
    void integerListsConvertToIndependentPrimitiveArrays() {
        List<Integer> source = new ArrayList<>(Arrays.asList(4, 5, 6));
        int[] result = ArrayConversions.toPrimitiveArray(source);

        assertArrayEquals(new int[]{4, 5, 6}, result);

        source.set(0, 99);
        assertEquals(4, result[0]);

        assertArrayEquals(new int[0], ArrayConversions.toPrimitiveArray(List.of()));
        assertThrows(IllegalArgumentException.class, () -> ArrayConversions.toPrimitiveArray(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayConversions.toPrimitiveArray(Arrays.asList(1, null, 3))
        );
    }


    @Test
    void studentProfileSourceFileHasExpectedPackageAndTopLevelClass() throws IOException {
        Path source = Path.of(
                "src",
                "main",
                "java",
                "com",
                "javacg",
                "skills",
                "basics",
                "StudentProfile.java"
        );

        assertTrue(Files.exists(source), "StudentProfile.java must exist at the required package path");

        String content = Files.readString(source);

        assertTrue(
                content.contains("package com.javacg.skills.basics;"),
                "StudentProfile.java must declare package com.javacg.skills.basics"
        );

        assertTrue(
                content.matches("(?s).*\\bpublic\\s+class\\s+StudentProfile\\b.*"),
                "StudentProfile.java must declare public class StudentProfile"
        );

        assertFalse(
                content.matches("(?s).*import\\s+java\\.lang\\..*"),
                "Do not import java.lang types explicitly"
        );
    }

    @Test
    void studentProfileFollowsTheBehavioralContract() {
        int before = StudentProfile.getCreatedCount();

        StudentProfile first = new StudentProfile("Maksym");
        StudentProfile second = new StudentProfile("Alex", 3);

        assertEquals("Maksym", first.getName());
        assertEquals(StudentProfile.DEFAULT_LEVEL, first.getLevel());

        assertEquals("Alex", second.getName());
        assertEquals(3, second.getLevel());

        second.setLevel(5);
        assertEquals(5, second.getLevel());

        assertEquals("Maksym [level=" + StudentProfile.DEFAULT_LEVEL + "]", first.describe());
        assertEquals("Alex [level=5]", second.describe());

        assertEquals(before + 2, StudentProfile.getCreatedCount());

        assertThrows(IllegalArgumentException.class, () -> new StudentProfile(null));
        assertThrows(IllegalArgumentException.class, () -> new StudentProfile(""));
        assertThrows(IllegalArgumentException.class, () -> new StudentProfile("   "));
    }
}
