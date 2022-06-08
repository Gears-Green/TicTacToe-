import java.io.*;
import java.util.*;

public class TicTacToe
{
    public String[][] board = {{"-", "-", "-",},{"-", "-", "-",},{"-", "-", "-",}};
    public int player = 0;
    public boolean winner = false;
    public String p = "";
    public int r;
    public int c;
    
    public void game(){
        printBoard();
        System.out.println("X goes first");
        while(winner == false)
        {
            turn();
            printBoard();
            win();
        }
    }
    
    public void turn(){
        Scanner sc = new Scanner(System.in);
        if ((player % 2) == 0) p = "X"; else p = "O";
        System.out.print(p + " : Enter a row. ");
        r = sc.nextInt();
        System.out.print("Enter a col. ");
        c = sc.nextInt(); 
        if(!(r <= 3 && r >= 1) || !(c <= 3 && c >= 1)) System.out.println("Invalid number. Turn Skipped!\n"); 
        else if (board[r-1][c-1].equals("-"))
        {
            board[r-1][c-1] = p;
            System.out.println("");
        }
        else System.out.println("Space occupied. Turn Skipped!\n");
        player++;
    }
    
    public void printBoard(){
        for (String[] x : board)
        {
            for (String y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public  void win(){
        String b = Arrays.deepToString(board);
        if((r <= 3 && r >= 1) || (c <= 3 && c >= 1))
        {
            for (int i = 0; i < 3; i++)
            {
                String line = "";
                if(i == 0)
                {
                    line = board[r-1][0] + board[r-1][1] + board[r-1][2];
                    if(line.equals("OOO") || line.equals("XXX"))
                    {
                        winner = true; break;
                    }
                }
                else if(i == 1)
                {
                    line = board[0][c-1] + board[1][c-1] + board[2][c-1];
                    if(line.equals("OOO") || line.equals("XXX"))
                    {
                        winner = true; break;
                    }
                }
                else
                {
                    line = board[0][0] + board[1][1] + board[2][2];
                    if(line.equals("OOO") || line.equals("XXX"))
                    {
                        winner = true; break;
                    }
                    
                    line = board[0][2] + board[1][1] + board[2][0];
                    if(line.equals("OOO") || line.equals("XXX"))
                    {
                        winner = true; break;
                    }
                }
            }
        }
        if (winner == true)
        {
            System.out.println("Player " + p + " wins!");
        }
        if (b.indexOf("-") < 0 && winner == false)
        {
            winner = true;
            System.out.println("Draw! No one wins :(");
        }
    }
    
    public static void main(String[] args)
    {
        TicTacToe test = new TicTacToe();
        test.game();
    }
}