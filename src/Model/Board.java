package Model;

import java.util.ArrayList;

public class Board 
{
    private Cell[][] Cellobj ;
    private Cell[] KingInfo ;
    private ArrayList<Cell>[] KingCheckList ;

    public Board()
    {
        initialization() ;
        //Test_initialization1() ;
        //Test_initialization2() ;
        printBoard();
    }
    private void Test_initialization2() 
    {
        Cellobj = new Cell[8][8] ;
        KingInfo = new Cell[2] ;
        KingCheckList = new ArrayList[2] ;
        KingCheckList[0] = new ArrayList<Cell>() ;
        KingCheckList[1] = new ArrayList<Cell>() ;

        
        for(int i=0 ; i<8 ; i++)
        {
            for(int j=0 ; j<8 ;j++)
                Cellobj[i][j] = new Cell(null,new Position((char)(j+'A'),i+1)) ;
        }

        int i=2,j=3 ;
        boolean isWhite = false ;
        
        Cellobj[i][j] = new Cell(new PieceKing(isWhite),new Position((char)(j+'A'),i+1)) ;
        KingInfo[0] = Cellobj[i][j] ;

        i=1 ; j=2 ;
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ;  
        
        i=2 ; j=2 ;
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ; 
    
        i=3;j=2 ;        
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ; 
            
        i=4;j=5 ;        
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ; 
        
        i=7;j=0 ;
        Cellobj[i][j] = new Cell(new PieceKing(!isWhite),new Position((char)(j+'A'),i+1)) ;
        KingInfo[1] = Cellobj[i][j] ;
        
        i=6;j=4 ;
        Cellobj[i][j] = new Cell(new PieceQueen(!isWhite),new Position((char)(j+'A'),i+1)) ;

        i=5 ; j=0 ;
        Cellobj[i][j] = new Cell(new PieceBishop(!isWhite),new Position((char)(j+'A'),i+1)) ; 

        i=5 ; j=4 ;
        Cellobj[i][j] = new Cell(new PieceRook(!isWhite),new Position((char)(j+'A'),i+1)) ;        
        
        i=2 ; j=5 ;
        Cellobj[i][j] = new Cell(new PieceKnight(!isWhite),new Position((char)(j+'A'),i+1)) ;         
 
    }
    private void Test_initialization1() 
    {
        Cellobj = new Cell[8][8] ;
        KingInfo = new Cell[2] ;
        KingCheckList = new ArrayList[2] ;
        KingCheckList[0] = new ArrayList<Cell>() ;
        KingCheckList[1] = new ArrayList<Cell>() ;

        
        for(int i=0 ; i<8 ; i++)
        {
            for(int j=0 ; j<8 ;j++)
                Cellobj[i][j] = new Cell(null,new Position((char)(j+'A'),i+1)) ;
        }

        int i=1,j=3 ;
        boolean isWhite = false ;
        
        Cellobj[i][j] = new Cell(new PieceKing(isWhite),new Position((char)(j+'A'),i+1)) ;
        KingInfo[0] = Cellobj[i][j] ;

        i=2 ; j=2 ;
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ;  
        
        i=1 ; j=2 ;
        Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ; 
        
        i=3 ; j=2 ;
        Cellobj[i][j] = new Cell(new PieceKnight(isWhite),new Position((char)(j+'A'),i+1)) ; 
    
        i=7;j=1 ;        
                
        Cellobj[i][j] = new Cell(new PieceKing(!isWhite),new Position((char)(j+'A'),i+1)) ;
        KingInfo[1] = Cellobj[i][j] ;
        
        //Queen
        i=6;j=4 ;
        Cellobj[i][j] = new Cell(new PieceQueen(!isWhite),new Position((char)(j+'A'),i+1)) ;

        i=2 ; j=0 ;
        Cellobj[i][j] = new Cell(new PieceBishop(!isWhite),new Position((char)(j+'A'),i+1)) ; 

        i=5 ; j=5 ;
        Cellobj[i][j] = new Cell(new PieceRook(!isWhite),new Position((char)(j+'A'),i+1)) ;         

    }

    public Cell getCellInfo(char ch,int j)
    {
        int i = (int)(ch-'A') ;
        return Cellobj[j-1][i] ;
    }

    public Cell getCellInfo(int i,int j)
    {
        return Cellobj[i][j] ;
    }

    public void printBoard() 
    {
        System.out.print(" ") ;
        for(char i='A' ; i<='H' ; i++)
            System.out.print("  "+i+" ") ;
        
        System.out.println() ;
        for(int i=0 ; i<8 ; i++)
        {
            for(int j=0 ; j<9 ; j++)
            {
                if(j==0)
                    System.out.print(i+1) ;
                else if(this.Cellobj[i][j-1].getPiece()==null)
                    System.out.print("  . ") ;
                else
                    System.out.print("  "+Cellobj[i][j-1].getPiece().getSymbol()+" ") ;
            }
            System.out.println() ;
        }
    }

    private void initialization() 
    {
        Cellobj = new Cell[8][8] ;
        KingInfo = new Cell[2] ;    
        KingCheckList = new ArrayList[2] ;
        KingCheckList[0] = new ArrayList<Cell>() ;
        KingCheckList[1] = new ArrayList<Cell>() ;           

        Piece pieceobjnull = null ;

        boolean isWhite = false ;

        for(int i=0 ; i<8 ; i++)
        {
            for(int j=0 ; j<8 ; j++)
            {
                //Pawn
                if(i==1)
                    Cellobj[i][j] = new Cell(new PiecePawn(isWhite),new Position((char)(j+'A'),i+1)) ;
                
                else if(i==6)
                    Cellobj[i][j] = new Cell(new PiecePawn(!isWhite),new Position((char)(j+'A'),i+1)) ;
                
                //Rook
                else if(i==0 && (j==0 || j==7))
                    Cellobj[i][j] = new Cell(new PieceRook(isWhite),new Position((char)(j+'A'),i+1)) ;
                
                else if(i==7 && (j==0 || j==7))
                    Cellobj[i][j] = new Cell(new PieceRook(!isWhite),new Position((char)(j+'A'),i+1)) ;
                
                //Bishop
                else if(i==0 && (j==2 || j==5))
                    Cellobj[i][j] = new Cell(new PieceBishop(isWhite),new Position((char)(j+'A'),i+1)) ;
                
                else if(i==7 && (j==2 || j==5))
                    Cellobj[i][j] = new Cell(new PieceBishop(!isWhite),new Position((char)(j+'A'),i+1)) ;

                //Knight
                else if(i==0 && (j==1 || j==6))
                    Cellobj[i][j] = new Cell(new PieceKnight(isWhite),new Position((char)(j+'A'),i+1)) ;
                
                else if(i==7 && (j==1 || j==6))
                    Cellobj[i][j] = new Cell(new PieceKnight(!isWhite),new Position((char)(j+'A'),i+1)) ;

                //King
                else if(i==0 && j==3)
                {
                    Cellobj[i][j] = new Cell(new PieceKing(isWhite),new Position((char)(j+'A'),i+1)) ;
                    KingInfo[0] = Cellobj[i][j] ;
                }
                
                else if(i==7 && j==3)
                {
                    Cellobj[i][j] = new Cell(new PieceKing(!isWhite),new Position((char)(j+'A'),i+1)) ;
                    KingInfo[1] = Cellobj[i][j] ;
                }
                //Queen
                else if(i==0 && j==4)
                    Cellobj[i][j] = new Cell(new PieceQueen(isWhite),new Position((char)(j+'A'),i+1)) ;
            
                else if(i==7 && j==4)
                    Cellobj[i][j] = new Cell(new PieceQueen(!isWhite),new Position((char)(j+'A'),i+1)) ;
                
                else
                    Cellobj[i][j] = new Cell(pieceobjnull,new Position((char)(j+'A'),i+1)) ;
            }
        }

    }

    public boolean CheckValid(Cell src_cell, Cell dest_cell,boolean PlayerColor) 
    {
        return src_cell.getPiece()!=null &&
                src_cell.getPiece().validMove(this,src_cell, dest_cell) && 
                PlayerColor==src_cell.getPiece().getisWhite() &&
                (dest_cell.getPiece()==null || 
                dest_cell.getPiece().getisWhite()!=src_cell.getPiece().getisWhite() ) ;
    }

    private boolean isCapture(Cell dest_cell,Player pobj) 
    {
        if(dest_cell.getPiece()!=null && dest_cell.getPiece().getisWhite() != pobj.getPlayerColor())
            return true ;

        return false;
    }

    public boolean MakeMove(Cell src_cell,Cell dest_cell, Player pobj) 
    {
        Cell src_curr_cell = src_cell ;
        Cell dest_curr_cell = dest_cell ;

        Piece src_piece = src_cell.getPiece() ;
        Piece dest_piece = dest_cell.getPiece() ;

        boolean capture = isCapture(dest_cell, pobj) ;

        if(capture==true)
        {
            Piece killPiece = dest_cell.getPiece() ;

            if(pobj.getPlayerColor()==true)
                System.out.println("Black "+killPiece.getName()+" Killed");
            else
                System.out.println("White "+killPiece.getName()+" Killed");
            
            if(dest_piece.getName()==PieceType.KING)
            {
                if(dest_piece.getisWhite()==true)
                    KingInfo[1].setPiece(null) ;
                else
                    KingInfo[0].setPiece(null) ;
            }
            killPiece.KillPiece();
            killPiece = null ;
        }

        src_cell.setPiece(null);
        dest_cell.setPiece(src_piece);

        if(src_piece.getName() == PieceType.KING)
        {
            if(pobj.getPlayerColor() == true)
                KingInfo[1] = dest_cell ;
            else
                KingInfo[0] = dest_cell ;
        }

        Cell KingCell ;
        // if(pobj.getPlayerColor()==true)
        //     KingCell = KingInfo[1] ;
        // else
        //     KingCell = KingInfo[0] ;

        boolean isMoveReal = true ;
        
        for(int i=0 ; i<KingInfo.length ; i++)
        {        
            KingCell = KingInfo[i] ;
            if(FindKingCheck(KingCell,isMoveReal) == true )
            {
                ((PieceKing)KingCell.getPiece()).setKingCheck(true);

                if(KingCell.getPiece().getisWhite()==true)
                    System.out.println("White King is on CHECK !!") ;
                else
                    System.out.println("Black King is on CHECK !!") ;
                
                if((pobj.getPlayerColor() == true && 
                  ((PieceKing)KingInfo[1].getPiece()).getKingCheck() == true) ||
                  (pobj.getPlayerColor() == false && 
                  ((PieceKing)KingInfo[0].getPiece()).getKingCheck() == true))
                    ResetVirtualMove(src_curr_cell,dest_curr_cell,dest_piece) ;    
                
            }
            else
            {
                if(KingCell.getPiece().getisWhite()==true)
                    KingCheckList[1].clear() ;
                else
                    KingCheckList[0].clear() ;

                ((PieceKing)KingCell.getPiece()).setKingCheck(false);
            }
        }

        boolean col = pobj.getPlayerColor() ;

        if(col == true && ((PieceKing)KingInfo[1].getPiece()).getKingCheck() == true)
            return true ;

        if(col == false && ((PieceKing)KingInfo[0].getPiece()).getKingCheck() == true)
            return true ;
        
        return false ;
    }

    private void ResetVirtualMove(Cell src_curr_cell, Cell dest_curr_cell,Piece dest_Piece) 
    {
        src_curr_cell.setPiece(dest_curr_cell.getPiece());
        dest_curr_cell.setPiece(dest_Piece);

        if(src_curr_cell.getPiece().getName() == PieceType.KING)
        {
            if(src_curr_cell.getPiece().getisWhite() == true)
                KingInfo[1] = src_curr_cell ;
            else
                KingInfo[0] = src_curr_cell ;
        }
    }

    private boolean FindKingCheck(Cell kingCell,Boolean isMoveReal) 
    {
        boolean isKnight = KnightCheck(kingCell,isMoveReal) ;
        boolean isRow = RowVerCheck(kingCell,isMoveReal) ;
        boolean isDiagonal = DiagonalCheck(kingCell,isMoveReal) ;

        if(isKnight || isRow || isDiagonal)
            return true ;

        return false ;
    }

    private boolean DiagonalCheck(Cell kingCell,boolean isMoveReal) 
    {
        boolean isFromPawn = PawnCheck(kingCell,isMoveReal) ;
        
        if(isFromPawn)
            return true ;

        boolean kingColor = kingCell.getPiece().getisWhite() ;

        int idx=0;
        if(kingColor == true)
            idx=1 ;

        int x = kingCell.getPostion().getI()-1 ;
        int y = (int)(kingCell.getPostion().getCh()-'A') ;

        int[] dx = {1,1,-1,-1} ;
        int[] dy = {1,-1,-1,1} ;

        for(int i=0 ; i<4 ; i++)
        {
            int newx = x+dx[i] ;
            int newy = y+dy[i] ;

            while(newx<8 && newx>=0 && newy<8 && newy>=0)
            {
                if(Cellobj[newx][newy].getPiece()!=null && 
                   Cellobj[newx][newy].getPiece().getisWhite()!=kingColor &&
                   (Cellobj[newx][newy].getPiece().getName() == PieceType.BISHOP || 
                   Cellobj[newx][newy].getPiece().getName() == PieceType.QUEEN ))
                {
                    if(isMoveReal == true)
                        KingCheckList[idx].add(Cellobj[newx][newy]) ;
                    
                    return true ;
                }
                
                if(Cellobj[newx][newy].getPiece()!=null && Cellobj[newx][newy].getPiece().getisWhite()==kingColor)
                    break ;
                
                newx += dx[i] ;
                newy += dy[i] ;
            }
        }

        return false;
    }

    private boolean PawnCheck(Cell kingCell,boolean isMoveReal) 
    {
        boolean kingColor = kingCell.getPiece().getisWhite() ;

        int idx=0 ;
        if(kingColor == true)
            idx=1 ;

        int x = kingCell.getPostion().getI()-1 ;
        int y = (int)(kingCell.getPostion().getCh()-'A') ;

        if(kingColor == false)
        {
            if(x+1<8 && y+1<8 && 
                Cellobj[x+1][y+1].getPiece()!=null &&
                Cellobj[x+1][y+1].getPiece().getisWhite()!=kingColor && 
                Cellobj[x+1][y+1].getPiece().getName() == PieceType.PAWN)
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x+1][y+1]) ;
                
                return true ;
            }

            if(x+1<8 && y-1>=0 && 
                Cellobj[x+1][y-1].getPiece()!=null &&
                Cellobj[x+1][y-1].getPiece().getisWhite()!=kingColor && 
                Cellobj[x+1][y-1].getPiece().getName() == PieceType.PAWN)
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x+1][y-1]) ;
                
                return true ;
            }
        }
        else
        {
            if(x-1>=0 && y-1>=0 && 
                Cellobj[x-1][y-1].getPiece()!=null &&
                Cellobj[x-1][y-1].getPiece().getisWhite()!=kingColor && 
                Cellobj[x-1][y-1].getPiece().getName() == PieceType.PAWN)
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x-1][y-1]) ;
                
                return true ;
            }

            if(x-1>=0 && y+1<8 && 
                Cellobj[x-1][y+1].getPiece()!=null &&
                Cellobj[x-1][y+1].getPiece().getisWhite()!=kingColor && 
                Cellobj[x-1][y+1].getPiece().getName() == PieceType.PAWN)
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x-1][y+1]) ;
                
                return true ;
            }
        }

        return false ;
        
    }

    private boolean RowVerCheck(Cell kingCell,boolean isMoveReal) 
    {
        boolean kingColor = kingCell.getPiece().getisWhite() ;

        int idx=0 ;
        if(kingColor == true)
            idx=1 ;

        int x = kingCell.getPostion().getI()-1 ;
        int y = (int)(kingCell.getPostion().getCh()-'A') ;

        //down
        for(int i=x+1 ; i<8 ; i++)
        {
            if(Cellobj[i][y].getPiece()==null)
                continue;

            if(Cellobj[i][y].getPiece().getisWhite()!=kingColor && 
               (Cellobj[i][y].getPiece().getName() == PieceType.ROOK || 
               Cellobj[i][y].getPiece().getName() == PieceType.QUEEN ))
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[i][y]) ;
                
                return true ;
            }
            
            if(Cellobj[i][y].getPiece().getisWhite()==kingColor)
                break ;
            
            if((Cellobj[i][y].getPiece().getisWhite()!=kingColor &&
                Cellobj[i][y].getPiece().getName() != PieceType.ROOK  &&
                Cellobj[i][y].getPiece().getName() != PieceType.QUEEN ))
                break ;
        }

        //up
        for(int i=x-1 ; i>=0 ; i--)
        {
            if(Cellobj[i][y].getPiece()==null)
                continue;

            if(Cellobj[i][y].getPiece().getisWhite()!=kingColor && 
               (Cellobj[i][y].getPiece().getName() == PieceType.ROOK || 
               Cellobj[i][y].getPiece().getName() == PieceType.QUEEN ))
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[i][y]) ;
                
                return true ;
            }
            
            if(Cellobj[i][y].getPiece().getisWhite()==kingColor)
                break ;
            
            if((Cellobj[i][y].getPiece().getisWhite()!=kingColor &&
                Cellobj[i][y].getPiece().getName() != PieceType.ROOK  &&
                Cellobj[i][y].getPiece().getName() != PieceType.QUEEN ))
                break ;
        }

        //right
        for(int i=y+1 ; i<8 ; i++)
        {
            if(Cellobj[x][i].getPiece()==null)
                continue;

            if(Cellobj[x][i].getPiece().getisWhite()!=kingColor && 
               (Cellobj[x][i].getPiece().getName() == PieceType.ROOK || 
               Cellobj[x][i].getPiece().getName() == PieceType.QUEEN ))
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x][i]) ;
                
                return true ;
            }
            
            if(Cellobj[x][i].getPiece().getisWhite()==kingColor)
                break ;
            
            if((Cellobj[x][i].getPiece().getisWhite()!=kingColor &&
                Cellobj[x][i].getPiece().getName() != PieceType.ROOK  &&
                Cellobj[x][i].getPiece().getName() != PieceType.QUEEN ))
                break ;
        }

        //left
        for(int i=y-1 ; i>=0 ; i--)
        {
            if(Cellobj[x][i].getPiece()==null)
                continue;

            if(Cellobj[x][i].getPiece().getisWhite()!=kingColor && 
               (Cellobj[x][i].getPiece().getName() == PieceType.ROOK || 
               Cellobj[x][i].getPiece().getName() == PieceType.QUEEN ))
            {
                if(isMoveReal == true)
                    KingCheckList[idx].add(Cellobj[x][i]) ;
                
                return true ;
            }
            
            if(Cellobj[x][i].getPiece().getisWhite()==kingColor)
                break ;
            
            if((Cellobj[x][i].getPiece().getisWhite()!=kingColor &&
                Cellobj[x][i].getPiece().getName() != PieceType.ROOK  &&
                Cellobj[x][i].getPiece().getName() != PieceType.QUEEN ))
                break ;
        }
        return false ;
        
    }

    private boolean KnightCheck(Cell kingCell,boolean isMoveReal) 
    {
        boolean kingColor = kingCell.getPiece().getisWhite() ;

        int idx=0; 
        if(kingColor == true)
            idx=1 ;

        int x = kingCell.getPostion().getI()-1 ;
        int y = (int)(kingCell.getPostion().getCh()-'A') ;

        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

        for (int i = 0; i < 8; i++) 
        {
            int newx = x + dx[i];
            int newy = y + dy[i];
            
            if(newx>=0 && newx<8 && newy>=0 && newy<8)
            {
                if(Cellobj[newx][newy].getPiece()!=null && 
                   Cellobj[newx][newy].getPiece().getisWhite()!=kingColor && 
                   Cellobj[newx][newy].getPiece().getName() == PieceType.KNIGHT)
                {
                    if(isMoveReal == true)
                        KingCheckList[idx].add(Cellobj[newx][newy]) ;

                    return true ;
                }
            }
        }

        return false;
    }

    public boolean CheckWinner(boolean PlayerColor) 
    {
        Cell KingCell ;
        if(PlayerColor==true)
            KingCell = KingInfo[0] ;
        else
            KingCell = KingInfo[1] ;

        // int idx = 0 ;
        // if(KingCell.getPiece().getisWhite() == true)
        //     idx=1 ;

        //Check King can move
        boolean isKingCanMove = KingMove(KingCell) ;

        if(isKingCanMove == true)
            return false ;
        
        boolean isPlayerCanMove = PlayerCanMove(!PlayerColor) ;

        return !isPlayerCanMove ;         

        //it means King Can't Move there check for pieceKill
        // boolean isCheckPieceKill = CheckPieceKill(KingCell.getPiece().getisWhite()) ;

        // if(isCheckPieceKill == true)
        //     return false ;

        // //it means king cant move and cant kill piece therefore findObstacle 
        // boolean isObstacle = false ;
        // PieceType PieceName = KingCheckList[idx].get(0).getPiece().getName() ;

        // if(PieceName == PieceType.QUEEN || PieceName == PieceType.BISHOP || PieceName == PieceType.ROOK)
        //     isObstacle = CheckObstacle(this,KingCell,PlayerColor) ;
        
        // if(isObstacle == true)
        //     return false ;
        
        //return true ;
    }

    private boolean PlayerCanMove(boolean PlayerColor) 
    {
        int idx=0 ;
        if(PlayerColor == true)
            idx=1 ;
        
        Cell KingCell = KingInfo[idx] ;

        for(int i=0 ; i<8; i++)
        {
            for(int j=0 ; j<8 ; j++)
            {
                if(Cellobj[i][j].getPiece() == null || Cellobj[i][j].getPiece().getisWhite() != PlayerColor)
                    continue ;
                
                Cell src = Cellobj[i][j] ;
                ArrayList<Cell> dest ;
                PieceType PieceName = src.getPiece().getName() ;
                
                dest = FindDestCell(src,PieceName) ;
                
                for(int k=0 ; k<dest.size() ; k++)
                {
                    if(MakeVirtualMove(KingCell, src, dest.get(k), false,src.getPiece().getName() == PieceType.KING) == true)
                        return true ;
                }
            }
        }
        return false;
    }

    private ArrayList<Cell> FindDestCell(Cell src, PieceType pieceName) 
    {
        int x = src.getPostion().getI()-1 ;
        int y = (int)(src.getPostion().getCh()-'A') ;
        boolean PieceColor = src.getPiece().getisWhite() ;

        ArrayList<Cell> dest = new ArrayList<>() ;
        
        if(src.getPiece().getName() == PieceType.KNIGHT)
        {
            int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
            int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
    
            for (int i = 0; i < 8; i++) 
            {
                int newx = x + dx[i];
                int newy = y + dy[i];
                
                if(newx>=0 && newx<8 && newy>=0 && newy<8)
                {
                    if(Cellobj[newx][newy].getPiece()==null ||
                       Cellobj[newx][newy].getPiece().getisWhite()!=PieceColor)
                    {
                        dest.add(Cellobj[newx][newy]) ;
                    }
                }
            }    
        }

        if(src.getPiece().getName() == PieceType.ROOK || src.getPiece().getName() == PieceType.QUEEN)
        {
            //down
            for(int i=x+1 ; i<8 ; i++)
            {
                if(Cellobj[i][y].getPiece()==null)
                    dest.add(Cellobj[i][y]) ;
                
                else if(Cellobj[i][y].getPiece().getisWhite()!=PieceColor)
                {
                    dest.add(Cellobj[i][y]) ;
                    break ;
                }
                else
                    break ;
            }

            //up
            for(int i=x-1 ; i>=0 ; i--)
            {
                if(Cellobj[i][y].getPiece()==null)
                    dest.add(Cellobj[i][y]) ;
                
                else if(Cellobj[i][y].getPiece().getisWhite()!=PieceColor)
                {
                    dest.add(Cellobj[i][y]) ;
                    break ;
                }
                else
                    break ;
            }

            //right
            for(int i=y+1 ; i<8 ; i++)
            {
                if(Cellobj[x][i].getPiece()==null)
                dest.add(Cellobj[x][i]) ;
            
                else if(Cellobj[x][i].getPiece().getisWhite()!=PieceColor)
                {
                    dest.add(Cellobj[x][i]) ;
                    break ;
                }
                else
                    break ;
            }

            //left
            for(int i=y-1 ; i>=0 ; i--)
            {
                if(Cellobj[x][i].getPiece()==null)
                dest.add(Cellobj[x][i]) ;
            
                else if(Cellobj[x][i].getPiece().getisWhite()!=PieceColor)
                {
                    dest.add(Cellobj[x][i]) ;
                    break ;
                }
                else
                    break ;
            }
            
        }

        if(src.getPiece().getName() == PieceType.BISHOP || src.getPiece().getName() == PieceType.QUEEN)
        {
            int[] dx = {1,1,-1,-1} ;
            int[] dy = {1,-1,-1,1} ;
    
            for(int i=0 ; i<4 ; i++)
            {
                int newx = x+dx[i] ;
                int newy = y+dy[i] ;
    
                while(newx<8 && newx>=0 && newy<8 && newy>=0)
                {
                    if(Cellobj[newx][newy].getPiece()==null)
                        dest.add(Cellobj[newx][newy]) ;
                    
                    else if(Cellobj[newx][newy].getPiece().getisWhite()!=PieceColor)
                    {
                        dest.add(Cellobj[newx][newy]) ;
                        break ;
                    }
                    else
                        break ;
    
                    newx += dx[i] ;
                    newy += dy[i] ;
                }
            } 
        }
        
        if(src.getPiece().getName() == PieceType.PAWN)
        {
            if(PieceColor == true)
            {
                if(x-1>=0 && y-1>=0 && Cellobj[x-1][y-1].getPiece()!=null && Cellobj[x-1][y-1].getPiece().getisWhite()!=PieceColor)
                    dest.add(Cellobj[x-1][y-1]) ;
                
                if(x-1>=0 && y+1<8 && Cellobj[x-1][y+1].getPiece()!=null && Cellobj[x-1][y+1].getPiece().getisWhite()!=PieceColor)
                    dest.add(Cellobj[x-1][y+1]) ;
                
                if(x-1>=0 && Cellobj[x-1][y].getPiece()==null)
                    dest.add(Cellobj[x-1][y]) ;

                if(((PiecePawn)(src.getPiece())).getFirstMove() == true)
                {
                    if(x-1>=0 && x-2>=0 && Cellobj[x-1][y].getPiece()==null && Cellobj[x-2][y].getPiece()==null)
                        dest.add(Cellobj[x-2][y]) ;
                }
            }
            else
            {
                if(x+1<8 && y-1>=0 && Cellobj[x+1][y-1].getPiece()!=null && Cellobj[x+1][y-1].getPiece().getisWhite()!=PieceColor)
                    dest.add(Cellobj[x+1][y-1]) ;
                
                if(x+1<8 && y+1<8 && Cellobj[x+1][y+1].getPiece()!=null && Cellobj[x+1][y+1].getPiece().getisWhite()!=PieceColor)
                    dest.add(Cellobj[x+1][y+1]) ;
                
                if(x+1<8 && Cellobj[x+1][y].getPiece()==null)
                    dest.add(Cellobj[x+1][y]) ;

                if(((PiecePawn)(src.getPiece())).getFirstMove() == true)
                {
                    if(x+1<8 && x+2<8 && Cellobj[x+1][y].getPiece()==null && Cellobj[x+2][y].getPiece()==null)
                        dest.add(Cellobj[x+2][y]) ;
                }
            }
        }
        return dest;
    }

    // private boolean CheckObstacle(Board boardobj,Cell KingCell,boolean PlayerColor) 
    // {
    //     int kingPosX = KingCell.getPostion().getI()-1 ;
    //     int kingPosY = (int)(KingCell.getPostion().getCh()-'A') ;
    //     boolean kingColor = KingCell.getPiece().getisWhite() ;

    //     int idx=0 ;
    //     if(kingColor == true)
    //         idx=1 ;
        
    //     Cell checkCell = KingCheckList[idx].get(0) ;

    //     int CheckPiecePosX = checkCell.getPostion().getI()-1 ;
    //     int CheckPiecePosY = (int)(checkCell.getPostion().getCh()-'A') ;
        
    //     int idx_x = CheckPiecePosX - kingPosX ;
    //     int idx_y = CheckPiecePosY - kingPosY ;

    //     if((Math.abs(idx_x) == 0 && Math.abs(idx_y) == 1) || 
    //        (Math.abs(idx_x) == 1 && Math.abs(idx_y) == 0) ||
    //        (Math.abs(idx_x) == 1 && Math.abs(idx_y) == 1))
    //         return false ;
        
    //     if(idx_x!=0)
    //         idx_x = idx_x/Math.abs(idx_x) ;

    //     if(idx_y!=0)
    //         idx_y = idx_y/Math.abs(idx_y) ;

    //     while(true)
    //     {
    //         int newx = kingPosX + idx_x ;
    //         int newy = kingPosY + idx_y ;

    //         if(newx == CheckPiecePosX && newy == CheckPiecePosY)
    //             break ;

    //         Cell dest_cell = Cellobj[newx][newy] ;

    //         for(int i=0 ; i<8  ;i++)
    //         {
    //             for(int j=0 ; j<8 ; j++)
    //             {
    //                 Cell src_cell = Cellobj[i][j] ;

    //                 if(src_cell.getPiece()!=null && src_cell.getPiece().getisWhite() != kingColor)
    //                     continue ;
                    
    //                 if(CheckValid(src_cell,dest_cell,!PlayerColor) == true &&
    //                    MakeVirtualMove(KingCell,src_cell, dest_cell,false,src_cell.getPiece().getName() == PieceType.KING) == true )
    //                 return true ;
    //             }
    //         }
    //         kingPosX = newx ;
    //         kingPosY = newy ;
    //     }

    //     return false;
    // }

    // private boolean CheckPieceKill(boolean color) 
    // {
    //     Cell KillPiece ;
    //     if(color == true)
    //         KillPiece = KingCheckList[1].get(0) ;
    //     else
    //         KillPiece = KingCheckList[0].get(0) ;

    //     if(FindKingCheck(KillPiece,false) == true)
    //         return true ;

    //     return false;
    // }

    private boolean KingMove(Cell KingCell) 
    {
        int[] dx = {1,1,1,0,-1,-1,-1,0} ;
        int[] dy = {1,0,-1,-1,-1,0,1,1} ; 

        int kingPosX = KingCell.getPostion().getI()-1 ;
        int kingPosY = (int)(KingCell.getPostion().getCh()-'A') ;
        boolean kingColor = KingCell.getPiece().getisWhite() ;
        boolean isKingMove = true ;

        for(int i=0 ; i<8 ; i++)
        {
            int newx = kingPosX + dx[i] ;
            int newy = kingPosY + dy[i] ;

            if(newx>=0 && newx<8 && newy>=0 && newy<8)
            {
                if(Cellobj[newx][newy].getPiece() == null || Cellobj[newx][newy].getPiece().getisWhite()!=kingColor)
                {
                    Cell src = KingCell ;
                    Cell dest = Cellobj[newx][newy] ;
                
                    boolean isMovePossible = MakeVirtualMove(KingCell,src,dest,false,isKingMove) ;

                    if(isMovePossible == true)
                        return true ;
                }    
            }
        }

        return false ;
    }

    private boolean MakeVirtualMove(Cell KingCell,Cell src_cell, Cell dest_cell,boolean isMoveReal,boolean isKingMove) 
    {
        boolean isMovePossible = false ;
        Piece destPiece = dest_cell.getPiece() ;
        Piece src_piece = src_cell.getPiece() ;
        Cell MoveCell ;
        src_cell.setPiece(null);
        dest_cell.setPiece(src_piece);

        if(isKingMove == true)
            MoveCell = dest_cell ;
        else
            MoveCell = KingCell ;
        
        if(FindKingCheck(MoveCell,isMoveReal)== false)
            isMovePossible = true ;
        
        ResetVirtualMove(src_cell, dest_cell, destPiece);

        return isMovePossible;
    }

}
