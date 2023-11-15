package com.algoritum.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import com.algorithums.AssignmentController;

@SpringBootTest
public class algoapplicationcontroller {
	
	@InjectMocks
	private AssignmentController assignmentcontroller;
	
	
	@Test
	public void isPrime() {
		int a=assignmentcontroller.isPrime(5);
		assertEquals(1,a);
	}
	
	@Test
	public void isNotPrime() {
		int a=assignmentcontroller.isPrime(2);
		assertEquals(0,a);
	}

	@Test
	public void isPalindrome() {
		int a=assignmentcontroller.isPalindrome("mam");
		assertEquals(1,a);
	}
	
	@Test
	public void isNotPalindrome() {
		int a=assignmentcontroller.isPalindrome("mamq");
		assertEquals(0,a);
	}
	
	@Test
	public void isPalindromeforint() {
		String a=assignmentcontroller.isPalindrome(121);
		assertEquals(1,a);
	}
	
	@Test
	public void isNotPalindromeint() {
		String a=assignmentcontroller.isPalindrome(1233);
		assertEquals(0,a);
	}
	
	@Test
	public void factorial() {
		int a=assignmentcontroller.factorial(5);
		assertEquals(120,a);
	}
	
	@Test
	public void getnthfibonccinumber() {
		int no=assignmentcontroller.getnthfibonccinumber(6);
		assertEquals(5, no);
	}
	
	@Test
	public void getfiboncciseries() {
		assignmentcontroller.getfiboncciseries(5);
	}
	
	@Test
	public void findDiff() {
		assignmentcontroller.findDiff(27);
	}
	
	@Test
	public void thirdLargest() {
		int[] arr = { 1, 2, 3, 4 };
		int r=assignmentcontroller.thirdLargest(arr);
		assertNotNull(r);
		
	}
	
	@Test
	public void minAnd2ndMinElement() {
		TreeSet<Integer> arrList = new TreeSet<>();
		arrList.add(12);
		arrList.add(2);
		arrList.add(2);
		arrList.add(3);
		arrList.add(1);
		String A=assignmentcontroller.minAnd2ndMinElement(arrList);
		assertNotNull(A);
	}
	
	@Test
	public void immediateSmallerTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(-1,2,-1,1,-1,-1));
		ArrayList<Integer> res=assignmentcontroller.immediateSmaller(5,arr);
		assertEquals(exp, res);
	}
	
	
	@Test
	public void print2largestTest()
	{
		TreeSet<Integer> arr=new TreeSet<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		Integer res=assignmentcontroller.printSecondlargest(arr);
		assertEquals(6, res);
	}
	
	@Test
	public void remAnagramTest()
	{
		String res=assignmentcontroller.remAnagram("cddgk","gcd");
		assertEquals(2, res);
	}
	
	@Test
	public void zigZagTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(2,4,5,1,7,6,8));
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(2, 5, 1, 7, 4, 8, 6));
		ArrayList<Integer> res=assignmentcontroller.zigZag(arr);
		assertEquals(exp, res);
	}
	
	@Test
	public void sieveOfEratosthenesTest()
	{
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(2,3,5,7));
		ArrayList<Integer> res=assignmentcontroller.sieveOfEratosthenes(10);
		assertEquals(exp, res);
	}
	
	@Test
	public void isSubsequenceTest()
	{
		boolean res=assignmentcontroller.isSubsequence("AXY", "ADXCPY");
		assertEquals(true, res);
	}
	
	@Test
	public void mergeString() {
		String s1="abc";
		String s2="pqrst";
		String A=assignmentcontroller.mergeString(s1, s2);
		assertNotNull(A);
	}
	
	@Test
	public void MissingNumber() {
		Integer n=3;
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,5));
		int a=assignmentcontroller.MissingNumber(n, arr);
		assertNotNull(a);
	}
	
	@Test
	public void kthSmallestElement() {
		TreeSet<Integer> set=new TreeSet<>(Arrays.asList(5,2,3,15));
		int a=assignmentcontroller.kthSmallestElement(4, set);
		assertNotNull(a);
	}
	
	@Test
	public void calculate_Area() {
		ArrayList<Integer> arrList1 = new ArrayList<>();
		arrList1.add(1);
		arrList1.add(2);
		ArrayList<Integer> arrList2 = new ArrayList<>();
		arrList2.add(5);
		arrList2.add(6);
		ArrayList<Integer> arrList3 = new ArrayList<>();
		arrList3.add(8);
		arrList3.add(9);
		ArrayList<ArrayList<Integer>> arrayInput = new ArrayList<>();
		arrayInput.add(arrList3);
		arrayInput.add(arrList2);
		arrayInput.add(arrList1);
		assertEquals(72, assignmentcontroller.calculate_Area(arrayInput));
	}
}
