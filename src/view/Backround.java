package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Backround extends JFrame{
    JLayeredPane backround;

    public Backround(){
        ImageIcon imageIcon = new ImageIcon("src\\_background\\background.png");
        JLabel label = new JLabel(imageIcon);

        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        backround = new JLayeredPane();
        backround.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

        backround.add(label, JLayeredPane.DEFAULT_LAYER);

        setContentPane(backround);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //side bar

        JButton ReceiveCard = new JButton();
        ReceiveCard.setIcon(new ImageIcon("src\\_cards\\backCard.png"));
        ReceiveCard.setBounds(820, 180, 180, 270);
        backround.add(ReceiveCard, JLayeredPane.PALETTE_LAYER);

      //  JTable ReceiveCardLabel = new JTable();
      //  ReceiveCardLabel.setBounds(820, 230, 184, 280);
      //  backround.add(ReceiveCardLabel, JLayeredPane.PALETTE_LAYER);


        ImageIcon CurrentCard = new ImageIcon("src\\_cards\\backCard.png");
        JLabel CurrentCardLabel = new JLabel(CurrentCard);
        CurrentCardLabel.setBounds(1030, 180, 184, 280);
        backround.add(CurrentCardLabel, JLayeredPane.PALETTE_LAYER);
        CurrentCardLabel.setVisible(false);

        ReceiveCard.addActionListener(e -> {
            CurrentCardLabel.setVisible(true);
        });

     //   CurrentCard.setImage(new ImageIcon("src\\_cards\\card1.png").getImage());

        JTextArea InfoBox = new JTextArea();
        InfoBox.setBounds(820, 600, 394, 200);
        InfoBox.setEditable(false);
        InfoBox.setBackground(Color.WHITE);
        InfoBox.setBorder(new LineBorder(Color.BLACK));
        InfoBox.setFont(new Font("Serif", Font.BOLD, 20));
        backround.add(InfoBox, JLayeredPane.PALETTE_LAYER);
        InfoBox.append("Welcome to Sorry! \n");
    }
    public JLayeredPane getLayeredPane() {
        return backround;
    }
}