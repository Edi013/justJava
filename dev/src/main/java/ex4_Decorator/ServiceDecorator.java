package main.java.ex4_Decorator;

public abstract class ServiceDecorator implements Service{
    protected Service wrappee;

    public ServiceDecorator(Service wrappee){
       this.wrappee = wrappee;
    }
    @Override
    public void execute() {
        wrappee.execute();
    }
}
