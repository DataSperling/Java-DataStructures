package io.DataSperling;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running ArrayListTests")
public class TestArrayList {

    ArrayList arrayList;
    TestInfo testInfo;
    TestReporter testReporter;

    /*
     * Instantiation of test reporter objects if needed for reference later
     */
    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry(
                "Running " + testInfo.getDisplayName() +
                        " with tags " + testInfo.getTags()
        );

        //check new ArrayList is instantiated before each test
        System.out.println(" creating new ArrayList ...");
        arrayList = new ArrayList();
    }

    /*
    * inner class to test addToFront()
    */
    @Nested
    @DisplayName("test empty list")
    @Tag("array_element")
    class testEmptyArrayList {

        @Test
        @DisplayName("When ArrayList is empty")
        void testEmptyArrayList() {

            assertEquals(arrayList.getSize(), 0);

        }

        @Test
        @DisplayName("When adding null data to empty list")
        void testAddingNullToEmptyArrayList() {

            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToFront(null));

        }

        @Test
        @DisplayName("When adding null data non empty list")
        void testAddingNullToArrayList() {

            // when
            arrayList.addToFront("www.google.com");
            arrayList.addToFront("www.cran.com");

            //then
            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToFront(null));

        }
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

            // when
            arrayList.addToFront("www.zollsoft.de");

            // then
            assertEquals(arrayList.getSize(), 1);

        }

        @Test
        @DisplayName("When adding to FRONT of ArrayList with one or more nodes")
        void testAddToFrontOneOrMore() {

            // when
            arrayList.addToFront("www.google.com");
            arrayList.addToFront("www.ibm.com");


            // then
            assertEquals( arrayList.getBackingArray()[0].toString() ,"www.ibm.com");
            assertEquals( arrayList.getBackingArray()[1].toString(), "www.google.com");
        }

        @Test
        @DisplayName("When adding to FRONT of FULL ArrayList requiring resize")
        void testAddToFrontFull() {

            // require resize
        }
    }


}
