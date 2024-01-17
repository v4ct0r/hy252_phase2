package view;

import controller.Controller;

import javax.swing.*;

public class GameView {

    public Background background;
    public BoardUI boardUI;

    /**
     * Constructor of the class
     * @param controller
     * Connect every graphical component of the game
     */
    public GameView(Controller controller) {

        background = new Background(controller);
        Menu menu = new Menu(background);

        // Add the toolbar to the Backround
        background.getLayeredPane().add(menu.getToolBar(), JLayeredPane.PALETTE_LAYER);


        background.setBounds(0, 0, background.getPreferredSize().width, background.getPreferredSize().height);
        background.setVisible(true);

        // Now set the bounds of the toolbar
        menu.getToolBar().setBounds(0, 0, background.getWidth(), 30);

        // Create the BoardUI and add it to the Backround
        boardUI = new BoardUI(controller, background);
        background.getLayeredPane().add(boardUI, JLayeredPane.PALETTE_LAYER);
        int menuHeight = menu.getToolBar().getHeight();
        boardUI.setBounds(-150, menuHeight , background.getWidth()-397, background.getHeight() - menuHeight - 107);


    }
}