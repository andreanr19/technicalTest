import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // función para leer el los pisos donde se va a ingresar y donde se va a bajar
        // la persona del ascensor
        for (int i = 0; i < amountFloor; i++) {
            System.out.println("Ingrese el piso inicial número " + (i + 1) + "del  HashMap");
            int startFloor = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el destino número " + (i + 1) + "del HashMap");
            int destinyFloor = sc.nextInt();
            hashMap.put(startFloor, destinyFloor);
        }

        int arrayPendientes[] = new int[amountFloor];
        int actualState = initialFloor;
        String sentido = "";

        // Recorrido que permite hacer la simulación del ascensor
        for (int i = 0; i < arrayStartFloors.length; i++) {
            if (actualState < arrayStartFloors[i]) {
                if (i < arrayStartFloors.length - 1 && arrayPendientes != null) {
                    if (arrayPendientes[i] < arrayStartFloors[i] && sentido.equalsIgnoreCase("subiendo")) {
                        System.out
                                .println("El que ingresó en el piso " + arrayStartFloors[i - 1] + " se baja en el piso "
                                        + arrayPendientes[i]);
                        System.out.println("entro en " + i);
                    }
                }

                System.out.println("Elevador en el piso: " + actualState);
                actualState = arrayStartFloors[i];
                System.out.println("Elevador subiendo hasta el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador en el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador se detiene");

                if (i < arrayStartFloors.length - 1) {
                    System.out.println("Piso ingresado " + arrayStartFloors[i + 1]);
                    if (arrayStartFloors[i] < arrayStartFloors[i + 1]) {
                        sentido = "subiendo";
                    } else {
                        sentido = "bajando";
                    }
                }
                arrayPendientes[i] = hashMap.get(arrayStartFloors[i]);

            } else {
                System.out.println("Elevador en el piso: " + actualState);
                actualState = arrayStartFloors[i];
                System.out.println("Elevador bajando hasta el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador en el piso: " + arrayStartFloors[i]);
                System.out.println("Elevador se detiene");

                if (i < arrayStartFloors.length - 1) {
                    System.out.println("Piso ingresado " + arrayStartFloors[i + 1]);
                    if (arrayStartFloors[i] > arrayStartFloors[i + 1]) {
                        sentido = "bajando";
                    } else {
                        sentido = "subiendo";
                    }
                }
                arrayPendientes[i] = hashMap.get(arrayStartFloors[i]);
                if (i < arrayStartFloors.length - 1 && arrayPendientes != null) {
                    if (arrayPendientes[i] > arrayStartFloors[i + 1] && sentido.equalsIgnoreCase("bajando")) {
                        System.out.println("El que ingresó en el piso " + arrayStartFloors[i] + " se baja en el piso "
                                + arrayPendientes[i]);
                    }
                } else if (i == arrayStartFloors.length - 1 && arrayPendientes != null) {
                    System.out.println("Elevador bajando hasta el piso " + arrayPendientes[i]);
                    System.out.println("El que ingresó en el piso " + arrayStartFloors[i] + " se baja en el piso "
                            + arrayPendientes[i]);
                    System.out.println("Elevador se detiene");
                }

            }
        }
    }

}
