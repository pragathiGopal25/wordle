import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ParseWordFile {
    private final List<String> words = new ArrayList<>();
    private final Random rand = new Random();

    public ParseWordFile() throws IOException {
        readFile();
    }

    public void readFile() throws IOException {
        String filename = "words.txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }
        }
    }
    
    public String generateRandomWord(){
        int boundInt = rand.nextInt(words.size());
        return words.get(boundInt);
    }


    public boolean checkValidity(String w) {
        return words.contains(w);
    }
    
    public static void main (String args[]) throws IOException{
        ParseWordFile pw = new ParseWordFile();
        System.out.println(pw.generateRandomWord());
    }
}