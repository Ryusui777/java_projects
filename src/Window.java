import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Window extends JFrame {

    String logo_image = "images/logo.png"; // Company's logo path
    ImageIcon logo = new ImageIcon(logo_image); // Loaded company's logo
    int width = get_monitor_size(true);
    int height = get_monitor_size(false);
    Color window_color = new Color(0x123456);

    // Class constructor
    Window(){
        // Creates window, sets color, size, icon and title
        this.setTitle("Zaphiro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(this.width, this.height);
        this.setVisible(true);
        this.setIconImage(this.logo.getImage());
        this.getContentPane().setBackground(this.window_color);

    }
    // Login box
    public void login(){

        // Creating login box boarder
        Border log_border = BorderFactory.createLineBorder(new Color(0xfcfbf4), 5);
        JPanel panel = new JPanel();
        panel.setBackground(this.window_color);
        panel.setBounds(get_aspect_ratio(0.65, this.width),
                        get_aspect_ratio(0.7, this.height),
                        get_aspect_ratio(0.7, this.width),
                        get_aspect_ratio(0.7, this.height));
        panel.setBorder(log_border);
        this.add(panel);

    }
    // Gets the monitor size and determines the window size
    static int get_monitor_size(Boolean width){
        int size_of_window;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        if (width){
            size_of_window = (int)(size.width - size.width * 0.3);
        }
        else{
            size_of_window = (int)(size.height - size.height * 0.3);
        }
        return size_of_window;


    }

    // Calculates the aspect ratio of components based on
    static int get_aspect_ratio(double aspectRatio, int contrastingSize){
        int adjusted_size;
        adjusted_size = (int)(contrastingSize - contrastingSize * aspectRatio);
        return adjusted_size;
    }

}

