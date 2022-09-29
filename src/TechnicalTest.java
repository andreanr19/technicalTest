import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TechnicalTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter the amount of floor that are going to be pressed");
        int amountOfFloors = sc.nextInt();
        int pressedFloors[] = new int[amountOfFloors];
        System.out.println("Please, enter the values in which the lift will be called");
        for (int i = 0; i < amountOfFloors; i++) {
            System.out.println("Enter the " + (i + 1) + " value");
            int floor = sc.nextInt();
            pressedFloors[i] = floor;
            sc.nextLine();
        }

        System.out.println("Please, enter the start floor");
        int initialFloor = sc.nextInt();
        sc.nextLine();

        HashMap<Integer, Integer> startAndDestinyFloors = new HashMap<>();

        for (int i = 0; i < amountOfFloors; i++) {
            System.out.println("Please, enter the value number " + (i + 1) + " in which the lift will be called");
            int startFloor = sc.nextInt();
            sc.nextLine();
            System.out.println("Please, enter the value number " + (i + 1) + " in which the lift was desired to go to");
            int destinyFloor = sc.nextInt();
            startAndDestinyFloors.put(startFloor, destinyFloor);
        }

        int actualState = initialFloor;
        PriorityQueue<Integer> arregloDePisosPendientes = new PriorityQueue<Integer>();

        for (int i = 0; i < pressedFloors.length; i++) {
            if (floorIsLowerThanOtherFloor(actualState, pressedFloors[i])) {
                System.out.println("El elevador está en el piso " + actualState);
                arregloDePisosPendientes.add(startAndDestinyFloors.get(pressedFloors[i]));

                if (i < pressedFloors.length - 1) {
                    // si el piso al que va es menor al piso que del cual el elevador fue llamado
                    // despues, para en el piso menor
                    if (floorIsLowerThanOtherFloor(arregloDePisosPendientes.peek(), pressedFloors[i + 1])) {
                        System.out.println("El elevador se detiene en el piso " + arregloDePisosPendientes.poll()
                                + " para que el que lo presionó en el piso " + pressedFloors[i] + " se baje");
                    } else {
                        System.out.println("Elevador subiendo hasta el piso " + pressedFloors[i]);
                        System.out.println("El elevador se detiene en el piso " + pressedFloors[i]);
                    }
                }

                actualState = pressedFloors[i];
            } else {
                System.out.println("El elevador está en el piso " + actualState);
                System.out.println("Elevador bajando hasta el piso " + pressedFloors[i]);
                System.out.println("El elevador se detiene en el piso " + pressedFloors[i]);
                actualState = pressedFloors[i];
            }
        }

    }

    public static void liftInOperation(int[] arrayOfFloors, int[] pendientes, HashMap<Integer, Integer> startAndDestiny,
            String orientarion) {

    }

    public static boolean floorIsLowerThanOtherFloor(int actualFloor, int destinyFloor) {
        boolean isLower = false;
        if (actualFloor < destinyFloor) {
            isLower = true;
        }
        return isLower;
    }

}
