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
    public ListNode removeElements(ListNode head, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=val) ans.add(list.get(i));
        }
        ListNode h = new ListNode(0);
        temp = h;
        for(int i=0;i<ans.size();i++){
            ListNode t = new ListNode(ans.get(i));
            temp.next = t;
            temp = t;
        }
        return h.next;
    }
}