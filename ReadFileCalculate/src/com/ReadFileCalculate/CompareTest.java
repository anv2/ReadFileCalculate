package com.ReadFileCalculate;

import java.util.*;

public class CompareTest {
	
	//method to sort HashMap
	//@param map to be sorted and limit of salary
	//@return sorted map
	 public static Map<String, Integer> sortByValue(Map<String, Integer> map, int L) {
		    
		 	LinkedList l = new LinkedList(map.entrySet());
		    Collections.sort(l, new Comparator() {

		      @Override
		      public int compare(Object o2, Object o1) {
		        return ((Comparable) ((Map.Entry) (o2)).getValue())
		            .compareTo(((Map.Entry) (o1)).getValue());
		      }
		    });

		    Map r = new LinkedHashMap();
		    for (Iterator it = l.iterator(); it.hasNext();) {
		      Map.Entry entry = (Map.Entry) it.next();
		      r.put(entry.getKey(), entry.getValue());
		      
		    }
		    return r;
	 }
	 
}