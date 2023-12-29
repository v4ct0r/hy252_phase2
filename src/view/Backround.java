package view;

import controller.Controller;
import model.card.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class Backround extends JFrame{
    JLayeredPane background;
    JButton ReceiveCard;
    JButton Fold;
    public Backround(Controller controller){
        super("SORRY!");

        ImageIcon imageIcon = new ImageIcon("src\\_background\\background.png");
        JLabel label = new JLabel(imageIcon);

        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        background = new JLayeredPane();
        background.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

        background.add(label, JLayeredPane.DEFAULT_LAYER);

        setContentPane(background);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ReceiveCard = new JButton();
        ReceiveCard.setIcon(new ImageIcon("src\\_cards\\backCard.png"));
        ReceiveCard.setBounds(820, 180, 180, 270);
        background.add(ReceiveCard, JLayeredPane.PALETTE_LAYER);

        JLabel ReceiveCardLabel = new JLabel("Receive Card");
        ReceiveCardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ReceiveCardLabel.setBounds(850, 445, 180, 50);//under the button
        background.add(ReceiveCardLabel, JLayeredPane.PALETTE_LAYER);

        ImageIcon CurrentCard = new ImageIcon("src\\_cards\\backCard.png");
        JLabel CurrentCardLabel = new JLabel(CurrentCard);
        CurrentCardLabel.setBounds(1030, 180, 170, 260);
        background.add(CurrentCardLabel, JLayeredPane.PALETTE_LAYER);
        CurrentCardLabel.setVisible(false);

        JLabel CurrentCardLabel2 = new JLabel("Current Card");
        CurrentCardLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        CurrentCardLabel2.setBounds(1050, 445, 180, 50);
        background.add(CurrentCardLabel2, JLayeredPane.PALETTE_LAYER);
        CurrentCardLabel2.setVisible(false);



        Fold = new JButton("FOLD");
        Fold.setFont(new Font("Arial", Font.BOLD, 20));
        Fold.setBounds(820, 500, 394, 50);
        Fold.setBackground(Color.RED);
        Fold.setForeground(Color.BLACK);
        Fold.setBorder(new LineBorder(Color.BLACK));
        background.add(Fold, JLayeredPane.PALETTE_LAYER);


        JTextArea InfoBox = new JTextArea();
        InfoBox.setBounds(820, 600, 394, 150);
        InfoBox.setEditable(false);
        InfoBox.setBackground(Color.WHITE);
        InfoBox.setBorder(new LineBorder(Color.BLACK));
        InfoBox.setFont(new Font("Arial", Font.BOLD, 20));
        background.add(InfoBox, JLayeredPane.PALETTE_LAYER);
        if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
            InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
        else
            InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
        InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n"); //print the number of cards left

        ReceiveCard.addActionListener(e -> {
            card current_card = controller.deck.draw();
            controller.setCurrent_card(current_card);
            CurrentCardLabel.setIcon(new ImageIcon(card_path(current_card)));
            if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
                InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
            else
                InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
            InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n"); //print the number of cards left

            CurrentCardLabel.setVisible(true);
            CurrentCardLabel2.setVisible(true);
            ReceiveCard.setEnabled(false);
        });


    }

    private String card_path(card s) {
        if (s instanceof Number_OneCard)
            return "src\\_cards\\card1(Custom).png";
        else if (s instanceof Number_TwoCard)
             return "src\\_cards\\card2(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 3)
            return "src\\_cards\\card3(Custom).png";
        else if (s instanceof Number_FourCard)
            return "src\\_cards\\card4(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 5)
            return "src\\_cards\\card5(Custom).png";
        else if (s instanceof Number_SevenCard)
            return "src\\_cards\\card7(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 8)
            return "src\\_cards\\card8(Custom).png";
        else if (s instanceof Number_TenCard)
            return "src\\_cards\\card10(Custom).png";
        else if (s instanceof Number_ElevenCard)
            return "src\\_cards\\card11(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 12)
            return "src\\_cards\\card12(Custom).png";
        else if (s instanceof Sorry_Card)
            return "src\\_cards\\cardSorry(Custom).png";
        else
            return "src\\_cards\\backCard.png";
    }


    public JLayeredPane getLayeredPane() {
        return background;
    }
}