package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253{

	public static int minMeetingRooms(Interval[] intervals){
		
		if(intervals == null || intervals.length ==0) return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});
		
	    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.end - b.end; }
	    });
	    
	    heap.offer(intervals[0]);
		
		for (int i = 1; i < intervals.length; i++) {
	        // get the meeting room that finishes earliest
	        Interval interval = heap.poll();
	        System.out.println("heap poll interval:" + interval.start +","+interval.end);
	        
	        if (intervals[i].start >= interval.end) {
	            // if the current meeting starts right after 
	            // there's no need for a new room, merge the interval
	        	System.out.println("intervals["+i+"].start:"+intervals[i].start+" >= interval.end:" + interval.end);
	            interval.end = intervals[i].end;
	            
	        } else {
	            // otherwise, this meeting needs a new room
	            heap.offer(intervals[i]);
	            System.out.println("heap offer intervals["+i+"]:" + intervals[i].start+","+intervals[i].end);
	        }
	        
	        // don't forget to put the meeting room back
	        heap.offer(interval);
	        System.out.println("heap offer interval:" + interval.start +","+interval.end);
	        System.out.println();
		}
		
		return heap.size();
	}
	
	public static void main(String args[]){
		Interval[] interval = {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
		int min = minMeetingRooms(interval);
		System.out.println(min);
	}
}

