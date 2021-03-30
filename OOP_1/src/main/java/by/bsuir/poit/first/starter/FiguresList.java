package by.bsuir.poit.first.starter;

import by.bsuir.poit.first.figures.BaseFigure;

import java.util.ArrayList;
import java.util.List;

public class FiguresList {
    private final static List<BaseFigure> STATIC_LIST = new ArrayList<>();

    public static List<BaseFigure> getStaticList() {
        return STATIC_LIST;
    }
}
