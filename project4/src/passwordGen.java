import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class passwordGen {
    int wordsNum;
    int capsNum;
    int numNum;
    int charNum;
    List<String> wordList;

    public passwordGen(int w, int c, int n, int cha, List<String> wordList) {
        this.wordsNum = w;
        if (c > w) {
            throw new IllegalArgumentException("invalid input, cap words cannt be greatter than the total nume of words");
        }
        capsNum = c;
        numNum = n;
        charNum = cha;
        this.wordList = wordList;
    }

    public String generate() {
        StringBuffer password = new StringBuffer();
        int size = wordList.size();
        Random ranGen = new Random();
        int totalC = capsNum;
        int totalNum = numNum;
        int totalChar = charNum;
        List<String> listS = Arrays.asList("~", "!", "@", "#", "$", "%", "^", "&", "*", ".", ":", ";");

        for (int i = wordsNum; i > 0; i--) {
            if (ranGen.nextBoolean() && totalNum > 0) {
                password.append(ranGen.nextInt(10));
                totalNum--;
            }
            if (ranGen.nextBoolean() && totalChar > 0) {
                password.append(listS.get(ranGen.nextInt(listS.size())));
                totalChar--;
            }
            int ranNum = ranGen.nextInt(size);
            String wordsOri = wordList.get(ranNum);
            String words = "";
            if (totalC == i) {
                words = wordsOri.substring(0, 1).toUpperCase() + wordsOri.substring(1);
                totalC--;
            } else {
                int ranC = ranGen.nextInt(wordsNum) + 1;
                if (ranC == i) {
                    words = wordsOri.substring(0, 1).toUpperCase() + wordsOri.substring(1);
                    totalC--;
                } else {
                    words = wordsOri;
                }

            }
            password.append(words);
        }
        if (totalNum > 0) {
            for (int i = totalNum; i > 0; i--) {
                password.append(ranGen.nextInt(10));
                totalNum--;
            }
        }
        if (totalChar > 0) {
            for (int i = totalChar; i > 0; i--) {
                password.append(listS.get(ranGen.nextInt(listS.size())));
                totalChar--;
            }
        }
        return password.toString();

    }
}
