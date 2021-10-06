package S191220100;

public class SelectSorter implements Sorter{
    String log;
    int[] array;

    public SelectSorter(){
        log = "";
        array = null;
    }

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        log = log + "" + i + "," + j + "\n"; 
    }


    @Override
    public void load(int[] array){
        this.array = array;
    }

    @Override
    public void sort(){
        if(this.array == null)
            return;
        this.log = "";
        for(int i = 0; i <= this.array.length - 2; i++){
            int minIndex = i;
            for(int j = i + 1; j <= this.array.length - 1; j++){
                if(this.array[j] < this.array[minIndex])
                    minIndex = j;
            }
            this.swap(i, minIndex);
        }
    }

    @Override
    public String getSortLog(){
        return this.log;
    }
}