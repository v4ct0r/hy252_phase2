package view;

import javax.swing.*;

public class GameView {


    public GameView() {
        Backround backround = new Backround();
        Menu menu = new Menu();

        // Add the toolbar to the Backround
        backround.getLayeredPane().add(menu.getToolBar(), JLayeredPane.PALETTE_LAYER);

        // Pack and make the Backround visible
        backround.setBounds(0, 0, backround.getPreferredSize().width, backround.getPreferredSize().height);
        backround.setVisible(true);

        // Now set the bounds of the toolbar
        menu.getToolBar().setBounds(0, 0, backround.getWidth(), 30);

        // Create the BoardUI and add it to the Backround
        BoardUI boardUI = new BoardUI();
        backround.getLayeredPane().add(boardUI, JLayeredPane.MODAL_LAYER);
        int menuHeight = menu.getToolBar().getHeight();
        boardUI.setBounds(-150, menuHeight , backround.getWidth()-397, backround.getHeight() - menuHeight - 207);


    }
}