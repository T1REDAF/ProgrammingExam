package org.example.Tasks.Task2;

import org.example.Tasks.Task2.WIndows.FiguresDrawer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Menu implements ActionListener {

    //создание формы
    private List<Integer> squares;
    private int a;
    private int i;
    JFrame frame = new JFrame("Task 2");
    JButton solveButton = new JButton("Рассчитать");
    JButton exitButton = new JButton("Выйти");
    JTextField sideTextField = new JTextField();
    JTextField attemptTextField = new JTextField();
    JLabel sideLabel = new JLabel("Сторона а");
    JLabel attemptLabel = new JLabel("Кол-во попыток");

    public Menu(){
        //расставление элементов на фрейме
        squares = new ArrayList<>();
        solveButton.setBounds(100,200,100,30);
        solveButton.setFocusable(false);
        solveButton.addActionListener(this);

        exitButton.setBounds(200,200,100,30);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        sideTextField.setBounds(100,150,80,30);
        attemptTextField.setBounds(220,150,80,30);

        sideLabel.setBounds(100,120,80,30);
        attemptLabel.setBounds(220,120,100,30);

        frame.add(solveButton);
        frame.add(exitButton);
        frame.add(sideTextField);
        frame.add(attemptTextField);
        frame.add(attemptLabel);
        frame.add(sideLabel);
        //чтобы когда программа закрывалась она авто стопилась
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,350);
        frame.setLayout(null);
        //чтобы окно было в середине экрана
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    //метод нажатии на кнопку
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==solveButton) {
            if (!isNumeric(attemptTextField.getText()) || !isNumeric(sideTextField.getText())) {
                //вывод ошибки
                JOptionPane.showMessageDialog(new JFrame(), "Введите корректно данные", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            //лень писать
            if (attemptTextField.isVisible())
                //i - это кол-во попыток
                i = Integer.parseInt(attemptTextField.getText());
            //а - это значение стороны
            a = Integer.parseInt(sideTextField.getText());
            attemptTextField.setVisible(false);
            attemptLabel.setVisible(false);
            findSquare();

        }

        if (e.getSource()==exitButton) {
            frame.dispose();
        }
    }

    private void findSquare() {
        //пока есть попытки
        i--;
        squares.add(a*a);
        if (i==0){
            //вывод сообщ
            JOptionPane.showMessageDialog(new JFrame(),"Площадь последней фигуры: "+(a*a));
            frame.dispose();
            showFigures();
        }

    }

    private void showFigures() {

        new FiguresDrawer(squares);
    }

    public static boolean isNumeric(String string) {

        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return intValue > 0;
        } catch (NumberFormatException e) {
            System.err.println("Введите корректно данные");
        }
        return false;
    }
}
