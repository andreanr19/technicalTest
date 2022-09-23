import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String name = sc.nextLine();
        // System.out.println("Nombre: " + name);
        System.out.println("Ingrese la cantidad de pisos del arreglo");
        int amountFloor = sc.nextInt();

        int arrayStartFloors[] = new int[amountFloor];
        StringBuffer arrayStartFloorsString = new StringBuffer();

        System.out.println("Ingrese los valores del arreglo de pisos a los cuales el elevador será llamado");
        for (int i = 0; i < amountFloor; i++) {
            System.out.println("Ingrese el valor " + (i + 1) + " del arreglo");
            int floor = sc.nextInt();
            arrayStartFloors[i] = floor;
            if (i != amountFloor - 1) {
                arrayStartFloorsString.append(floor + ", ");
            } else {
                arrayStartFloorsString.append(floor);
            }
            sc.nextLine();
        }

        System.out.println("Ingrese el piso inicial");
        int initialFloor = sc.nextInt();
        sc.nextLine();
        String state = "";

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < amountFloor; i++) {
            System.out.println("Ingrese el piso inicial número " + (i + 1) + "del  HashMap");
            int startFloor = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el destino número " + (i + 1) + "del HashMap");
            int destinyFloor = sc.nextInt();
            hashMap.put(startFloor, destinyFloor);
        }
        // for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        // System.out.println("Key = " + entry.getKey() + ", Value = " +
        // entry.getValue());
        // }

        // System.out.println("Arreglo de pisos: [" + arrayStartFloorsString + "]");
        // System.out.println("Piso inicial de ejecución " + initialFloor);

        int arrayPendientes[] = new int[amountFloor];
        int actualState = initialFloor;

        for (int i = 0; i < arrayStartFloors.length; i++) {
            if (actualState < arrayStartFloors[i]) {
                System.out.println("Elevador en el piso: " + actualState);
                actualState = arrayStartFloors[i];
                System.out.println("Elevador subiendo hasta el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador en el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador se detiene");
                // if (i == arrayStartFloors.length - 1) {
                // System.out.println("Elevador se detiene");

                // }
                if (i < arrayStartFloors.length - 1) {
                    System.out.println("Piso ingresado " + arrayStartFloors[i + 1]);
                }
                arrayPendientes[i] = hashMap.get(arrayStartFloors[i]);
            } else {
                System.out.println("Elevador en el piso: " + actualState);
                actualState = arrayStartFloors[i];
                System.out.println("Elevador bajando hasta el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador en el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador se detiene");
                // if (i == arrayStartFloors.length - 1) {
                // System.out.println("Elevador se detiene");

                // }
                if (i < arrayStartFloors.length - 1) {
                    System.out.println("Piso ingresado " + arrayStartFloors[i + 1]);
                }
                arrayPendientes[i] = hashMap.get(arrayStartFloors[i]);

            }
        }

        for (int i = 0; i < arrayPendientes.length; i++) {
            System.out.println("arreglo pendientes posicion " + (i + 1) + ": " + arrayPendientes[i]);
        }
    }

}
