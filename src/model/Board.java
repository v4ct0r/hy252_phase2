package model;

import model.Square.*;

public class Board {
    public Square [] squares = new Square[72];

    public Board(){
        initializeSquares(squares);
    }

    private void initializeSquares(Square[] squares) {
        for(int i=0;i<72;i++) {

            //SLIDES RED
            if (i == 1)
                squares[i] = new Start_Slide_Square(i, "red", 10);
            else if (i ==16)
                squares[i] = new Start_Slide_Square(i, "red", 20);
            else if (i == 2 || i == 9 || i > 15 && i < 20)
                squares[i] = new Internal_Slide_Square(i, "red");
            else if (i == 10 || i == 20)
                squares[i] = new End_Slide_Square(i, "red");
            //Safety Zone Red
            else if (i > 2 && i<8)
                squares[i] = new Safety_Zone_Square(i, "red");
            //Home Red
            else if (i ==8)
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
            else
                squares[i] = new Simple_Square(i);
        }
    }



}

