import java.util.concurrent.Semaphore;

public class ProduciDato extends Thread {
    Semaphore pieno;
    Semaphore vuoto;
    int tanti = 5;
    int quantita = 1;

    public ProduciDato(Semaphore s1, Semaphore s2) {
        pieno = s1;
        vuoto = s2;
    }

    public ProduciDato(Semaphore s1, Semaphore s2, int quantita) {
        pieno = s1;
        vuoto = s2;
        this.quantita = quantita;
    }

    public void run() {
        for (int k = 0; k < tanti; k++) {
            try {
                vuoto.acquire();
                App.buffer = k;
                System.out.println("Scrittore: dato scritto: " + k);
                pieno.release(quantita);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Scrittore: termine scrittura dati.");
    }
}
