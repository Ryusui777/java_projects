import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Window(){
        System.out.println("Window Created Successfully");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program
        this.setSize(1000,650);
        this.setVisible(true);

        ImageIcon logo = new ImageIcon("images/logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(0x123456));
    }

}

