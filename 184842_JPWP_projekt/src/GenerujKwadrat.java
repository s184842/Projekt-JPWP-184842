import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GenerujKwadrat {

    int tempX, tempY;

    //Niepotrzebne, wrzucic co trzeba do RozlozKwadraty
    //TODO: USUNAC

    public void RysujKwadrat(JPanel panel){

        GenerujKwadrat[] kwad = new GenerujKwadrat[3];

        JPanel kwadrat = new JPanel();

        kwadrat.setSize(new Dimension(100, 100));
        kwadrat.setBackground(Color.white);

        //RozlozKwadraty(kwadrat, panel);

        //tempX = rand.nextInt(1200);
        //tempY = rand.nextInt(540);

        //kwadrat.setLocation(tempX, tempY);
        //panel.add(kwadrat);

    }

    /*
        Funkcja do sprawdzania czy kwadraty na siebie nachodza
        Funkcja sprawia, ze program nie chce sie czasami wlaczyc i nie dziala jak powinna
        TODO: NAPRAWIC, Zamienic GenerujKwadrat[] na int[][] lub Point[]
     */
    public void RozlozKwadraty(JPanel panel) {

        GenerujKwadrat[] kwad = new GenerujKwadrat[3];
        JPanel[] kwadraty = new JPanel[kwad.length];

        Random r = new Random();

        for (int i = 0; i < kwad.length; i++) {

            boolean czyNachodza = true;

            kwad[i] = new GenerujKwadrat();

            kwad[i].tempX = r.nextInt(1000);
            kwad[i].tempY = r.nextInt(500);

            if (i > 0) {
                while (czyNachodza) {
                    for (int j = 0; j < i; j++) {
                        if (kwad[i].tempX < (kwad[j].tempX - 70) || kwad[i].tempX > (kwad[j].tempX + 70)){
                            if (kwad[i].tempY < (kwad[j].tempY - 70) || kwad[i].tempY > (kwad[j].tempY + 70))
                                czyNachodza = false;
                        }
                        else{
                            kwad[i].tempX = r.nextInt(900);
                            kwad[i].tempY = r.nextInt(500);
                        }
                    }
                }
            }
            kwadraty[i] = new JPanel();
            kwadraty[i].setLocation(kwad[i].tempX, kwad[i].tempY);
            kwadraty[i].setSize(new Dimension(100, 100));
            kwadraty[i].setBackground(Color.white);
            panel.add(kwadraty[i]);
        }
    }
}