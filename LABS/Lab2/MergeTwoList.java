class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add a new node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
public class MergeTwoList{
    public Node mergeLists(Node head1, Node head2){
        LinkedList list=new LinkedList();
        Node temp=list.head;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                list.addNode(head1.data);
                head1=head1.next;
            }
            else{
                list.addNode(head2.data);
                head2=head2.next;
            }
        }
        if(head1==null && head2!=null){
            while(head2!=null){
                list.addNode(head2.data);
                head2=head2.next;
            }
        }
        if(head2==null && head1!=null){
            while(head1!=null){
                list.addNode(head1.data);
                head1=head1.next;
            }
        }
        
        return list.head;
    }
    public static void main(String args[]){

    }
}