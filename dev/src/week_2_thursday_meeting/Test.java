package week_2_thursday_meeting;

public interface Test {
    private String name() {
        return null;
    }

    Integer test();

    default void run() {
        System.out.println("Test");
    }
}


