import java.util.Stack;

/**
 * Stack 두개를 이용해 Queue 를 구현 하세요
 */

public class StackQueue {

    Stack firstStack;
    Stack secondStack;

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
    }

    StackQueue() {
        this.firstStack = new Stack();
        this.secondStack = new Stack();
    }

    void inQueue(int v) {
        //TODO
    }

    int outQueue() {
        //TODO
        return 0;
    }

    int size() {
        //TODO
        return 0;
    }
}
