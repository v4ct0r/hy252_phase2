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
    private JButton Cards;
    private int prev;
    private String prevPawn;
    private int prediction;
    JButton redPawn1;
    JButton redPawn2;
    JButton yellowPawn1;
    JButton yellowPawn2;

    Rectangle redPawn1Start;
    Rectangle redPawn2Start;
    Rectangle yellowPawn1Start;
    Rectangle yellowPawn2Start;
    Rectangle redPawn1Home;
    Rectangle redPawn2Home;
    Rectangle yellowPawn1Home;
    Rectangle yellowPawn2Home;




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
        redPawn1 = new JButton();
        redPawn1.setIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        redPawn1.setDisabledIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        redPawn1Start = new Rectangle(320, 75,redPawn1.getIcon().getIconWidth(),redPawn1.getIcon().getIconHeight());
        redPawn1.setBounds(redPawn1Start);
        this.add(redPawn1);

        redPawn2 = new JButton();
        redPawn2.setIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPawn2.setDisabledIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPawn2Start = new Rectangle(375, 75, redPawn2.getIcon().getIconWidth(),redPawn2.getIcon().getIconHeight());
        redPawn2.setBounds(redPawn2Start);
        this.add(redPawn2);

        //init yellow pawns
        yellowPawn1 = new JButton();
        yellowPawn1.setIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        yellowPawn1.setDisabledIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        yellowPawn1Start = new Rectangle(672, 675, yellowPawn1.getIcon().getIconWidth(),yellowPawn1.getIcon().getIconHeight());
        yellowPawn1.setBounds(yellowPawn1Start);
        this.add(yellowPawn1);

        yellowPawn2 = new JButton();
        yellowPawn2.setIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        yellowPawn2.setDisabledIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        yellowPawn2Start = new Rectangle(727, 675, yellowPawn2.getIcon().getIconWidth(),yellowPawn2.getIcon().getIconHeight());
        yellowPawn2.setBounds(yellowPawn2Start);
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
                    redPawn1Home = new Rectangle(225, 80 + (i-3) * 50, 50, 50);
                    redPawn2Home = new Rectangle(275, 80 + (i-3) * 50, 50, 50);
                    squares.get(i).setBounds(215, 50 + (i-3) * 50, 120, 120);
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
            if(i==37 || i==38 || i==45 ||i==46 || i>=51 && i<=55){
                if(i==37 || i==51) {
                    squares.get(i).setIcon(new ImageIcon("src\\_slides\\YellowSlideStart.png"));
                }
                else if(i==38 || i==45 || i==52 || i==53 || i==54  ) {
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
                    yellowPawn1Home = new Rectangle(775, 660 - (i-39) * 50, 50, 50);
                    yellowPawn2Home = new Rectangle(825, 660 - (i-39) * 50, 50, 50);
                    squares.get(i).setBounds(765, 630 - (i-39) * 50, 120, 120);
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


            if(controller.getCurrent_player().getColor().equals("yellow")){ //BUMPING
                controller.play(controller.get_pawn(prevPawn), prediction);
                redPawn1.setBorder(null);
                redPawn1.setBounds(redPawn1Start);
                squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_opponent_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    redPawn1.setBounds(squares.get(controller.getRed_pawn1().getPosition()).getBounds());
                }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);

                return;
            }
            if(backround.getisdrawn()) {
                prevPawn = "redPawn1";

                if(controller.getRed_pawn1().getPosition()>=0)
                    prev = controller.getRed_pawn1().getPosition();

                cleanSquares(squares);

                if(controller.predict(controller.getRed_pawn2())>=0 && !controller.getRed_pawn2().getHome())
                    squares.get(controller.predict(controller.getRed_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));

                prediction = controller.predict(controller.getRed_pawn1());
                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                bumpingUI(prediction ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);

                set_squares_switch_turn(controller.getRed_pawn1(), squares, redPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround , prediction, prev, redPawn1Home);
            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        redPawn2.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("yellow")){//BUMPING
                controller.play(controller.get_pawn(prevPawn), prediction);

                redPawn2.setBorder(null);
                redPawn2.setBounds(redPawn2Start);
                squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_opponent_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    redPawn2.setBounds(squares.get(controller.getRed_pawn2().getPosition()).getBounds());
                }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);

                return;
            }

            if(backround.getisdrawn()) {
                prevPawn = "redPawn2";

                if(controller.getRed_pawn2().getPosition()>=0)
                    prev = controller.getRed_pawn2().getPosition();

                cleanSquares(squares);

                if(controller.predict(controller.getRed_pawn1())>=0 && !controller.getRed_pawn1().getHome())
                    squares.get(controller.predict(controller.getRed_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));

                prediction = controller.predict(controller.getRed_pawn2());
                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                bumpingUI(prediction ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);

                set_squares_switch_turn(controller.getRed_pawn2(), squares, redPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround, prediction, prev,redPawn2Home);

            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        yellowPawn1.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("red")){//BUMPING

                controller.play(controller.get_pawn(prevPawn), prediction);
                yellowPawn1.setBorder(null);
                yellowPawn1.setBounds(yellowPawn1Start);
                squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_opponent_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    yellowPawn1.setBounds(squares.get(controller.getYellow_pawn2().getPosition()).getBounds());
                }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);

                return;
            }
            if(backround.getisdrawn()) {
                prevPawn = "yellowPawn1";

                if(controller.getYellow_pawn1().getPosition()>=0)
                    prev = controller.getYellow_pawn1().getPosition();

                cleanSquares(squares);

                if(controller.predict(controller.getYellow_pawn2())>=0 && !controller.getYellow_pawn2().getHome())
                    squares.get(controller.predict(controller.getYellow_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));

                prediction = controller.predict(controller.getYellow_pawn1());
                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                bumpingUI(prediction ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);

                set_squares_switch_turn(controller.getYellow_pawn1(), squares, yellowPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround, prediction, prev, yellowPawn1Home);
            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
        yellowPawn2.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("red")){//BUMPING

                controller.play(controller.get_pawn(prevPawn), prediction);
                yellowPawn2.setBorder(null);
                yellowPawn2.setBounds(yellowPawn2Start);
                squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));


              if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                  refresh_opponent_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                  yellowPawn2.setBounds(squares.get(controller.getYellow_pawn2().getPosition()).getBounds());
              }

              switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);

              return;
            }
            if(backround.getisdrawn()) {
                prevPawn = "yellowPawn2";

                if(controller.getYellow_pawn2().getPosition()>=0)
                    prev = controller.getYellow_pawn2().getPosition();

                cleanSquares(squares);

                if(controller.predict(controller.getYellow_pawn1())>=0 && !controller.getYellow_pawn1().getHome())
                    squares.get(controller.predict(controller.getYellow_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));

                prediction = controller.predict(controller.getYellow_pawn2());
                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                bumpingUI(prediction ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);

                set_squares_switch_turn(controller.getYellow_pawn2(), squares, yellowPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2,backround, prediction, prev,yellowPawn2Home);
            }
            else
                JOptionPane.showMessageDialog(backround, "You must draw a card first!");
        });
    }

    private JButton prevPawnUI() {
        if(Objects.equals(prevPawn, "redPawn1"))
            return redPawn1;
        else if(Objects.equals(prevPawn, "redPawn2"))
            return redPawn2;
        else if(Objects.equals(prevPawn, "yellowPawn1"))
            return yellowPawn1;
        else if(Objects.equals(prevPawn, "yellowPawn2"))
            return yellowPawn2;
        return null;
    }

    private void cleanSquares(ArrayList<JButton> squares) {
        for(int i=0; i<72; i++)
            for(ActionListener al : squares.get(i).getActionListeners())
                squares.get(i).removeActionListener(al);

    }

    private void bumpingUI(int prediction, Pawn enemyPawn1, Pawn enemyPawn2, JButton enemyPawnUI1, JButton enemyPawnUI2) {
        enemyPawnUI1.setEnabled(false);
        enemyPawnUI2.setEnabled(false);
        enemyPawnUI1.setBorder(null);
        enemyPawnUI2.setBorder(null);
        if(prediction == enemyPawn1.getPosition()){
            enemyPawnUI1.setEnabled(true);
            enemyPawnUI1.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
        if(prediction == enemyPawn2.getPosition()){
            enemyPawnUI2.setEnabled(true);
            enemyPawnUI2.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
    }

    private void set_squares_switch_turn(Pawn pawn, ArrayList<JButton> squares, JButton pawnUI, Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, Backround backround, int prediction, int prev, Rectangle Home) {

        for(int i=0; i<72; i++){
            //go to action listener of each square and unable all of them except the current pawn position
            if(i != prediction){
                squares.get(i).addActionListener(e -> {
                    JOptionPane.showMessageDialog(this, "You can't move there!");
                });

            }
            else {
                squares.get(i).addActionListener(e -> {
                    controller.play(pawn, prediction);
                    squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.BLACK, 2));
                    if(!pawn.getHome()) {
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }
                    else {
                        if(Objects.equals(pawn.getColor(), "red"))
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.RED, 7));
                        else
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.YELLOW, 7));
                        pawnUI.setBounds(Home);
                    }
                    squares.get(prev).setVisible(true);
                    if(!pawn.getHome()){
                        squares.get(pawn.getPosition()).setVisible(false);
                    }
                    else{
                        this.add(pawnUI, JLayeredPane.PALETTE_LAYER); //pawnUI OVERLAPS the square HOME
                    }

                    if(controller.check_for_slide(pawn)){
                        refresh_opponent_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }

                    switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, backround);
                    if (pawn.getHome())
                        pawnUI.setEnabled(false);
                    cleanSquares(squares);
                });
            }
        }
    }

    private void refresh_opponent_pawns(Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, ArrayList<JButton> squares) {
        if(controller.current_player.getColor()=="red"){
            if(controller.getYellow_pawn1().getPosition() == controller.player2.getStartPosition())
                yellowPawn1.setBounds(yellowPawn1Start);
            if(controller.getYellow_pawn2().getPosition() == controller.player2.getStartPosition())
                yellowPawn2.setBounds(yellowPawn2Start);
        }
        else {
            if(controller.getRed_pawn1().getPosition() == controller.player1.getStartPosition())
                redPawn1.setBounds(redPawn1Start);
            if(controller.getRed_pawn2().getPosition() == controller.player1.getStartPosition())
                redPawn2.setBounds(redPawn2Start);
        }
        //make all the squares visible except the current pawn position
        for(int i=0; i<72; i++){
            if(i != controller.getYellow_pawn1().getPosition() && i != controller.getYellow_pawn2().getPosition() && i != controller.getRed_pawn1().getPosition() && i != controller.getRed_pawn2().getPosition()){
                squares.get(i).setVisible(true);
            }
            else {
                squares.get(i).setVisible(false);
            }
        }

    }


    private void ActionListener_FoldButton(Backround backround, Controller controller, JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
        backround.Fold.addActionListener(e -> {

            controller.switch_current_player(controller.player1, controller.player2);
            DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

            if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
                backround.InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
            else
                backround.InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
            backround.InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n");
            backround.ReceiveCard.setEnabled(true);


            backround.setiIsdrawn(false);
            backround.Fold.setEnabled(false);
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
        if(controller.getRed_pawn1().getHome())
            redPaw1.setEnabled(false);
        if(controller.getRed_pawn2().getHome())
            redPaw2.setEnabled(false);
        if(controller.getYellow_pawn1().getHome())
            yellowPaw1.setEnabled(false);
        if(controller.getYellow_pawn2().getHome())
            yellowPaw2.setEnabled(false);
    }
    private void switch_turn(Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2 , Backround backround) {
        if(!(controller.getCurrent_card() instanceof Number_TwoCard)) {
            controller.switch_current_player(controller.player1, controller.player2);
            DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);
        }
        if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
            backround.InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
        else
            backround.InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
        backround.InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n");
        backround.ReceiveCard.setEnabled(true);
        backround.setiIsdrawn(false);
    }


}
