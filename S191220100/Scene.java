package S191220100;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import example.classloader.SteganographyClassLoader;

public class Scene {
    public static void main(String[] args) throws Exception {
        String log = "";

        LineLike line = new Line(64);
        Snake theSnake = Snake.getSnakeObject();

        SteganographyClassLoader quickSorterLoader = new SteganographyClassLoader(
                new URL("file:S191220100/source/S191220100.QuickSorter.png"));

        Class c = quickSorterLoader.loadClass("S191220100.QuickSorter");

        Sorter quickSorter = (Sorter) c.newInstance();        

        SteganographyClassLoader selectSorterLoader = new SteganographyClassLoader(
                new URL("file:S191220100/source/S191220100.SelectSorter.png"));

        c = selectSorterLoader.loadClass("S191220100.SelectSorter");

        Sorter selectSorter = (Sorter) c.newInstance();

        //task 2
        theSnake.setSorter(quickSorter);
        line.setRandList();
        log = theSnake.lineUP(line);
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("S191220100/result/quickSort.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

        
        theSnake.setSorter(selectSorter);
        line.setRandList();
        log = theSnake.lineUP(line);
        writer = new BufferedWriter(new FileWriter("S191220100/result/selectSort.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}