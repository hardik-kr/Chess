package Model;

public class Position 
{
    private char ch ;
    private int i ;
    public Position(char ch,int i)
    {
        this.setCh(ch);
        this.setI(i);
    }
    public void setCh(char ch) 
    {
        this.ch = ch ;
    }
    public void setI(int i)
    {
        this.i = i ;
    }
    public char getCh()
    {
        return this.ch ;
    }
    public int getI()
    {
        return this.i ;
    }

}
