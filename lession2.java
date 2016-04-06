/**
	 * You are given two linked lists representing two non-negative numbers. 
	 *   The digits are stored in reverse order and each of their nodes contain a single digit.
	 *   Add the two numbers and return it as a linked list.
	 * Definition for singly-linked list. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 *
	 * public class ListNode { int val; ListNode next; ListNode(int x) { val =
	 * x; } }
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		ListNode tmp = pre;
		int cnt = 0;
		int sum;
		ListNode cur;
		while(l1 !=null || l2 != null || cnt !=0 ){
			cur = new ListNode(0);
			sum = (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val) + cnt;
			cur.val = sum % 10;
			cnt = sum / 10;
			pre.next = cur;
			pre = cur;
			
			l1 = (l1 == null) ? l1: l1.next;
			l2 = (l2 == null) ? l2: l2.next;
		}
		return tmp.next;
    }

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}