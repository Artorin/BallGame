import processing.core.PGraphics;

import static java.lang.Float.min;
import static processing.core.PApplet.*;
import static processing.core.PConstants.HALF_PI;
import static processing.core.PConstants.TWO_PI;

public class Clocks {

    float m,h;
    float secondsRadius;
    float minutesRadius;
    float hoursRadius;
    float clockDiameter;

    float s;

    int width = 1000;
    int height = 750;

    int radius;

    float cx = width / 2;
    float cy = height / 2;


    public void setupClocks( int radius ){
      this.secondsRadius = (float) (radius * 0.72);
      this.minutesRadius = (float) (radius * 0.60);
      this.hoursRadius = (float) (radius * 0.50);
      this.clockDiameter = (float) (radius * 1.8);
      this.radius = radius;
        //// Angles for sin() and cos() starten um 3 Uhr;
        //  // subtrachieren HALF_PI um auf null Uhr setzen
      this.s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
      this.m = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI;
      this.h = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI;

    }


    public void show(PGraphics g)
    {
        // Uhr Rueckseite
        g.fill(80);
        g.noStroke();
        g.ellipse(cx, cy, clockDiameter, clockDiameter);
        // hands of the clock
        g.stroke(255);
        g.strokeWeight(1);
        g.line(cx, cy, cx + cos(s) * secondsRadius, cy + sin(s) * secondsRadius);
        g.strokeWeight(2);
        g.line(cx, cy, cx + cos(m) * minutesRadius, cy + sin(m) * minutesRadius);
        g.strokeWeight(4);
        g.line(cx, cy, cx + cos(h) * hoursRadius, cy + sin(h) * hoursRadius);
        // minute ticks
        g.strokeWeight(2);
        g.beginShape(POINTS);
        for (int a = 0; a < 360; a+=6) {
            float angle = radians(a);
            float x = cx + cos(angle) * secondsRadius;
            float y = cy + sin(angle) * secondsRadius;
            g.vertex(x, y);
        }
        g.endShape();


    }
}

