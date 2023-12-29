package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class BoardUI extends JPanel {
    private JLabel StartLabel;
    private JButton FoldButton;
    private JButton Cards;


    public BoardUI(Controller controller, Backround backround) {
        //set the logo in the middle of the screen
        this.setLayout(null);
        this.setPreferredSize(new Dimension(200, 200));
        this.setBounds(0, 0, 200, 200);
        this.setBackground(Color.CYAN);
        this.setVisible(true);

        Image logoImage = new ImageIcon("src\\_sorrylogo\\sorryImage.png").getImage();
        //add the logo to the board
        JLabel LogoLabel = new JLabel(new ImageIcon(logoImage));
        LogoLabel.setBounds(380,300 , logoImage.getWidth(null), logoImage.getHeight(null));
        this.add(LogoLabel);

        //init red pawns
        Rectangle redPaw1Home = new Rectangle(335, 75, 50, 50);
        JButton redPaw1 = new JButton();
        redPaw1.setIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        redPaw1.setBounds(redPaw1Home);
        this.add(redPaw1);

        Rectangle redPaw2Home = new Rectangle(390, 75, 50, 50);
        JButton redPaw2 = new JButton();
        redPaw2.setIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPaw2.setBounds(redPaw2Home);
        this.add(redPaw2);

        //init yellow pawns
        Rectangle yellowPaw1Home = new Rectangle(627, 675, 50, 50);
        JButton yellowPaw1 = new JButton();
        yellowPaw1.setIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        yellowPaw1.setBounds(yellowPaw1Home);
        this.add(yellowPaw1);

        Rectangle yellowPaw2Home = new Rectangle(682, 675, 50, 50);
        JButton yellowPaw2 = new JButton();
        yellowPaw2.setIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        yellowPaw2.setBounds(yellowPaw2Home);
        this.add(yellowPaw2);

        redPaw1.addActionListener(e -> {

        });


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
        RedstartLabel.setBounds(75 + 5 * 50, 50, 125, 125);
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
        YellowStart.setBounds(617, 625, 125, 125);
        this.add(YellowStart);

        for (int i = 58; i < 72; i++) {
            squares.get(i).setText(" " + (i) + " ");
            squares.get(i).setBackground(Color.WHITE);
            squares.get(i).setOpaque(true);
            squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
            squares.get(i).setBounds(150, 650 - (i - 59) * 50, 50, 50); //left edge
            this.add(squares.get(i));
        }

    }

    private void change_turn(Controller controller, JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
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


}
