package org.example.Tasks.Task2.WIndows;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//класс чтобы рисовать фигуры по найденным площадям
public  class FiguresDrawer extends JFrame {

    List<Integer> results;
    //конструктор для тех кто не знает что это такое мои соболезнования
    public FiguresDrawer(List<Integer> squares){
        results = squares;
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void paint(Graphics g){
        //это как рисовать некоторые фигуры
        //для треугольник и тому подобных в встроенных библеотеках нет функции
        //поэтому вам придется найти код в интернете и самому рисовать
        //советую искать на англ там априори больше инфы
//            g.drawOval(40, 40, 60, 60); //FOR CIRCLE
//            g.drawRect(80, 30, 200, 200); // FOR SQUARE
//            g.drawRect(200, 100, 100, 200); // FOR RECT
//            g.drawRoundRect(300,100,100,200,100,80);
        //переменная чтобы фигуры не строились в одном и том же месте
        AtomicInteger i = new AtomicInteger(10);
        results.forEach(s -> {
            g.drawRect(50 + i.get()/2 , 30 + i.get(), 8 + s, 8 + s);
            i.set(i.get() + 40);
        });
    }
}

