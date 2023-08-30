/**
* A class that tests arraySet using a number of test methods
*
*
* @author <Moultrie Dangerfield, Flynn Nisbet, Mengsrun Nit>
* @date <08/30/23>
*/
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
        
		//Check elements that don't exist
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
		
		//------Test------
		testRet.retainAll(testCollection);
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
		//-----Test1------
		ArraySet <Integer> testRem = new ArraySet<Integer>();
		testRem.add(1);
		testRem.add(2);
		testRem.add(3);
		testRem.add(4);
		
		assertEquals(4, testRem.size());
        
        testRem.removeAll(testRem);
        assertEquals(0, testRem.size());
        
        //----Test2------
        //Remove all from empty set
        ArraySet <Integer> testRem2 = new ArraySet<Integer>();
        assertEquals(0, testRem2.size());
        testRem.removeAll(testRem2);
        assertEquals(0, testRem2.size());
	}
	@Test
	void testAddAll(){
		
		//------Test1-----------
		ArraySet <Integer> testAddA = new ArraySet<Integer>();
		//Populate arrraySet
		testAddA.add(1);
		testAddA.add(2);
		testAddA.add(3);
		testAddA.add(4);
		assertEquals(4, testAddA.size());
		
		//Populate collection to add
		List<Integer> collTest = new ArrayList<>();
		collTest.add(1);
		collTest.add(2);
		collTest.add(3);
		collTest.add(4);
		
		//Add collection to array set no duplicates
		testAddA.addAll(collTest);
		assertEquals(4, testAddA.size());
		assertTrue(testAddA.contains(4));
		
		
		//----Test 2------
		ArraySet <Integer> testAddA1 = new ArraySet<Integer>();
		
		testAddA1.add(1);
		testAddA1.add(2);
		testAddA1.add(3);
		testAddA1.add(4);
		
		List<Integer> collTest1 = new ArrayList<>();
		collTest1.add(5);
		collTest1.add(6);
		collTest1.add(7);
		collTest1.add(8);
		
		//Add all duplicate list. Size should still be 4
		testAddA1.addAll(collTest1);
		assertEquals(8, testAddA1.size());
		
		
	}

}
