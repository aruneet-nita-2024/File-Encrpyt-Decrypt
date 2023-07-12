import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageOperations {

    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        try {
            FileInputStream fis = new FileInputStream(file);
            byte data[] = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("File Encrpyt & Decrpyt");
        f.setSize(500, 500);
        f.setLocationRelativeTo(f);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Font font = new Font("Roboto", Font.BOLD, 20);

        // Creating buttons
        JButton button1 = new JButton();
        button1.setText("Encrypt");
        button1.setFont(font);

        JButton button2 = new JButton();
        button2.setText("Decrypt");
        button2.setFont(font);

        // Creating text fields
        JTextField textField1 = new JTextField(10);
        textField1.setFont(font);
        textField1.setText("pass-phrase");

        JTextField textField2 = new JTextField(10);
        textField2.setFont(font);
        textField2.setText("pass-phrase");

        // Creating panels
        JPanel panel1 = new JPanel();
        panel1.add(button1);
        panel1.add(textField1);

        JPanel panel2 = new JPanel();
        panel2.add(button2);
        panel2.add(textField2);

        button1.addActionListener(e -> {
            String text = textField1.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        button2.addActionListener(e -> {
            String text = textField2.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        // Setting layout
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100));
        f.add(panel1);
        f.add(panel2);
        f.setVisible(true);
    }
}
