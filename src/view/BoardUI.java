package view;

import controller.Controller;
import model.card.Number_TwoCard;
import model.player.Pawn;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class BoardUI extends JLayeredPane {
    private JLabel StartLabel;
    private JButton FoldButton;
    private JButton Cards;
    private int previousPosition1=-10;
    private int previousPosition2=-10;


    public BoardUI(Controller controller, Backround backround) {
        //set the logo in the middle of the screen
        this.setLayout(null);
        this.setPreferredSize(new Dimension(200, 200));
        this.setBounds(0, 0, 200, 200);
        this.setOpaque(true);
        this.setBackground(Color.CYAN);

        Image logoImage = new ImageIcon("src\\_sorrylogo\\sorryImage.png").getImage();
        //add the logo to the board
        JLabel LogoLabel = new JLabel(new ImageIcon(logoImage));
        LogoLabel.setBounds(390,300 , logoImage.getWidth(null), logoImage.getHeight(null));
        this.add(LogoLabel);

        //init red pawns
        JButton redPawn1 = new JButton();
        redPawn1.setIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        redPawn1.setDisabledIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        Rectangle redPawn1Home = new Rectangle(320, 75,redPawn1.getIcon().getIconWidth(),redPawn1.getIcon().getIconHeight());
        redPawn1.setBounds(redPawn1Home);
        this.add(redPawn1);

        JButton redPawn2 = new JButton();
        redPawn2.setIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPawn2.setDisabledIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        Rectangle redPawn2Home = new Rectangle(375, 75, redPawn2.getIcon().getIconWidth(),redPawn2.getIcon().getIconHeight());
        redPawn2.setBounds(redPawn2Home);
        this.add(redPawn2);

        //init yellow pawns
        JButton yellowPawn1 = new JButton();
        yellowPawn1.setIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        yellowPawn1.setDisabledIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        Rectangle yellowPawn1Home = new Rectangle(672, 675, yellowPawn1.getIcon().getIconWidth(),yellowPawn1.getIcon().getIconHeight());
        yellowPawn1.setBounds(yellowPawn1Home);
        this.add(yellowPawn1);

        JButton yellowPawn2 = new JButton();
        yellowPawn2.setIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        yellowPawn2.setDisabledIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        Rectangle yellowPawn2Home = new Rectangle(727, 675, yellowPawn2.getIcon().getIconWidth(),yellowPawn2.getIcon().getIconHeight());
        yellowPawn2.setBounds(yellowPawn2Home);
        this.add(yellowPawn2);




        ArrayList<JButton> squares = new ArrayList<>();
        //init squares
        for (int i = 0; i < 72; i++) {
            JButton square = new JButton();
            squares.add(new JButton());
        }
        int k= 0;
        for (int i = 0; i < 22; i++) {
            if(i==1 || i==2 || i==9 || i==10 || i==16 || i==17 || i==18 || i==19 || i==20){
                if(i==1 || i==16) {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\redSlideStart.png"));
                }
                    else if( i==2 || i==9 || i==17 || i==18 || i==19 ) {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\redSlideMedium.png"));
                }
                    else {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\redSlideEnd.png"));
                }
                squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                squares.get(i).setBounds(150 + k * 50, 0, 50, 50); //top edge
                this.add(squares.get(i));
                k++;
            }
            else {
                if(i==3 || i==4 || i==5 || i==6 || i==7){
                    squares.get(i).setText(" " + (i) + " ");
                    squares.get(i).setBackground(Color.RED);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                    squares.get(i).setBounds(250, 50 + (i-3) * 50, 50, 50);
                    this.add(squares.get(i));
                }else if(i==8){
                    squares.get(i).setText("HOME");
                    squares.get(i).setFont(new Font("Garamond", Font.BOLD, 20));
                    squares.get(i).setBackground(Color.WHITE);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.RED, 7));
                    squares.get(i).setBounds(225, 50 + (i-3) * 50, 100, 100);
                    this.add(squares.get(i));
                }
                else {
                    squares.get(i).setText(" " + (i) + " ");
                    squares.get(i).setBackground(Color.WHITE);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                    squares.get(i).setBounds(150 + k * 50, 0, 50, 50); //top edge
                    k++;
                    this.add(squares.get(i));
                }
            }
        }
        JLabel RedstartLabel = new JLabel("    START");
        RedstartLabel.setFont(new Font("Garamond", Font.BOLD, 20));
        RedstartLabel.setBackground(Color.WHITE);
        RedstartLabel.setOpaque(true);
        RedstartLabel.setBorder(new LineBorder(Color.RED, 7));
        RedstartLabel.setBounds(60 + 5 * 50, 50, 125, 125);
        this.add(RedstartLabel);

        for (int i = 22; i < 37; i++) {
            squares.get(i).setText(" " + (i) + " ");
            squares.get(i).setBackground(Color.WHITE);
            squares.get(i).setOpaque(true);
            squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
            squares.get(i).setBounds(900, 50 + (i - 22) * 50, 50, 50); //right edge
            this.add(squares.get(i));
        }
        k= 0;
        for (int i = 37; i < 58; i++) {
            if(i==37 || i==38 || i==45 ||i==46 || i>=50 && i<=55){
                if(i==37 || i==50) {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\YellowSlideStart.png"));
                }
                else if(i==38 || i==45 || i==51 || i==52 || i==53 || i==54  ) {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\YellowSlideMedium.png"));
                }
                else {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\YellowSlideEnd.png"));
                }
                squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                squares.get(i).setBounds( 850 - k * 50, 750, 50, 50);
                this.add(squares.get(i));
                k++;
            }
            else {
                if(i>38 && i<44){ //safe zone
                    squares.get(i).setText(" " + (i) + " ");
                    squares.get(i).setBackground(Color.YELLOW);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                    squares.get(i).setBounds(800, 700 - (i-39) * 50, 50, 50);
                    this.add(squares.get(i));
                }else if(i==44){
                    squares.get(i).setText("HOME");
                    squares.get(i).setFont(new Font("Garamond", Font.BOLD, 20));
                    squares.get(i).setBackground(Color.WHITE);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.YELLOW, 7));
                    squares.get(i).setBounds(775, 650 - (i-39) * 50, 100, 100);
                    this.add(squares.get(i));
                }
                else {
                    squares.get(i).setText(" " + (i) + " ");
                    squares.get(i).setBackground(Color.WHITE);
                    squares.get(i).setOpaque(true);
                    squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                    squares.get(i).setBounds(850 - k * 50, 750, 50, 50);
                    k++;
                    this.add(squares.get(i));
                }
            }
        }

        JLabel YellowStart = new JLabel("    START");
        YellowStart.setFont(new Font("Garamond", Font.BOLD, 20));
        YellowStart.setBackground(Color.WHITE);
        YellowStart.setOpaque(true);
        YellowStart.setBorder(new LineBorder(Color.YELLOW, 7));
        YellowStart.setBounds(662, 625, 125, 125);
        this.add(YellowStart);

        for (int i = 58; i < 72; i++) {
            squares.get(i).setText(" " + (i) + " ");
            squares.get(i).setBackground(Color.WHITE);
            squares.get(i).setOpaque(true);
            squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
            squares.get(i).setBounds(150, 650 - (i - 59) * 50, 50, 50); //left edge
            this.add(squares.get(i));
        }

        DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

        ActionListener_FoldButton(backround, controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

        /**
         * ActionListener of Fold button is in BoardUI because it needs access to Pawns
         * precondition: the current player must have drawn a card
         * if the card is not drawen pop up a message
         * call the move_pawn method in controller
         * @param controller.getRed_pawn1()
         */
        redPawn1.addActionListener(e -> {
            removeallthepawnlisteners(squares ,redPawn2, yellowPawn1, yellowPawn2);
            if(controller.getCurrent_player().getColor().equals("yellow")){
                redPawn1.setBounds(redPawn1Home);
                return;
            }
            if(backround.getisdrawn()) {

                if(controller.getRed_pawn1().getPosition()!=controller.player1.getStartPosition()) {
                    squares.get(controller.getRed_pawn1().getPosition()).setVisible(true);//make the pawn visible
                }
                if(previousPosition2!=-10)
                    controller.getRed_pawn2().setPosition(previousPosition2);//if pawn switch give to the second pawn the previous position
                if(previousPosition1==-10){
                    previousPosition1=controller.getRed_pawn1().getPosition();
                    controller.play(controller.getRed_pawn1());
                    bumpingUI(controller.getRed_pawn1() ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }
                //TODO IF I WITCH TO THE SECOND RED PAWN I NEED TO GIVE THE PREVIOUS POSITION TO THE FIRST PAWN
                //the the button of the square is not pressed give to pawn the previous position
                set_squares_switch_turn(controller.getRed_pawn1(), squares, redPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround);
            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        redPawn2.addActionListener(e -> {
            removeallthepawnlisteners(squares, redPawn1, yellowPawn1, yellowPawn2);
            if(controller.getCurrent_player().getColor().equals("yellow")){
                redPawn2.setBounds(redPawn2Home);
                return;
            }
            if(backround.getisdrawn()) {
                if(controller.getRed_pawn2().getPosition()!=controller.player1.getStartPosition())
                    squares.get(controller.getRed_pawn2().getPosition()).setVisible(true);

                if(previousPosition1!=-10)
                    controller.getRed_pawn1().setPosition(previousPosition1);//if pawn switch give to the first pawn the previous position

                if(previousPosition2==-10){//prevent spamming the button
                    previousPosition2=controller.getRed_pawn2().getPosition();
                    controller.play(controller.getRed_pawn2());
                    bumpingUI(controller.getRed_pawn2() ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }
                set_squares_switch_turn(controller.getRed_pawn2(), squares, redPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround);

            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        yellowPawn1.addActionListener(e -> {
            removeallthepawnlisteners(squares, redPawn1, redPawn2, yellowPawn2);
            if(controller.getCurrent_player().getColor().equals("red")){
                yellowPawn1.setBounds(yellowPawn1Home);
                return;
            }
            if(backround.getisdrawn()) {
                if(controller.getYellow_pawn1().getPosition()!=controller.player2.getStartPosition())
                    squares.get(controller.getYellow_pawn1().getPosition()).setVisible(true);

                if(previousPosition2!=-10)
                    controller.getYellow_pawn2().setPosition(previousPosition2);//if pawn switch give to the second pawn the previous position
                if(previousPosition1==-10){
                    previousPosition1=controller.getYellow_pawn1().getPosition();
                    controller.play(controller.getYellow_pawn1());
                    bumpingUI(controller.getYellow_pawn1() ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                }
                controller.play(controller.getYellow_pawn1());
                bumpingUI(controller.getYellow_pawn1() ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                set_squares_switch_turn(controller.getYellow_pawn1(), squares, yellowPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround);

            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        yellowPawn2.addActionListener(e -> {
            removeallthepawnlisteners(squares, redPawn1, redPawn2, yellowPawn1);
            if(controller.getCurrent_player().getColor().equals("red")){
                yellowPawn2.setBounds(yellowPawn2Home);
                return;
            }
            if(backround.getisdrawn()) {
                if(controller.getYellow_pawn2().getPosition()!=controller.player2.getStartPosition())
                    squares.get(controller.getYellow_pawn2().getPosition()).setVisible(true);

                if(previousPosition1!=-10)
                    controller.getYellow_pawn1().setPosition(previousPosition1);//if pawn switch give to the first pawn the previous position
                if(previousPosition2==-10){
                    previousPosition2=controller.getYellow_pawn2().getPosition();
                    controller.play(controller.getYellow_pawn2());
                    bumpingUI(controller.getYellow_pawn2() ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                }
                controller.play(controller.getYellow_pawn2());
                bumpingUI(controller.getYellow_pawn2() ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                set_squares_switch_turn(controller.getYellow_pawn2(), squares, yellowPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround);

            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
    }

    private void removeallthepawnlisteners(ArrayList<JButton> squares, JButton Pawn1, JButton Pawn2, JButton Pawn3) {
        for(int i=0; i<72; i++){
            for(ActionListener al : squares.get(i).getActionListeners())
                squares.get(i).removeActionListener(al);
        }
       // for(ActionListener al : Pawn1.getActionListeners())
       //     Pawn1.removeActionListener(al);
       // for(ActionListener al : Pawn2.getActionListeners())
       //     Pawn2.removeActionListener(al);
       // for(ActionListener al : Pawn3.getActionListeners())
       //     Pawn3.removeActionListener(al);

    }

    private void bumpingUI(Pawn myPawn, Pawn enemyPawn1, Pawn enemyPawn2, JButton enemyPawnUI1, JButton enemyPawnUI2) {
        if(myPawn.getPosition() == enemyPawn1.getPosition()){
            enemyPawnUI1.setEnabled(true);
        }
        if(myPawn.getPosition() == enemyPawn2.getPosition()){
            enemyPawnUI2.setEnabled(true);
        }
    }

    private void set_squares_switch_turn(Pawn pawn, ArrayList<JButton> squares, JButton pawnUI, Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, Backround backround) {
        for(int i=0; i<72; i++){
            for(ActionListener al : squares.get(i).getActionListeners())
                squares.get(i).removeActionListener(al); //remove all action listeners
            //go to action listener of each square and unable all of them except the current pawn position
            if(i != pawn.getPosition())
                squares.get(i).addActionListener(e -> {
                    JOptionPane.showMessageDialog(this, "You can't move there!");
                });
            else {
                squares.get(i).addActionListener(e -> {
                    pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    squares.get(pawn.getPosition()).setVisible(false);
                    switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);
                });
            }
        }
    }

    private void ActionListener_FoldButton(Backround backround, Controller controller, JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
        backround.Fold.addActionListener(e -> {
            switch_turn(controller, redPaw1, redPaw2, yellowPaw1, yellowPaw2, backround);
        });
    }

    private void DisablenotCurrentPlayerPawns(Controller controller, JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
        if(controller.getCurrent_player().getColor().equals("red")) {
            redPaw1.setEnabled(true);
            redPaw2.setEnabled(true);
            yellowPaw1.setEnabled(false);
            yellowPaw2.setEnabled(false);
        }
        else {
            redPaw1.setEnabled(false);
            redPaw2.setEnabled(false);
            yellowPaw1.setEnabled(true);
            yellowPaw2.setEnabled(true);
        }
    }
    private void switch_turn(Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2 , Backround backround) {
        if(!(controller.getCurrent_card() instanceof Number_TwoCard)) {
            controller.switch_current_player(controller.player1, controller.player2);
            DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);
        }
        previousPosition1=-10;
        previousPosition2=-10;
        if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
            backround.InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
        else
            backround.InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
        backround.InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n");
        backround.ReceiveCard.setEnabled(true);
        backround.setiIsdrawn(false);
    }


}
