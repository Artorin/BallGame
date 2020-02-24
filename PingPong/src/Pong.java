import processing.core.PApplet;
import processing.core.PImage;

public class Pong extends PApplet {

    public static void main(String[] args) {
        PApplet.main(Pong.class);

    }
    public int width = 1000; //Breite des Fensters
    public int height = 500; //Höhe des Fensters




    Ball ball; // Objekt Ball
    public Paddle left;
    public Paddle right;
    //public AIPaddle aiPaddle;
    public Clocks clocks;


   // PImage backImage;

    public void settings()
    {

        size(width, height);
    }

    public void setup()
    {

       // PImage backImage = loadImage("src/Data/backImage.png");

        ball = new Ball(this);
        left = new Paddle(10, this); //Abstand vom Rand vom Paddle links
        right = new Paddle(width-25, this);
        //aiPaddle = new AIPaddle(width-25, this, 50);

        clocks = new Clocks();
        clocks.setupClocks(50);

    }

    public void draw()
    {
        background( 0); //Hintergrundfarbe
       // tint(255,ball.yspeed,ball.yspeed);
       // image(backImage,0,0,ball.xspeed,ball.yspeed);



        //if (true) {
        //aiPaddle.show(g);
        //aiPaddle.tick(this, ball);
        //aiPaddle.checkCollision(ball);
        //}
        //else {
            right.show(g);
            right.checkCollisionRight(ball);
        //}


        left.show(g);
        left.checkCollisionLeft(ball);

        clocks.show(g);
        clocks.setupClocks(100);
        clocks.show(g);

        ball.show(g);
        ball.update();
        ball.edges();

        fill(255); //Scorefarbe
        updateText();

    }

    private void updateText()
    {
        if(ball.score_left) {
            left.score++;
            ball.score_left = false;
        }
        if(ball.score_right) {
            right.score++;
            ball.score_right = false;

            if(left.score == 10) {

                System.exit(10);
            }
            if(right.score == 10) {
                System.exit(10); //Spiel läuft solange bis jemand 10 Punkte hat
            }
        }

        textSize(35);
        text(left.score, 32, 40);  //Score Ausrichtung
        text(right.score, width-64, 40);

    }

    public void keyPressed()
    {
        if(key == 'w' && left.y > 0) {
            left.y -= 10;
        }
        if(key == 's' && left.y < height - left.h) {
            left.y += 10;
        }
        if(key == ';' && right.y > 0) {
            right.y -= 10;
        }
        if(key == '.' && right.y < height - right.h) {
            right.y += 10;
        }
    }
}


