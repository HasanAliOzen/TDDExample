import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Student id: B201202020
 * Full Name: Hasan Ali Özen
 * Lecture: SWE 202 Software Verification And Validation
 * Homework: 1
 * Repository Link: https://github.com/HasanAliOzen/TDDExample
 * */
class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDivision1() {
        assertEquals(5, Calculator.divide(10, 2));
    }

    @Test
    void testDivision2() {
        assertEquals(2.5, Calculator.divide(10, 4));
    }

    @Test
    void testDivision3() {
        assertEquals(2.5, Calculator.divide(12.5, 5));
    }

    @Test
    void testDivision4() {
        assertEquals(4, Calculator.divide(10, 2.5));
    }

    @Test
    void testDivision5() {
        assertEquals(5, Calculator.divide(12.5, 2.5));
    }

    @Test
    void testDivision6() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5, 0),
                "IllegalArgumentException expected."
        );

    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void parameterizedTest(double a,double b,double expected){
        assertEquals(expected,Calculator.divide(a,b));
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(10,2,5),
                Arguments.of(10,4,2.5),
                Arguments.of(12.5,5,2.5),
                Arguments.of(10,2.5,4),
                Arguments.of(12.5,2.5,5)
        );
    }
}