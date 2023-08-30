package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
	{
		ArraySet <Integer> addTest = new ArraySet<Integer>();
		assertEquals(0, addTest.size());
	}

	@Test
	void testAddE() {
		
		ArraySet <Integer> addTest = new ArraySet<Integer>();
		//Populate array
		addTest.add(0);
		addTest.add(1);
        addTest.add(2);
        addTest.add(3);
 
        //Make sure size is right after adding
        assertEquals(4, addTest.size());
        
		//Check elements that dont exist
        assertFalse(addTest.contains(4));
        assertFalse(addTest.contains(-2));
        //Elements that do exist
        assertTrue(addTest.contains(3));
        
        //Add duplicates
        assertFalse(addTest.add(3));
        assertFalse(addTest.add(0));
	}

	@Test
	void testRetainAll()
	{
		//Create a list
		List<Integer> testCollection = new ArrayList<>();
		
		testCollection.add(5);
		testCollection.add(12);
		testCollection.add(15);
		
		assertEquals(3,testCollection.size());
	        
		
		//Populate array set. 
		ArraySet <Integer> testRet = new ArraySet<Integer>();
		
		testRet.add(0);
		testRet.add(5);
		testRet.add(10);
		testRet.add(12);
		testRet.add(15);
		
		assertEquals(5,testRet.size());
		
		//What does this do?
		assertTrue(testRet.retainAll(testCollection));
		assertEquals(3,testRet.size());
		
		assertFalse(testRet.contains(0));
		assertFalse(testRet.contains(10));
		assertTrue(testRet.contains(5));
		assertTrue(testRet.contains(12));
		assertTrue(testRet.contains(15));	
	}
	

	@Test
	void testRemoveAll()
	{
		ArraySet <Integer> testRem = new ArraySet<Integer>();
		testRem.add(1);
		testRem.add(2);
		testRem.add(3);
		testRem.add(4);
		
		assertEquals(4, testRem.size());
		
        assertEquals(4, testRem.size());
        
        testRem.removeAll(testRem);
        assertEquals(0, testRem.size());
	}
	
	void testAddAll(){
		
		//Populate array to add to
		ArraySet <Integer> testAddA = new ArraySet<Integer>();
		
		testAddA.add(1);
		testAddA.add(2);
		testAddA.add(3);
		testAddA.add(4);
		
		//Populate collection to add
		List<Integer> collTest = new ArrayList<>();
		collTest.add(5);
		collTest.add(6);
		collTest.add(7);
		collTest.add(8);
		
		//Add collection to array set no duplicates
		assertTrue(testAddA.addAll(collTest));
		
		
		List<Integer> collTest1 = new ArrayList<>();
		collTest.add(1);
		collTest.add(2);
		collTest.add(3);
		collTest.add(4);
		
		//Add collection to array set all duplicates
		assertFalse(testAddA.addAll(collTest));
		
	}

}
