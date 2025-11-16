package main.java.ex4_Decorator;

public class SimpleService  implements  Service{
    @Override
    public void execute() {
        System.out.println("Simple Service - execute method");
    }
}
