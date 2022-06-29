package main.GridGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {

    public  int[][] oneDBoard;


    public GameOfLife(int chooseRows, int chooseCols, String difficulty, int delay,String rule) {

        oneDBoard=makeTwoDArray(chooseCols,chooseRows,difficulty);
        setSize(500, 500);
        if(chooseCols == 0 && chooseRows == 0) {
            setLayout(new GridLayout(10, 10));
        }else {
            setLayout(new GridLayout(chooseRows, chooseCols));
        }




        JButton cells[][] = new JButton[chooseRows][chooseCols];

        for (int i = 0; i < oneDBoard.length; i++) {
            for (int j = 0; j < oneDBoard.length; j++) {
                JButton temp = new JButton();
                if (oneDBoard[i][j] == 1) {
                    temp.setBackground(Color.BLACK);
                } else {
                    temp.setBackground(Color.CYAN);
                }
                add(temp);
                cells[i][j] = temp;

            }


        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] nextGenBoard=new int[oneDBoard.length][oneDBoard.length];
                switch (rule) {
                    case "Conway":
                        nextGenBoard = nextGenerationBoard(oneDBoard);

                        break;
                    case "Spontaneous":
                        nextGenBoard = nextGenerationBoardSpontaneous(oneDBoard);
                        break;
                    case "Hyper Active":
                        nextGenBoard = nextGenerationBoardHyperActive(oneDBoard);
                        break;
                    case "High Life":
                        nextGenBoard = nextGenerationBoardHalfLife(oneDBoard);
                        break;
                    default:
                        nextGenBoard = nextGenerationBoard(oneDBoard);
                }


                oneDBoard=nextGenBoard;

                for (int i = 0; i < nextGenBoard.length; i++) {
                    for (int j = 0; j < nextGenBoard.length; j++) {

                        if (nextGenBoard[i][j] == 1) {
                            cells[i][j].setBackground(Color.BLACK);
                        } else {
                            cells[i][j].setBackground(Color.CYAN);
                        }


                    }
                }

      for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[i].length; j++) {
                        int finalJ = j;
                        int finalI = i;
                        cells[i][j].addMouseListener(new MouseListener() {
                            public void mouseClicked(MouseEvent e) {
                                if (e.getButton() == MouseEvent.BUTTON1) {
                                    cells[finalI][finalJ].setBackground(Color.BLACK);
                                    oneDBoard[finalI][finalJ] = 1;
                                } else if (e.getButton() == MouseEvent.BUTTON3) {
                                    cells[finalI][finalJ].setBackground(Color.CYAN);
                                    oneDBoard[finalI][finalJ] = 0;
                                }
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                                oneDBoard[finalI][finalJ] = 1;

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {

                            }

                            @Override
                            public void mouseExited(MouseEvent e) {

                            }

                        });
                    }
                }
            }

        });


        timer.start();



    }



    public  int[][] makeTwoDArray(int cols,int rows,String difficulty){

        int[][] board=new int[cols][rows];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                switch (difficulty){
                    case "Low":
                        if(Math.random()<0.1){
                            board[i][j]=1;
                        }else{
                            board[i][j]=0;
                        }
                        break;
                    case "Medium":
                        if(Math.random()<0.3){
                            board[i][j]=1;
                        }else{
                            board[i][j]=0;
                        }
                        break;
                    case "Large":
                        if(Math.random()<0.5){
                            board[i][j]=1;
                        }else{
                            board[i][j]=0;
                        }
                        break;
                    default:
                        //add difficulty later
                        board[i][j]= (int)Math.round(Math.random());
                }

            }
        }

        return board;
    }
    public  int[][] nextGenerationBoard(int[][] prevBoard){
        int [][] nextBoard=new int[prevBoard.length][prevBoard.length];
        for(int i=1;i<prevBoard.length-1;i++){
            for (int j=1;j< prevBoard.length-1;j++){

                int sum= countStatesOfCells(prevBoard,i,j);
                if(prevBoard[i][j]==1) {
                    if (sum < 2 || sum > 3) {
                        nextBoard[i][j] = 0;
                    }
                    if (sum == 2 || sum == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
                if(prevBoard[i][j]==0 ) {
                    if( sum==3){
                        nextBoard[i][j]=1;
                    }
                }



            }
        }

        return nextBoard;
    }
    public int[][] nextGenerationBoardHalfLife(int[][] prevBoard){
        int [][] nextBoard=new int[prevBoard.length][prevBoard.length];
        for(int i=1;i<prevBoard.length-1;i++){
            for (int j=1;j< prevBoard.length-1;j++){

                int sum= countStatesOfCells(prevBoard,i,j);
                if(prevBoard[i][j]==1) {
                    if (sum < 2 || sum > 3) {
                        nextBoard[i][j] = 0;
                    }
                    if (sum == 2 || sum == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
                if(prevBoard[i][j]==0 ) {
                    if( sum==3){
                        nextBoard[i][j]=1;
                    } else {
                        nextBoard[i][j]=0;
                    }

                }



            }
        }

        return nextBoard;
    }
    public int[][] nextGenerationBoardHyperActive(int[][] prevBoard){
        int [][] nextBoard=new int[prevBoard.length][prevBoard.length];
        for(int i=1;i<prevBoard.length-1;i++){
            for (int j=1;j< prevBoard.length-1;j++){

                int sum= countStatesOfCells(prevBoard,i,j);
                if(prevBoard[i][j]==1) {
                    if (sum < 2 || sum > 5) {
                        nextBoard[i][j] = 0;
                    }
                    if (sum == 2 || sum == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
                if(prevBoard[i][j]==0 ) {
                    if( sum==3){
                        nextBoard[i][j]=1;
                    } else {
                        nextBoard[i][j]=0;
                    }

                }



            }
        }

        return nextBoard;
    }

    public int[][] nextGenerationBoardSpontaneous(int[][] prevBoard){
        int [][] nextBoard=new int[prevBoard.length][prevBoard.length];
        for(int i=1;i<prevBoard.length-1;i++){
            for (int j=1;j< prevBoard.length-1;j++){

                int sum= countStatesOfCells(prevBoard,i,j);
                if(prevBoard[i][j]==1) {
                    if (sum < 2 || sum > 3) {
                        nextBoard[i][j] = 0;
                    }
                    if (sum == 2 || sum == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
                if(prevBoard[i][j]==0 ) {
                    if( sum==3){
                        nextBoard[i][j]=1;
                    }
                    if(Math.random()>0.5){
                        nextBoard[i][j]=1;
                    }
                }



            }
        }

        return nextBoard;
    }



    public  int countStatesOfCells(int[][] grid, int row, int col){

        int sum=0;


        for (int i =row-1; i < row+2; i++) {

            for (int j =col-1; j < col+2; j++) {


                sum += grid[i][j];
            }
        }

        sum -= grid[row][col];

        return sum;

    }

    public  void print(int[][] board){
        for (int i=0;i<board.length;i++){
            System.out.println();
            for (int j=0;j<board.length;j++){
                System.out.print(board[i][j] + " , ");
            }
        }
    }
}
