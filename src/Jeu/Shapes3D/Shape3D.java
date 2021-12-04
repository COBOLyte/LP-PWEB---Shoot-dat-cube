package Jeu.Shapes3D;

import com.jogamp.opengl.GL2;

public abstract class Shape3D {
    protected double x, y, z;
    protected double r, g, b;
    protected double size;

    public Shape3D() {
        this.x = 0; this.y = 0; this.z = 0;
        this.r = 0; this.g = 0; this.b = 0;
        this.size = 1;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public abstract void display(GL2 gl);
}
