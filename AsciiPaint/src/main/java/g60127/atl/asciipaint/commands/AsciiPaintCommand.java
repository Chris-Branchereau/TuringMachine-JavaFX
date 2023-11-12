package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;

public abstract class AsciiPaintCommand implements Command{
        protected AsciiPaint paint;
        public AsciiPaintCommand(AsciiPaint paint) {
            this.paint = paint;
        }

}
