import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

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

        if (s.equals("submit")){
            l.setText(t.getText());
            t.setText(" ");
            board.repaint();
        }
    }

}


class BoardPanel extends JPanel {
  
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(50, 50, 50, 60);
        g2.drawRect(110, 50, 50, 60);
        g2.drawRect(170, 50, 50, 60);
        g2.drawRect(230, 50, 50, 60);
        g2.drawRect(290, 50, 50, 60);

        g2.drawRect(50, 120, 50, 60);
        g2.drawRect(110, 120, 50, 60);
        g2.drawRect(170, 120, 50, 60);
        g2.drawRect(230, 120, 50, 60);
        g2.drawRect(290, 120, 50, 60);

        g2.drawRect(50, 190, 50, 60);
        g2.drawRect(110, 190, 50, 60);
        g2.drawRect(170, 190, 50, 60);
        g2.drawRect(230, 190, 50, 60);
        g2.drawRect(290, 190, 50, 60);

        g2.drawRect(50, 260, 50, 60);
        g2.drawRect(110, 260, 50, 60);
        g2.drawRect(170, 260, 50, 60);
        g2.drawRect(230, 260, 50, 60);
        g2.drawRect(290, 260, 50, 60);

        g2.drawRect(50, 330, 50, 60);
        g2.drawRect(110, 330, 50, 60);
        g2.drawRect(170, 330, 50, 60);
        g2.drawRect(230, 330, 50, 60);
        g2.drawRect(290, 330, 50, 60);
    }
}
