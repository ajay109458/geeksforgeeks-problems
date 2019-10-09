package temp;

import utils.LLNode;

public class LinkedListHelper {

	public static LLNode reverseLinkedList(LLNode head) {
		
		LLNode prev  = null;
		
		LLNode  curr = head;
		
		while (curr != null) {
			
			LLNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		return prev;
	}
	
	public static LLNode segregateEvenOdd(LLNode head) {
		
		 LLNode p = head;
		 
		 LLNode evenHead = null;
		 LLNode oddHead = null;
		 
		 while(p != null) {
			 
			 int val = p.data;
			 
			 LLNode temp = p;
			 p = p.next;
			 temp.next = null;
			 
			 if ( val % 2 == 0) {
					 
				 if (evenHead != null) {
					 temp.next = evenHead;
				 }
				 evenHead = temp;
				 
			 } else {
				 if (oddHead != null) {
					 temp.next = oddHead;
				 }
				 
				 oddHead = temp;
			 }
		 }
		 
		 if (evenHead == null)
			 return oddHead;
		
		 p = evenHead;
		 
		 while(p.next != null) {
			 p = p.next;
		 }
		 
		 p.next = oddHead;
		 
		 return evenHead;
	}
	
	public static LLNode getIntersectionPoint(LLNode head1, LLNode head2) {
		
		int len1 = getLength(head1);
		int len2 = getLength(head2);
		
		int diff = len1 - len2;
		
		LLNode p = head1;
		LLNode q = head2;
		
		int moveCount = Math.abs(diff);
		if (diff > 0) {
			while(moveCount-- > 0) {
				p = p.next;
			}
		} else {
			while(moveCount-- > 0) {
				q = q.next;
			}
		}
		
		while(p != null && q != null) {
			
			if (p == q) {
				return p;
			}
			
			p = p.next;
			q = q.next;
		}
		
		return null;
	}
	
	public static int getLength(LLNode head) {
		
		LLNode p = head;
		
		int len = 0;
		
		while (p != null) {
			p = p.next;
			len++;
		}
			
		return len;
		
	}
	
}
