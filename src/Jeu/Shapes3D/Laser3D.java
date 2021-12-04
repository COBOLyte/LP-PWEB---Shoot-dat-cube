package Jeu.Shapes3D;

import com.jogamp.opengl.GL2;

public class Laser3D extends Shape3D {
    public Laser3D(double x, double y, double z, double size) {
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
            gl.glVertex3d(-1,-1,1);
            gl.glVertex3d(1,-1,1);
            gl.glVertex3d(1,5,1);
            gl.glVertex3d(-1,5,1);

            // Rear
            gl.glVertex3d(-1,-1,-1);
            gl.glVertex3d(1,-1,-1);
            gl.glVertex3d(1,5,-1);
            gl.glVertex3d(-1,5,-1);

            // Left
            gl.glVertex3d(-1,-1,1);
            gl.glVertex3d(-1,-1,-1);
            gl.glVertex3d(-1,5,-1);
            gl.glVertex3d(-1,5,1);

            // Right
            gl.glVertex3d(1,-1,-1);
            gl.glVertex3d(1,5,-1);
            gl.glVertex3d(1,5,1);
            gl.glVertex3d(1,-1,1);

            // Up
            gl.glVertex3d(-1,5,1);
            gl.glVertex3d(-1,5,-1);
            gl.glVertex3d(1,5,-1);
            gl.glVertex3d(1,5,1);

            // Bottom
            gl.glVertex3d(-1,-1,1);
            gl.glVertex3d(-1,-1,-1);
            gl.glVertex3d(1,-1,-1);
            gl.glVertex3d(1,-1,1);
        gl.glEnd();

        gl.glPopMatrix();
    }

    /**
     * Augmente la valeur de l'abscisse y pour le déplacer vers le haut
     */
    public void goUp() {
        super.y += 0.1;
    }
}
