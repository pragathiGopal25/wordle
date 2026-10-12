class WordleGame {
    String word;
    String[] guesses = new int[5];

    public WordleGame(){
        ParseWordFile pw = new ParseWordFile();
        word = pw.generateRandomWord();
    }

    
}