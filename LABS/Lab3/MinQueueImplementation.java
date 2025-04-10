class MinQueue {
    private MinStack enqueueStack;
    private MinStack dequeueStack;

    public MinQueue(){
        enqueueStack=new MinStack();
        dequeueStack=new MinStack();
    }

    public void enqueue(int x){
        enqueueStack.push(x);
    }

    public void dequeue(){
        if(dequeueStack.stacks.isEmpty()){
            transferElements();
        }
        dequeueStack.pop();
    }

    public int front(){
        if(dequeueStack.stacks.isEmpty()){
            transferElements();
        }
        return dequeueStack.top();
    }

    public int getMin(){
        if(dequeueStack.stacks.isEmpty()){
            transferElements();
        }
        return dequeueStack.getMin();
    }

    private void transferElements(){
        while(!enqueueStack.stacks.isEmpty()){
            dequeueStack.push(enqueueStack.top());
            enqueueStack.pop();
        }
    }
}
public class MinQueueImplementation{
    public static void main(String args[]){
        MinQueue minQueue = new MinQueue();

        // Test enqueue and getMin
        minQueue.enqueue(5);
        minQueue.enqueue(3);
        minQueue.enqueue(7);
        System.out.println("Minimum: " + minQueue.getMin()); // Output: 3

        // Test front and dequeue
        System.out.println("Front: " + minQueue.front()); // Output: 5
        minQueue.dequeue();
        System.out.println("Minimum: " + minQueue.getMin()); // Output: 3

        minQueue.dequeue();
        System.out.println("Minimum: " + minQueue.getMin()); // Output: 7
    }
}
