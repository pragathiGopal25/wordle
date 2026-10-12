import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


class text extends JFrame implements ActionListener {
    static JTextField t;
    static JFrame f;
    static JButton b;
    static JLabel l;
    static BoardPanel board;
    text(){}

    public static void main (String[] args){
        f = new JFrame("Wordle");

        l = new JLabel("Enter Word");
        b = new JButton("submit");
        t = new JTextField(16);

        text te = new text();
        b.addActionListener(te);

        board = new BoardPanel();
        JPanel p = new JPanel();

        p.add(t);
        p.add(b);
        p.add(l);

        f.setLayout(new BorderLayout());
        f.add(board, BorderLayout.CENTER);
        f.add(p, BorderLayout.SOUTH);

        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        String guess = t.getText().trim().toUpperCase();

        if (s.equals("submit")){
            l.setText(guess);
            t.setText(" ");
            board.addGuess(guess);
        }
    }
}


class BoardPanel extends JPanel {
    ArrayList<String> guesses = new ArrayList<String>();

    public void addGuess(String guess){

        if (guesses.size() <= 5) {
            guesses.add(guess);
            repaint();
        }
    }

    public void paint(Graphics g){
        super.paintComponent(g);

        int w = 50;
        int h = 60;
        int startX = 50;
        int startY = 50;
        int gap = 10;

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 


        for (int row = 0; row < 5; row++) {
            String word = row < guesses.size() ? guesses.get(row) : "";

            for (int col = 0; col < 5; col++) {
                int x = startX + col * (w + gap);
                int y = startY + row * (h + gap);
                g2.drawRect(x, y, w, h);

                if (word.length() >= 1) {
                    g2.drawString(String.valueOf(word.charAt(col)), x + 15, y + 40);
                }
            }
        }
    }
}
