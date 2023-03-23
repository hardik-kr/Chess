import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.*;

public class Game 
{
    private Board Boardobj ;
    private Deque<Player> PlayerList = new LinkedList<>() ;

    public void Initialization()
    {
        Boardobj = new Board();
        //TestInput() ;
        InitialInput();
    }

    private void TestInput() 
    {
        Player Pobj = new Player("hardik", true) ;
        PlayerList.add(Pobj) ;
        Pobj = new Player("prashu", false) ;
        PlayerList.add(Pobj) ;
    }

    public String Start() throws IOException
    {
        
        boolean winner = false ;
        //boolean isKingOnCheck = false ;
        File myObj = new File("/home/hardik/LLD/Chess/src/testcase.txt");
        Scanner inp  = new Scanner(myObj) ;
        Scanner inp2  = new Scanner(System.in) ;
        // FileWriter filew = new FileWriter("/home/hardik/LLD/Chess/src/testcase.txt") ;
        // filew.close();
    
        while(winner!=true)
        {
            Boardobj.printBoard();
            
            Player pobj = PlayerList.removeFirst() ;
            System.out.print("\nEnter position (src,dest) "+pobj.getName()+" : ");
            String data = "" ;
            if(inp.hasNextLine()) 
                data = inp.nextLine(); 
            else
                data = inp2.nextLine() ;
                //System.out.println(data);
            String chance = data ;//inp.nextLine() ;
            // BufferedWriter filewr = new BufferedWriter(new FileWriter("/home/hardik/LLD/Chess/src/testcase.txt",true)) ;
            // filewr.write(chance);
            // filewr.write("\n");
            // filewr.close();
            
            Pattern pattern = Pattern.compile("[A-H][1-8],[A-H][1-8]|Cant Move") ;
            Matcher matcher = pattern.matcher(chance) ;
            Boolean isValidInput = matcher.find() ;

            if(isValidInput == false)
            {   
                System.out.println("Invalid Input !!") ;
                PlayerList.addFirst(pobj);
                continue ;
            }
            if(chance.equals("Cant Move"))
            {
                return PlayerList.getFirst().getName() ;
            }

            String[] pos = chance.split(",") ;
            char src_ch = pos[0].charAt(0) ;
            int src_i = (int)(pos[0].charAt(1)-'0') ;
            char dest_ch = pos[1].charAt(0) ;
            int dest_i = (int)(pos[1].charAt(1)-'0');

            Cell src_cell = Boardobj.getCellInfo(src_ch, src_i) ;
            Cell dest_cell = Boardobj.getCellInfo(dest_ch, dest_i) ;

            boolean isValid = Boardobj.CheckValid(src_cell,dest_cell,pobj.getPlayerColor()) ;
            
            if(isValid == false)
            {
                System.out.println("Wrong Move !!") ;
                PlayerList.addFirst(pobj);
                continue ;
            }
            
            boolean isKingOnCheck = Boardobj.MakeMove(src_cell,dest_cell,pobj) ;
            
            if(isKingOnCheck == true)
            {   
                System.out.println("Invalid Move ---Check !!") ;
                PlayerList.addFirst(pobj);
                continue ;
            }

            
            winner = Boardobj.CheckWinner(pobj.getPlayerColor()) ;
            if(winner)
            {
                Boardobj.printBoard();
                return pobj.getName() ;
            }
            
            PlayerList.addLast(pobj);

        }
        return "" ;
    }

    // private boolean CheckValid(Board bobj,Cell src_cell, Cell dest_cell,Player pobj) 
    // {
    //     return src_cell.getPiece()!=null &&
    //             src_cell.getPiece().validMove(bobj,src_cell, dest_cell) && 
    //             pobj.getPlayerColor()==src_cell.getPiece().getisWhite() &&
    //             (dest_cell.getPiece()==null || 
    //             dest_cell.getPiece().getisWhite()!=src_cell.getPiece().getisWhite() ) ;
    // }

    private void InitialInput()
    {
        Scanner inp  = new Scanner(System.in) ;

        String name1,name2,color1,color2 ;
        Player Pobj ;
        System.out.print("\nPlayer 1 Name : ");
        name1 = inp.nextLine() ;

        System.out.print("Color : ");
        color1 = inp.nextLine() ;

        System.out.println() ;
        System.out.print("Player 2 Name : ");
        name2 = inp.nextLine() ;

        if(color1.equals("White") || color1.equals("white") || color1.equals("w") || color1.equals("W"))
        {
            color2 = "black" ;
            Pobj = new Player(name1, true) ;
            PlayerList.add(Pobj) ;
            Pobj = new Player(name2, false) ;
            PlayerList.add(Pobj) ;
        }
        else
        {
            color2 = "white" ;
            Pobj = new Player(name2, true) ;
            PlayerList.add(Pobj) ;
            Pobj = new Player(name1, false) ;
            PlayerList.add(Pobj) ;
        }

        System.out.println("Color set to : "+color2) ;
    }

}
