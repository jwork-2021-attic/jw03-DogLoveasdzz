package S191220100;

public class QuickSorter implements Sorter{
    String log;
    int[] array;
    
    public QuickSorter(){
        log = "";
        array = null;
    }

    private void swap(int i, int j){
        if(i == j)
            return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        log = log + "" + i + "," + j + "\n"; 
    }

    private void quickSortStep(int head, int tail){
        if(head >= tail)
            return;
        int pivot = head;
        for(int i = head + 1; i <= tail; i++){
            if(this.array[i] < this.array[head]){
                pivot++;
                this.swap(i, pivot);
            }
        }
        this.swap(head, pivot);
        this.quickSortStep(head, pivot - 1);
        this.quickSortStep(pivot + 1, tail);
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
        this.quickSortStep(0, this.array.length - 1);
    }

    @Override
    public String getSortLog(){
        return this.log;
    }
}