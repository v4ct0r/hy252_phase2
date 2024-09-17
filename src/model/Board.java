package model;

import model.Square.*;

public class Board {
    public Square [] squares = new Square[72];

    public Board(){
        initializeSquares(squares);
    }

    /**
     * @param squares
     * Initialize the squares of the board
     */
    private void initializeSquares(Square[] squares) {
        for(int i=0;i<72;i++) {
            //SLIDES RED
            if (i == 1)
                squares[i] = new Start_Slide_Square(i, "red", 10);
            else if (i ==15)
                squares[i] = new Start_Slide_Square(i, "red", 19);
            else if (i == 2 || i == 9 || i > 14 && i < 19)
                squares[i] = new Internal_Slide_Square(i, "red");
            else if (i == 10 || i == 19)
                squares[i] = new End_Slide_Square(i, "red");
            //Safety Zone Red
            else if (i > 2 && i<8)
                squares[i] = new Safety_Zone_Square(i, "red");
            //Home Red
            else if (i == 8)
                squares[i] = new Home_Square(i, "red");
            //SLIDES YELLOW
            else if (i == 37)
                squares[i] = new Start_Slide_Square(i, "yellow", 46);
            else if (i == 51)
                squares[i] = new Start_Slide_Square(i, "yellow", 55);
            else if (i == 38 || i == 45 || i > 51 && i < 55)
                squares[i] = new Internal_Slide_Square(i, "yellow");
            else if (i == 46 || i == 55)
                squares[i] = new End_Slide_Square(i, "yellow");
            else if (i > 38 && i<44)
                squares[i] = new Safety_Zone_Square(i, "yellow");
            //Home Yellow
            else if (i == 44)
                squares[i] = new Home_Square(i, "yellow");
            //SLIDES BLUE
            else if (i==22)
                squares[i] = new Start_Slide_Square(i, "blue", 25);
            else if (i==30)
                squares[i] = new Start_Slide_Square(i, "blue", 34);
            else if (i == 23 || i == 24 || i > 30 && i < 34)
                squares[i] = new Internal_Slide_Square(i, "blue");
            else if (i == 25 || i == 34)
                squares[i] = new End_Slide_Square(i, "blue");
            //SLIDES GREEN
            else if (i==58)
                squares[i] = new Start_Slide_Square(i, "green", 61);
            else if (i==65)
                squares[i] = new Start_Slide_Square(i, "green", 69);
            else if (i == 59 || i == 60 || i > 65 && i < 69)
                squares[i] = new Internal_Slide_Square(i, "green");
            else if (i == 61 || i == 69)
                squares[i] = new End_Slide_Square(i, "green");
            else
                squares[i] = new Simple_Square(i);
        }
    }



}

