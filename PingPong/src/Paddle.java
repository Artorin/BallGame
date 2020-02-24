import processing.core.PGraphics;

public class Paddle implements Muster{

    public float x;
    public float y;
    public float w;
    public float h;
    public int score = 0;

    // Farben
    int weiss;
    int farbe;
    int rot;

    // Fenstergröße
    int width;
    int height;

    public Paddle(int x, Pong p)
    {
        width = p.width;
        height = p.height;
        weiss = p.color(255, 255, 255);
        rot  = p.color(184, 0, 64);
        farbe = weiss;
        this.x = x;
        this.w = 15;
        this.h = 80;
        this.y = height/2 - h/2; //Position vom Paddle
    }


    public void show(PGraphics g)
    {

        g.fill(farbe); //Füllung des Paddles
        g.rect(x, y, w, h); // Form des Paddles

    }


    public void checkCollisionLeft(Ball b)
    {
        if(b.y < y + h && b.y > y  && b.x - b.radius < x + w - 10)	// (Unterer Teil, Oberer Teil, Abprallfläche)
        {

            b.xspeed *= -1;

        }
    }
    public void checkCollisionRight(Ball b)
    {
        if(b.y < y + h && b.y > y  && b.x + b.radius > x - w + 20){
            b.xspeed *= -1;
        }

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

