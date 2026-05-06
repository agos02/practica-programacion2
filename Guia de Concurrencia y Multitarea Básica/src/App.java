public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Guía de Ejercicios Prácticos: Concurrencia y Multitarea Básica");

        //Ejercicio 1.1-------------------------------------------------
        TareaHilo h1 = new TareaHilo(1);
        TareaHilo h2 = new TareaHilo(2);

        h1.start();
        h2.start();

        //Ejercicio 1.2-------------------------------------------------
        TareaRunnable tarea = new TareaRunnable();
        Thread h3 = new Thread(tarea);
        h3.start();

        //Ejercicio 2.1-------------------------------------------------
        Contador contador = new Contador();

        Thread h4 = new Thread(new TareaContador(contador));
        Thread h5 = new Thread(new TareaContador(contador));

        h4.start();
        h5.start();

        h4.join();
        h5.join();

        System.out.println("Valor final del contador: " + contador.entero);

        //Ejercicio 3.1-------------------------------------------------
        ContadorSincronizado contador2 = new ContadorSincronizado();

        Thread h6 = new Thread(new TareaContadorSync(contador2));
        Thread h7 = new Thread(new TareaContadorSync(contador2));

        h6.start();
        h7.start();

        h6.join();
        h7.join();

        System.out.println("Valor final sincronizado metodo: " + contador2.entero);

        //Ejercicio 3.2-------------------------------------------------
        ContadorBloque contador3 = new ContadorBloque();

        Thread h8 = new Thread(new TareaContadorBloque(contador3));
        Thread h9 = new Thread(new TareaContadorBloque(contador3));

        h8.start();
        h9.start();

        h8.join();
        h9.join();

        System.out.println("Valor final sincronizado bloque: " + contador3.entero);

        //Ejercicio 4.1-------------------------------------------------
        Thread h10 = new Thread(new TareaPrioridad(), "Hilo Baja");
        Thread h11 = new Thread(new TareaPrioridad(), "Hilo Alta");

        h10.setPriority(1);
        h11.setPriority(10);

        h10.start();
        h11.start();

        h10.join();
        h11.join();

        //Ejercicio 4.2-------------------------------------------------
        Thread h12 = new Thread(new TareaLarga());

        h12.start();

        h12.join();

        System.out.println("Hilo largo terminado");

        Thread h13 = new Thread(new TareaLarga());

        h13.start();

        Thread.sleep(2000);

        h13.interrupt();
    }
}

//Ejercicio 1.1-------------------------------------------------
class TareaHilo extends Thread {
    int numero;

    TareaHilo(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo " + numero + " Numero: " + i);
        }
    }
}

//Ejercicio 1.2-------------------------------------------------
class TareaRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ejecutando la interfaz runnable: " + i);
        }
    }
}

//Ejercicio 2.1-------------------------------------------------
class Contador {
    int entero = 0;

    public void incrementar() {
        entero++;
    }
}

class TareaContador implements Runnable {

    Contador contador;

    public TareaContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            contador.incrementar();
        }
    }
}

//Ejercicio 3.1-------------------------------------------------
class ContadorSincronizado {
    int entero = 0;

    public synchronized void incrementar() {
        entero++;
    }
}

class TareaContadorSync implements Runnable {

    ContadorSincronizado contador;

    public TareaContadorSync(ContadorSincronizado contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            contador.incrementar();
        }
    }
}

//Ejercicio 3.2-------------------------------------------------
class ContadorBloque {
    int entero = 0;

    public void incrementar() {
        synchronized (this) {
            entero++;
        }
    }
}

class TareaContadorBloque implements Runnable {

    ContadorBloque contador;

    public TareaContadorBloque(ContadorBloque contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            contador.incrementar();
        }
    }
}

//Ejercicio 4.1-------------------------------------------------
class TareaPrioridad implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " Prioridad: " +
                    Thread.currentThread().getPriority() +
                    " Numero: " + i);
        }
    }
}

//Ejercicio 4.2-------------------------------------------------
class TareaLarga implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Trabajando... " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
    }
}