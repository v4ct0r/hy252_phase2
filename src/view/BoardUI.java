package view;

import controller.Controller;
import model.Square.*;
import model.card.*;
import model.player.Pawn;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class BoardUI extends JLayeredPane {
    private int prev;
    private int Simple_Flag = 0 ;
    private String prevPawn;
    private int prediction;
    private int prediction10 = -1;
    private int[] prediction7 = new int[7];
    private int flag7 =-1;
    private int flag7_help1 ;
    private int flag7_help2 ;
    private int temp11;
    private boolean flag7_bump = false;
    public static ArrayList<JButton> squares ;
    static JButton redPawn1;
    static JButton redPawn2;
    static JButton yellowPawn1;
    static JButton yellowPawn2;

    public String getPrevPawn() {
        return prevPawn;
    }

    public static JButton getRedPawn1() {
        return redPawn1;
    }

    public static JButton getRedPawn2() {
        return redPawn2;
    }

    public static JButton getYellowPawn1() {
        return yellowPawn1;
    }

    public static JButton getYellowPawn2() {
        return yellowPawn2;
    }

    Rectangle redPawn1Start;
    Rectangle redPawn2Start;
    Rectangle yellowPawn1Start;
    Rectangle yellowPawn2Start;
    Rectangle redPawn1Home;
    Rectangle redPawn2Home;
    Rectangle yellowPawn1Home;
    Rectangle yellowPawn2Home;


    /**
     * Constructor of BoardUI
     * @param controller
     * @param background
     * Here is everything that has to do with the board
     * 1)Initialize the board
     * 2)Initialize the pawns
     * Includes also the ActionListener of the paws , the Fold button and the Squares of the board
     * ActionListener of the pawns:
     * The current players pawns are enabled and the others are disabled except if the current player can capture an enemy pawn "Bumping"
     * the way it works is when the pawn is clicked the squares that the pawn can move to are highlighted with a magenta border
     * and when the square or the enemy pawn is clicked the pawn moves to that square in graphics and in the parallel board in controller
     */
    public BoardUI(Controller controller, Background background) {
        this.setLayout(null);
        this.setOpaque(true);//make the background visible
        this.setBackground(Color.CYAN);
        Image logoImage = new ImageIcon(getClass().getResource("/_sorrylogo/sorryImage.png")).getImage();
        JLabel LogoLabel = new JLabel(new ImageIcon(logoImage));
        LogoLabel.setBounds(390,300 , logoImage.getWidth(null), logoImage.getHeight(null));
        add(LogoLabel);

        //init red pawns
        redPawn1 = new JButton();
        redPawn1.setIcon(new ImageIcon(getClass().getResource("/_pawns/redPawn1.png")));
        redPawn1.setDisabledIcon(new ImageIcon(getClass().getResource("/_pawns/redPawn1.png")));
        redPawn1Start = new Rectangle(320, 75,redPawn1.getIcon().getIconWidth(),redPawn1.getIcon().getIconHeight());
        redPawn1.setBounds(redPawn1Start);
        add(redPawn1);

        redPawn2 = new JButton();
        redPawn2.setIcon(new ImageIcon(getClass().getResource("/_pawns/redPawn2.png")));
        redPawn2.setDisabledIcon(new ImageIcon(getClass().getResource("/_pawns/redPawn2.png")));
        redPawn2Start = new Rectangle(375, 75, redPawn2.getIcon().getIconWidth(),redPawn2.getIcon().getIconHeight());
        redPawn2.setBounds(redPawn2Start);
        add(redPawn2);

        //init yellow pawns
        yellowPawn1 = new JButton();
        yellowPawn1.setIcon(new ImageIcon(getClass().getResource("/_pawns/yellowPawn1.png")));
        yellowPawn1.setDisabledIcon(new ImageIcon(getClass().getResource("/_pawns/yellowPawn1.png")));
        yellowPawn1Start = new Rectangle(672, 675, yellowPawn1.getIcon().getIconWidth(),yellowPawn1.getIcon().getIconHeight());
        yellowPawn1.setBounds(yellowPawn1Start);
        add(yellowPawn1);

        yellowPawn2 = new JButton();
        yellowPawn2.setIcon(new ImageIcon(getClass().getResource("/_pawns/yellowPawn2.png")));
        yellowPawn2.setDisabledIcon(new ImageIcon(getClass().getResource("/_pawns/yellowPawn2.png")));
        yellowPawn2Start = new Rectangle(727, 675, yellowPawn2.getIcon().getIconWidth(),yellowPawn2.getIcon().getIconHeight());
        yellowPawn2.setBounds(yellowPawn2Start);
        add(yellowPawn2);

        squares = new ArrayList<>();
        //init squares
        for (int i = 0; i < 72; i++) {
            squares.add(new JButton());
        }
        int k= 0;
        for (int i = 0; i < 22; i++) {
            if(i==1 || i==2 || i==9 || i==10 || i==15 || i==16 || i==17 || i==18 || i==19){
                if(i==1 || i==15) {
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/redSlideStart.png")));
                }
                    else if( i==2 || i==9 || i==16 || i==17 || i==18 ) {
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/redSlideMedium.png")));
                }
                    else {
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/redSlideEnd.png")));
                }
                squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                squares.get(i).setBounds(150 + k * 50, 0, 50, 50); //top edge
                this.add(squares.get(i));
                k++;
            }
            else {
                if(i==3 || i==4 || i==5 || i==6 || i==7){

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
            if (controller.board.squares[i] instanceof Start_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/blueSlideStart.png")));
            else if(controller.board.squares[i] instanceof Internal_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/blueSlideMedium.png")));
            else if(controller.board.squares[i] instanceof End_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/blueSlideEnd.png")));
            else
                squares.get(i).setIcon(null);
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
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/yellowSlideStart.png")));
                }
                else if(i==38 || i==45 || i==52 || i==53 || i==54  ) {
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/yellowSlideMedium.png")));
                }
                else {
                    squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/yellowSlideEnd.png")));
                }
                squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
                squares.get(i).setBounds( 850 - k * 50, 750, 50, 50);
                this.add(squares.get(i));
                k++;
            }
            else {
                if(i>38 && i<44){ //safe zone

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
            if(controller.board.squares[i] instanceof Start_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/greenSlideStart.png")));
            else if(controller.board.squares[i] instanceof Internal_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/greenSlideMedium.png")));
            else if(controller.board.squares[i] instanceof End_Slide_Square)
                squares.get(i).setIcon(new ImageIcon(getClass().getResource("/_slides/greenSlideEnd.png")));
            else
                squares.get(i).setIcon(null);
            squares.get(i).setBackground(Color.WHITE);
            squares.get(i).setOpaque(true);
            squares.get(i).setBorder(new LineBorder(Color.BLACK, 2));
            squares.get(i).setBounds(150, 650 - (i - 59) * 50, 50, 50); //left edge
            this.add(squares.get(i));
        }

        DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

        ActionListener_FoldButton(background, controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

        redPawn1.addActionListener(e -> {


            if(controller.getCurrent_player().getColor().equals("yellow")){ //BUMPING
                prediction = controller.getRed_pawn1().getPosition();
                temp11 = controller.get_pawn(prevPawn).getPosition();
                controller.play(controller.get_pawn(prevPawn), prediction);
                redPawn1.setBorder(null);
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    redPawn1.setBounds(redPawn1Start);
                else
                    redPawn1.setBounds(squares.get(temp11).getBounds());
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    if(prev>=0)
                        squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                }
                if(flag7_bump){
                    prevPawnUI().setEnabled(false);
                    flag7_bump = false;
                    flag7 = flag7_help1;
                    if(flag7==7){
                        flag7 = -1;
                        switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    }
                    fix_squares_border();
                    return;
                }


                if(controller.getCurrent_card() instanceof Simple_Number_Card){
                    if( controller.teammate(controller.get_pawn(prevPawn)).isStart() || controller.teammate(controller.get_pawn(prevPawn)).getHome() || !controller.teammate(controller.get_pawn(prevPawn)).isMoveable()) {
                        Simple_Flag++;
                    }
                    prevPawnUI().setEnabled(false);
                    Simple_Flag++;
                }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                fix_squares_border();
                return;
            }

            if(background.getisdrawn()) {
                if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                    if(controller.getRed_pawn2().isStart() || controller.getRed_pawn2().getHome() || !controller.getRed_pawn2().isMoveable())
                        Simple_Flag ++;
                }


                prevPawn = "redPawn1";// USED FOR BUMPING

                prev = controller.getRed_pawn1().getPosition();

                cleanSquares(squares);

                flag7_bump = false;
                if(controller.getCurrent_card() instanceof Number_SevenCard && !controller.getRed_pawn2().isStart() && !controller.getRed_pawn2().getHome() && flag7==-1){

                    fix_squares_border();

                    prediction7 = controller.predict7(controller.getRed_pawn1());
                    for(int i = 0 ; i < 7 ; i++){
                        if(prediction7[i] == controller.getRed_pawn1().getPosition()){
                            if(prediction7[i]>=0)
                                squares.get(prediction7[i]).setVisible(false);
                        }
                        if(prediction7[i]>=0)
                            squares.get(prediction7[i]).setBorder(new LineBorder(Color.MAGENTA, 3));
                    }
                    bumpingUI_for_array(prediction7 ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                    set_squares_switch_turn_for_array(controller.getRed_pawn1(), squares, redPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction7, prev, redPawn1Home);
                    return;
                }


                if(controller.predict(controller.getRed_pawn2())>=0 && !controller.getRed_pawn2().getHome()) {
                    if(controller.predict(controller.getRed_pawn2())!=controller.player1.getHomePosition())
                        squares.get(controller.predict(controller.getRed_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));//remove team pawn prediction
                    else
                        squares.get(controller.predict(controller.getRed_pawn2())).setBorder(new LineBorder(Color.RED, 7));
                    if(controller.current_card instanceof Number_TenCard)
                        squares.get(controller.predict1(controller.getRed_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                }


                prediction = controller.predict(controller.getRed_pawn1());

                if(flag7!=-1){

                    prediction = controller.predictdiff7(controller.getRed_pawn1(),7-flag7); //the move of the second pawn

                }

                if(prediction == controller.getRed_pawn1().getPosition()) {
                    if(prediction>=0)
                        squares.get(prediction).setVisible(false);
                }

                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                //CARD 10
                prediction10 = -1;
                if (controller.getCurrent_card() instanceof Number_TenCard) {
                    prediction10 = controller.predict1(controller.getRed_pawn1());

                    if (prediction10 == controller.getRed_pawn1().getPosition()) {
                        if (prediction10 >= 0)
                            squares.get(prediction10).setVisible(false);
                    }
                    if (prediction10 >= 0)
                        squares.get(prediction10).setBorder(new LineBorder(Color.MAGENTA, 3));

                    bumpingUI(prediction10 ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }

                if(controller.getCurrent_card() instanceof Number_ElevenCard){
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                    if((!controller.getRed_pawn1().isStart()) && (!controller.getRed_pawn1().isSafe())){
                        enableEnemy_for_11_Sorry( controller.getYellow_pawn1(), controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);}
                }
                if(controller.getCurrent_card() instanceof Sorry_Card){
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                    if(controller.getRed_pawn1().isStart())
                        enableEnemy_for_11_Sorry( controller.getYellow_pawn1(), controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }

                bumpingUI(prediction ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);

                set_squares_switch_turn(controller.getRed_pawn1(), squares, redPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction, prev, redPawn1Home);
            }
            else
                JOptionPane.showMessageDialog(background, "You must draw a card first!");
        });

        redPawn2.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("yellow")){//BUMPING
                prediction = controller.getRed_pawn2().getPosition();
                temp11 = controller.get_pawn(prevPawn).getPosition();
                controller.play(controller.get_pawn(prevPawn), prediction);

                redPawn2.setBorder(null);

                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    redPawn2.setBounds(redPawn2Start);
                else{
                    redPawn2.setBounds(squares.get(temp11).getBounds());
                }
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    if(prev>=0)
                        squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                }
                if(flag7_bump){
                    prevPawnUI().setEnabled(false);
                    flag7_bump = false;
                    flag7 = flag7_help2;
                    if(flag7==7){
                        flag7 = -1;
                        switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    }
                    fix_squares_border();
                    return;
                }
                if(controller.getCurrent_card() instanceof Simple_Number_Card){
                    if( controller.teammate(controller.get_pawn(prevPawn)).isStart() || controller.teammate(controller.get_pawn(prevPawn)).getHome()) {
                        Simple_Flag++;
                    }
                    prevPawnUI().setEnabled(false);
                    Simple_Flag++;
                }
                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                fix_squares_border();
                return;
            }

            if(background.getisdrawn()) {
                if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                    if(controller.getRed_pawn1().isStart() || controller.getRed_pawn1().getHome() || !controller.getRed_pawn1().isMoveable())
                        Simple_Flag ++;
                }


                prevPawn = "redPawn2";// USED FOR BUMPING


                prev = controller.getRed_pawn2().getPosition();

                cleanSquares(squares);

                flag7_bump = false;
                if(controller.getCurrent_card() instanceof Number_SevenCard && !controller.getRed_pawn1().isStart() && !controller.getRed_pawn1().getHome() && flag7==-1){
                    fix_squares_border();

                    prediction7 = controller.predict7(controller.getRed_pawn2());
                    for(int i = 0 ; i < 7 ; i++){
                        if(prediction7[i] == controller.getRed_pawn2().getPosition()){
                            if(prediction7[i]>=0)
                                squares.get(prediction7[i]).setVisible(false);
                        }
                        if(prediction7[i]>=0)
                            squares.get(prediction7[i]).setBorder(new LineBorder(Color.MAGENTA, 3));

                    }
                    bumpingUI_for_array(prediction7 ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);

                    set_squares_switch_turn_for_array(controller.getRed_pawn2(), squares, redPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction7, prev, redPawn2Home);

                    return;
                }


                if(controller.predict(controller.getRed_pawn1())>=0 && !controller.getRed_pawn1().getHome()) {
                    if(controller.predict(controller.getRed_pawn1())!=controller.player1.getHomePosition())
                        squares.get(controller.predict(controller.getRed_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));//remove team pawn prediction
                    else
                        squares.get(controller.predict(controller.getRed_pawn1())).setBorder(new LineBorder(Color.RED, 7));
                    if(controller.current_card instanceof Number_TenCard)
                        squares.get(controller.predict1(controller.getRed_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                }
                prediction = controller.predict(controller.getRed_pawn2());


                if(flag7!=-1){

                    prediction = controller.predictdiff7(controller.getRed_pawn2(),7-flag7); //the move of the second pawn

                }

                if(prediction == controller.getRed_pawn2().getPosition()){
                    if(prediction>=0)
                        squares.get(prediction).setVisible(false);
                }

                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                //CARD 10
                prediction10 = -1;
                if (controller.getCurrent_card() instanceof Number_TenCard) {
                    prediction10 = controller.predict1(controller.getRed_pawn2());

                    if (prediction10 == controller.getRed_pawn2().getPosition()) {
                        if (prediction10 >= 0)
                            squares.get(prediction10).setVisible(false);
                    }
                    if (prediction10 >= 0)
                        squares.get(prediction10).setBorder(new LineBorder(Color.MAGENTA, 3));

                    bumpingUI(prediction10 ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }

                if(controller.getCurrent_card() instanceof Number_ElevenCard){
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                    if((!controller.getRed_pawn2().isStart()) && (!controller.getRed_pawn2().isSafe()))
                        enableEnemy_for_11_Sorry( controller.getYellow_pawn1(), controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }
                if(controller.getCurrent_card() instanceof Sorry_Card){
                    disable_enemy_pawns( yellowPawn1, yellowPawn2);
                    if(controller.getRed_pawn2().isStart())
                        enableEnemy_for_11_Sorry( controller.getYellow_pawn1(), controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);
                }

                bumpingUI(prediction ,controller.getYellow_pawn1() , controller.getYellow_pawn2(), yellowPawn1, yellowPawn2);

                set_squares_switch_turn(controller.getRed_pawn2(), squares, redPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction, prev,redPawn2Home);

            }
            else
                JOptionPane.showMessageDialog(background, "You must draw a card first!");
        });
        yellowPawn1.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("red")){//BUMPING
                prediction = controller.getYellow_pawn1().getPosition();
                temp11 = controller.get_pawn(prevPawn).getPosition();
                controller.play(controller.get_pawn(prevPawn), prediction);
                yellowPawn1.setBorder(null);
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    yellowPawn1.setBounds(yellowPawn1Start);
                else
                    yellowPawn1.setBounds(squares.get(temp11).getBounds());
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    if(prev>=0)
                     squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));

                if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                    refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                    prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                }
                if(flag7_bump){
                    prevPawnUI().setEnabled(false);
                    flag7_bump = false;
                    flag7 = flag7_help1;
                    if(flag7==7){
                        flag7 = -1;
                        switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    }
                    fix_squares_border();
                    return;
                }
                if(controller.getCurrent_card() instanceof Simple_Number_Card){
                    if( controller.teammate(controller.get_pawn(prevPawn)).isStart() || controller.teammate(controller.get_pawn(prevPawn)).getHome() || !controller.teammate(controller.get_pawn(prevPawn)).isMoveable()) {
                        Simple_Flag++;
                    }
                    prevPawnUI().setEnabled(false);
                    Simple_Flag++;
                }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                fix_squares_border();
                return;
            }
            if(background.getisdrawn()) {
                if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                    if(controller.getYellow_pawn2().isStart() || controller.getYellow_pawn2().getHome() || !controller.getYellow_pawn2().isMoveable())
                        Simple_Flag ++;
                }

                prevPawn = "yellowPawn1";// USED FOR BUMPING

                prev = controller.getYellow_pawn1().getPosition();

                cleanSquares(squares);

                flag7_bump = false;
                if(controller.getCurrent_card() instanceof Number_SevenCard && !controller.getYellow_pawn2().isStart() && !controller.getYellow_pawn2().getHome() && flag7==-1){
                    fix_squares_border();

                    prediction7 = controller.predict7(controller.getYellow_pawn1());
                    for(int i = 0 ; i < 7 ; i++){
                        if(prediction7[i] == controller.getYellow_pawn1().getPosition()){
                            if(prediction7[i]>=0)
                                squares.get(prediction7[i]).setVisible(false);
                        }
                        if(prediction7[i]>=0)
                            squares.get(prediction7[i]).setBorder(new LineBorder(Color.MAGENTA, 3));
                    }
                    bumpingUI_for_array(prediction7 ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                    set_squares_switch_turn_for_array(controller.getYellow_pawn1(), squares, yellowPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction7, prev, yellowPawn1Home);
                    return;
                }


                if(controller.predict(controller.getYellow_pawn2())>=0 && !controller.getYellow_pawn2().getHome()){//remove team pawn prediction
                    if(controller.predict(controller.getYellow_pawn2())!=controller.player2.getHomePosition())
                        squares.get(controller.predict(controller.getYellow_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));
                    else
                        squares.get(controller.predict(controller.getYellow_pawn2())).setBorder(new LineBorder(Color.YELLOW, 7));
                    if(controller.current_card instanceof Number_TenCard)
                        squares.get(controller.predict1(controller.getYellow_pawn2())).setBorder(new LineBorder(Color.BLACK, 2));
                    disable_enemy_pawns( redPawn1, redPawn2);
                }

                prediction = controller.predict(controller.getYellow_pawn1());

                if(flag7!=-1){
                    prediction = controller.predictdiff7(controller.getYellow_pawn1(),7-flag7);//the move of the second pawn
                }

                if(prediction == controller.getYellow_pawn1().getPosition()){
                    if(prediction>=0)
                        squares.get(prediction).setVisible(false);
                }

                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                prediction10 = -1;
                if (controller.getCurrent_card() instanceof Number_TenCard) {
                    prediction10 = controller.predict1(controller.getYellow_pawn1());

                    if (prediction10 == controller.getYellow_pawn1().getPosition()) {
                        if (prediction10 >= 0)
                            squares.get(prediction10).setVisible(false);
                    }
                    if (prediction10 >= 0)
                        squares.get(prediction10).setBorder(new LineBorder(Color.MAGENTA, 3));

                    bumpingUI(prediction10 ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                }


                if(controller.getCurrent_card() instanceof Number_ElevenCard){
                    disable_enemy_pawns( redPawn1, redPawn2);
                    if((!controller.getYellow_pawn1().isStart())&&(!controller.getYellow_pawn1().isSafe()))
                        enableEnemy_for_11_Sorry( controller.getRed_pawn1(), controller.getRed_pawn2(), redPawn1, redPawn2);
                }

                if(controller.getCurrent_card() instanceof Sorry_Card){
                    disable_enemy_pawns( redPawn1, redPawn2);
                    if(controller.getYellow_pawn1().isStart())
                        enableEnemy_for_11_Sorry( controller.getRed_pawn1(), controller.getRed_pawn2(), redPawn1, redPawn2);
                }


                bumpingUI(prediction ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);

                set_squares_switch_turn(controller.getYellow_pawn1(), squares, yellowPawn1,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction, prev, yellowPawn1Home);
            }
            else
                JOptionPane.showMessageDialog(background, "You must draw a card first!");
        });
        yellowPawn2.addActionListener(e -> {

            if(controller.getCurrent_player().getColor().equals("red")){//BUMPING
                prediction = controller.getYellow_pawn2().getPosition();
                temp11 = controller.get_pawn(prevPawn).getPosition();
                controller.play(controller.get_pawn(prevPawn), prediction);
                yellowPawn2.setBorder(null);
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    yellowPawn2.setBounds(yellowPawn2Start);
                else
                    yellowPawn2.setBounds(squares.get(temp11).getBounds());
                if(!(controller.getCurrent_card() instanceof Number_ElevenCard))
                    if(prev>=0)
                        squares.get(prev).setVisible(true);
                prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
                squares.get(controller.get_pawn(prevPawn).getPosition()).setBorder(new LineBorder(Color.BLACK, 2));


              if(controller.check_for_slide(controller.get_pawn(prevPawn))){
                  refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                  prevPawnUI().setBounds(squares.get(controller.get_pawn(prevPawn).getPosition()).getBounds());
              }
              if(flag7_bump){
                    prevPawnUI().setEnabled(false);
                    flag7_bump = false;
                    flag7 = flag7_help2;
                    if(flag7==7){
                        flag7 = -1;
                        switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    }
                  fix_squares_border();
                  return;
              }
              if(controller.getCurrent_card() instanceof Simple_Number_Card) {
                  if (controller.teammate(controller.get_pawn(prevPawn)).isStart() || controller.teammate(controller.get_pawn(prevPawn)).getHome()) {
                      Simple_Flag++;
                  }
                  prevPawnUI().setEnabled(false);
                  Simple_Flag++;
              }

                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                fix_squares_border();
                return;

            }

            if(background.getisdrawn()) {
                if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                    if(controller.getYellow_pawn1().isStart() || controller.getYellow_pawn1().getHome() || !controller.getYellow_pawn1().isMoveable())
                        Simple_Flag ++;
                }


                prevPawn = "yellowPawn2"; // USED FOR BUMPING

                prev = controller.getYellow_pawn2().getPosition();

                cleanSquares(squares);

                flag7_bump = false;

                if(controller.getCurrent_card() instanceof Number_SevenCard && !controller.getYellow_pawn1().isStart() && !controller.getYellow_pawn1().getHome() && flag7==-1){
                    fix_squares_border();

                    prediction7 = controller.predict7(controller.getYellow_pawn2());
                    for(int i = 0 ; i < 7 ; i++){
                        if(prediction7[i] == controller.getYellow_pawn2().getPosition()){
                            if(prediction7[i]>=0)
                                squares.get(prediction7[i]).setVisible(false);
                        }
                        if(prediction7[i]>=0)
                            squares.get(prediction7[i]).setBorder(new LineBorder(Color.MAGENTA, 3));
                    }
                    bumpingUI_for_array(prediction7 ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                    set_squares_switch_turn_for_array(controller.getYellow_pawn2(), squares, yellowPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction7, prev, yellowPawn2Home);
                    return;
                }

                if(controller.predict(controller.getYellow_pawn1())>=0 && !controller.getYellow_pawn1().getHome()) {//remove team pawn prediction
                    if (controller.predict(controller.getYellow_pawn1()) != controller.player2.getHomePosition())
                        squares.get(controller.predict(controller.getYellow_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));
                    else
                        squares.get(controller.predict(controller.getYellow_pawn1())).setBorder(new LineBorder(Color.YELLOW, 7));
                    if (controller.current_card instanceof Number_TenCard)
                        squares.get(controller.predict1(controller.getYellow_pawn1())).setBorder(new LineBorder(Color.BLACK, 2));
                    disable_enemy_pawns(redPawn1, redPawn2);
                }
                prediction = controller.predict(controller.getYellow_pawn2());

                if(flag7!=-1){
                    prediction = controller.predictdiff7(controller.getYellow_pawn2(),7-flag7);//the move of the second pawn
                }

                if(prediction == controller.getYellow_pawn2().getPosition()) {
                    if(prediction>=0)
                        squares.get(prediction).setVisible(false);
                }

                if(prediction>=0)
                    squares.get(prediction).setBorder(new LineBorder(Color.MAGENTA, 3));

                prediction10 = -1;
                if (controller.getCurrent_card() instanceof Number_TenCard) {
                    prediction10 = controller.predict1(controller.getYellow_pawn2());

                    if (prediction10 == controller.getYellow_pawn2().getPosition()) {
                        if (prediction10 >= 0)
                            squares.get(prediction10).setVisible(false);
                    }
                    if (prediction10 >= 0)
                        squares.get(prediction10).setBorder(new LineBorder(Color.MAGENTA, 3));

                    bumpingUI(prediction10 ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);
                }
                if(controller.getCurrent_card() instanceof Number_ElevenCard){
                    disable_enemy_pawns( redPawn1, redPawn2);
                    if((!controller.getYellow_pawn2().isStart())&&(!controller.getYellow_pawn2().isSafe()))
                        enableEnemy_for_11_Sorry( controller.getRed_pawn1(), controller.getRed_pawn2(), redPawn1, redPawn2);
                }

                if(controller.getCurrent_card() instanceof Sorry_Card){
                    disable_enemy_pawns( redPawn1, redPawn2);
                    if(controller.getYellow_pawn2().isStart())
                        enableEnemy_for_11_Sorry( controller.getRed_pawn1(), controller.getRed_pawn2(), redPawn1, redPawn2);
                }

                bumpingUI(prediction ,controller.getRed_pawn1() , controller.getRed_pawn2(), redPawn1, redPawn2);

                set_squares_switch_turn(controller.getYellow_pawn2(), squares, yellowPawn2,controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background, prediction, prev,yellowPawn2Home);
            }
            else
                JOptionPane.showMessageDialog(background, "You must draw a card first!");
        });
    }

    /**
     * @param enemyPawnUI1
     * @param enemyPawnUI2
     * Disables the enemy pawns and resets their border
     */
    private void disable_enemy_pawns(JButton enemyPawnUI1, JButton enemyPawnUI2) {
        enemyPawnUI1.setBorder(null);
        enemyPawnUI2.setBorder(null);
        enemyPawnUI1.setEnabled(false);
        enemyPawnUI2.setEnabled(false);
    }

    /**
     * Refreshes pawns border and the board
     */
    public static void fix_squares_border() {
        //fix pawn border too
        redPawn1.setBorder(null);
        redPawn2.setBorder(null);
        yellowPawn1.setBorder(null);
        yellowPawn2.setBorder(null);
        for(int i=0; i<72; i++){
           if(i != 8 && i !=44)
                squares.get(i).setBorder(new LineBorder(Color.black, 2));
           else if(i==8)
               squares.get(i).setBorder(new LineBorder(Color.RED, 7));
           else
               squares.get(i).setBorder(new LineBorder(Color.YELLOW, 7));
        }
    }
    /**
     * prevPawn is a global variable that is used for bumping
     * @return the previous pawn that was clicked
     * (ex. red player can capture yellow player's pawn, so prevPawn is redPawn1 or redPawn2 so when the yellow pawn is clicked to know which pawn captured it)
     */
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

    /**
     * @param squares
     * removes all the action listeners from the squares
     */

    private static void cleanSquares(ArrayList<JButton> squares) {
        for(int i=0; i<72; i++)
            for(ActionListener al : squares.get(i).getActionListeners())
                squares.get(i).removeActionListener(al);

    }

    /**
     * used to call cleanSquares when the new card is drawn
     */
    public static void getcleanSquares() {
        cleanSquares(squares) ;
    }

    /**
     * @param prediction7
     * @param enemyPawn1
     * @param enemyPawn2
     * @param enemyPawnUI1
     * @param enemyPawnUI2
     * in card 7 if the prediction array contains the enemy pawn position then enable it so the player can bump it
     */
    private void bumpingUI_for_array(int[] prediction7, Pawn enemyPawn1, Pawn enemyPawn2, JButton enemyPawnUI1, JButton enemyPawnUI2) {
        enemyPawnUI1.setBorder(null);
        enemyPawnUI2.setBorder(null);
        for(int i = 0 ; i < 7 ; i++){
            if(prediction7[i] == enemyPawn1.getPosition()){
                flag7_bump = true;
                flag7_help1 = i + 1 ;
                this.prediction = enemyPawn1.getPosition();
                enemyPawnUI1.setEnabled(true);
                enemyPawnUI1.setBorder(new LineBorder(Color.MAGENTA, 3));
            }
            else if(prediction7[i] == enemyPawn2.getPosition()){
                flag7_bump = true;
                flag7_help2 = i + 1 ;
                this.prediction = enemyPawn2.getPosition();
                enemyPawnUI2.setEnabled(true);
                enemyPawnUI2.setBorder(new LineBorder(Color.MAGENTA, 3));
            }
        }
    }

    /**
     * @param enemyPawn1
     * @param enemyPawn2
     * @param enemyPawnUI1
     * @param enemyPawnUI2
     * in card 11 and sorry if the enemy pawn is not safe and not in home and not in start then enable it so the player can swap it (11) or capture it (sorry)
     */
    private void enableEnemy_for_11_Sorry(Pawn enemyPawn1, Pawn enemyPawn2, JButton enemyPawnUI1, JButton enemyPawnUI2) {
        if(!enemyPawn1.isSafe() && !enemyPawn1.getHome() && !enemyPawn1.isStart()){
            enemyPawnUI1.setEnabled(true);
            enemyPawnUI1.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
        if(!enemyPawn2.isSafe() && !enemyPawn2.getHome() && !enemyPawn2.isStart()){
            enemyPawnUI2.setEnabled(true);
            enemyPawnUI2.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
    }

    /**
     * @param prediction
     * @param enemyPawn1
     * @param enemyPawn2
     * @param enemyPawnUI1
     * @param enemyPawnUI2
     * enables the enemy pawn if the prediction is the enemy pawn position so the player can bump it
     */
    private void bumpingUI(int prediction, Pawn enemyPawn1, Pawn enemyPawn2, JButton enemyPawnUI1, JButton enemyPawnUI2) {
        if(prediction == enemyPawn1.getPosition()){
            enemyPawnUI1.setEnabled(true);
            enemyPawnUI1.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
        if(prediction == enemyPawn2.getPosition()){
            enemyPawnUI2.setEnabled(true);
            enemyPawnUI2.setBorder(new LineBorder(Color.MAGENTA, 3));
        }
    }

    /**
     * @param pawn
     * @param squares
     * @param pawnUI
     * @param controller
     * @param redPawn1
     * @param redPawn2
     * @param yellowPawn1
     * @param yellowPawn2
     * @param background
     * @param prediction7
     * @param prev
     * @param Home
     * Every action listener of the squares in the board when card 7 is drawn
     */
    private void set_squares_switch_turn_for_array(Pawn pawn, ArrayList<JButton> squares, JButton pawnUI, Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, Background background, int[] prediction7, int prev, Rectangle Home) {
        for(int i=0 ; i<72 ;i++){
            if(i != prediction7[0] && i != prediction7[1] && i != prediction7[2] && i != prediction7[3] && i != prediction7[4] && i != prediction7[5] && i != prediction7[6]){
                squares.get(i).addActionListener(e -> {
                    JOptionPane.showMessageDialog(this, "You can't move there!");
                });

            }
            else {
                for (int j = 0; j < 7; j++) {
                    if(i == prediction7[j]){
                        int finalJ = j;
                        squares.get(i).addActionListener(e -> {
                            controller.play(pawn, prediction7[finalJ]);
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.BLACK, 2));
                            if(!pawn.getHome()) {
                                pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                            }
                            else {
                                if(Objects.equals(pawn.getColor(), "red")) {
                                    squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.RED, 7));
                                }
                                else {
                                    squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.YELLOW, 7));
                                }
                                pawnUI.setBounds(Home);
                            }
                            if(prev>=0) {
                                squares.get(prev).setVisible(true);
                            }
                            if(!pawn.getHome()){
                                if(pawn.getPosition()>=0) {
                                    squares.get(pawn.getPosition()).setVisible(false);
                                }
                            }
                            else{
                                this.add(pawnUI, JLayeredPane.PALETTE_LAYER); //pawnUI OVERLAPS the square HOME
                            }

                            if(controller.check_for_slide(pawn)){
                                refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                                pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                            }


                            if(controller.game_has_finished()){
                                JOptionPane.showMessageDialog(this, controller.current_player.getColor() + " player has won!");
                                background.dispose();
                                new GameView(new Controller());
                            }


                            if (pawn.getHome()) {
                                pawnUI.setEnabled(false);
                            }
                            cleanSquares(squares);


                            pawnUI.setEnabled(false);

                            flag7 = finalJ + 1;
                            if(flag7==7){
                                flag7=-1;
                                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                                fix_squares_border();
                                return;
                            }
                            if(controller.teammate(pawn).isStart()){//for the case that the pawn capture the other same color one in controller.check_for_slide(pawn)
                                flag7=-1;
                                switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                            }
                            fix_squares_border();
                        });

                    }
                }
            }
        }
    }

    /**
     *
     * @param pawn
     * @param squares
     * @param pawnUI
     * @param controller
     * @param redPawn1
     * @param redPawn2
     * @param yellowPawn1
     * @param yellowPawn2
     * @param background
     * @param prediction
     * @param prev
     * @param Home
     * Every action listener of the squares in the board
     */

    private void set_squares_switch_turn(Pawn pawn, ArrayList<JButton> squares, JButton pawnUI, Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, Background background, int prediction, int prev, Rectangle Home) {

        for(int i=0; i<72; i++){
            //go to action listener of each square and unable all of them except the current pawn position
            if(i != prediction && i != prediction10){
                squares.get(i).addActionListener(e -> {
                    JOptionPane.showMessageDialog(this, "You can't move there!");
                });

            }
            else if(i == prediction){
                squares.get(i).addActionListener(e -> {
                    controller.play(pawn, prediction);
                    squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.BLACK, 2));
                    if(!pawn.getHome()) {
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }
                    else {
                        if(Objects.equals(pawn.getColor(), "red")) {
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.RED, 7));
                        }
                        else {
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.YELLOW, 7));
                        }
                        pawnUI.setBounds(Home);
                    }
                    if(prev>=0) {
                        squares.get(prev).setVisible(true);
                    }
                    if(!pawn.getHome()){
                        if(pawn.getPosition()>=0) {
                            squares.get(pawn.getPosition()).setVisible(false);
                        }
                    }
                    else{
                        this.add(pawnUI, JLayeredPane.PALETTE_LAYER); //pawnUI OVERLAPS the square HOME
                    }

                    if(controller.check_for_slide(pawn)){
                        refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }

                    if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                        if(controller.theotherpawn(pawn).isStart() || controller.theotherpawn(pawn).getHome() || !controller.theotherpawn(pawn).isMoveable())
                            Simple_Flag ++;
                        pawnUI.setEnabled(false);
                        Simple_Flag ++;
                    }
                    if(controller.getCurrent_card() instanceof Number_TenCard ){
                        if(prediction10>=0)
                            squares.get(prediction10).setBorder(new LineBorder(Color.BLACK, 2));
                    }

                    flag7=-1;

                    if(controller.game_has_finished()){
                        JOptionPane.showMessageDialog(this, controller.current_player.getColor() + " player has won!");
                        background.dispose();
                        GameView game = new GameView(new Controller());
                    }

                    switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    if (pawn.getHome()) {
                        pawnUI.setEnabled(false);
                    }
                    cleanSquares(squares);
                    fix_squares_border();
                });
            }else if(i == prediction10){
                squares.get(i).addActionListener(e -> {

                    controller.play(pawn, prediction10);
                    squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.BLACK, 2));
                    if(!pawn.getHome()) {
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }
                    else {
                        if(Objects.equals(pawn.getColor(), "red")) {
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.RED, 7));
                        }
                        else {
                            squares.get(pawn.getPosition()).setBorder(new LineBorder(Color.YELLOW, 7));
                        }
                        pawnUI.setBounds(Home);
                    }
                    if(prev>=0) {
                        squares.get(prev).setVisible(true);
                    }
                    if(!pawn.getHome()){
                        if(pawn.getPosition()>=0) {
                            squares.get(pawn.getPosition()).setVisible(false);
                        }
                    }
                    else{
                        this.add(pawnUI, JLayeredPane.PALETTE_LAYER); //pawnUI OVERLAPS the square HOME
                    }

                    if(controller.check_for_slide(pawn)){
                        refresh_all_the_pawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, squares);
                        pawnUI.setBounds(squares.get(pawn.getPosition()).getBounds());
                    }

                    if(controller.getCurrent_card() instanceof Simple_Number_Card ){
                        if(controller.theotherpawn(pawn).isStart() || controller.theotherpawn(pawn).getHome() || !controller.theotherpawn(pawn).isMoveable())
                            Simple_Flag ++;
                        pawnUI.setEnabled(false);
                        Simple_Flag ++;
                    }
                    if(controller.getCurrent_card() instanceof Number_TenCard ){
                        if(prediction>=0)
                            squares.get(prediction).setBorder(new LineBorder(Color.BLACK, 2));
                    }


                    if(controller.game_has_finished()){
                        JOptionPane.showMessageDialog(this, controller.current_player.getColor() + " player has won!");
                        background.dispose();
                        new GameView(new Controller());
                    }

                    switch_turn(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2, background);
                    if (pawn.getHome()) {
                        pawnUI.setEnabled(false);
                    }
                    cleanSquares(squares);
                    fix_squares_border();
                });


            }

        }
    }

    /**
     * @param controller
     * @param redPawn1
     * @param redPawn2
     * @param yellowPawn1
     * @param yellowPawn2
     * @param squares
     * Refreshes all the pawns and squares
     */

    private void refresh_all_the_pawns(Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2, ArrayList<JButton> squares) {
        if(controller.getYellow_pawn1().getPosition() == controller.player2.getStartPosition())
            yellowPawn1.setBounds(yellowPawn1Start);
        if(controller.getYellow_pawn2().getPosition() == controller.player2.getStartPosition())
            yellowPawn2.setBounds(yellowPawn2Start);

        if(controller.getRed_pawn1().getPosition() == controller.player1.getStartPosition())
            redPawn1.setBounds(redPawn1Start);
        if(controller.getRed_pawn2().getPosition() == controller.player1.getStartPosition())
            redPawn2.setBounds(redPawn2Start);

        //make all the squares visible except the current pawn position
        for(int i=0; i<72; i++) {
            if (i != controller.getYellow_pawn1().getPosition() && i != controller.getYellow_pawn2().getPosition() && i != controller.getRed_pawn1().getPosition() && i != controller.getRed_pawn2().getPosition()) {
                    squares.get(i).setVisible(true);
            } else {
                if(i != controller.player1.getHomePosition() && i != controller.player2.getHomePosition())
                    squares.get(i).setVisible(false);
            }
        }
    }

    /**
     * @param background
     * @param controller
     * @param redPaw1
     * @param redPaw2
     * @param yellowPaw1
     * @param yellowPaw2
     * Action listener for the fold button
     */
    private void ActionListener_FoldButton(Background background, Controller controller, JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
        background.Fold.addActionListener(e -> {

            refresh_paws_border(redPaw1, redPaw2, yellowPaw1, yellowPaw2);
            controller.switch_current_player(controller.player1, controller.player2);
            DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);

            if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
                background.InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
            else
                background.InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
            background.InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n");
            background.ReceiveCard.setEnabled(true);


            background.setiIsdrawn(false);
            background.Fold.setEnabled(false);
            background.Fold.setVisible(false);
        });
    }

    /**
     * @param redPaw1
     * @param redPaw2
     * @param yellowPaw1
     * @param yellowPaw2
     * Refreshes the pawns border to null
     */
    private void refresh_paws_border(JButton redPaw1, JButton redPaw2, JButton yellowPaw1, JButton yellowPaw2) {
        redPaw1.setBorder(null);
        redPaw2.setBorder(null);
        yellowPaw1.setBorder(null);
        yellowPaw2.setBorder(null);
    }

    /**
     * @param controller
     * @param redPaw1
     * @param redPaw2
     * @param yellowPaw1
     * @param yellowPaw2
     * Disables the pawns that are not the current player's pawns
     * Also disables the pawns that are in home
     */
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

    /**
     * @param controller
     * @param redPawn1
     * @param redPawn2
     * @param yellowPawn1
     * @param yellowPawn2
     * @param background
     * Switches the turn of the players
     */
    private void switch_turn(Controller controller, JButton redPawn1, JButton redPawn2, JButton yellowPawn1, JButton yellowPawn2 , Background background) {

        if(controller.getCurrent_card() instanceof Simple_Number_Card) {
            if(Simple_Flag < 2) {
                return;
            }
        }
        Simple_Flag = 0;
        flag7 = -1;

        if(!(controller.getCurrent_card() instanceof Number_TwoCard) ) {
            controller.switch_current_player(controller.player1, controller.player2);
            DisablenotCurrentPlayerPawns(controller, redPawn1, redPawn2, yellowPawn1, yellowPawn2);
        }
        cleanSquares(squares);
        if(Objects.equals(controller.getCurrent_player().getColor(), "red"))//return the current player
            background.InfoBox.setText("Info Box\n\nTurn: Player 1 (Red)\n");
        else
            background.InfoBox.setText("Info Box\n\nTurn: Player 2 (Yellow)\n");
        background.InfoBox.append("Cards left: " + controller.deck.getCardsLeft() + "\n");

        background.ReceiveCard.setEnabled(true);
        background.setiIsdrawn(false);

    }
}