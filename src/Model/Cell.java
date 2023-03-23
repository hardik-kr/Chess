package Model;

public class Cell 
{
    private Piece pieceObj ;
    private Position posObj ;

    public Cell(Piece Pobj,Position posobj)
    {
        this.setPiece(Pobj) ;
        this.setPosition(posobj) ;
    }
    public void setPosition(Position posobj) 
    {
        this.posObj = posobj ;
    }
    public void setPiece(Piece pobj) 
    {
        this.pieceObj = pobj ;
    }
    public Position getPostion()
    {
        return this.posObj ;
    }
    public Piece getPiece()
    {
        return this.pieceObj ;
    }




    
}
