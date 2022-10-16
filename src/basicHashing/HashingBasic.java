package basicHashing;

import java.util.*;

public class HashingBasic {
	
	
	public Map<Integer,Integer> countFrequency(int[] arr) {
		
		// Learn HashMap from java collection to understand it.
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if( hmap.get(arr[i]) != null && hmap.get(arr[i]) > 0) {
				int value = hmap.get(arr[i]);
				hmap.put(arr[i], value+1);
			}else {
				hmap.put(arr[i], 1);
			}
		}
		
		System.out.println(hmap);
		
		return hmap;
	}
	
	public void highestAndLowestFrequency(int[] arr) {
		Map<Integer,Integer> frequencyMap = this.countFrequency(arr);
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(Map.Entry<Integer, Integer> h: frequencyMap.entrySet()) {
			int value = h.getValue();
			
			if(value > max) {
				max = value;
			}
			if(value < min) {
				min = value;
			}
		}
		
		//System.out.println(min+"  "+max);
		
		
		for(Map.Entry<Integer, Integer> h: frequencyMap.entrySet()) {
			if(h.getValue() == max) {
				System.out.println("Most repeated key: "+ h.getKey());
			}
			
			if(h.getValue() == min) {
				System.out.println("Less repeated Key: "+ h.getKey());
			}
		}
	}
}
