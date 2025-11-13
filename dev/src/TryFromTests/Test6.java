package TryFromTests;

public class Test6 {
    public static void main(String[] args){
        // publicMethods this keyword are allowed in Enums !
        enum Card {
            HEART, CLUB, SPADE, DIAMOND;

            public boolean isRed(){
                return switch(this){
                    case HEART, DIAMOND -> true;
                    default -> false;
                };
            } 
        }
    }
}
