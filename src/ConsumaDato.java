import java.util.concurrent.Semaphore;

public class ConsumaDato extends Thread {
    Semaphore pieno;
    Semaphore vuoto;
    int dato;
    String nome;

    public ConsumaDato(Semaphore s1, Semaphore s2, String nome) {
        pieno = s1;
        vuoto = s2;
        this.nome = nome;
    }

    public void run() {
        while (true) {
            try {
                pieno.acquire();
                dato = App.buffer;
                System.out.println("Lettore (" + nome +"): dato letto " + dato);
                vuoto.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
