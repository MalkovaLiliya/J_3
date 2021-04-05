import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        String[] strArr = {"nic", "Commu", "ation"};

        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i]);
        }
        System.out.println();
        swapElements(strArr, 0, 1);
        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i]);
        }

        //Задание 2
        doArrList(strArr);
        List<String> list = doArrList(strArr);
        System.out.println("\n" + list);

        //Задание 3
        //Задача 3. Коробки с фруктами
        System.out.println("Task 3");
        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBoxOne = new Box();
        Box<Orange> orangeBoxTwo = new Box();
        Box<Apple> appleBox = new Box();

        for (int i = 0; i < 5; i++) {
            orangeBoxOne.add(new Orange());
        }

        for (int i = 0; i < 4; i++) {
            orangeBoxTwo.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }


        orangeBoxOne.info();
        orangeBoxTwo.info();
        appleBox.info();

        System.out.println("Вес коробки 1 с апельсинами: " + orangeBoxOne.getWeight());
        System.out.println("Вес коробки 2 с апельсинами: " + orangeBoxTwo.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());

        System.out.println("Сравнить вес orangeBoxOne и appleBox: " + orangeBoxOne.compare(appleBox));


        orangeBoxOne.moveAt(orangeBoxTwo);
        orangeBoxOne.info();
        orangeBoxTwo.info();
    }

    static <T> void swapElements(T[] arr, int ind1, int ind2) {
        T tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    static <E> List<E> doArrList(E[] arr){
        List<E> list = new ArrayList<E>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
