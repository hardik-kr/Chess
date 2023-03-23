package Model;

public class PieceRook extends Piece 
{
    private static char blackSymbol = '♜' ;
    private static char whiteSymbol = '♖' ;

    public PieceRook(boolean white) 
    {
        super(white,blackSymbol,whiteSymbol,PieceType.ROOK);
    }

    public boolean validMove(Board boardobj,Cell src,Cell dest) 
    {
        if(src.getPiece()==null || src.getPostion() == dest.getPostion())
            return false ; 

        if(dest.getPiece()!=null && dest.getPiece().getisWhite() == src.getPiece().getisWhite())
            return false;

        int srcy = (int)(src.getPostion().getCh()-'A') ;
        int srcx = src.getPostion().getI()-1 ;

        int desty = (int)(dest.getPostion().getCh()-'A') ;
        int destx = dest.getPostion().getI()-1 ;

        if(srcx!=destx && srcy!=desty)
            return false ;

        int[] dx = {1,0,-1,0} ;
        int[] dy = {0,-1,0,1} ;

        int idx=-1 ;
        if(destx-srcx>0 && desty==srcy)
            idx=0 ;
        
        else if(destx==srcx && desty-srcy<0)
            idx=1 ;
        
        else if(destx-srcx<0 && desty==srcy)
            idx=2 ;
        
        else if(destx==srcx && desty-srcy>0)
            idx=3 ;
            
        while(true)
        {
            int newx = srcx+dx[idx] ;
            int newy = srcy+dy[idx] ;

            if(newx==destx && newy==desty)
                break ;

            if(boardobj.getCellInfo(newx,newy).getPiece()!=null )
                return false ;
            
            srcx = newx ;
            srcy = newy ;           
        }

        return true ;
    }
    
}
