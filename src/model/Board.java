package model;

import model.Square.Position;
import model.Square.Simple_Square;
import model.Square.Square;

public class Board {
    Square [][] squares = new Square[16][16];

    public Board(){
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                if(i==0||i==15 || j==0 || j==15)
                    squares[i][j]=new Simple_Square(new Position(i,j));
                else
                    squares[i][j] = null;
            }
        }
        initializeSlides(squares);
        initializeSafetyZones(squares);
        initializeHomeZones(squares);
    }

    /**
     * @param squares
     * pre-condition: no slides in the board
     * post-condition: slides are initialized
     */
    private void initializeSlides(Square[][] squares) {
        //TODO
    }
    /**
     * @param squares
     * pre-condition: no safety zones in the board
     * post-condition: safety zones are initialized
     */
    private void initializeSafetyZones(Square[][] squares) {
        //TODO
    }
    /**
     * @param squares
     * pre-condition: no home zones in the board
     * post-condition: home zones are initialized
     */
    private void initializeHomeZones(Square[][] squares) {
        //TODO
    }

}

