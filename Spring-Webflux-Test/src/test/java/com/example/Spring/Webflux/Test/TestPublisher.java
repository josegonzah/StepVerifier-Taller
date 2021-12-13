package com.example.Spring.Webflux.Test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class TestPublisher {

    final reactor.test.publisher.TestPublisher<String> testPublisher = TestPublisher.create();

    @Test
    void testUpperCase() {
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(testPublisher.flux());
        StepVerifier.create(upperCaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERAODS", "SOFKA")
                .verifyComplete();
    }
}
