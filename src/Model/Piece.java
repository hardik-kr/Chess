package Model;

public abstract class Piece 
{
    private char whiteSymbol ;
    private char blackSymbol ;
    private boolean isWhite  ;
    private boolean isAlive ;
    private PieceType Name ;
    
    public Piece(boolean white,char Whsym,char Blsym,PieceType name)
    {
        this.isWhite = white ;
        this.isAlive = true ;
        this.whiteSymbol = Whsym ;
        this.blackSymbol = Blsym ;
        this.Name = name ;
    }

    public void KillPiece()
    {
        this.isAlive = false ;
    }
    public boolean getisAlive()
    {
        return  this.isAlive ;
    }
    public boolean getisWhite()
    {
        return  this.isWhite ;
    }
    public PieceType getName()
    {
        return this.Name ;
    }
    public char getSymbol()
    {
        if(getisWhite()==true)
            return this.whiteSymbol ;
            
        return this.blackSymbol ;
    }
    public abstract boolean validMove(Board obj,Cell src,Cell dest) ;
    
}
