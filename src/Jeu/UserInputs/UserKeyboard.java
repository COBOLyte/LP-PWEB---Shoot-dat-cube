package Jeu.UserInputs;

import Jeu.GLHandler.GLHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserKeyboard implements KeyListener {
    private final GLHandler events;

    public UserKeyboard(GLHandler events) {
        this.events = events;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Appel de méthodes de GLHandler pour déplacer le vaisseau
     *  q: Gauche, d: Droite, ESPACE: Tirer avec le vaisseau
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'q') this.events.goLeft();
        if (e.getKeyChar() == 'd') this.events.goRight();
        if (e.getKeyChar() == KeyEvent.VK_SPACE) this.events.fire();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
