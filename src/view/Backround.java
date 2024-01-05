package view;

import controller.Controller;
import model.card.*;
import model.player.Pawn;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class Backround extends JFrame{
    JLayeredPane background;
    JTextArea InfoBox;
    public JButton ReceiveCard;
    JButton Fold;

    private boolean isdrawn = false;
    public Backround(Controller controller){
        super("Sorry!");

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/_background/background.png"));
        JLabel label = new JLabel(imageIcon);

        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        background = new JLayeredPane();
        background.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

        background.add(label, JLayeredPane.DEFAULT_LAYER);

        setContentPane(background);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ReceiveCard = new JButton();
        ReceiveCard.setIcon(new ImageIcon(getClass().getResource("/_cards/backCard.png")));
        ReceiveCard.setBounds(820, 180, 180, 270);
        background.add(ReceiveCard, JLayeredPane.PALETTE_LAYER);

        JLabel ReceiveCardLabel = new JLabel("Receive Card");
        ReceiveCardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ReceiveCardLabel.setBounds(850, 445, 180, 50);//under the button
        background.add(ReceiveCardLabel, JLayeredPane.PALETTE_LAYER);

        ImageIcon CurrentCard = new ImageIcon(getClass().getResource("/_cards/backCard.png"));
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
        Fold.setEnabled(false);
        //ActionListener of Fold button is in BoardUI because it needs access to Pawns

        InfoBox = new JTextArea();
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

            isdrawn = true;

            BoardUI.fix_squres_border();

            card current_card = controller.draw_card(controller.deck);
            CurrentCardLabel.setIcon(new ImageIcon(getClass().getResource(card_path(current_card))));
            if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
                InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
            else
                InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
            InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n"); //print the number of cards left

            CurrentCardLabel.setVisible(true);
            CurrentCardLabel2.setVisible(true);
            if(!(current_card instanceof Simple_Number_Card8_12))
                ReceiveCard.setEnabled(false);

           setFold_button(controller, current_card);
        });


    }

    private void setFold_button(Controller controller, card currentCard) {

        if(currentCard instanceof Simple_Number_Card8_12) {
            Fold.setEnabled(false);
            return;
        }
        Fold.setEnabled(false);
        controller.predict(controller.current_player.getPawn1());
        controller.predict(controller.current_player.getPawn2());
        if(currentCard instanceof Number_TenCard){
            controller.predict1(controller.current_player.getPawn1());
            controller.predict1(controller.current_player.getPawn2());
        }
        if(currentCard instanceof Number_SevenCard && !controller.current_player.getPawn2().isStart()&& !controller.current_player.getPawn2().getHome()){
            controller.predict7(controller.current_player.getPawn1());
        }
        if(currentCard instanceof Number_SevenCard && !controller.current_player.getPawn1().isStart() && !controller.current_player.getPawn1().getHome()){
            controller.predict7(controller.current_player.getPawn2());
        }

        if(!controller.current_player.getPawn1().isMoveable() && !controller.current_player.getPawn2().isMoveable())
            Fold.setEnabled(true);
    }



    private String card_path(card s) {
        if (s instanceof Number_OneCard)
            return "/_cards/card1(Custom).png";
        else if (s instanceof Number_TwoCard)
             return "/_cards/card2(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 3)
            return "/_cards/card3(Custom).png";
        else if (s instanceof Number_FourCard)
            return "/_cards/card4(Custom).png";
        else if (s instanceof Simple_Number_Card && ((Simple_Number_Card) s).getValue() == 5)
            return "/_cards/card5(Custom).png";
        else if (s instanceof Number_SevenCard)
            return "/_cards/card7(Custom).png";
        else if (s instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) s).getValue() == 8)
            return "/_cards/card8(Custom).png";
        else if (s instanceof Number_TenCard)
            return "/_cards/card10(Custom).png";
        else if (s instanceof Number_ElevenCard)
            return "/_cards/card11(Custom).png";
        else if (s instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) s).getValue() == 12)
            return "/_cards/card12(Custom).png";
        else if (s instanceof Sorry_Card)
            return "/_cards/cardSorry(Custom).png";
        else
            return "/_cards/backCard.png";
    }
    public boolean getisdrawn() {
        return isdrawn;
    }

    public void setiIsdrawn(boolean isdrawn) {
        this.isdrawn = isdrawn;
    }

    public JLayeredPane getLayeredPane() {
        return background;
    }
}