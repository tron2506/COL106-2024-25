import java.util.Stack;

class MyQueue{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void enqueue(int x){
        stack1.push(x);
    }

    public void dequeue(){
        if(stack2.isEmpty()) transferElements();
        if(!stack2.isEmpty()){
            stack2.pop();
        }
    }

    public int front(){
        if(stack2.isEmpty()) transferElements();
        return stack2.peek();
    }

    public boolean isEmpty(){
        if(stack2.isEmpty()) transferElements();
        return stack2.isEmpty();
    }

    private void transferElements(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
public class StackedQueue{
    public static void main(String args[]){
        MyQueue queue=new MyQueue();
        System.out.println("hello");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(6);
        System.out.println(queue.front());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.front());
        }
}