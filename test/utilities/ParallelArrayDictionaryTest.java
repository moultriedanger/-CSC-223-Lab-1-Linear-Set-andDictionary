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
		ParallelArrayDictionary <Integer,Integer> testParallel = new ParallelArrayDictionary<Integer,Integer>();
		assertEquals(0, testParallel.size());
	}

	@Test
	void testGet()
	{
		ParallelArrayDictionary <Integer,Integer> remDict = new ParallelArrayDictionary<Integer,Integer>();
		remDict.put(1, 3);
		remDict.put(2, 6);
		remDict.put(3, 9);
		
		assertEquals(remDict.get(1), (Object) 3);
	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary <Integer,Integer> putTest = new ParallelArrayDictionary<Integer,Integer>();
		putTest.put(1, 3);
		putTest.put(2, 6);
		putTest.put(3, 9);
		assertEquals(3,putTest.size());
		
		
	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary <Integer,Integer> remDict = new ParallelArrayDictionary<Integer,Integer>();
		remDict.put(1, 3);
		remDict.put(2, 6);
		remDict.put(3, 9);
		
		remDict.remove(2);
		assertEquals(2,remDict.size());
		assertFalse(remDict.containsKey(2));
	}

	@Test
	void testPutAll()
	{
		ParallelArrayDictionary <Integer,Integer> putTest = new ParallelArrayDictionary<Integer,Integer>(); 
		
		Map <Integer,Integer> testMap = new HashMap<Integer,Integer>();
		testMap.put(1, 3);
		testMap.put(2, 6);
		testMap.put(3, 9);
		
		putTest.putAll(testMap);
		
		
		assertEquals(3,putTest.size());
	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary <Integer,Integer> testDict = new ParallelArrayDictionary<Integer,Integer>();
		
		testDict.put(1, 3);
		testDict.put(2, 6);
		testDict.put(3, 9);
		
		assertFalse(testDict.isEmpty());
		
		testDict.clear();
		
		assertTrue(testDict.isEmpty());
		
		//Create an empty dicitonary and then clear it
		ParallelArrayDictionary <Integer,Integer> testDict1 = new ParallelArrayDictionary<Integer,Integer>();
		assertEquals(0,testDict1.size());
		testDict1.clear();
		assertEquals(0,testDict1.size());
		
		
	}
}
