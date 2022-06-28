package main.GridGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridGameOfLifeGUI extends JFrame {

    String difficulty="Medium";
    int chooseDelay=2000;

    public GridGameOfLifeGUI() {
        super("Grid Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new GridLayout(10, 10));


        JPanel panelText = new JPanel();

        JPanel startPanel = new JPanel();
        JLabel startText = new JLabel("Choose rows columns  difficulty and delay iterator");
        JTextField textOptionsForRowsCols = new JTextField(10);


        JTextField textOptionsForDelay = new JTextField(10);

        JComboBox<String> boxOptionsForDelay = new JComboBox<>();
        boxOptionsForDelay.setSize(70, 70);
        boxOptionsForDelay.addItem("Very Slow");
        boxOptionsForDelay.addItem("Slow");
        boxOptionsForDelay.addItem("Normal");
        boxOptionsForDelay.addItem("Fast");
        boxOptionsForDelay.addItem("Very Fast");


        boxOptionsForDelay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textDelay = (String) boxOptionsForDelay.getSelectedItem();
                if(textDelay.equals("Very Slow")){
                    chooseDelay=2000;
                    textOptionsForDelay.setText("2s");
                } else if (textDelay.equals("Slow")){
                    chooseDelay=1000;
                    textOptionsForDelay.setText("1s");
                } else if (textDelay.equals("Normal")){
                    chooseDelay=500;
                    textOptionsForDelay.setText("0.5s");
                } else if (textDelay.equals("Fast")){
                    chooseDelay=200;
                    textOptionsForDelay.setText("0.2s");
                } else if (textDelay.equals("Very Fast")){
                    chooseDelay=1;
                    textOptionsForDelay.setText("No Delay");
                }

                }



        });


        JComboBox<String> boxOptionsRowsXCols = new JComboBox<>();
        boxOptionsRowsXCols.setSize(70, 70);
        boxOptionsRowsXCols.addItem("6X6");
        boxOptionsRowsXCols.addItem("8X8");
        boxOptionsRowsXCols.addItem("10X10");
        boxOptionsRowsXCols.addItem("15X15");
        boxOptionsRowsXCols.addItem("20X20");
        boxOptionsRowsXCols.addItem("30X30");
        boxOptionsRowsXCols.addItem("50X50");
        boxOptionsRowsXCols.addItem("75X75");


        boxOptionsRowsXCols.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textRowsAndCols = (String) boxOptionsRowsXCols.getSelectedItem();
                if (textRowsAndCols.equals("6X6")) {
                    textOptionsForRowsCols.setText("6");
                } else if (textRowsAndCols.equals("8X8")) {
                    textOptionsForRowsCols.setText("8");
                } else if (textRowsAndCols.equals("10X10")) {
                    textOptionsForRowsCols.setText("10");
                } else if (textRowsAndCols.equals("15X15")) {
                    textOptionsForRowsCols.setText("15");
                } else if (textRowsAndCols.equals("20X20")) {
                    textOptionsForRowsCols.setText("20");
                } else if (textRowsAndCols.equals("30X30")) {
                    textOptionsForRowsCols.setText("30");
                } else if (textRowsAndCols.equals("50X50")) {
                    textOptionsForRowsCols.setText("50");
                } else if (textRowsAndCols.equals("75X75")) {
                    textOptionsForRowsCols.setText("75");
                }

                }
        });


        JComboBox<String> optionsSelectLivingCells = new JComboBox<>();
        optionsSelectLivingCells.setSize(50, 50);
        optionsSelectLivingCells.addItem("Low");
        optionsSelectLivingCells.addItem("Medium");
        optionsSelectLivingCells.addItem("Large");

        optionsSelectLivingCells.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent e) {

            difficulty = (String) optionsSelectLivingCells.getSelectedItem();

       }
        });



        JButton buttonStart = new JButton("Start");

        panelText.add(startText);

        add(panelText);
        add(optionsSelectLivingCells);


        add(panelText);

        panelText.add(textOptionsForRowsCols);
        add(panelText);

        add(boxOptionsRowsXCols);

        panelText.add(textOptionsForDelay);
        add(panelText);
        add(boxOptionsForDelay);




        startPanel.add(buttonStart);
        add(startPanel);


        buttonStart.addActionListener(e -> {

                int chooseRows = Integer.parseInt(textOptionsForRowsCols.getText());



            dispose();
            new GameOfLife(chooseRows, chooseRows,difficulty,chooseDelay);

        });
    }



}
