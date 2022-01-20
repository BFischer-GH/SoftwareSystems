package ss.calculator.myCalculator;

import ss.calculator.Calculator;
import ss.calculator.DivideByZeroException;
import ss.calculator.StackEmptyException;

import java.util.Stack;

public class MyCalculator implements Calculator {

    public Stack<Double> stack = new Stack<>(); //Create new stack to work with


    @Override
    public void push(double value) {
        stack.push(value);
    } // End of push

    @Override
    public double pop() throws StackEmptyException {
        if (stack.size() == 0) {
            throw new StackEmptyException("error: Stack is empty!");
        } else {
            return stack.pop();
        }
    }

    // takes two values from the stack, adds them and put the result on the stack
    @Override
    public void add() throws StackEmptyException {
        if (stack.size() < 2) {
            throw new StackEmptyException("error: Stack is has less than 2 values");
        } else {
            Double value1 = stack.pop();
            Double value2 = stack.pop();
            Double sum = value1 + value2;
            stack.push(sum);
        }
    }

    @Override
    public void sub() throws StackEmptyException {
        if (stack.size() < 2) {
            throw new StackEmptyException("error: Stack is has less than 2 values");
        } else {
            Double value1 = stack.pop();
            Double value2 = stack.pop();
            Double sub = value2 - value1;
            stack.push(sub);
        }
    }

    @Override
    public void mult() throws StackEmptyException {
        if (stack.size() < 2) {
            throw new StackEmptyException("error: Stack is has less than 2 values");
        } else {
            Double value1 = stack.pop();
            Double value2 = stack.pop();
            Double mult = value1 * value2;
            stack.push(mult);
        }

    }

    @Override
    public void div() throws DivideByZeroException, StackEmptyException {
        if (stack.size() < 2) {
            throw new StackEmptyException("error: Stack is has less than 2 values");
        } else {
            Double value1 = stack.pop();
            Double value2 = stack.pop();
            if (value1 == 0) {
                stack.push(Double.NaN);
                throw new DivideByZeroException("error: Cannot divide by 0");
            }
            Double div = value2 / value1;
            stack.push(div);
        }
    }

    @Override
    public void dup() throws StackEmptyException {
        if(stack.size() == 0){
            throw new StackEmptyException("error: Stack is empty");
        } else {
        double value = stack.peek();
        stack.push(value);
        }
    }

    @Override
    public void mod() throws DivideByZeroException, StackEmptyException {
        if (stack.size() < 2) {
            throw new StackEmptyException("error: Stack is has less than 2 values");
        } else {
            Double value1 = stack.pop();
            Double value2 = stack.pop();
            if (value1 == 0) {
                stack.push(Double.NaN);
                throw new DivideByZeroException("error: Cannot divide by 0");
            }
            Double mod = value2 % value1;
            stack.push(mod);
        }
    }
}