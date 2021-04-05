package hw3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("task_3.docx", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter page:");
        int p = sc.nextInt() - 1;
        raf.seek(p * PAGE_SIZE);

        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char) raf.read());
        }
        raf.close();
    }




}
