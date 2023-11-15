package com.algorithums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/AlgoAssignment")
public class AssignmentController {

	@GetMapping(path = "/isPrime/{value}")
	public int isPrime(@PathVariable int value) {
		int n = 0, count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		if (count == 2)
			return 1;
		else {
			return 2;
		}
	}

	@GetMapping(path = "/isPalindrome/{number}")
	public String isPalindrome(@PathVariable int number) {
		int temp = number;
		int rem = 0;
		int rev = 0;
		while (temp != 0) {
			rem = temp % 10;
			rev = rem * 10 + rem;
			temp = temp / 10;
		}
		if (rev == number)
			return "yes";
		else {
			return "no";
		}

	}

	@GetMapping(path = "/ispalindrom/{String}")
	public int isPalindrome(@PathVariable String value) {
		StringBuilder sb = new StringBuilder(value);
		sb.reverse();
		String rev = sb.toString();
		if (rev.equals(value))
			return 1;
		else
			return 0;

	}

	@GetMapping(path = "/factorial/{number}")
	public int factorial(@PathVariable int number) {
		int fact = 1;
		for (int i = 0; i <= number; i++) {
			fact = fact * 1;
		}
		return fact;

	}

	@GetMapping(path = "/NthFibonacci/{number}")
	public int getnthfibonccinumber(@PathVariable int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 0; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return a;

	}

	@GetMapping(path = "/fibonacci/{number}")
	public int getfiboncciseries(@PathVariable int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 0; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;

	}

	@GetMapping(path = "/finddiff/{amount}")
	public int findDiff(@PathVariable int amount) {
		// Convert the amount to a char array to iterate over digits
		char[] digits = String.valueOf(amount).toCharArray();

		// Find the maximum difference by replacing some 6s with 9s
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == '6') {
				digits[i] = '9';
				// Replace the leftmost 6 with 9 and break the loop
			}
		}

		// Convert the char array back to an integer and return the difference
		int result = Integer.parseInt(new String(digits)) - amount;
		return result;
	}

	@PostMapping("/thirdLargest")
	public int thirdLargest(@RequestBody int[] arr) {
		int temp;
		int size = arr.length;
		if (size < 3) {
			return -1;
		}
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr[size - 3];
	}

	@GetMapping("/minAnd2ndMin")
	public String minAnd2ndMinElement(@RequestParam("arrList") TreeSet<Integer> set) {
		Map<String, Integer> smallestEle = new HashMap<>();

		List<Integer> arr = new ArrayList<>(set);
		smallestEle.put("smallest", arr.get(0));
		smallestEle.put("secondSmallest", arr.get(1));
		return "smallest and secondSmallest element is " + smallestEle;
	}

	@GetMapping("/immediateSmaller") // {4, 2, 1, 5, 3}
	public ArrayList<Integer> immediateSmaller(@RequestParam Integer n,
			@RequestParam("arrList") ArrayList<Integer> arr) {
		ArrayList<Integer> updatedList = new ArrayList<>(n);
		int j = 0;
		for (int i = 0; i < n; i++) {
			j = i + 1;
			if (arr.get(j) < arr.get(i)) {
				updatedList.add(arr.get(j));
			} else {
				updatedList.add(-1);
			}
		}
		updatedList.add(-1);
		return updatedList;
	}

	@GetMapping("/anagram")
	public String remAnagram(@RequestParam String p1, @RequestParam String p2) {
		char[] ch = p2.toCharArray();
		StringBuilder sb = new StringBuilder(p1);
		for (int i = 0; i < ch.length; i++) {
			int index = p1.indexOf(ch[i]); // find the index of s2 string char in s1
			if (index != -1) // if value found
			{
				sb = sb.deleteCharAt(index);
			}
		}
		String result = sb.toString();
		return result;

	}

	@GetMapping("/zigZag")
	public ArrayList<Integer> zigZag(@RequestParam("arrList") ArrayList<Integer> arr) {
		int k = 0, j = 0;
		for (int i = 0; i < arr.size() - 2; i++) {
			i = k;
			j = i + 1;
			k = j + 1;

			if (!(arr.get(i) < arr.get(j))) {
				Collections.swap(arr, i, j);
			}

			if (!(arr.get(j) > arr.get(k))) {
				Collections.swap(arr, j, k);
			}

		}

		return arr;

	}

	@GetMapping("/getPrimeNoList")
	public ArrayList<Integer> sieveOfEratosthenes(@RequestParam Integer num) {
		int count;

		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			count = 0;
			for (int j = 1; j <= num; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				primeList.add(i);
			}
		}

		return primeList;
	}

	@GetMapping("/subsequence")
	public boolean isSubsequence(@RequestParam String A1, @RequestParam String A2) {
		char charArray[] = A2.toCharArray();
		StringBuilder subSeqString = new StringBuilder(A2);
		for (int i = 0; i < charArray.length; i++) {
			// check char from s2 is present in s1
			int index = A1.indexOf(charArray[i]);
			// if not present then remove that char from s2
			if (index == -1) {
				subSeqString = subSeqString.deleteCharAt(A2.indexOf(charArray[i]));
				A2 = subSeqString.toString();

			}
		}
		if (A1.equals(A2)) {

			return true;
		} else {

			return false;
		}
	}

	@GetMapping("/mergetwoString")
	public String mergeString(@RequestParam String s1, @RequestParam String s2) {
		int maxLen = Math.max(s1.length(), s2.length());
		StringBuilder mergeString = new StringBuilder();
		for (int i = 0; i < maxLen; i++) {
			if (i < s1.length()) {
				mergeString = mergeString.append(s1.charAt(i));
			}

			if (i < s2.length()) {
				mergeString = mergeString.append(s2.charAt(i));
			}

		}

		return mergeString.toString();
	}

	@GetMapping("/isFrequencyUnique")
	public boolean isFrequencyUnique(@RequestParam("arrList") ArrayList<Integer> arr) {
		//// arr =[1, 1, 2, 5, 5
		int count = 0;
		TreeSet<Integer> set = new TreeSet<>(arr); // after adding to set arr =1,2,5
		ArrayList<Integer> newList = new ArrayList<>();
		newList.addAll(set);
		set.clear();
		for (int i = 0; i < newList.size(); i++) {

			for (int j = 0; j < arr.size(); j++) {
				if (newList.get(i) == arr.get(j)) {
					count++;
				}
			}
			set.add(count); // added frequency in set so that only unique freq will add
			count = 0;
		}

		if (newList.size() == set.size()) {
			return true;
		} else {
			return false;
		}

	}

	@GetMapping("/MissingNumber")
	public Integer MissingNumber(@RequestParam Integer n, @RequestParam("arrList") ArrayList<Integer> arr) {
		int missingNumber = -1;

		for (int i = 1; i <= n; i++) {

			if (!arr.contains(i)) {
				missingNumber = i;

			}
		}
		return missingNumber;

	}
	
	@GetMapping("/kthSmallest")
	public Integer kthSmallestElement(@RequestParam Integer k,@RequestParam("arrList") TreeSet<Integer> set)
	{
			List<Integer> arr = new ArrayList<>(set);
			return arr.get(k-1);
	}
	
	@GetMapping("/secondLargest")
	public Integer printSecondlargest(@RequestParam("arrList") TreeSet<Integer> set) {
		  List<Integer> arr = new ArrayList<>(set.descendingSet());
		  int  secondLargestElement=arr.get(1); // first element at 0th index
			return secondLargestElement;
	}
	
	@PostMapping("/calculate_Area")
	public int calculate_Area(@RequestBody ArrayList<ArrayList<Integer>> arrayInput) {
		ArrayList<Integer> arr = new ArrayList<>();
		int temp = 1;
		for (int i = 0; i < arrayInput.size(); i++) {
			arr = arrayInput.get(i);
			int result = arr.stream().reduce(1, (a, b) -> a * b).intValue();
			if (result > temp) {
				temp = result;
			}

		}
		return temp;
	}
	
	@GetMapping("/getPairsCount")
	public Integer getPairsCount(@RequestParam Integer n,@RequestParam Integer k, @RequestParam("arrList") ArrayList<Integer> arr)
	{
		int count=0;
		for (int i = 0; i <n; i++)
		{
			for (int j = i+1; j <n; j++)
			{
			if (arr.get(i)+arr.get(j)==k) 
			{			
				count++;
			}
			}
		}
		return count;

	}
	

}
