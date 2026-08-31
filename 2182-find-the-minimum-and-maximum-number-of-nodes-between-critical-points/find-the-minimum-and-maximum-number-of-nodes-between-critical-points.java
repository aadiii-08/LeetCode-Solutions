/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) return new int[]{-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode last = head.next.next;

        int first = -1;
        int previous = -1;
        int min = Integer.MAX_VALUE;
        int max = -1;
        int i = 2;

        while(last != null){
            if((prev.val < curr.val && curr.val > last.val) ||
               (prev.val > curr.val && curr.val < last.val)){
                if(first == -1){
                    first = i;
                    previous = i;
                }else{
                    min = Math.min(min , i - previous);
                    max =  i - first;
                    previous = i;
                }
            }
            i++;
            prev = curr;
            curr = last;
            last = last.next;
        }

        if(previous == first) return new int[]{-1, -1};

        return new int[]{min, max};
    }
}