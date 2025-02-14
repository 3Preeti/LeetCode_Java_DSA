class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // If the list is empty or has only one node, return null (since there's no middle to delete)
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize two pointers: slow moves one step, fast moves two steps
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head; // To track the node before slow

        // Traverse the list using the two-pointer technique
        while (fast != null && fast.next != null) {
            curr = slow;    // Store the previous node of slow
            slow = slow.next; // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }

        // Delete the middle node by skipping it
        curr.next = slow.next;

        // Return the modified list
        return head;
    }
}
