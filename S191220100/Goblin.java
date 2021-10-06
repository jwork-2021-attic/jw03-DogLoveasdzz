package S191220100;

public class Goblin implements Linable{
    private int value;

    public Goblin(){
        value = 0;
    }

    public Goblin(int v){
        value = v;
    }

    @Override
    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return "\033[48;2;" + this.getR() + ";" + this.getG() + ";" + this.getB() + ";38;2;0;0;0m    \033[0m";
    }

    @Override
    public void setValue(int v){
        this.value = v;
    }

    private int getR(){
        if(this.value*12 > 255)
            return 255;
        else
            return this.value*12;
    }

    private int getG(){
        if(this.value*12 >= 255*2)
            return 255;
        else if(this.value*12 > 255)
            return this.value*12 - 255;
        else
            return 0;
    }

    private int getB(){
        if(this.value*12 <= 255*2)
            return 0;
        else
            return this.value*12 - 255*2;
    }
}