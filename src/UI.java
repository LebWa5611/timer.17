import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel timer = new JLabel("Timer");
    JLabel label = new JLabel("0");
    JLabel label1 = new JLabel("0");
    JLabel label2 = new JLabel("0");

    private Custom threadCustom;
    private Custom1 threadCustom1;
    private Custom2 threadCustom2;

    public UI(){
        setSize(600, 485);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        panel.setBounds(0, 350, 600, 100);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(Color.GRAY);
        add(panel, BorderLayout.SOUTH);

        panel1.setBounds(0, 0, 600, 500);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setLayout(null);
        add(panel1);

        label.setFont(new Font("Arial", Font.PLAIN, 70));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 125, 120, 100);
        panel1.add(label);

        label1.setFont(new Font("Arial",Font.PLAIN,70));
        label1.setForeground(Color.WHITE);
        label1.setBounds(260, 125, 120, 100);
        panel1.add(label1);

        label2.setFont(new Font("Arial",Font.PLAIN,70));
        label2.setForeground(Color.WHITE);
        label2.setBounds(430, 125, 120, 100);
        panel1.add(label2);

        timer.setFont(new Font("Arial",Font.BOLD,70));
        timer.setForeground(Color.WHITE);
        timer.setLayout(null);
        timer.setBounds(180,-180,getWidth(),getHeight());
        panel1.add(timer);

        JButton start = new JButton("Start");
        start.setFont(new Font("Arial", Font.BOLD, 20));
        start.setPreferredSize(new Dimension(100, 60));
        start.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        start.setBackground(Color.WHITE);
        panel.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadCustom = new Custom(label2);
                threadCustom1 = new Custom1(label1);
                threadCustom2 = new Custom2(label);
                threadCustom.start();
                threadCustom1.start();
                threadCustom2.start();
            }
        });

        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (start.getBackground() == Color.WHITE) {
                    start.setBackground(Color.GREEN);
                }
            }
                @Override
                public void mouseExited(MouseEvent e) {
                    start.setBackground(Color.WHITE);
                }
        });

        JButton stop = new JButton("Stop");
        stop.setFont(new Font("Arial", Font.BOLD, 20));
        stop.setPreferredSize(new Dimension(100, 60));
        stop.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        stop.setBackground(Color.WHITE);
        panel.add(stop);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(threadCustom != null) threadCustom.stopThread();
                if(threadCustom1 != null) threadCustom1.stopThread();
                if(threadCustom2 != null) threadCustom2.stopThread();
            }
        });
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(stop.getBackground() == Color.WHITE){
                    stop.setBackground(Color.RED);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
class Custom extends Thread {
    JLabel txt;
    boolean running = true;

    public Custom(JLabel txt) {
        this.txt = txt;
    }
    public void stopThread() {
        running = false;
    }
    public void run() {
        int i = 0;
        while (running) {
            txt.setText(String.valueOf(i));
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Custom1 extends Thread {
    JLabel txt;
    boolean running = true;

    public Custom1(JLabel txt) {
        this.txt = txt;
    }
    public void stopThread(){
        running = false;
    }
    public void run() {
        int i = 0;
        while (running) {
            txt.setText(String.valueOf(i));
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Custom2 extends Thread {
    JLabel txt;
    boolean running = true;

    public Custom2(JLabel txt) {
        this.txt = txt;
    }
    public void stopThread(){
        running = false;
    }
    public void run() {
        int i = 0;
        while (running) {
            txt.setText(String.valueOf(i));
            i++;
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

