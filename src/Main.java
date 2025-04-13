import Sorting.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        ComparingAndExchanging compare = new ComparingAndExchanging();
        Insertion insertion = new Insertion();
        Selection selection = new Selection();
        Quick quick = new Quick();

        Merge merge = new Merge();
        boolean consoleoutput = false;
        int linecount = 0;
        String filenameinput = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Comparable[] inputarray = null;

        bw.write("What do you want to do?");
        bw.newLine();
        bw.write("1. Write input");
        bw.newLine();
        bw.write("2. Read from file");
        bw.newLine();
        bw.flush();

        String input = br.readLine();
        switch(input) {
            case "1":
                consoleoutput = true;
                bw.write("What is the input size?");
                bw.newLine();
                bw.flush();
                int n = Integer.parseInt(br.readLine());
                bw.write("Write your input line by line or copy paste");
                bw.newLine();
                bw.flush();
                inputarray = new Comparable[n];
                for (int i = 0; i < n; i++) {
                    inputarray[i] = br.readLine();
                }
                break;
            case "2":
                bw.write("What is the file path?");
                bw.newLine();
                bw.flush();
                filenameinput = br.readLine();
                BufferedReader bf = new BufferedReader(new FileReader(filenameinput));
                while (bf.readLine() != null) {
                    linecount++;
                }

                bf.close();
                bf = new BufferedReader(new FileReader(filenameinput));

                inputarray = new Comparable[linecount];
                int i = 0;
                Comparable line;
                while ((line = bf.readLine()) != null) {
                    inputarray[i++] = line;
                }
                bf.close();
                break;
        }

        bw.write("How do you want to sort?");
        bw.newLine();
        bw.write("1. Selection Sort");
        bw.newLine();
        bw.write("2. Insertion Sort");
        bw.newLine();
        bw.write("3. Merge Sort");
        bw.newLine();
        bw.write("4. Quick Sort");
        bw.newLine();
        bw.flush();

        input = br.readLine();
        double start = System.nanoTime();
        switch(input) {
            case "1":
                selection.sort(inputarray);
                break;
            case "2":
                insertion.sort(inputarray);
                break;
            case "3":
                merge.sort(inputarray);
                break;
            case "4":
                quick.sort(inputarray);
                break;
        }
        double end = System.nanoTime();

        if (consoleoutput) {
            for (Comparable x : inputarray) {
                bw.write((String) x);
                bw.newLine();
            }
        } else {
            Path currentRelativePath = Paths.get("");
            String currentPath = currentRelativePath.toAbsolutePath().toString();

            Path path = Paths.get(currentPath, "src", "Sorting", "sorted.txt");
            String filePath = path.toString();
            File file = new File(filePath);

            try {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }

                if (file.createNewFile()) {
                    bw.write("File Created: " + file.getName());
                    bw.newLine();
                } else {
                    bw.write("Data updated in: " + file.getName());
                    bw.newLine();
                }
                bw.flush();
            } catch (IOException e) {
                bw.write("Error: Unable to create or write to file.");
                bw.newLine();
                e.printStackTrace();
            }

            try (BufferedWriter bn = new BufferedWriter(new FileWriter(file, false))) {
                for (Comparable x : inputarray) {
                    bn.write(x.toString());
                    bn.newLine();
                }
            } catch (IOException e) {
                bw.write("Error: Unable to write to file.");
                bw.newLine();
                e.printStackTrace();
            }
        }

        bw.write(String.format("Time elapsed: " + "%.10f", (end - start) / 1_000_000_000.0) + "s");
        bw.flush();
    }
}