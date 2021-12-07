import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CollatzConjecture {
    public static void main (String[] args) {
        try {
            long timeStart = System.currentTimeMillis();
            BufferedWriter output = new BufferedWriter(new FileWriter("./tests.csv"));
            for (int i = 1; i <=100000; i++) {
                String line = writeLine(i);
                output.append(line + "\n");
            }
            output.close();
            System.out.println("took " + String.valueOf(System.currentTimeMillis() - timeStart) + "ms");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static String writeLine (long num) {
        ArrayList<String> line = new ArrayList<String>(100);
        line.add(String.valueOf(num));
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
                line.add(String.valueOf(num));
            } else {
                num = (num * 3) + 1;
                line.add(String.valueOf(num));
            }
        }

        return String.join(",", line);

    }
}