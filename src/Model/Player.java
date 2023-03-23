package Model;

public class Player 
{
    private String Name ;
    private boolean PlayerColor ;
    public Player(String name,boolean color)
    {
        this.Name = name ;
        this.PlayerColor = color ;
    }
    public String getName()
    {
        return this.Name ;
    }
    public boolean getPlayerColor()
    {
        return this.PlayerColor ;
    } 
}
