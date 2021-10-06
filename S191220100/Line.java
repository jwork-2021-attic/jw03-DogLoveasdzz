package S191220100;

public class Line extends LineLike{
    public Line(int length){
        array = new Goblin[length];
        for(int i = 0; i < length; i++){
            this.array[i] = new Goblin(i);
        }
    }
    
    @Override
    public String toString(){
        String ret = "";
        for(Linable x : this.array){
            ret = ret + x.toString();
        }
        return ret;
    }
}