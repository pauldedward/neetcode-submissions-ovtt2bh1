/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node current = head;
        while(current != null) {
            Node next = current.next;
            Node random = current.random;

            oldToNew.putIfAbsent(current, new Node(current.val));
            if(next != null) {
                oldToNew.putIfAbsent(next, new Node(next.val));
                oldToNew.get(current).next = oldToNew.get(next);
            }
            if(random != null) {
                oldToNew.putIfAbsent(random, new Node(random.val));
                oldToNew.get(current).random = oldToNew.get(random);
            }
            current = current.next;
        }

        return oldToNew.get(head);
    }
}
