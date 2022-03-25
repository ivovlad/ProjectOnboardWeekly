import java.util.EmptyStackException;

public class TestStack{
    private int top = 0;
    private int maxSize;
    private int arrayVals[];
    private int maxVals[];

    //constructor
    public TestStack(int m){
        this.maxSize = m;
        this.top = -1;
        arrayVals = (int[]) new int[maxSize];
        maxVals = (int[]) new int[maxSize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return  top == maxSize;
    }

    public int getSize(){
        return top+1;
    }

    public void push(int element){
        if (isFull()){
            System.err.println("Stack is full");
            return;
        }
        arrayVals[++top] = element;
        if(top==0){
            maxVals[top]=element;
        }else{
            if (element>maxVals[top-1]){
                maxVals[top]=element;
            }else{
                maxVals[top]=maxVals[top-1];
            }
        }
        return;
    }

    public int pop(){
        if(isEmpty()){
            System.err.println("Stack is empty");
            return 0;
        }
        return arrayVals[top--];
    }

    public int maxConstTime(){
        if(isEmpty()){
            System.err.println("Stack is empty");
            return 0;
        }
        return maxVals[top];
    }

    public int maxLinearTime(){
        if(isEmpty()){
            System.err.println("Stack is empty");
            throw new EmptyStackException();

        }
        int max= arrayVals[0];
//        try{
        for(int i=0;i<=top;i++){
            if(max<arrayVals[i]){
                max = arrayVals[i];
            }
        }
//        } catch(Exception e){
//            System.out.println("Your stack probably contains non-numeric values. Cannot find Maximum!");
//            System.out.println(e);
//        }
        return max;
    }

    public int peek(){
        if (isEmpty()){
            System.err.println("Stack is empty");
            return 0;
        }
        return arrayVals[top];
    }
    public int search(int element){
        if (isEmpty()){
            System.err.println("Cannot search an empty stack");
            return -1;
        }
        for (int i = 0; i<=top;i++){
            if (arrayVals[i] == element)
                return i;

        }
        return -1;
    }
    public int size(){
        return top+1;
    }

    public static void main(String[] args) {
        TestStack stackTry = new TestStack(5);
        stackTry.push(1);
        System.out.println("Top of stack = "+stackTry.top);
        stackTry.push(2);
        System.out.println("Top of stack = "+stackTry.top);
        stackTry.push(3);
        System.out.println("Top of stack = "+stackTry.top);

//        System.out.println("Stack maxLinearTime = " + stackTry.maxLinearTime());
//        System.out.println("Stack maxConstTime = " + stackTry.maxConstTime());
//        System.out.println(stackTry.search(1));
//        System.out.println(stackTry.pop());
//        System.out.println(stackTry.search(3));
        System.out.println("Stack maxLinearTime = "+ stackTry.maxLinearTime());
        System.out.println("Stack maxConstTime = " + stackTry.maxConstTime());
        System.out.println("Stack size = "+stackTry.size());

        while(stackTry.top >-1){
            stackTry.pop();
            System.out.println("Stack size = "+stackTry.size());
            System.out.println("Stack maxConstTime = "+stackTry.maxConstTime());
        }
        stackTry.pop();
        stackTry.maxConstTime();


    }
}