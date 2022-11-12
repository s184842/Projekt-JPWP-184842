import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame {

    JFrame frame = new JFrame();

    static GenerujKwadrat gra = new GenerujKwadrat();       //panel do przeciagania kwadratow
    static JPanel[] kontener = new JPanel[4];               //kontenery do wrzucania kwadratow
    static JPanel menu = new JPanel();                      //panel menu
    //elementy menu
    static JButton start = new JButton("Start");
    static JButton stop = new JButton("Stop");
    static JButton wyjscie = new JButton("Wyjscie");
    static JSpinner poziom = new JSpinner(new SpinnerNumberModel(1, 1, Poziomy.maxPoziom, 1));
    static JLabel licznik = new JLabel();
    static JLabel poziomObecny = new JLabel("OBECNY POZIOM: " + Poziomy.ktoryPoziom);

    static int poziomPoczatkowy = 1;                         //poziom, od ktorego gracz rozpoczyna gre
    static JLabel poziomPocz = new JLabel("POCZATKOWY POZIOM: " + poziomPoczatkowy);

    public void Okno() {
        //JFrame frame = new JFrame();
        int width = 1280;
        int height = 1024;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setFocusable(true);

        //Glowny panel
        JPanel panel = new JPanel();
        panel.setSize(width, height);
        panel.setBackground(Color.gray);

        gra.Panel();

        menu.setPreferredSize(new Dimension(width - 30, 124));
        menu.setBackground(Color.yellow);

        start.setPreferredSize(new Dimension(200, 100));
        start.addActionListener(new PrzyciskStart());

        stop.setPreferredSize(new Dimension(200, 100));
        stop.addActionListener(new PrzyciskStop());
        stop.setEnabled(false);

        wyjscie.setPreferredSize(new Dimension(200, 100));
        wyjscie.addActionListener(new PrzyciskWyjscie());

        poziom.setPreferredSize(new Dimension(100, 100));
        poziom.addChangeListener(new Spinner());
        ((JSpinner.DefaultEditor) poziom.getEditor()).getTextField().setEditable(false);

        licznik.setText("CZAS: " + countdownTimer.czas);
        //JLabel poziomPocz = new JLabel("POCZATKOWY POZIOM: " + poziomPoczatkowy);
        //JLabel poziomObecny = new JLabel("OBECNY POZIOM: " + Poziomy.ktoryPoziom);


        frame.add(panel);

        panel.add(gra);
        panel.add(menu);

        menu.add(start);
        menu.add(stop);
        menu.add(wyjscie);
        menu.add(poziom);
        menu.add(licznik);
        menu.add(poziomPocz);
        menu.add(poziomObecny);

        frame.setVisible(true);
    }

    //Spinner, w ktorym zmieniany jest poczatkoy poziom
    public static class Spinner implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            JSpinner s = (JSpinner) e.getSource();
            int poziom = (int) s.getValue();
            poziomPoczatkowy = poziom;
            System.out.println("Poziom zmieniony na poziom " + poziom);

            Poziomy.ktoryPoziom = poziom;

        }
    }

    boolean czyPierwszeWlaczenie = true;
    CountdownTimer countdownTimer = new CountdownTimer();   //Timer odliczajacy czas w poziomach

    //Przycisk Start, po wcisnieciu laduje poczatkowy poziom (ustawiony na sliderze)
    //Przy pierwszym kliknieciu generuje rowniez kontenery
    public class PrzyciskStart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            stopWcisniety = false;

            //Generacja kontenerow
            if (czyPierwszeWlaczenie) {
                kontener[0] = new JPanel();
                kontener[0].setSize(300, 200);
                kontener[0].setLocation(10, 645);

                kontener[1] = new JPanel();
                kontener[1].setSize(300, 200);
                kontener[1].setLocation(320, 645);

                kontener[2] = new JPanel();
                kontener[2].setSize(300, 200);
                kontener[2].setLocation(630, 645);

                kontener[3] = new JPanel();
                kontener[3].setSize(300, 200);
                kontener[3].setLocation(940, 645);

                for (int i = 0; i < 4; i++)
                    gra.add(kontener[i]);

                czyPierwszeWlaczenie = false;
            }

            //Wylaczenie przycisku START i slidera do wyboru poziomu
            start.setEnabled(false);
            poziom.setEnabled(false);
            stop.setEnabled(true);
            wyjscie.setEnabled(false);

            Poziomy.ktoryPoziom = poziomPoczatkowy;
            poziomPocz.setText("POCZATKOWY POZIOM: " + poziomPoczatkowy);
            poziomObecny.setText("OBECNY POZIOM: " + Poziomy.ktoryPoziom);

            gra.repaint();
            countdownTimer.run();

            gra.GenerujKoordynaty();
        }
    }

    static boolean stopWcisniety = false;

    public class PrzyciskStop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stopWcisniety = true;

            //Program musi zaczekac 1s, aby timer na pewno zakonczyl prace
            //Inaczej istnieje ryzyko powstania drugiego odliczania;

            countdownTimer.czas = 0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            //Usuniecie wszystkich elementow na panelu
            GenerujKwadrat.kwadraty.removeAll(GenerujKwadrat.kwadraty);
            GenerujKwadrat.kolory.removeAll(GenerujKwadrat.kolory);
            Poziomy.dostepneKolory.removeAll(Poziomy.dostepneKolory);

            start.setEnabled(true);
            poziom.setEnabled(true);
            stop.setEnabled(false);
            wyjscie.setEnabled(true);
        }
    }

    public class PrzyciskWyjscie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            countdownTimer.czas = 0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            frame.dispose();
        }
    }
}