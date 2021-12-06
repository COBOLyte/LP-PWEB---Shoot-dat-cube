package Jeu;

import java.awt.*;

import javax.swing.JFrame;

import Jeu.GLHandler.GLHandler;
import Jeu.UserInputs.UserKeyboard;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class MainGL {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GLCanvas canvas = new GLCanvas();
        GLHandler events = new GLHandler();

        // Implémente un écouteur d'événements pour les entrées au clavier
        canvas.addKeyListener(new UserKeyboard(events));
        // Permet d'initialiser la fenêtre à la taille maximale de l'écran de l'utilisateur
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        canvas.setPreferredSize(new Dimension((int) screenSize.getWidth(), (int) screenSize.getWidth()));
        canvas.addGLEventListener(events);

        frame.getContentPane().add(canvas);
        frame.setTitle("Shoot dat cube");
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        FPSAnimator anim = new FPSAnimator(canvas, 60);
        anim.start();
    }
}
