package ex_custom;

public class Mammal {
    private void sneeze(){}

    public Mammal(){}

    public Mammal(int age){
        System.out.print("ex_custom.Mammal");
    }

}

class Plat extends Mammal{
    int sneeze() {return 1;}

    public Plat(int age){
        System.out.print("ex_custom.Plat");
    }

    public static void main (String[] args){
        new Mammal(5);
    }
}