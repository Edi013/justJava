package ex4_Decorator;

public class Main {
    public static void main(){
        Service oldService = new SimpleService();

        // abstract classes cannot be instantiated
        //ServiceDecorator baseDecoratorInstance = new ServiceDecorator(oldService);

        // Using runtime polymorphism, we can still use the base abstract decorator class
        ServiceDecorator loggingDecorator = new LoggingDecorator(oldService);

        // Is it ok ? Yes, it annotates the code telling everyone
        // the base decorator should never be instantiated

        // But it is still my bad, considering my previous presentation ! 

    }
}
