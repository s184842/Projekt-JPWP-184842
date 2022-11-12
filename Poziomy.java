import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public class Poziomy {

    static ArrayList<Color> dostepneKolory = new ArrayList<Color>(4);
    static int ktoryPoziom = 1;
    static int maxPoziom = 5;

    //Metoda do tworzenia i woboru poziomow

    public void Poziomy() {

        switch (ktoryPoziom) {

            case 1:

                GenerujKwadrat.ileKwadratow = 3;        //Ilosc kwadratow
                CountdownTimer.czas = 10;               //Czas na poziom

                dostepneKolory.add(Color.red);          //Kolory kwadratow
                dostepneKolory.add(Color.green);
                dostepneKolory.add(Color.yellow);
                dostepneKolory.add(Color.blue);

                break;

            case 2:

                GenerujKwadrat.ileKwadratow = 6;
                CountdownTimer.czas = 20;

                dostepneKolory.add(Color.magenta);
                dostepneKolory.add(Color.lightGray);
                dostepneKolory.add(Color.pink);
                dostepneKolory.add(Color.orange);

                break;

            case 3:

                GenerujKwadrat.ileKwadratow = 5;
                CountdownTimer.czas = 15;

                dostepneKolory.add(Color.blue);
                dostepneKolory.add(Color.green);
                dostepneKolory.add(new Color(184, 3, 255));
                dostepneKolory.add(Color.orange);

                break;

            case 4:

                GenerujKwadrat.ileKwadratow = 7;
                CountdownTimer.czas = 20;

                dostepneKolory.add(new Color(0,102,0));
                dostepneKolory.add(new Color(102, 255, 102));
                dostepneKolory.add(Color.green);
                dostepneKolory.add(new Color(204, 255, 204));

                break;

            case 5:

                GenerujKwadrat.ileKwadratow = 10;
                CountdownTimer.czas = 15;

                dostepneKolory.add(Color.darkGray);
                dostepneKolory.add(Color.gray);
                dostepneKolory.add(Color.lightGray);
                dostepneKolory.add(Color.black);

                break;

            default:
                break;

        }

        if (ktoryPoziom <= maxPoziom) {
            for (int i = 0; i < 4; i++)
                Okno.kontener[i].setBackground(dostepneKolory.get(i));
        }
         else{
             System.out.println("Koniec gry!");
            ktoryPoziom = Okno.poziomPoczatkowy;
            Okno.poziomObecny.setText("OBECNY POZIOM: " + Poziomy.ktoryPoziom);
            Okno.stopWcisniety = true;
            CountdownTimer.czas = 0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            Okno.start.setEnabled(true);
            Okno.poziom.setEnabled(true);
            Okno.stop.setEnabled(false);
            Okno.wyjscie.setEnabled(true);
        }
    }

}
