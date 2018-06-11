/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /*
        Sample one, but get many errors when I wrote it. The main idea is loop through the listNode and find the one with the val and 
        use node.next = node.next.next to remove it. First, I forgot to consider the situation that the head is null. 
        And because there is only next method for a node, which means I need use node.next instead of node as the loop element, 
        I forgot to take care the situation that the head's value.
        很简单的一道题，但是我犯了很多错误。主要的原则就是找到和这个val值一样的node，然后用node.next = node.next.next删掉它。我错的点在，第一，忘记了
        head为null的情况。第二，因为要使用node.next = node.next.next，所以要判断的元素是cur.next而不是cur。所以当循环结束的时候，我忘记判断head的值了。
        这是第二个错误。

        */
        ListNode cur = head;
        if (cur == null) {
            return null;
        }

        while(cur.next != null){
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else{
            cur = cur.next;
            }
        }
        if (head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}