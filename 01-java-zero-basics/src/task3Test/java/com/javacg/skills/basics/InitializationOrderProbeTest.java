package com.javacg.skills.basics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitializationOrderProbeTest {

    @Test
    void recordsRealInitializationEventsInRequiredOrder() {
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
}
