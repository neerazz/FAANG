package biweekly.biweekly56;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jul 10, 2021
 * Ref:
 */

public class MinimumCostToReachDestinationInTime {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, null)
        );
    }

    static Function<Object, Object> function;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(Object input, Object expected) {
        assertEquals(expected, function.apply(input));
    }
}
