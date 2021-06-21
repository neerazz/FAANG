import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://www.baeldung.com/parameterized-tests-junit-5
 */

public class TestRunner {

    public static <I, O> void runTest(Function<I, O> function, I input, O output) {
        JUnitCore junit = new JUnitCore();
        junit.run(TestRunner.class);
    }

    @TestFactory
    Collection<DynamicTest> perform_a_recursive_test_to_get_unique_id() throws Exception {
        Collection<DynamicTest> uniqueIdTests = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            DynamicTest dynamicTest = DynamicTest.dynamicTest(
//                    "Creating a unique ID: ",
//                    this::getUniqueId);
//            uniqueIdTests.add(dynamicTest);
//        }
        return uniqueIdTests;
    }

    static <I, O> Stream<Arguments> getArguments(I input, O output) {
        return Stream.of(Arguments.of(input, output));
    }

    @Test
    public <I, O> void test(Function<I, O> function, I input, O output) {
        Assertions.assertEquals(function.apply(input), output);
    }

    static class TestCase<I, O> {
        I input;
        O output;
        Function<I, O> function;

        public TestCase(Function<I, O> function, I input, O output) {
            this.function = function;
            this.input = input;
            this.output = output;
        }

        @Test
        public void test() {
            Assertions.assertEquals(function.apply(input), output);
        }
    }
}
