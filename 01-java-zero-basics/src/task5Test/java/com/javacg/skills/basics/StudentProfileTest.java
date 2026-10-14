package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StudentProfileTest {

    @Test
    void sourceFileHasExpectedPackageAndTopLevelClass() throws IOException {
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
    void constructorsInitializeRequiredState() {
        int before = StudentProfile.getCreatedCount();

        StudentProfile first = new StudentProfile("Maksym");
        StudentProfile second = new StudentProfile("Alex", 3);

        assertEquals("Maksym", first.getName());
        assertEquals(StudentProfile.DEFAULT_LEVEL, first.getLevel());
        assertEquals("Alex", second.getName());
        assertEquals(3, second.getLevel());

        assertEquals(before + 2, StudentProfile.getCreatedCount());
    }

    @Test
    void setLevelAndDescribeFollowContract() {
        StudentProfile profile = new StudentProfile("Alex", 3);

        profile.setLevel(5);

        assertEquals(5, profile.getLevel());
        assertEquals("Alex [level=5]", profile.describe());
    }

    @Test
    void defaultLevelIsUsedBySingleArgumentConstructor() {
        StudentProfile profile = new StudentProfile("Maksym");

        assertEquals(
                "Maksym [level=" + StudentProfile.DEFAULT_LEVEL + "]",
                profile.describe()
        );
    }

    @Test
    void constructorsRejectInvalidNames() {
        assertThrows(IllegalArgumentException.class, () -> new StudentProfile(null));
        assertThrows(IllegalArgumentException.class, () -> new StudentProfile(""));
        assertThrows(IllegalArgumentException.class, () -> new StudentProfile("   "));
    }
}
