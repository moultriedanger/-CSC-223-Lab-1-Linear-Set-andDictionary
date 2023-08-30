/**
* A class that tests ParallelArrayDictionary using a number of test methods
*
*
* @author <Moultrie Dangerfield, Flynn Nisbet, Mengsrun Nit>
* @date <08/30/23>
*/
package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	
	@Test
	void testParallelArrayDictionary()
	{
		//Tests creation of PAD
		ParallelArrayDictionary <Integer,Integer> testParallel = new ParallelArrayDictionary<Integer,Integer>();
		assertEquals(0, testParallel.size());
	}

	@Test
	void testGet()
	{
		//Populates PAD
		ParallelArrayDictionary <Integer,Integer> remDict = new ParallelArrayDictionary<Integer,Integer>();
		remDict.put(1, 3);
		remDict.put(2, 6);
		remDict.put(3, 9);
		//-------Test------
		assertEquals(remDict.get(1), (Object) 3);
		assertEquals(3,remDict.size());
		assertEquals(remDict.get(2), (Object) 6);
	}

	@Test
	void testPut()
	{
		//Tests ability to populate PAD, checks size
		ParallelArrayDictionary <Integer,Integer> putTest = new ParallelArrayDictionary<Integer,Integer>();
		putTest.put(1, 3);
		putTest.put(2, 6);
		putTest.put(3, 9);
		assertEquals(3,putTest.size());
		putTest.put(1, 5);
		assertEquals(3,putTest.size());
		//Test to see if the value updated
		assertTrue(putTest.containsValue(5));
		assertEquals(3,putTest.size());
	}
	

	@Test
	void testRemove()
	{
		ParallelArrayDictionary <Integer,Integer> remDict = new ParallelArrayDictionary<Integer,Integer>();
		remDict.put(1, 3);
		remDict.put(2, 6);
		remDict.put(3, 9);
		//Removes, then checks size and if the PAD contains the key
		remDict.remove(2);
		assertEquals(2,remDict.size());
		assertFalse(remDict.containsKey(2));
	}

	@Test
	void testPutAll()
	{
		ParallelArrayDictionary <Integer,Integer> putAllDict = new ParallelArrayDictionary<Integer,Integer>(); 
		
		Map <Integer,Integer> testMap = new HashMap<Integer,Integer>();
		testMap.put(1, 3);
		testMap.put(2, 6);
		testMap.put(3, 9);
		
		putAllDict.putAll(testMap);
		//-------Test1------
		assertEquals(3,putAllDict.size());
		Map <Integer,Integer> testMap2 = new HashMap<Integer,Integer>();
		testMap2.put(1, 8);
		testMap2.put(2, 11);
		testMap2.put(3, 52);
		putAllDict.putAll(testMap);
		
		//-------Test2------
		assertEquals(3,putAllDict.size());
		assertTrue(putAllDict.containsValue(9));
	}

	@Test
	void testClear()
	{
	
		//Creates and populates, clears, and checks size before and after
		ParallelArrayDictionary <Integer,Integer> testDict = new ParallelArrayDictionary<Integer,Integer>();
		
		testDict.put(1, 3);
		testDict.put(2, 6);
		testDict.put(3, 9);
		
		assertFalse(testDict.isEmpty());
		
		testDict.clear();
		
		assertTrue(testDict.isEmpty());
		
		//Create an empty dictionary and then clear it
		ParallelArrayDictionary <Integer,Integer> testDict1 = new ParallelArrayDictionary<Integer,Integer>();
		assertEquals(0,testDict1.size());
		testDict1.clear();
		assertEquals(0,testDict1.size());
	}
}
