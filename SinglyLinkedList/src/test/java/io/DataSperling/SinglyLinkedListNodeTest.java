package io.DataSperling;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Arrays;
import java.util.NoSuchElementException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running SinglyLinkedListTests")
class TestSinglyLinkedList {

    SinglyLinkedList<String> singlyLinkedList;
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

        // check a new SLL instance is instantiated before each test
        System.out.println(" creating new SinglyLinkedList ...");
        singlyLinkedList = new SinglyLinkedList();
    }

    /*
    * inner class for node tests
     */
    @Nested
    @DisplayName("SLLNode pointers")
    @Tag("node")
    class testNode {

        @Test
        @DisplayName(" test empty node")
        void testNullPointersEmptyList() {

            // given empty SLL then
            assertNull(singlyLinkedList.getHead());
            assertNull(singlyLinkedList.getTail());
            assertEquals(singlyLinkedList.getSize(), 0, " SLL size should be zero as empty");
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
        @DisplayName("When adding to FRONT of an empty SinglyLinkedList")
        void testAddToFrontEmpty() {

            // given
            singlyLinkedList.addToFront("www.ineos.no");

            // then
            assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.addToFront(null));
            assertEquals(singlyLinkedList.getSize(), 1);
            assertEquals(singlyLinkedList.getHead().getData(), "www.ineos.no");
            assertEquals(singlyLinkedList.getTail().getData(), "www.ineos.no");
            assertNull(singlyLinkedList.getHead().getNext());
            assertNull(singlyLinkedList.getTail().getNext());
        }

        @Test
        @DisplayName("When adding to FRONT of a SinglyLinkedList with one or more nodes")
        void testAddToFrontOneOrMoreNodes() {

            // given
            singlyLinkedList.addToFront("www.ineos.no");
            singlyLinkedList.addToFront("www.zollsoft.de");

            // then
            assertEquals(singlyLinkedList.getSize(), 2);
            assertEquals(singlyLinkedList.getHead().getData(), "www.zollsoft.de");
            assertEquals(singlyLinkedList.getTail().getData(), "www.ineos.no");
            assertEquals(singlyLinkedList.getHead().getNext().getData(), singlyLinkedList.getTail().getData() );
            assertNull(singlyLinkedList.getTail().getNext());
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
        @DisplayName("When adding to BACK of empty SLL")
        void testAddToBackEmpty() {

            // given
            singlyLinkedList.addToBack("www.stackoverflow.com");

            // then
            assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.addToBack(null));
            assertEquals(singlyLinkedList.getSize(), 1);
            assertEquals(singlyLinkedList.getHead().getData(), "www.stackoverflow.com");
            assertEquals(singlyLinkedList.getTail().getData(), "www.stackoverflow.com");
            assertNull(singlyLinkedList.getHead().getNext());
            assertNull(singlyLinkedList.getTail().getNext());

        }

        @Test
        @DisplayName("When adding to BACK of a SinglyLinkedList with one or more nodes")
        void testAddToBackOneOrMoreNodes() {

            // given
            singlyLinkedList.addToBack("www.stackoverflow.com");
            singlyLinkedList.addToBack("www.github.com");

            // then
            assertEquals(singlyLinkedList.getSize(), 2);
            assertEquals(singlyLinkedList.getHead().getData(), "www.stackoverflow.com");
            assertEquals(singlyLinkedList.getTail().getData(), "www.github.com");
            assertEquals(singlyLinkedList.getHead().getNext().getData(), singlyLinkedList.getTail().getData() );
            assertNull(singlyLinkedList.getTail().getNext());
        }
    }

    /*
    * inner class to test addBefore()
    */
    @Nested
    @DisplayName("addBefore()")
    @Tag("addToList")
    class testAddBefore {

        @Test
        @DisplayName("When adding BEFORE on empty SLL")
        void testAddBeforeEmpty() {

            // given empty SLL then
            assertThrows(IllegalArgumentException.class, () ->
                    singlyLinkedList.addBefore("www.askubuntu.com", null));

            assertThrows(NoSuchElementException.class, () ->
                    singlyLinkedList.addBefore("www.askubuntu.com", "www.code.google.com"));

            assertEquals(singlyLinkedList.getSize(), 0);
        }

        @Test
        @DisplayName("When adding BEFORE middle node")
        void testAddBeforeMiddleNode() {

        }

        @Test
        @DisplayName("When adding BEFORE last node")
        void testAddBeforeLastNode() {

            // given
            singlyLinkedList.addToBack("www.ibm.com");
            singlyLinkedList.addToBack("www.kdnuggets.com");
            singlyLinkedList.addToBack("www.cran.r-project.org");
            singlyLinkedList.addToBack("www.knime.com");
            singlyLinkedList.addToBack("www.oracle.com");
            singlyLinkedList.addToBack("www.superuser.com");
            singlyLinkedList.addBefore("www.superuser.com", "www.intel.com");

            // when
            SinglyLinkedListNode current = singlyLinkedList.getHead();
            while (current.getNext().getData() != "www.superuser.com") {
                current = current.getNext();
            }

            // then
            assertEquals(current.getData(), "www.intel.com");
            assertEquals(singlyLinkedList.getHead().getData(), "www.ibm.com");
            assertEquals(singlyLinkedList.getTail().getData(), "www.superuser.com");
            assertEquals(singlyLinkedList.getSize(), 7);
        }
    }

    /*
    * inner class to test addAfter()
    */
    @Nested
    @DisplayName("addAfter()")
    @Tag("addToList")
    class testAddAfter {

        @Test
        @DisplayName("When adding AFTER on empty SLL")
        void testAddAfterEmpty() {

            // given empty SLL then
            assertThrows(IllegalArgumentException.class, () ->
                    singlyLinkedList.addBefore("www.datacamp.com", null));

            assertThrows(NoSuchElementException.class, () ->
                    singlyLinkedList.addBefore("www.kaggle.com", "www.jetbrains.com"));

            assertEquals(singlyLinkedList.getSize(), 0);
        }

        @Test
        @DisplayName("When adding after MIDDLE node")
        void testAddAfterMiddleNode() {

            // given
            singlyLinkedList.addToBack("www.spring.com");
            singlyLinkedList.addToBack("www.maven.org");
            singlyLinkedList.addToBack("www.apache.org");
            singlyLinkedList.addToBack("www.sparksql.com");
            singlyLinkedList.addToBack("www.seaborn.com");
            singlyLinkedList.addAfter("www.apache.org", "www.dplyr.com");

            // when
            SinglyLinkedListNode current = singlyLinkedList.getHead();
            while (current.getData() != "www.apache.org") {
                current = current.getNext();
            }

            // then
            assertEquals(current.getNext().getData(), "www.dplyr.com");
            assertEquals(singlyLinkedList.getHead().getData(), "www.spring.com");
            assertEquals(singlyLinkedList.getTail().getData(), "www.seaborn.com");
            assertEquals(singlyLinkedList.getSize(), 6);
        }

        @Test
        @DisplayName("When adding AFTER last node")
        void testAddAfterLastNode() {

            // given
            singlyLinkedList.addToBack("www.dataflair.org");
            singlyLinkedList.addToBack("www.datacampblog.com");
            singlyLinkedList.addToBack("www.datascience.com");
            singlyLinkedList.addToBack("www.databricks.com");
            singlyLinkedList.addAfter("www.databricks.com", "www.trifacta.com");
            System.out.println(singlyLinkedList.toString());

            // when
            SinglyLinkedListNode current = singlyLinkedList.getHead();
            while (current.getData() != "www.databricks.com") {
                current = current.getNext();
            }

            // then
            assertEquals(current.getNext().getData(), "www.trifacta.com");
            assertEquals(singlyLinkedList.getHead().getData(), "www.dataflair.org");
            assertEquals(singlyLinkedList.getTail().getData(), "www.trifacta.com");
            assertEquals(singlyLinkedList.getSize(), 5);
        }
    }

    /*
    * inner class to test removeFromFront()
    */
    @Nested
    @DisplayName("removeFromFront()")
    @Tag("removeFromList")
    class testRemoveFromFront {

        @Test
        @DisplayName("When removingFromFront on empty list")
        void testRemoveFromFrontEmpty() {

            // given empty SLL then
            assertThrows(NoSuchElementException.class, () ->
                    singlyLinkedList.removeFromFront());

            // given empty SLL then
            assertEquals(singlyLinkedList.getSize(), 0);
        }

        @Test
        @DisplayName("When removingFromFront on list with one node ")
        void testRemoveFromFrontSingleNode() {

            // given
            singlyLinkedList.addToFront("www.youtube.com/videos");
            assertEquals(singlyLinkedList.getHead().getData(), "www.youtube.com/videos");
            assertEquals(singlyLinkedList.getTail().getData(), "www.youtube.com/videos");

            // when
            singlyLinkedList.removeFromFront();

            // then
            assertNull(singlyLinkedList.getHead());
            assertNull(singlyLinkedList.getTail());
            assertEquals(singlyLinkedList.getSize(), 0);
        }

        @Test
        @DisplayName("When removingFromFront on list with multiple nodes")
        void testRemoveFromFrontMultipleNodes() {

            // given
            singlyLinkedList.addToFront("www.netflix.com");
            singlyLinkedList.addToBack("www.peacock.com");
            singlyLinkedList.addToFront("www.hulu.com");
            singlyLinkedList.addToBack("www.disneyplus.com");

            // when
            singlyLinkedList.removeFromFront();

            // then
            assertEquals(singlyLinkedList.getHead().getData(), "www.netflix.com");
            assertEquals(singlyLinkedList.getTail().getData(), "www.disneyplus.com");
            assertNull(singlyLinkedList.getTail().getNext());
            assertEquals(singlyLinkedList.getSize(), 3);
        }
    }

    /*
    * inner class to test removeFromBack()
    */
    @Nested
    @DisplayName("removeFromBack()")
    @Tag("removeFromList")
    class testRemoveFromBack {

        @Test
        @DisplayName("When removingFromBack on empty list")
        void testRemoveFromBackEmpty() {

            // given empty SLL then
            assertThrows(NoSuchElementException.class, () ->
                    singlyLinkedList.removeFromBack());

            // given empty SLL then
            assertEquals(singlyLinkedList.getSize(), 0);

        }

        @Test
        @DisplayName("When removingFromBack on list with one node")
        void testRemoveFromBackSingleNode() {

            // given
            singlyLinkedList.addToBack("www.kubernetes.io");
            assertEquals(singlyLinkedList.getHead().getData(), "www.kubernetes.io");
            assertEquals(singlyLinkedList.getTail().getData(), "www.kubernetes.io");
            assertNull(singlyLinkedList.getHead().getNext());

            // when
            singlyLinkedList.removeFromBack();

            // then
            assertNull(singlyLinkedList.getHead());
            assertNull(singlyLinkedList.getTail());
            assertEquals(singlyLinkedList.getSize(), 0);
        }

        @Test
        @DisplayName("When removingFromBack on list with multiple nodes")
        void testRemoveFromBackMultipleNodes() {

        }
    }

    /*
    * inner class to test removeData()
    */
    @Nested
    @DisplayName("removeData()")
    @Tag("removeFromList")
    class testRemoveData {

        @Test
        @DisplayName("When removing data that's not present in SLL")
        void testRemoveDataNotPresent() {

            // given
            singlyLinkedList.addToBack("www.basf.com");
            singlyLinkedList.addToFront("www.bayerag.com");
            singlyLinkedList.addToBack("www.henkelag.com");
            singlyLinkedList.addToFront("www.evonik.com");

            // then
            assertThrows(NoSuchElementException.class, () ->
                    singlyLinkedList.removeData("www.siemens.de"));
        }

        @Test
        @DisplayName("When removing null from SLL")
        void testRemoveDataIsNull() {

            // given
            singlyLinkedList.addToBack("www.audi.ch");
            singlyLinkedList.addToFront("www.bmw.mu");
            singlyLinkedList.addToBack("www.vw.de");
            singlyLinkedList.addToFront("www.volvo.se");

            // then
            assertThrows(IllegalArgumentException.class, () ->
                    singlyLinkedList.removeData(null));
        }

        @Test
        @DisplayName("When removing data that's in head node")
        void testRemoveDataHeadNode() {

        }

        @Test
        @DisplayName("When removing data that's in middle node")
        void testRemoveDataInMiddleNode() {

        }

        @Test
        @DisplayName("When removing data from tail node")
        void testRemoveDataInTailNode() {

        }
    }



}

