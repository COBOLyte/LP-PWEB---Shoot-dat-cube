package Jeu.Shapes3D;

import com.jogamp.opengl.GL2;

public class Cube3D extends Shape3D {
    public Cube3D(double x, double y, double z, double size) {
        super.x = x; super.y = y; super.z = z;
        super.size = size;
    }

    @Override
    public void display(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(super.x, super.y, super.z);
        gl.glScaled(super.size, super.size, super.size);

        gl.glBegin(gl.GL_QUADS);
            // Front
            gl.glColor3d(1,0,0); gl.glVertex3d(-1,-1,1);
            gl.glColor3d(0,1,0); gl.glVertex3d(1,-1,1);
            gl.glColor3d(0,0,1); gl.glVertex3d(1,1,1);
            gl.glColor3d(1,0,1); gl.glVertex3d(-1,1,1);

            // Rear
            gl.glColor3d(1,1,0); gl.glVertex3d(-1,-1,-1);
            gl.glColor3d(0,1,1); gl.glVertex3d(1,-1,-1);
            gl.glColor3d(1,0,0); gl.glVertex3d(1,1,-1);
            gl.glColor3d(1,1,1); gl.glVertex3d(-1,1,-1);

            // Left
            gl.glColor3d(1,0,0); gl.glVertex3d(-1,-1,1);
            gl.glColor3d(0,1,0); gl.glVertex3d(-1,-1,-1);
            gl.glColor3d(0,1,1); gl.glVertex3d(-1,1,-1);
            gl.glColor3d(1,1,0); gl.glVertex3d(-1,1,1);

            // Right
            gl.glColor3d(1,0,1); gl.glVertex3d(1,-1,-1);
            gl.glColor3d(0,0,1); gl.glVertex3d(1,1,-1);
            gl.glColor3d(1,0,0); gl.glVertex3d(1,1,1);
            gl.glColor3d(1,1,1); gl.glVertex3d(1,-1,1);

            // Up
            gl.glColor3d(1,1,1); gl.glVertex3d(-1,1,1);
            gl.glColor3d(1,0,1); gl.glVertex3d(-1,1,-1);
            gl.glColor3d(1,0,0); gl.glVertex3d(1,1,-1);
            gl.glColor3d(1,1,0); gl.glVertex3d(1,1,1);

            // Bottom
            gl.glColor3d(1,0,0); gl.glVertex3d(-1,-1,1);
            gl.glColor3d(0,0,1); gl.glVertex3d(-1,-1,-1);
            gl.glColor3d(0,1,0); gl.glVertex3d(1,-1,-1);
            gl.glColor3d(0,1,1); gl.glVertex3d(1,-1,1);
        gl.glEnd();

        gl.glPopMatrix();
    }

    /**
     * Augmente la valeur de l'abscisse x pour le déplacer vers la droite
     */
    public void goRight() {
        super.x += 0.01;
    }

    /**
     * Réduit la valeur de l'abscisse x pour le déplacer vers la gauche
     */
    public void goLeft() {
        super.x -= 0.01;
    }
}
