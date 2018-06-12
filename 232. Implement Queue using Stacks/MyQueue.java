class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public MyQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            return true;
        }
        return false;
    }
}
