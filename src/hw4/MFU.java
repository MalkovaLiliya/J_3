package hw4;

public class MFU {
    private final Object COPYm = new Object();
    private final Object PRINTm = new Object();

    public void programsMFU (int sheets, progMFU prg) {

        switch (prg){
            case COPY:
                {
                synchronized (COPYm) {
                    System.out.println("Делаем скан в файл");
                    for (int i = 0; i < sheets; i++) {
                        System.out.println("Страница " + (i+1) + " отсканирована и добавлена в файл scan.pdf");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сканирование завершено");
                    break;
                }
            }
            case PRINT:
            {
                synchronized (PRINTm) {
                    System.out.println("Печать документа. Количество страниц: " + sheets);
                    for (int i = 0; i < sheets; i++) {
                        System.out.println("Страница " + (i+1) + " напечатана");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Печать завершена");
                    break;
                }
            }
            case XEROCOPY:
            {
                synchronized (COPYm) {
                    System.out.println("Делаем ксерокопию");
                    for (int i = 0; i < sheets; i++) {
                        System.out.println("Страница " + (i+1) + " отсканирована и напечатана");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сканирование завершено");
                    break;
                }
            }
        }

    }
    public enum progMFU {
        XEROCOPY,
        COPY,
        PRINT
    }
}
