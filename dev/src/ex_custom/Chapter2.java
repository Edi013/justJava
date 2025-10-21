package ex_custom;

public class Chapter2 {
    public void tryInstanceOfWithPolymorphism(){
        var animal = new Animal();
        var cat = new Animal();

        animal = cat;

        System.out.println("Is a cat an instance of Animal :");
        System.out.println(cat instanceof Animal);

        System.out.println("Is an animal an instance of Cat :");
        System.out.println(animal instanceof Cat);

        System.out.println("Is a cat subreference type, that is referenced as an animal, an instance of Animal :");
        System.out.println(animal instanceof Animal);

        System.out.println("Is a cat subreference type, that is referenced as an animal, an instance of Cat :");
        System.out.println(animal instanceof Cat);

    }

    public void printTextBlock(){
        var var = """
                   squirrel \s
                   pigeon   \
                   termite""";
        System.out.print(var);
    }

    private class Animal{
        public void makeSound(){
            System.out.println("Animal sound...");
        }
    }

    private class Cat extends Animal{
        @Override
        public void makeSound(){
            System.out.println("Meow !");
        }
    }

    public static void main(String[] args) {
        var chapter2 = new Chapter2();
        chapter2.tryInstanceOfWithPolymorphism();

    }
}


