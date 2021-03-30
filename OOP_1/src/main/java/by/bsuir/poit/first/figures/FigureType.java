package by.bsuir.poit.first.figures;

public enum FigureType {
    CIRCLE {
        @Override
        public BaseFigure getFigure(int x1, int y1, int x2, int y2) {
            return new SimpleCircle(x1, y1, x2, y2);
        }
    }, LINE {
        @Override
        public BaseFigure getFigure(int x1, int y1, int x2, int y2) {
            return new SimpleLine(x1, y1, x2, y2);
        }
    }, SQUARE {
        @Override
        public BaseFigure getFigure(int x1, int y1, int x2, int y2) {
            return new SimpleSquare(x1, y1, x2, y2);
        }
    }, RECTANGLE {
        @Override
        public BaseFigure getFigure(int x1, int y1, int x2, int y2) {
            return new SimpleRectangle(x1, y1, x2, y2);
        }
    }, ELLIPSE {
        @Override
        public BaseFigure getFigure(int x1, int y1, int x2, int y2) {
            int w = Math.abs(x1 - x2);
            int h = Math.abs(y1 - y2);
            return new SimpleEllipse(x1, y1, w, h);
        }
    };

    public abstract BaseFigure getFigure(int x1, int y1, int x2, int y2);
}
