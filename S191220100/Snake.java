package S191220100;

public class Snake {
    private Sorter sorter;
    private static Snake theSnake = null;

    private Snake(){}

    public static Snake getSnakeObject(){
        if(theSnake == null)
            theSnake = new Snake();
        return theSnake;
    }

    public void setSorter(Sorter s){
        this.sorter = s;
    }

    public String lineUP(LineLike line){
        String log = new String();

        if (this.sorter == null)
            return null;
        
        int[] queue = line.toArray();

        this.sorter.load(queue);
        this.sorter.sort();

        String[] sortSteps = this.sorter.getSortLog().split("\n");
        for(String step : sortSteps){
            String[] positions = step.split(",");
            line.swap(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
            log = log + line.toString();
            log = log + "\n[frame]\n";
        }
        return log;
    }
}