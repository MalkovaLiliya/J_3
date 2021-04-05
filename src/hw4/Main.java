package hw4;

public class Main {
    private static final Object MONITOR = new Object();
    private static volatile char actualLetter = 'A';
    public static void main(String[] args) {

        Thread tA = new Thread(() -> {
            runThread('A');
        });

        Thread tB = new Thread(() -> {
            runThread('B');
        });

        Thread tC = new Thread(() -> {
            runThread('C');
        });
        tA.start();
        tB.start();
        tC.start();

        // задача с мфу
        MFU mfu = new MFU();

        new Thread(() -> { mfu.programsMFU(5, MFU.progMFU.XEROCOPY); }).start();
        new Thread(() -> { mfu.programsMFU(6, MFU.progMFU.PRINT); }).start();
        new Thread(() -> { mfu.programsMFU(2, MFU.progMFU.COPY); }).start();
        new Thread(() -> { mfu.programsMFU(3, MFU.progMFU.XEROCOPY); }).start();
        new Thread(() -> { mfu.programsMFU(4, MFU.progMFU.PRINT); }).start();





    }

    public static void runThread(char letter)
    {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (actualLetter != letter) {
                        MONITOR.wait();
                    }
                    System.out.print(letter);
                    if (letter == 'A')
                        actualLetter = 'B';
                    if (letter == 'B')
                        actualLetter = 'C';
                    if (letter == 'C')
                        actualLetter = 'A';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
