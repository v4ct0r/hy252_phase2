package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.util.ArrayList;

public class BoardUI extends JPanel {
    private JLabel StartLabel;
    private JButton FoldButton;
    private JButton Cards;


    public BoardUI() {
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
        JButton redPaw1 = new JButton();
        redPaw1.setIcon(new ImageIcon("src\\_pawns\\redPawn1.png"));
        redPaw1.setBounds(335, 75, 50, 50);
        this.add(redPaw1);
        JButton redPaw2 = new JButton();
        redPaw2.setIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPaw2.setBounds(390, 75, 50, 50);
        this.add(redPaw2);

        //init yellow pawns
        JButton yellowPaw1 = new JButton();
        yellowPaw1.setIcon(new ImageIcon("src\\_pawns\\yellowPawn1.png"));
        yellowPaw1.setBounds(627, 675, 50, 50);
        this.add(yellowPaw1);
        JButton yellowPaw2 = new JButton();
        yellowPaw2.setIcon(new ImageIcon("src\\_pawns\\yellowPawn2.png"));
        yellowPaw2.setBounds(682, 675, 50, 50);
        this.add(yellowPaw2);


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

/*
        JButton redPaw2 = new JButton();
        redPaw2.setIcon(new ImageIcon("src\\_pawns\\redPawn2.png"));
        redPaw2.setBounds(200, 0, 50, 50);
        this.add(redPaw2);




        this.redSlideStart = new ImageIcon("src\\_slides\\redSlideStart.png").getImage();
        this.redSlideMedium = new ImageIcon("src\\_slides\\redSlideMedium.png").getImage();
        this.redSlideEnd = new ImageIcon("src\\_slides\\redSlideEnd.png").getImage();


        this.YellowSlideStart = new ImageIcon("src\\_slides\\YellowSlideStart.png").getImage();
        this.YellowSlideMedium = new ImageIcon("src\\_slides\\YellowSlideMedium.png").getImage();
        this.YellowSlideEnd = new ImageIcon("src\\_slides\\YellowSlideEnd.png").getImage();

        this.HomeImage = new ImageIcon("src\\view\\images\\Home.png").getImage();
        this.HomeLabel = new JLabel();
        this.StartImage = new ImageIcon("src\\view\\images\\Start.png").getImage();
        this.StartLabel = new JLabel();
        this.Pawn = new JPanel();
        this.PawnButton = new JButton();
        this.PawnImages = new ImageIcon("src\\view\\images\\Pawn.png").getImage();
        this.FoldButton = new JButton();
        this.Cards = new JButton();
        */
    }


    
}
