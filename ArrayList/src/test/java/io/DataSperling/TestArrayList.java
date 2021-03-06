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
    * inner class to test ArrayList is instantiated with the correct parameters
    */
    @Nested
    @DisplayName("test empty list")
    @Tag("array_element")
    class testEmptyArrayList {

        @Test
        @DisplayName("When ArrayList is empty")
        void testEmptyArrayListSize() {
            /*
            * Check size and length of ArrayList are correct
            */
            assertEquals(arrayList.getSize(), 0);
            assertEquals(arrayList.getBackingArray().length, 11) ;
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
        @DisplayName("When adding null to FRONT of empty ArrayList")
        void testAddNullToFrontEmpty() {
            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToFront(null));
        }

        @Test
        @DisplayName("When adding null to FRONT non empty list")
        void testAddingNullTFrontNonEmpty() {

            // given
            arrayList.addToFront("www.google.com");
            arrayList.addToFront("www.cran.com");

            // then
            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToFront(null));
        }


        @Test
        @DisplayName("When adding data to FRONT of empty ArrayList")
        void testAddToFrontEmpty() {
            // given
            arrayList.addToFront("www.zollsoft.de");

            // then
            assertEquals(arrayList.getSize(), 1);
        }

        @Test
        @DisplayName("When adding data to FRONT of ArrayList with one or more nodes")
        void testAddToFrontOneOrMore() {
            // given
            arrayList.addToFront("www.google.com");
            arrayList.addToFront("www.ibm.com");

            // then
            assertEquals( arrayList.getBackingArray()[0].toString() ,"www.ibm.com");
            assertEquals( arrayList.getBackingArray()[1].toString(), "www.google.com");
        }

        @Test
        @DisplayName("When adding data to FRONT of FULL ArrayList requiring resize")
        void testAddToFrontFull() {
            // given
            arrayList.addToFront("www.endpoint.com");
            arrayList.addToFront("www.zune.com");
            arrayList.addToFront("www.apache.org");
            arrayList.addToFront("www.ibm.com");
            arrayList.addToFront("www.google.com");
            arrayList.addToFront("www.ibm.com");
            arrayList.addToFront("www.aws.com");
            arrayList.addToFront("www.colab.com");
            arrayList.addToFront("www.kaggle.com");
            arrayList.addToFront("www.tds.com");
            arrayList.addToFront("www.azure.com");

            // when
            arrayList.addToFront("www.startpoint.com");

            // then
            assertEquals(arrayList.getSize(), 12);
            assertEquals(arrayList.getBackingArray()[0].toString() ,"www.startpoint.com");
            assertEquals(arrayList.getBackingArray()[1].toString(), "www.azure.com");
            assertEquals(arrayList.getBackingArray()[11].toString() ,"www.endpoint.com");
            assertEquals(arrayList.getBackingArray().length, 22);
            assertNull(arrayList.getBackingArray()[12]);
        }
    }

    /*
     * inner class to test addAtIndex()
     */
    @Nested
    @DisplayName("addAtIndex()")
    @Tag("addToList")
    class testAddAtIndex {
        @Test
        @DisplayName("When adding null at index 0 of empty list")
        void testAddNullAtIndexEmpty() {
            assertThrows(java.lang.IllegalArgumentException.class, ()->
                    arrayList.addAtIndex(0, null));

        }

        @Test
        @DisplayName("When adding data to middle of non empty list")
        void testAddAtIndexEmptyNonEmpty() {
            // given
            arrayList.addToBack("www.google.com");
            arrayList.addToBack("www.azure.com");
            arrayList.addToBack("www.kdd.com");
            arrayList.addToBack("www.tds.com");
            arrayList.addToBack("www.ubuntu.com");
            arrayList.addToBack("www.kvv.com");
            arrayList.addToBack("www.zollsoft.com");

            // when
            arrayList.addAtIndex(3, "www.bing.com");

            // then
            assertEquals(arrayList.getBackingArray()[2], "www.kdd.com");
            assertEquals(arrayList.getBackingArray()[3], "www.bing.com");
            assertEquals(arrayList.getBackingArray()[4], "www.tds.com");
            assertEquals(arrayList.getSize(), 8);
            assertNull(arrayList.getBackingArray()[8]);
        }

        @Test
        @DisplayName("When adding data to middle of FULL list")
        void testAddAtIndexFull() {
            // given
            arrayList.addToBack("www.ibm.com");
            arrayList.addToBack("www.edx.com");
            arrayList.addToBack("www.coursera.com");
            arrayList.addToBack("www.udemy.com");
            arrayList.addToBack("www.google.com");
            arrayList.addToBack("www.amazon.com");
            arrayList.addToBack("www.tsmc.com");
            arrayList.addToBack("www.nvidia.com");
            arrayList.addToBack("www.sony.com");
            arrayList.addToBack("www.tencent.com");
            arrayList.addToBack("www.samsung.com");
            arrayList.addToBack("www.broadcom.com");
            arrayList.addToBack("www.cisco.com");
            arrayList.addToBack("www.oracle.com");


            // when
            arrayList.addAtIndex(6, "www.intel.com");

            // then
            assertEquals(arrayList.getBackingArray()[5], "www.amazon.com");
            assertEquals(arrayList.getBackingArray()[6], "www.intel.com");
            assertEquals(arrayList.getBackingArray()[7], "www.tsmc.com");
            assertEquals(arrayList.getSize(), 15);
            assertNull(arrayList.getBackingArray()[15]);

        }
    }







    /*
     * inner class to test addToBack()
     */
    @Nested
    @DisplayName("addToBack()")
    @Tag("addToList")
    class testAddToBack {
        @Test
        @DisplayName("When adding null to BACK of empty ArrayList")
        void testAddNullToBackEmpty() {
            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToBack(null));
        }

        @Test
        @DisplayName("When adding null to BACK non empty ArrayList")
        void testAddingNullTBackNonEmpty() {

            // given
            arrayList.addToFront("www.google.com");
            arrayList.addToBack("www.cran.com");

            // then
            assertThrows(IllegalArgumentException.class, () ->
                    arrayList.addToBack(null));
        }

        @Test
        @DisplayName("When adding to BACK of ArrayList does NOT require resize")
        void testAddToBackOneOrMore() {
            // given
            arrayList.addToFront("www.sap.com");
            arrayList.addToBack("www.lufthansa.com");
            arrayList.addToFront("www.selek.com");
            arrayList.addToBack("www.softserve.com");

            // then
            assertEquals(arrayList.getSize(), 4);
            assertEquals(arrayList.getBackingArray()[0].toString(), "www.selek.com");
            assertEquals(arrayList.getBackingArray()[1].toString(), "www.sap.com");
            assertEquals(arrayList.getBackingArray()[2].toString(), "www.lufthansa.com");
            assertEquals(arrayList.getBackingArray()[3].toString(), "www.softserve.com");
        }

        @Test
        @DisplayName("When adding to BACK of a FULL ArrayList requires resize")
        void testAddToBackFull() {
            // given
            arrayList.addToFront("www.allianz.com");
            arrayList.addToBack("www.daimler.com");
            arrayList.addToFront("www.bmw.com");
            arrayList.addToBack("www.volkswagen.com");
            arrayList.addToFront("www.basf.com");
            arrayList.addToBack("www.rwe.com");
            arrayList.addToFront("www.bayer.com");
            arrayList.addToBack("www.eon.com");
            arrayList.addToFront("www.siemens.com");
            arrayList.addToBack("www.db.com");
            arrayList.addToFront("www.thyssenkrup.com");

            // when
            arrayList.addToBack("www.deutschepost.com");
            arrayList.addToBack("www.bosch.com");
            arrayList.addToBack("www.zf.com");

            // then
            assertEquals(arrayList.getSize(), 14);
            assertEquals(arrayList.getBackingArray().length, 22);
            assertEquals(arrayList.getBackingArray()[0].toString(), "www.thyssenkrup.com");
            assertEquals(arrayList.getBackingArray()[2].toString(), "www.bayer.com");
            assertEquals(arrayList.getBackingArray()[4].toString(), "www.bmw.com");
            assertEquals(arrayList.getBackingArray()[6].toString(), "www.daimler.com");
            assertEquals(arrayList.getBackingArray()[8].toString(), "www.rwe.com");
            assertEquals(arrayList.getBackingArray()[10].toString(), "www.db.com");
            assertEquals(arrayList.getBackingArray()[11].toString(), "www.deutschepost.com");
            assertEquals(arrayList.getBackingArray()[12].toString(), "www.bosch.com");
            assertEquals(arrayList.getBackingArray()[13].toString(), "www.zf.com");
            assertNull(arrayList.getBackingArray()[14]);
            assertNull(arrayList.getBackingArray()[15]);
        }
    }

    /*
     * inner class to test removeFromFront()
     */
    @Nested
    @DisplayName("removeFromFront()")
    @Tag("removeFromList")
    class removeFromFront {
        @Test
        @DisplayName("When removing from FRONT of empty ArrayList")
        void testRemoveFromFrontEmpty() {
            assertThrows(NoSuchElementException.class, () ->
                    arrayList.removeFromFront() );
        }

        @Test
        @DisplayName("When removing from FRONT of ArrayList with single element")
        void testRemoveFromFrontSingleElement() {
            // given
            arrayList.addToFront("www.zollsoft.com");

            // when
            arrayList.removeFromFront();

            // then
            assertNull(arrayList.getBackingArray()[0]);
            assertNull(arrayList.getBackingArray()[1]);
            assertNull(arrayList.getBackingArray()[2]);
            assertEquals(arrayList.getSize(), 0);
        }

        @Test
        @DisplayName("When removing from FRONT of ArrayList with multiple elements")
        void testRemoveFromFrontMultiple() {
            // given
            arrayList.addToBack("www.alpina.com");
            arrayList.addToFront("www.aralAG.com");
            arrayList.addToBack("www.audi.com");
            arrayList.addToFront("www.bechtle.com");
            arrayList.addToBack("www.beyerdynamic.com");
            arrayList.addToFront("www.biontech.com");

            // when
            assertEquals(arrayList.removeFromFront(), "www.biontech.com");

            // then
            assertEquals(arrayList.getBackingArray()[0], "www.bechtle.com");
            assertEquals(arrayList.getBackingArray()[1], "www.aralAG.com");
            assertEquals(arrayList.getBackingArray()[2], "www.alpina.com");
            assertEquals(arrayList.getSize(), 5);
        }
    }

    /*
     * inner class to test removeFromBack()
     */
    @Nested
    @DisplayName("removeFromBack()")
    @Tag("removeFromList")
    class removeFromBack {
        @Test
        @DisplayName("When removing from BACK of empty ArrayList")
        void testRemoveFromBackEmpty() {
            assertThrows(NoSuchElementException.class, () ->
                    arrayList.removeFromBack() );
        }

        @Test
        @DisplayName("When removing from BACK of ArrayList with single element")
        void testRemoveFromBackSingleElement() {
            // given
            arrayList.addToBack("www.ibm.de");

            // when
            arrayList.removeFromBack();

            // then
            assertNull(arrayList.getBackingArray()[0]);
            assertNull(arrayList.getBackingArray()[1]);
            assertNull(arrayList.getBackingArray()[2]);
            assertEquals(arrayList.getSize(), 0);
        }

        @Test
        @DisplayName("When removing from BACK ArrayList with multiple elements")
        void testRemoveFromBackMultiple() {
            // given
            arrayList.addToFront("www.allianz.com");
            arrayList.addToBack("www.daimler.com");
            arrayList.addToFront("www.bmw.com");
            arrayList.addToBack("www.volkswagen.com");
            arrayList.addToFront("www.basf.com");
            arrayList.addToBack("www.rwe.com");

            // when
            assertEquals(arrayList.removeFromBack(), "www.rwe.com");

            // then
            assertEquals(arrayList.getBackingArray()[0], "www.basf.com");
            assertEquals(arrayList.getBackingArray()[1], "www.bmw.com");
            assertEquals(arrayList.getBackingArray()[2], "www.allianz.com");
            assertEquals(arrayList.getBackingArray()[3], "www.daimler.com");
            assertEquals(arrayList.getBackingArray()[4], "www.volkswagen.com");
            assertNull(arrayList.getBackingArray()[5]);
        }
    }
}
