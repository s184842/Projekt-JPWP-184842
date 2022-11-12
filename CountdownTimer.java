import java.util.Timer;
import java.util.TimerTask;

// Timer, ktory odlicza od zadanego czasu (zmienna czas) do zera
// Jezeli czas == 0, timer zaprzestaje odliczania
// Timer odlicza w sekundach

public class CountdownTimer extends Thread{
    static Timer timer;
    static int czas = 0;
    Thread t;

    public void run() {
        int delay = 1000;          //opoznienie (w ms)
        int period = 1000;      //czas po jakim wartosc timera zmniejsza sie o 1 (w ms)
        timer = new Timer();
        System.out.println(czas);

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(setInterval());
            }
        }, delay, period);

    }

    // Odliczanie czasu timera
    // Jezeli osiagnie on wartosc 0, spelniony jest warunek przegranej
    private static final int setInterval() {
        if (czas < 1){
            timer.cancel();
            if(!Okno.stopWcisniety){
                GenerujKwadrat gk = new GenerujKwadrat();
                GenerujKwadrat.ileKwadratow = 0;
                GenerujKwadrat.czyWygrana = false;
                gk.repaint();
                gk.SprawdzenieWygranej();
            }
        }

        //Wyswietlanie czasu w oknie Menu
        Okno.licznik.setText("CZAS: " + czas);
        return czas--;
    }

    //Utworzenie nowego threada, który obsluguje tylk licznik
    public void start (){
        if (t == null){
            Thread t = new Thread(this, "licznik");
        }
    }
}
