package S191220100;

public class Matrix extends LineLike{
    public Matrix(int length){
        array = new Goblin[length];
        for(int i = 0; i < length; i++){
            this.array[i] = new Goblin(i);
        }
    }
    
    @Override
    public String toString(){
        String ret = "\t";
        int count = 0;
        for(Linable x : this.array){
            ret = ret + x.toString();
            count = (count + 1) % 8;
            if(count == 0)
                ret = ret + "\n\t";
        }
        return ret;
    }
}