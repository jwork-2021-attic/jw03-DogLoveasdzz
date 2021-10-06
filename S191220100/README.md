# 一.代码工作原理理解
1. 生成图片
+ 调用java编译器，将对应的.java源码文件编译成.class字节码文件
+ 找到.class字节码文件以及对应的图片文件，将其交给SteganographyEncoder对象，将字节码加密到图片中，再将图片输出。
2. 代码排序算法运行
+ 继承Classoader（重写findClass方法）：
    + 找到对应的图片文件
    + 将图片文件交给SteganographyEncoder对象，将加密在图片中的字节码以byte数组的形式输出
    + 调用父类的defineClass方法，将byte数组作为class加载
+ 实际运行
    + 将图片交给SteganographyClassLoader对象，调用loadClass方法试图加载类
    + SteganographyClassLoader对象向父类委托加载类的任务（本例中父类应未能加载类），由于父类未能加载，故调用自身的findClass方法。
    + Sorter类被成功加载到内存并运行

# 二.Sorter图片的URL
说明：我在W02的Sorter实现方式和example Sorter的实现方式略有不同。example的排序器getPlan得到的结果是一串记录，每个记录都对应了两个Linable对象，意为两者交换位置。由于Position类对我而言太过抽象，故在写W02时舍弃了Position，排序器getSortLog得到的也是一串记录，不过是对应了两个位置，而不是对应两个Linable对象。所以W02的排序器在example上将不起作用。故二、三步均是在我的W02基础上完成的。

1. quickSorter：S191220100/source/S191220100.QuickSorter.png
2. selectSorter：S191220100/source/S191220100.SelectSorter.png

# 三.排序结果视频
1. quickSorter：<https://asciinema.org/a/440384>
2. selectSorter：<https://asciinema.org/a/440388>

# 四.
尝试了学号191220097同学的QuickSorter，未能成功运行，不清楚是不是这位同学的sorter实现方式也不同于example，或者图片下载后因压缩而发生了更变。报错如下：
```
Exception in thread "main" java.lang.NoClassDefFoundError: S191220097/QuickSorter (wrong name: S191220097/Sorter)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1017)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:878)
        at example.classloader.SteganographyClassLoader.findClass(SteganographyClassLoader.java:32)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:589)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1017)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:878)
        at example.classloader.SteganographyClassLoader.findClass(SteganographyClassLoader.java:32)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:589)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
        at example.Scene.main(Scene.java:27)
```