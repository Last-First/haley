package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Eru on 4/1/2016.
 */
public class Interface {

    public JTextField tf_response;
    public JLabel pic;
    public TextArea backread;

    private static final long serialVersionUID = 1L;
//    public static final int WIDTH = 320;
//    public static final int HEIGHT = WIDTH / 12 * 9;
//    public static final int SCALE = 2;
    public JFrame frame;

    public void init() {

//        ui.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
//        ui.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
//        ui.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame("");
//        frame.add(ui);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setBounds(100, 100, 700, 702);

        tf_response = new JTextField();
        tf_response.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent arg0) {
                if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
                    String response = tf_response.getText();
                    tf_response.setText("");
                    backread.append("You: " + response + "\n");
                    Algo r = new Algo();
                    backread.append(r.reply(response));
//                    for (int i = 0; r.img(i) == null; i++){
//                        pic.setIcon(r.img(i));
//                        i++;
//                    }
                }
            }
        });
        tf_response.setBounds(31, 513, 375, 31);
        frame.getContentPane().add(tf_response);
        tf_response.setColumns(10);

        //  Conversation History
        backread = new TextArea();
        backread.setEditable(false);
        backread.setBounds(31, 376, 375, 126);
        frame.getContentPane().add(backread);

        //  Return Life Hack Picture
        pic = new JLabel();
        pic.setBounds(31, 24, 339, 339);
        frame.getContentPane().add(pic);

        //  Set Background Picture
        JLabel bennett = new JLabel();
        bennett.setIcon(new ImageIcon(Main.class.getResource("/pics/Haley" + ".jpg")));
        frame.getContentPane().add(bennett);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
