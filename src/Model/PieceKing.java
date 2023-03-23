package Model;

public class PieceKing extends Piece 
{
    private static char blackSymbol = '♚' ;
    private static char whiteSymbol = '♔' ;
    private boolean isCheck ;
    
    public PieceKing(boolean white) 
    {
        super(white,blackSymbol,whiteSymbol,PieceType.KING);
    }

    public boolean getKingCheck()
    {
        return this.isCheck ;
    }

    public void setKingCheck(boolean check)
    {
        this.isCheck = check ;
    }
    public boolean validMove(Board boardobj,Cell src,Cell dest) 
    {
        if(src.getPiece()==null || src.getPostion() == dest.getPostion())
            return false ;

        if(dest.getPiece()!=null && dest.getPiece().getisWhite() == src.getPiece().getisWhite())
            return false;

        int srcy = (int)(src.getPostion().getCh()-'A') ;
        int srcx = src.getPostion().getI() ;

        int desty = (int)(dest.getPostion().getCh()-'A') ;
        int destx = dest.getPostion().getI() ;

        int x = Math.abs(srcx-destx) ;
        int y = Math.abs(srcy-desty) ;

        return x+y<=2;
    }
    
}
