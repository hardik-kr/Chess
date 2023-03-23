package Model;

public class PiecePawn extends Piece
{
    private static char blackSymbol = '♟' ;
    private static char whiteSymbol = '♙' ;
    private boolean firstMove ;

    public PiecePawn(boolean white) 
    {
        super(white,blackSymbol,whiteSymbol,PieceType.PAWN);
    }
    public boolean getFirstMove()
    {
        return !(this.firstMove) ;
    }
    public void setFirstMove()
    {
        this.firstMove = true ;
    }

    public boolean validMove(Board boardobj,Cell src,Cell dest) 
    {
        if(src.getPiece()==null || src.getPostion() == dest.getPostion())
            return false ; 
            
        if(dest.getPiece()!=null && dest.getPiece().getisWhite() == src.getPiece().getisWhite())
            return false;

        int srcy = (int)(src.getPostion().getCh()-'A') ;
        int desty = (int)(dest.getPostion().getCh()-'A') ;
        int srcx = src.getPostion().getI()-1 ;
        int destx = dest.getPostion().getI()-1 ;

        int x = Math.abs(destx-srcx) ;
        int signx = destx-srcx ;
        int y = Math.abs(desty-srcy) ;

        if(x==0)
            return false ;

        int sign = (destx-srcx)/x ;

        if(src.getPiece().getisWhite() == true && signx>0 || src.getPiece().getisWhite() == false && signx<0 )
            return false ;

        //Diagonal capture
        if(x==1 && y==1 && dest.getPiece()!=null && dest.getPiece().getisWhite()!=src.getPiece().getisWhite())
            return true ;

        if(x>2 || y!=0 || (getFirstMove()==false && x==2))
            return false ;

        for(int i=1 ; i<=x && x<=2 ; i++)
        {
            if(boardobj.getCellInfo(srcx+(sign)*i, srcy).getPiece() != null )
                return false ;
        }

        setFirstMove() ;

        return true ;
    }
    
}
