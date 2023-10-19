import java.util.concurrent.Semaphore;

public class App {
    protected static int buffer;

    public static void main(String[] args) throws Exception {
        Semaphore pieno1 = new Semaphore(0);
        Semaphore pieno2 = new Semaphore(0);
        Semaphore vuoto1 = new Semaphore(1);
        Semaphore vuoto2 = new Semaphore(1);
        ProduciDato prod1 = new ProduciDato(pieno1, vuoto1);
        ProduciDato prod2 = new ProduciDato(pieno2, vuoto2, 2);
        ConsumaDato cons1 = new ConsumaDato(pieno1, vuoto1, "Marco");
        ConsumaDato cons2 = new ConsumaDato(pieno2, vuoto2, "Paolo");
        prod1.start();
        prod2.start();
        cons1.start();
        cons2.start();
        System.out.println("Main: termine avvio thread.");
    }
}
