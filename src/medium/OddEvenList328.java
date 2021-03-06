package medium;

import easy.ListNode;

public class OddEvenList328 {

	public ListNode oddEvenList(ListNode head) {
		 if (head != null) {
			    
		        ListNode odd = head, even = head.next, evenHead = even; 
		    
		        while (even != null && even.next != null) {
		            odd.next = odd.next.next; 
		            odd = odd.next;
		            even.next = even.next.next; //even.next！=null
		            even = even.next;
		        }
		        odd.next = evenHead; 
		  }
		  return head;
		
    }
}
