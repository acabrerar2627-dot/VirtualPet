package VirtualPet;
import java.util.Random;

public class Main{

    public static void main (String[] args){

        //Numeros aleatorios
        Random random = new Random();

        //Elegir mascota
        System.out.println("Elige tu mascota");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("Opción: ");

        int opcionTipo = Teclat.llegirInt();

        String tipo;

        if (opcionTipo == 1){
           tipo = "perro";
        } else if (opcionTipo == 2){
            tipo = "gato";
        } else {
            System.out.println("Opción incorrecta.");
            return;
        }

        //Introducir nombre
        System.out.println("Elige un nombre para tu mascota");
        String nombre = Teclat.llegirString();

        //Crear mascota con valores aleatorios 40 - 60
        mascota mascota = new mascota(
                tipo,
                nombre,
                random.nextInt(21) + 40,
                random.nextInt(21) + 40,
                random.nextInt(21) + 40,
                random.nextInt(21) + 40
        );

        //Dummy con atributos 100
        mascota dummy = new mascota(
                "Dummy", "dummy", 100, 100, 100, 100
        );

        int opcion;
        boolean jugando = true;

        //Bucle principal
        while (jugando && mascota.estaViva()){
            mascota.mostrarEstado();

            System.out.println("--- MENÚ ---");
            System.out.println("1. Dormir");
            System.out.println("2. Jugar");
            System.out.println("3. Comer");
            System.out.println("4. Ducha");
            System.out.println("5. Atacar al dummy");
            System.out.println("6. Bailar");
            System.out.println("0. Salir");
            System.out.println("Elige una opción: ");

            opcion = Teclat.llegirInt();
            switch (opcion) {

                case 1:
                    mascota.dormir();
                    break;

                case  2:
                    mascota.jugar();
                    break;

                case 3:
                    mascota.comer();
                    break;

                case 4:
                    mascota.ducha();
                    break;

                case 5:  //Introducir numero de ataques
                    System.out.println("Cuantas veces quieres atacar?");
                    int numeroAtaques = Teclat.llegirInt();

                    if (numeroAtaques <= 0){
                        System.out.println("Introduce un número mayor que 0.");
                        break;
                    }
                    //Inicio contador
                    int contador = 0;

                    //Bucle de ataques
                    while (contador < numeroAtaques){
                        mascota.ataque(dummy);
                        System.out.println("Ataque número " + (contador + 1));

                        System.out.println("--- Estado del Dummy ---");
                        dummy.mostrarEstado();

                        if (!mascota.estaViva()){
                            System.out.println("¡Tu mascota ha muerto!");
                            jugando = false;
                            break;
                        }

                        if (!dummy.estaViva()){
                            System.out.println("¡El dummy ha muerto!");
                            break;
                        }
                        //Incrementar contador
                        contador = contador +1;
                    }
                    break;

                case 6:
                    mascota.bailar();
                    break;

                case 0:
                    jugando = false;
                    System.out.println("Has salido del juego");
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }
            //Comprobar atributos
            if (jugando && !mascota.estaViva()){
                System.out.println("\n!GAME OVER? Tu mascota ha muerto.");
                mascota.mostrarEstado();
                jugando = false;
            }

            if (jugando && !dummy.estaViva()){
                System.out.println("El Dummy ha muerto.");
            }
        }
        System.out.println("FIN DEL JUEGO");
    }
}
