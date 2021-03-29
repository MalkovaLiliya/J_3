package hw3;

import java.io.*;
import java.util.*;

public class Main {


        public static void main(String[] args) {
            try {
                readArrayOfBytes();
                sewFiles();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void readArrayOfBytes() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("task1"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while((x = in.read()) != -1) {
            out.write(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));
        in.close();
        out.close();
    }

    public static void sewFiles() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            al.add(new FileInputStream("task2_" + i + ".txt"));
        }
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);

        }
        in.close();
    }
    }

