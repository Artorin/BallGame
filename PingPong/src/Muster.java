import processing.core.PGraphics;

public interface Muster {
    public abstract void show(PGraphics g);
    public abstract float getY();
    public abstract void setY(int y);
    public abstract float getX();
    public abstract void setX(int x);
}
