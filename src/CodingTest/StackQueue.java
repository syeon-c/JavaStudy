package CodingTest;

import java.util.Stack;

/**
 * Stack 두개를 이용해 Queue 를 구현 하세요
 */

public class StackQueue {

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
    }

    StackQueue() {
        this.firstStack = new Stack();
        this.secondStack = new Stack();
    }

    void inQueue(int v) {
        firstStack.push(v);
    }

    int outQueue() {
        if (!firstStack.empty()) {
            while(!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    int size() {
        return firstStack.size() + secondStack.size();
    }
}
