package VirtualPet;

public class mascota {

    //atributos mascota
    String tipo;
    String nombre;
    int energia;
    int higiene;
    int peso;
    int animo;

    //constructor
    public mascota(String tipo, String nombre, int energia, int higiene, int peso, int animo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.energia = energia;
        this.higiene = higiene;
        this.peso = peso;
        this.animo = animo;
    }

    //Mostrar estado de la mascota
    public void mostrarEstado() {
        System.out.println("--- Estado de " + nombre + " ---");
        System.out.println("Tipo: " + tipo);
        System.out.println("Energía: " + energia);
        System.out.println("Higiene: " + higiene);
        System.out.println("Peso: " + peso);
        System.out.println("Ánimo: " + animo);
    }

    //Dormir
    public void dormir() {
        if (tipo.equals("perro")) {
            energia += 25;
        } else if (tipo.equals("gato")) {
            energia += 20;
        }
        animo += 10;
        System.out.println(nombre + " ha dormido");
    }

    //Jugar
    public void jugar() {
        energia -= 20;
        animo += 20;
        peso -= 10;
        System.out.println(nombre + " ha jugado");
    }

    //Comer
    public void comer() {
        energia += 10;
        higiene -= 15;
        peso += 10;
        System.out.println(nombre + " ha comido");
    }

    //Ducha
    public void ducha() {
        if (tipo.equals("perro")) {
            energia -= 10;
            higiene += 25;
            animo -= 15;

        } else if (tipo.equals("gato")) {
            energia -= 5;
            higiene += 25;
            animo -= 5;
            System.out.println(nombre + " se ha duchado");
        }
    }

    //Ataque
    public void ataque(mascota dummy) {
        energia -= 3;
        higiene -= 3;
        animo -= 3;

        dummy.energia -= 3;
        dummy.higiene -= 3;
        dummy.animo -= 3;

    }

    //Bailar
    public void bailar(){
        this.energia -= 10;
        System.out.println(this.nombre + " está bailando un mambo!\uD83D\uDC83\uD83D\uDD7A");
    }

    //Comprobar si mascota sigue viva
    public boolean estaViva() {
        return energia > 0 && energia <= 100
                && higiene > 0 && higiene <= 100
                && peso > 0 && peso <= 100
                && animo > 0 && animo <= 100;
    }


}


