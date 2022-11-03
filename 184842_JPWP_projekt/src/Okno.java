import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Okno extends JFrame {

    Okno(){
        JFrame frame = new JFrame();
        int width = 1280;
        int height = 1024;

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setFocusable(true);

        JPanel panel = new JPanel();
        panel.setSize(width, height);
        panel.setBackground(Color.gray);

        JPanel gra = new JPanel();
        gra.setPreferredSize(new Dimension(width - 30, 845));
        gra.setBackground(Color.cyan);
        gra.setLayout(null);


        //Panele do testowania

        /*JPanel panelNaKwadraty = new JPanel();
        panelNaKwadraty.setPreferredSize(new Dimension(width - 30, 845-220));
        panelNaKwadraty.setLayout(null);
        panelNaKwadraty.setBackground(Color.darkGray);

        JPanel panelNaKontenery = new JPanel();
        panelNaKontenery.setPreferredSize(new Dimension(width - 30, 200));
        panelNaKontenery.setLayout(null);
        panelNaKontenery.setBackground(Color.lightGray);*/


        //Kontenery na kwadraty

        JPanel kontenerCzerwony = new JPanel();
        kontenerCzerwony.setBackground(Color.red);
        kontenerCzerwony.setSize(300, 200);
        kontenerCzerwony.setLocation(10, 645);

        JPanel kontenerZielony = new JPanel();
        kontenerZielony.setBackground(Color.green);
        kontenerZielony.setSize(300, 200);
        kontenerZielony.setLocation(320, 645);

        JPanel kontenerZolty = new JPanel();
        kontenerZolty.setBackground(Color.yellow);
        kontenerZolty.setSize(300, 200);
        kontenerZolty.setLocation(630, 645);

        JPanel kontenerNiebieski = new JPanel();
        kontenerNiebieski.setBackground(Color.blue);
        kontenerNiebieski.setSize(300, 200);
        kontenerNiebieski.setLocation(940, 645);

        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(width - 30, 124));
        menu.setBackground(Color.yellow);

        frame.add(panel);

        panel.add(gra);
        panel.add(menu);


        gra.add(kontenerCzerwony);
        gra.add(kontenerZielony);
        gra.add(kontenerZolty);
        gra.add(kontenerNiebieski);

        //Do testow
        //GenerujKwadrat kwad = new GenerujKwadrat();
        //kwad.RozlozKwadraty(gra);

        frame.setVisible(true);
    }

}
