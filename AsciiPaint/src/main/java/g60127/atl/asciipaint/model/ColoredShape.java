package g60127.atl.asciipaint.model;


public  abstract class ColoredShape extends ShapeComponent {
        //permits Rectangle, Circle, Line, ShapeComposite {
    private char color;
    public ColoredShape(char color){
        this.color = color;
    }
    public char getColor(){
        return color;
    }
    public void setColor(char color){
        this.color = color;
    }
}
