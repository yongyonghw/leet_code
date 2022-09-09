public class AddTwoNumbers_2 {

    static ListNode makeListNode(int[] arr) {
        ListNode listNode = new ListNode();
        ListNode head = null;
        for(int i = 0 ; i < arr.length; i ++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
            listNode.val = arr[i];
            if(i == 0) {
                head = listNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = makeListNode(new int[]{9,9});
        ListNode l2 = makeListNode(new int[]{9});

        addTwoNumbers(l1, l2);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = null;
        int carry = 0;

        // 두 값이 모두 null 이 아닐때까지 진행한다.
        int i = 0;
        while(l1 != null || l2 != null) {
            l3.next = new ListNode();
            l3 = l3.next;
            if(i == 0) {
                head = l3;
            }
            if(l1 != null && l2 != null) {
                int tempValue = carry + l1.val + l2.val;
                carry = (tempValue) / 10;
                l3.val = tempValue % 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null) {
                int tempValue = (l1.val + carry);
                carry = (tempValue) / 10;
                l3.val = tempValue % 10;
                l1 = l1.next;
            } else {
                int tempValue = (l2.val + carry);
                carry = (tempValue) / 10;
                l3.val = tempValue % 10;
                l2 = l2.next;
            }
            i ++;
        }
        if(carry > 0) {
            l3.next = new ListNode(1);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
