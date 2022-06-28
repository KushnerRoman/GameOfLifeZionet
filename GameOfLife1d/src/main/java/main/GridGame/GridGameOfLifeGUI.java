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

        //create options for delay and iterator
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
                switch (textDelay) {
                    case "Very Slow" :
                        textOptionsForDelay.setText("2s");
                        chooseDelay = 2000;

                    case "Slow" :
                        textOptionsForDelay.setText("1s");
                        chooseDelay = 1000;
                    case "Normal" :
                        textOptionsForDelay.setText("0.5s");
                        chooseDelay = 500;

                    case "Fast" :
                        textOptionsForDelay.setText("200ms");
                        chooseDelay = 200;
                    ;
                    case "Very Fast" :
                        textOptionsForDelay.setText("No delay");
                        chooseDelay = 1;

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


        boxOptionsRowsXCols.addActionListener(e -> {
            String textRowsAndCols = (String) boxOptionsRowsXCols.getSelectedItem();
            switch (textRowsAndCols) {
                case "6X6":
                        textOptionsForRowsCols.setText("6");
                case "8X8" :
                        textOptionsForRowsCols.setText("8");
                case "10X10" :
                        textOptionsForRowsCols.setText("10");
                case "15X15" :
                        textOptionsForRowsCols.setText("15");
                case "20X20" :
                        textOptionsForRowsCols.setText("20");
                case "30X30":
                        textOptionsForRowsCols.setText("30");
                case "50X50" :
                        textOptionsForRowsCols.setText("50");
                case "75X75":
                        textOptionsForRowsCols.setText("75");
                case "100X100":
                        textOptionsForRowsCols.setText("100");
            }


        });


        JComboBox<String> optionsSelectLivingCells = new JComboBox<>();
        optionsSelectLivingCells.setSize(50, 50);
        optionsSelectLivingCells.addItem("Low");
        optionsSelectLivingCells.addItem("Medium");
        optionsSelectLivingCells.addItem("Large");

        optionsSelectLivingCells.addActionListener(e -> difficulty = (String) optionsSelectLivingCells.getSelectedItem());


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
