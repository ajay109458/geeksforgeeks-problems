package temp;

import utils.LLNode;

public class LinkedListHelper {

	public static LLNode reverseLinkedList(LLNode head) {

		LLNode prev = null;

		LLNode curr = head;

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

		while (p != null) {

			int val = p.data;

			LLNode temp = p;
			p = p.next;
			temp.next = null;

			if (val % 2 == 0) {

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

		while (p.next != null) {
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
			while (moveCount-- > 0) {
				p = p.next;
			}
		} else {
			while (moveCount-- > 0) {
				q = q.next;
			}
		}

		while (p != null && q != null) {

			if (p == q) {
				return p;
			}

			p = p.next;
			q = q.next;
		}

		return null;
	}

	public static LLNode moveLastElementInFront(LLNode head) {

		if (head == null || head.next == null)
			return head;

		LLNode p = head;

		while (p != null && p.next != null && p.next.next != null) {
			p = p.next;
		}

		LLNode temp = p.next;
		p.next = null;
		temp.next = head;
		head = temp;

		return head;

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

	public static LLNode pairWiseSwap(LLNode head) {

		if (head == null || head.next == null)
			return head;

		LLNode temp = head.next;
		head.next = temp.next;
		temp.next = head;
		head = temp;

		head.next.next = pairWiseSwap(head.next.next);

		return head;

	}

	public static void printReverseRecursive(LLNode head) {

		if (head == null)
			return;

		printReverseRecursive(head.next);
		System.out.print(head.data + " ");
	}

	public static LLNode mergeTwoSortedListInReverse(LLNode head1, LLNode head2) {

		LLNode result = null;
		
		while (head1 != null && head2 != null) {
			LLNode temp = null;
			if (head1.data < head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}
			
			temp.next = null;
			
			if (result == null) {
				result = temp;
			} else {
				temp.next = result;
				result = temp;
			}
			
		}
		
		return result;

	}
	
	public static LLNode reverseListInGroupK(LLNode head, int k) {
		
		LLNode current = head;
		LLNode prev = null;
		LLNode next;
		
		for (int i = 0; i < k; i++) {
			
			if (current == null)
				break;
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		if (current != null) {
			head.next = reverseListInGroupK(current, k);
		}
		
		return prev;
		
	}
	

}
