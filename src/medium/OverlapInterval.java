package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlapInterval {

  /*Given two lists of intervals, find their overlapping intervals, e.g.
    l1: [1,5], [7,10], [12,18], [22,24]
    l2: [3,8], [13,15], [16,17], [18,21], [22,23]
    returns [3,5],[7,8],[13,15],[16,17],[18,18],[22,23] */
	
	public static List<Interval> overlapInterval(Interval[] l1, Interval[] l2){
		if(l1 == null || l2 == null || l1.length == 0 || l2.length == 0){
			return null;
		}
		
	/*	Arrays.sort(l1, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});
		
		Arrays.sort(l2, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});*/
		
		List<Interval> list = new ArrayList<Interval>();
		
		int i = 0, j = 0;
				
		while(i < l1.length && j < l2.length){
			while(l1[i].start > l2[j].end){
				j++;
			}
			while(l1[i].end < l2[j].start){
				i++;
			}
			if(l1[i].start <= l2[j].start && l1[i].end <= l2[j].end){
				list.add(new Interval(l2[j].start, l1[i].end));
				i++;
			}else if(l1[i].start <= l2[j].start && l1[i].end > l2[j].end){
				list.add(new Interval(l2[j].start, l2[j].end));
				j++;
			}else if(l1[i].start > l2[j].start && l1[i].end > l2[j].end){
				list.add(new Interval(l1[i].start, l2[j].end));
				j++;
			}else if(l1[i].start > l2[j].start && l1[i].end <= l2[j].end){
				list.add(new Interval(l1[i].start, l1[i].end));
				i++;
			}
		}
		
		return list;
	}
	
	public static void main(String args[]){
		Interval[] l1 = {new Interval(1,5), new Interval(7,10),new Interval(12,18)};
		Interval[] l2 = {new Interval(3,8), new Interval(13,15)};
		System.out.println(overlapInterval(l1,l2).toString());
	}
}
