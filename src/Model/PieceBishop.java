package Model;

public class PieceBishop extends Piece 
{
    private static char blackSymbol = '♝' ;
    private static char whiteSymbol = '♗' ;

    public PieceBishop(boolean white) 
    {
        super(white,blackSymbol,whiteSymbol,PieceType.BISHOP);
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

        int x = Math.abs(srcx-destx) ;
        int y = Math.abs(srcy-desty) ;

        if(x!=y) 
            return false ;
        
        int[] dx = {1,1,-1,-1} ;
        int[] dy = {1,-1,-1,1} ;

        int idx=-1 ;
        if(destx-srcx>0 && desty-srcy>0)
            idx=0 ;
        
        else if(destx-srcx>0 && desty-srcy<0)
            idx=1 ;
        
        else if(destx-srcx<0 && desty-srcy<0)
            idx=2 ;
        
        else if(destx-srcx<0 && desty-srcy>0)
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
