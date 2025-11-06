package ex4_Decorator;

public class LoggingDecorator extends ServiceDecorator{
    public LoggingDecorator(Service wrappee){
        super(wrappee);
    }

    @Override
    public void execute(){
        System.out.println("Start logging...");
        this.wrappee.execute();
        System.out.println("End logging...");
    }
}
