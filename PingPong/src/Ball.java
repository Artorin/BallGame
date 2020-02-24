import processing.core.PGraphics;

public class Ball implements Muster  {

    public float x; // Position des Körpers
    public float y;

    public float xspeed = 7.5f; // Geschwindigkeit des Körpers
    public float yspeed = 7.5f;

    public int radius = 20; // Größe des Balls


    int rot;// Farben

    // Fenstergröße
    int width;
    int height;

    public boolean score_left;
    public boolean score_right;

    public Ball(Pong p)
    {
        width = p.width; // Ball bewegt sich in der Fenstergröße
        height = p.height;

        rot = p.color(255, 0, 0); //Farbe vom Ball


        reset();
    }

    public void edges()
    {
        if(y > height - radius || y < radius) {
            yspeed *= -1;
        }
        if(x > width-radius) {

            reset();
            score_left = true; // Punkte werden gezählt +1
        }
        if(x < radius) {

            reset();
            score_right = true;
        }

    }

    public void reset()
    {
        x = width / 2.3f; //Startpunkt des Balles
        y = height / 2.3f;

    }

    public void update()
    {
        x = x + xspeed;
        y = y + yspeed;
    }

    public void show(PGraphics g) {

        g.fill(rot);
        g.ellipse(x, y, radius, radius); //Geometrie des Balles

    }

    @Override
    public void setX(int x) {
        this.x = x;
    }


    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public float getY() {
        return y;
    }
}
