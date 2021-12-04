package Jeu.Shapes3D;

import com.jogamp.opengl.GL2;

public class Vaisseau3D extends Shape3D {
    public Vaisseau3D(double x, double y, double z, double size) {
        super.x = x; super.y = y; super.z = z;
        super.size = size;
    }

    @Override
    public void display(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(super.x, super.y, super.z);
        gl.glScaled(super.size, super.size, super.size);
        gl.glColor3d(1,1,1);

        gl.glBegin(gl.GL_QUADS);
            // Front
            gl.glVertex3d(-2,0,1);
            gl.glVertex3d(-2,1,1);
            gl.glVertex3d(2,1,1);
            gl.glVertex3d(2,0,1);

            // Rear
            gl.glVertex3d(-2,0,0);
            gl.glVertex3d(-2,1,0);
            gl.glVertex3d(2,1,0);
            gl.glVertex3d(2,0,0);

            // Left
            gl.glVertex3d(-2,0,1);
            gl.glVertex3d(-2,0,0);
            gl.glVertex3d(-2,1,0);
            gl.glVertex3d(-2,1,1);

            // Right
            gl.glVertex3d(2,0,1);
            gl.glVertex3d(2,0,0);
            gl.glVertex3d(2,1,0);
            gl.glVertex3d(2,1,1);

            // Up
            gl.glVertex3d(-2,1,1);
            gl.glVertex3d(-2,1,0);
            gl.glVertex3d(2,1,0);
            gl.glVertex3d(2,1,1);

            // Bottom
            gl.glVertex3d(-2,0,1);
            gl.glVertex3d(-2,0,0);
            gl.glVertex3d(2,0,0);
            gl.glVertex3d(2,0,1);

            // Canon Front
            gl.glVertex3d(-0.5,1,0.75);
            gl.glVertex3d(-0.5,2,0.75);
            gl.glVertex3d(0.5,2,0.75);
            gl.glVertex3d(0.5,1,0.75);

            // Canon Rear
            gl.glVertex3d(-0.5,1,0.25);
            gl.glVertex3d(-0.5,2,0.25);
            gl.glVertex3d(0.5,2,0.25);
            gl.glVertex3d(0.5,1,0.25);

            // Canon Left
            gl.glVertex3d(-0.5,1,0.75);
            gl.glVertex3d(-0.5,1,0.25);
            gl.glVertex3d(-0.5,2,0.25);
            gl.glVertex3d(-0.5,2,0.75);

            // Canon Right
            gl.glVertex3d(0.5,1,0.75);
            gl.glVertex3d(0.5,1,0.25);
            gl.glVertex3d(0.5,2,0.25);
            gl.glVertex3d(0.5,2,0.75);

            // Canon Up
            gl.glVertex3d(-0.5,2,0.75);
            gl.glVertex3d(-0.5,2,0.25);
            gl.glVertex3d(0.5,2,0.25);
            gl.glVertex3d(0.5,2,0.75);
        gl.glEnd();

        gl.glPopMatrix();
    }

    /**
     * Augmente la valeur de l'ordonnée x pour le déplacer vers la droite
     */
    public void goRight() {
        super.x += 0.1;
    }

    /**
     * Réduit la valeur de l'ordonnée x pour le déplacer vers la gauche
     */
    public void goLeft() {
        super.x -= 0.1;
    }
}
