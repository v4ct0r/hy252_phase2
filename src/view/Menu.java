package view;

import javax.swing.*;

public class Menu {
    JToolBar toolBar;

    public Menu(){
        toolBar = new JToolBar("Menu");
        toolBar.setFloatable(false); // this will make the toolbar non-floating

        //toolbar options
        JButton newGame = new JButton("New Game");
        //add action to the button
        newGame.addActionListener(e -> {
            //TODO
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