

    // Complete the removeDuplicates function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode node = head.next;
        while (node != null && node.data == head.data) {
            node = node.next;
        }
        head.next = removeDuplicates(node);
        return head;

    }

