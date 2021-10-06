package S191220100;

import java.util.Random;

public abstract class LineLike {
    protected Linable[] array;

    public void setRandList(){
        Linable temp;
        Random rand = new Random();
        for(int i = 0; i < 2000; i++){
            int a = rand.nextInt(array.length);
            int b = rand.nextInt(array.length);
            temp = this.array[a];
            this.array[a] = this.array[b];
            this.array[b] = temp;
        }
    }

    public abstract String toString();

    public int[] toArray(){
        int[] ret = new int[this.array.length];
        for(int i = 0; i < this.array.length; i++){
            ret[i] = this.array[i].getValue();
        }
        return ret;
    }

    public void swap(int i, int j){
        Linable temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
}