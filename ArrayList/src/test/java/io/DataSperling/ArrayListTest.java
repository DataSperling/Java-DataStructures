package io.DataSperling;

import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running ArrayListTests")
public class ArrayListTest {

    ArrayList<String> arrayList;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry(
                "Running " + testInfo.getDisplayName() +
                        " with tags " + testInfo.getTags()
        );

        // check new ArrayList is instantiated before each test
        System.out.println(" creating new ArrayList");
        arrayList = new ArrayList();
    }

    /*
    * inner class to test addToFront()
    */
    @Nested
    @DisplayName("addToFront()")
    @Tag("addToList")
    class testAddToFront {

        @Test
        @DisplayName("When adding to FRONT of empty ArrayList")
        void testAddToFrontEmpty() {

            // simple add
        }

        @Test
        @DisplayName("When adding to FRONT of ArrayList with one or more nodes")
        void testAddToFrontOneOrMore() {

            // require shifting
        }

        @Test
        @DisplayName("When adding to FRONT of FULL ArrayList requiring resize")
        void testAddToFrontFull() {

            // require resize
        }
    }


}
