/*
Given an array A of integers, 
find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Problem Link -> https://www.interviewbit.com/problems/equal/

*/

import java.util.Scanner;
import java.util.*;

public class SumOfArrayIntegers{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3); list.add(4); list.add(7); list.add(1);
		list.add(2); list.add(9); list.add(8);
		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = 
			getMap(list);
		printMap(map);
		ArrayList<Integer> l = getList(map);
		printList(l);
	}

	// Find the two lists whose sum is the same and is lexicographically smallest
	public static ArrayList<Integer> getList(HashMap<Integer, ArrayList<ArrayList<Integer>>> map){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
		int min3 = Integer.MAX_VALUE; int min4 = Integer.MAX_VALUE;
		for(Integer key : map.keySet()){
			if(map.get(key).size() > 1){
				// atleast two lists 
				int firstIndex = map.get(key).get(0).get(0);
				int secondIndex = map.get(key).get(0).get(1);
				int thirdIndex = -1;
				int fourthIndex = -1;
				for(int i=1; i<map.get(key).size(); i++){
					// a < b & c < d and a < c properties are already satisfied
					if(secondIndex != map.get(key).get(i).get(0) 
						&& secondIndex != map.get(key).get(i).get(1)){
						thirdIndex = map.get(key).get(i).get(0);
						fourthIndex = map.get(key).get(i).get(1);
						break;
					}
				}
				if(thirdIndex != -1 && fourthIndex != -1){
					// finds the lexicographically smallest list
					if(firstIndex < min1){
						min1 = firstIndex;
						min2 = secondIndex; 
						min3 = thirdIndex;
						min4 = fourthIndex;
					}
					else if (firstIndex <= min1 && secondIndex < min2){
						min2 = secondIndex;
						min3 = thirdIndex;
						min4 = fourthIndex;
					}
					else if (firstIndex <= min1 && secondIndex <= min2 &&
						thirdIndex < min3){
						min3 = thirdIndex;
						min4 = fourthIndex;
					}
					else if (firstIndex <= min1 && secondIndex <= min2 &&
						thirdIndex <= min3 && fourthIndex < min4){
						min4 = fourthIndex;
					}
				}
			}
		}
		if(min1 == Integer.MAX_VALUE && min2 == Integer.MAX_VALUE &&
			min3 == Integer.MAX_VALUE && min4 == Integer.MAX_VALUE)
			return list;
		list.add(min1); list.add(min2); list.add(min3); list.add(min4);
		return list;
	}

	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> getMap(ArrayList<Integer> list){
		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = 
			new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		for(int i=0; i<list.size()-1; i++){
			for(int j=i+1; j<list.size(); j++){
				int sum = list.get(i) + list.get(j);
				ArrayList<Integer> currentList = new ArrayList<Integer>();
				currentList.add(i); currentList.add(j);
				if(!map.containsKey(sum)){
					ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
					l.add(currentList);
					map.put(sum, l);
				}
				else{
					ArrayList<ArrayList<Integer>> l = map.get(sum);
					l.add(currentList);
					map.put(sum, l);
				}
			}
		}
		return map;
	}

	// method to print the contents of the list
	public static void printList(ArrayList<Integer> list){
		for(int l : list)
			System.out.print(l + " ");
		System.out.println();
	}

	// method to print the contents of the map
	public static void printMap(HashMap<Integer, ArrayList<ArrayList<Integer>>> map){
		for(Integer key : map.keySet()){
			System.out.println("Key : " + key);
			System.out.println("Value : " + map.get(key));
		}
	}
}