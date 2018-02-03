package com.american.express.demo;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class NumberMultipleProblem {
	
	public static void main(String[] args) {
		NumberMultipleProblem problem = new NumberMultipleProblem();
		problem.fizzbuzz();
		problem.printUniqsDupsInList();
		problem.countChars();
		problem.processNumbers();
	}
	
	public void fizzbuzz () {
		System.out.println("MultipleProblem");
		System.out.println("--------------------");
		IntStream.iterate(1, i -> i + 1).limit(100)
		  .forEach(num -> { if(num%3 == 0 && num % 5 == 0)
			                  System.out.println("FB");
		  					else if(num%3 == 0)
		  					   System.out.println("F");
		  					else if(num%5 == 0)
			  					   System.out.println("B");
		  					else 
			  					   System.out.println(num);
		              }
				);
	}
	
	public void printUniqsDupsInList() {
		
		System.out.println("Uniqs and Dups InList");
		System.out.println("-----------------------");
		
		// Requirement: Create a list - myList with Strings in this order - 
		// "alpha", "omega", "beta", "theta", "alpha", "delta", "omega"
		
		List<String> myList = new ArrayList<>();
		myList.add("alpha");
		myList.add("omega");
		myList.add("beta");
		myList.add("theta");
		myList.add("alpha");
		myList.add("delta");
		myList.add("omega");
		
		
		Set<String> myHashSet = new HashSet<>(myList);

		// Print unique elements in myList
		System.out.println("unique elements in myList " + myHashSet );
		
		// Print duplicate elements in myList
		List<String> duplicateList = new ArrayList<>();
	    myList.stream()
		      .collect(groupingBy(map -> map.toString()))
	          .forEach((key,value) -> { if(value.size() > 1) 
	        	                          duplicateList.add(key);
	                                   });
        System.out.println("duplicate elements in myList " + duplicateList);
		
		
		
		// Print the middle element in myList
		System.out.println("the middle element in myList is " + myList.get(Math.round(myList.size()/2)));
	  }
	
	
	
	public void countChars() {
		
		
	  // Requirement: Initialize a String - myString = "Bookkeeper"
		String string = new String("Bookkeeper");
		
	  // Find number of occurrences of characters in myString
	  List<String> myList = new ArrayList<>(Arrays.asList(string.split("")));
	  
	  // Print characters and their number of occurrences
	  System.out.println("");
	  System.out.println("characters and their number of occurrences");
	  System.out.println("-------------------------------------------");
	  myList.stream().collect(groupingBy(map -> map.toString()))
			         .forEach((o1,o2) -> System.out.println(o1+"-"+o2.size()));
	}
	
	public void processNumbers() {
		Map<Integer,Integer> myList = new HashMap<>();
	//  Requirements: Generate 100 random numbers between 1-1000.
	//  Put the numbers into a Map.  Then move them to a Set.
		
		IntStream.iterate(1, i -> i + 1)
		         .limit(100)
		         .forEach(num -> myList.put(num,(int)Math.round((Math.random()*1000))));
		
	//  Then move the numbers into a List.  Then sort the numbers.
		List<Integer> myArrList = new ArrayList<>(myList.values());
        Collections.sort(myArrList);
      
	//  Finally output the numbers, with one number on every row
        System.out.println("Finally output the numbers, with one number on every row");
        System.out.println("-----------------------------------------------");
		myArrList.forEach(num -> System.out.println(num));
		
	}
	
	
}
