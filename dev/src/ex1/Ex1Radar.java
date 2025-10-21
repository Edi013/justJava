package ex1;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex1Radar {
    public static void startBasicRadar() {
        var scanner = new Scanner(System.in);
        String input;

        while (true) {
            final List<String> carTypes = List.of("Car", "Bus", "Bike");
            System.out.print("Enter vehicle type (Car, Bus, Bike):");
            input = scanner.nextLine();

            String userCarType = input.toLowerCase();
            if (carTypes.contains(userCarType)) {
                System.out.println("Unknown type. Accepted types: " + carTypes.toString());
                continue;
            }


            short carSpeedLimit = switch (userCarType) {
                case "car" -> 100;
                case "bus" -> 80;
                case "bike" -> 60;
                default -> -1;
            };

            System.out.print("Enter speed:");
            input = scanner.nextLine();
            short userSpeed = parseSpeedInput(input);

            if (userSpeed < 0) {
                System.out.println("Exiting system...");
                break;
            } else if(userSpeed <= carSpeedLimit){
                System.out.println("Speed OK");
            } else{
                System.out.println("Exiting system");
                break;
            }
        }
    }

    public static void startEfficientRadar() {
        var scanner = new Scanner(System.in);
        String input;

        while (true) {
            final Map<String, Short> carTypes = Map.of(
                    "car", (short)100,
                    "bus", (short)80,
                    "bike", (short)60
            );

            System.out.print("Enter vehicle type (Car, Bus, Bike):");
            input = scanner.nextLine();
            String userCarType = input.toLowerCase();

            boolean knownType = carTypes.containsKey(userCarType);
            if (!knownType) {
                System.out.println("Unknown type. Accepted types: " + carTypes.keySet().toString());
                continue;
            }

            System.out.print("Enter speed:");
            input = scanner.nextLine();
            short userSpeed = parseSpeedInput(input);

            if(userSpeed > carTypes.get(userCarType))
                System.out.println("Speeding!");
            else if(userSpeed >= 0)
                System.out.println("Speed OK");
            else{
                System.out.println("Exiting system");
                break;
            }
        }

    }

    private static short parseSpeedInput(String input){
        try {
            return Short.parseShort(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Ex1Radar.startEfficientRadar();

    }
}
