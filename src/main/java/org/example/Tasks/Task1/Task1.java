package org.example.Tasks.Task1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {
        findS();
    }
    public static void findS() throws IOException {
        //еще нужны проверки, это зависит от данной формулы(деление на 0, основание логарифма <=0)
        //можете весь этот метод разделить на методы
        List<Double> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение a");
        //проверка на число
        if(!scanner.hasNextInt() || !scanner.hasNext()) {
            System.err.println("Неправильное вводимое значение");
            findS();
            return;
        }
        //читаю число с консоли
        double a = Double.parseDouble(scanner.nextLine());
        if (a == 0) findS();
        double y = findY();
        results.add(y);
        double s = 0;//если произведение то 1 (потому что умножение на 0 = 0)
        for (int i = -20;i<=10;i++){
            //само s
            s = s + (2.3 * Math.pow(y,5/3.0) * Math.pow(a,i-1) -
                        (0.2 * Math.abs(y)));
        }
        results.add(s);
        //как я понял на экзамене есть разные способы вывода постараюсь сделать
        //1 просто вывод
        System.out.println("Значение S: "+ s);
        System.out.println("Значение y: " + y);
        //2 создание файла
        try {
            File file = new File("results.txt");
            if (file.createNewFile()) {
                System.out.println("File with results created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("results.txt");
            myWriter.write("Значение S: %f\nЗначение y: %f".formatted(results.get(1),results.get(0)));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3 окно сообщения
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Значение S: %f\nЗначение y: %f".formatted(results.get(1),results.get(0)));
    }

    //функция нахожденияя y
    private static double findY(){

        double y = 0;
        //цикл х
        for (int x = 3;x<=12;x = x + 3){
            y = y + customLog(3, (2 * x)/3.0) + Math.cos(1 + Math.pow(x,2));
        }
        return y;
    }
    //для определения логарифма, в джаве нет функции вычисление своего логарифма
    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}
