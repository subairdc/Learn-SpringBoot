package com.subairdc.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.subiardc.junit.MyMath;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_ThreeMemberArray() {
		
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
		//Absence of failure is success
		//Test condition or assert
	}
	
	@Test
	void calculateSum_ZeroLengthArray() {
		
		assertEquals(0, math.calculateSum(new int[] {}));
		//Absence of failure is success
		//Test condition or assert
	}
	
//	@Test
//	void test() {
//		
//		int[] numbers = {1,2,3,};
//		int result = math.calculateSum(numbers);
//		
//		System.out.println(result);
//		
//		int expectedResult = 0;
//		assertEquals(expectedResult, result);
//		//Absence of failure is success
//		//Test condition or assert
//	}


}
