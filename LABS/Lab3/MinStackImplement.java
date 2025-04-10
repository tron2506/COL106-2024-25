import java.util.Stack;
class MinStack{
    Stack<Integer> stacks;
    Stack<Integer> minStack;
    int min;
    public MinStack(){
        stacks=new Stack<>();
        minStack=new Stack<>();
    }
    public void push(int x){
        if(stacks.isEmpty()){
            min=x;
            stacks.push(x);
            minStack.push(min);
        }
        else{
            stacks.push(x);
            if(x<min){
                min=x;
            }
            minStack.push(min);
        }
    }
    public void pop(){
        if(!stacks.isEmpty()){
            stacks.pop();
            minStack.pop();
        }
    }
    public int top(){
        return stacks.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}

public class MinStackImplement {
    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        System.out.println(minStack.getMin()); // Output: 3
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 3
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
