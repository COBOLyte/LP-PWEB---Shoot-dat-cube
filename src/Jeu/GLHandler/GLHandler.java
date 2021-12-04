package Jeu.GLHandler;

import Jeu.Shapes3D.Cube3D;
import Jeu.Shapes3D.Laser3D;
import Jeu.Shapes3D.Vaisseau3D;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import java.util.ArrayList;

public class GLHandler implements GLEventListener {
    private final GLU glu;
    private double position; // Attribut permettant le suivi général de la position de l'ensemble des cubes
    private boolean hasReachedRightLimit;
    private final ArrayList<Cube3D> cubes3D;
    private final Vaisseau3D vaisseau3D;
    private Laser3D laser;

    public GLHandler() {
        this.glu = new GLU();
        this.position = 0;
        this.hasReachedRightLimit = false;
        this.laser = null;
        this.vaisseau3D = new Vaisseau3D(0, -1.5, -5, 0.1);

        this.cubes3D = new ArrayList<>();
        for (int i = -2; i <= 2; i++) {
            this.cubes3D.add(new Cube3D(i, 1.5, -5, 0.1));
            this.cubes3D.add(new Cube3D(i, 1, -5, 0.1));
            this.cubes3D.add(new Cube3D(i, 0.5, -5, 0.1));
            this.cubes3D.add(new Cube3D(i, 0, -5, 0.1));
        }
    }

    @Override
    public void init(GLAutoDrawable draw) {
        GL2 gl = draw.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
        GL2 gl = draw.getGL().getGL2();
        // SCREEN
        float aspect = (float) width / height;
        gl.glViewport(0, 0, width, height);
        // CAMERA
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        // FOCAL, ASPECT, Zmin, Zmax
        this.glu.gluPerspective(45.0, aspect, 0.1, 100);
        // OBJECTS
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        gl.glLoadIdentity();
    }

    @Override
    public void display(GLAutoDrawable draw) {
        // DESSIN
        GL2 gl = draw.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        // Affichage des cubes et déplacement de ceux-ci en fonction de l'extrémité gauche ou droite de la fenêtre atteinte
        for (Cube3D c : this.cubes3D) {
                c.display(gl);
                if (!this.hasReachedRightLimit) c.goRight();
                else c.goLeft();
        }
        this.vaisseau3D.display(gl);

        // Gestion des collisions
        if (this.laser != null) {
            if (this.laser.getY() <= 2) {
                laser.display(gl);
                laser.goUp();

                for (Cube3D c : this.cubes3D) {
                    double cubeX = c.getX();
                    double cubeY = c.getY();
                    /*
                     * Vérifie si l'abscisse et l'ordonnée du laser se trouve dans des intervalles de points, entre l'abscisse et ordonnée du cube courant
                     * Si oui, le cube est enlevé du tableau et ne sera donc pas affiché à la prochaine frame,
                     * le laser est détruit
                     * et sortie de la boucle, sinon erreur, car le laser sera null à la vérification et prochain tour de boucle
                     */
                    if ((this.laser.getX() >= (cubeX - 0.1) && this.laser.getX() <= (cubeX + 0.1)) && (this.laser.getY() >= (cubeY - 0.1) && this.laser.getY() <= (cubeY + 0.1))) {
                        this.cubes3D.remove(c);
                        this.laser = null;
                        break;
                    }
                }
            } else this.laser = null; // Destruction du laser s'il atteint l'extrémité haute de la fenêtre (si supérieur ou égal à 2)
        }

        // MAJ des attributs
        if (!this.hasReachedRightLimit) this.position += 0.01;
        else this.position -= 0.01;

        if (this.position >= 1.1 && this.position <= 1.2) this.hasReachedRightLimit = true;
        else if (this.position <= -1.1 && this.position >= -1.2) this.hasReachedRightLimit = false;
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {}

    public void goRight() {
        if (this.vaisseau3D.getX() <= 3) this.vaisseau3D.goRight();
    }
    public void goLeft() {
        if (this.vaisseau3D.getX() >= -3) this.vaisseau3D.goLeft();
    }

    public void fire() {
        if (this.laser == null) this.laser = new Laser3D(this.vaisseau3D.getX(), -1.25, -5, 0.025);
    }
}
