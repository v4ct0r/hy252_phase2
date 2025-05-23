package view;

import controller.Controller;

import javax.swing.*;

public class Menu {
    JToolBar toolBar;
    /**
     * Constructor of the class
     * @param background
     * Creates the menu bar
     * Creates the new game button
     * Creates the save game button
     * Creates the continue saved game button
     * Creates the exit button
     * Sets the action listener of the new game button
     * Sets the action listener of the save game button
     * Sets the action listener of the continue saved game button
     * Sets the action listener of the exit button
     */
    public Menu(Background background){
        toolBar = new JToolBar("Menu");
        toolBar.setFloatable(false); // this will make the toolbar non-floating

        //toolbar options
        JButton newGame = new JButton("New Game");
        //add action to the button
        newGame.addActionListener(e -> {
            background.dispose();//shut down the current game
            GameView game = new GameView(new Controller());//start a new game
        });
        toolBar.add(newGame);
        JButton Save_Game = new JButton("Save Game");
        Save_Game.addActionListener(e -> {
            //TODO
        });
        toolBar.add(Save_Game);
        JButton Continue_Saved_Game = new JButton("Continue Saved Game");
        Continue_Saved_Game.addActionListener(e -> {
            //TODO
        });
        toolBar.add(Continue_Saved_Game);
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            System.exit(0);
        });
        toolBar.add(exit);

    }

    public JToolBar getToolBar() {
        return toolBar;
    }

}