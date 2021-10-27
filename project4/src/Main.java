import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        int w = 4;
        int c = 0;
        int n = 0;
        int ca = 0;
        List<String> wordsList = new ArrayList<>();

        try {
            File source = new File("words.txt");
            Scanner myReader = new Scanner(source);
            while (myReader.hasNext()) {
                wordsList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Scanner command = new Scanner(System.in);
        while (command.hasNext()) {
            switch (command.next()) {
                case "--help":
                case "-h":
                    printHelp();
                    break;
                case "--words":
                case "-w":
                    try {
                        String num = command.next();
                        int input = Integer.parseInt(num);
                        w = input;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input. type  --help  or -h for help");
                        System.exit(1);
                    }
                    break;
                case "--caps":
                case "-c":
                    try {
                        String num = command.next();
                        int input = Integer.parseInt(num);
                        c = input;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input. type  --help  or -h for help");
                        System.exit(1);
                    }
                    break;
                case "--numbers":
                case "-n":
                    try {
                        String num = command.next();
                        int input = Integer.parseInt(num);
                        n = input;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input. type  --help  or -h for help");
                        System.exit(1);
                    }
                    break;

                case "--symbols":
                case "-s":
                    try{
                        String num = command.next();
                        int input = Integer.parseInt(num);
                        ca = input;
                    }catch (NumberFormatException e){
                        System.out.println("invalid input. type  --help  or -h for help");
                        System.exit(1);
                    }
                    break;
                default:
                    System.out.println("invalid input. type  --help  or -h for help");
                    System.exit(1);
            }
        }
        passwordGen ps = new passwordGen(w,c,n,ca,wordsList);
        System.out.println(ps.generate());
    }


    public static void printHelp() {
        String helpstate = "usage: xkcdpwgen [-h] [-w WORDS] [-c CAPS] [-n NUMBERS] [-s SYMBOLS]\n" +
                "                \n" +
                "Generate a secure, memorable password using the XKCD method\n" +
                "                \n" +
                "optional arguments:\n" +
                "    -h, --help            show this help message and exit\n" +
                "    -w WORDS, --words WORDS\n" +
                "                          include WORDS words in the password (default=4)\n" +
                "    -c CAPS, --caps CAPS  capitalize the first letter of CAPS random words\n" +
                "                          (default=0)\n" +
                "    -n NUMBERS, --numbers NUMBERS\n" +
                "                          insert NUMBERS random numbers in the password\n" +
                "                          (default=0)\n" +
                "    -s SYMBOLS, --symbols SYMBOLS\n" +
                "                          insert SYMBOLS random symbols in the password\n" +
                "                          (default=0)";
        System.out.println(helpstate);
    }


}