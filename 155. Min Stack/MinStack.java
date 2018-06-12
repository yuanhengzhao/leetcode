class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        stackData.push(x);
        if(stackMin.isEmpty()) {
            stackMin.push(x);
        }else{
            int preMin = stackMin.peek();
            stackMin.push(Math.min(preMin, x));
        }
    }
    
    public void pop() {
        stackMin.pop();
        stackData.pop();
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}
