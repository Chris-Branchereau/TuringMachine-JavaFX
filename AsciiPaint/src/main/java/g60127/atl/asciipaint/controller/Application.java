package g60127.atl.asciipaint.controller;

import g60127.atl.asciipaint.model.AsciiPaint;

public class Application {
    private static AsciiPaint paint = new AsciiPaint(50,50);

    public void start(){

    }

    public static void main(String[] args) {
        paint.newRectangle(5,4,3,2,'c');
        paint.newRectangle(5,5,3,2,'v');
        paint.newSquare(15,14,4,'r');
        paint.newCircle(25,25,5,'g');
        paint.newCircle(27,27,5,'s');
        paint.newCircle(2,25,4,'g');
        paint.
        //System.out.println((Math.pow(5,2)<=(Math.pow((15-20),2)+Math.pow((6-5),2)) && (Math.pow((15-20),2)+Math.pow((6-5),2))<=(Math.pow(5,2)+1)));

        paint.display();
    }
}
