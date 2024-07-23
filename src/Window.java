import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Window extends JFrame {

    // Loads the logo image
    ImageIcon logo = new ImageIcon("images/logo.png");

    // Defines the size of the window
    int width = getMonitorSize(true);
    int height = getMonitorSize(false);

    // Creates frequently used colors
    Color window_color = new Color(0x123456);
    Color cream = new Color(0xFCFBF4);

    // Class constructor
    Window(){

        // Creates window, sets color, size, icon and title

        // Color
        this.getContentPane().setBackground(this.window_color);
        // Size
        this.setSize(this.width, this.height);
        // Icon image
        this.setIconImage(this.logo.getImage());
        // Title
        this.setTitle("Zaphiro");
        // Makes it so that the program closes when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes the window not resizable
        this.setResizable(false);
        // Sets the layout type
        this.setLayout(null);
        // The first window is the login
        this.login();
    }

    // Login box
    private void login(){

        // Creates the login panel
        JPanel log_panel = getLogPanel();

        // Creating login text (label)
        JLabel logText = getLogText();

        // Creating username text field and password text field
        JTextField userName = getTextField(21, 67.18, 3.7, 28, 230.0, "Username");
        JPasswordField passWord = getPasswordField(10, 67.18, 3.7, 28,"Password");
        listeningText(userName, "Username");
        listeningPassword(passWord, "Password");

        // Adds all the components to the panel
        log_panel.add(logText);
        log_panel.add(userName);
        log_panel.add(passWord);

        // Adds the panel to the window
        this.add(log_panel);
        this.setVisible(false);
        this.setVisible(true);

    }

    private void listeningText(JTextField someField, String defaultMessage){
       someField.addFocusListener(new FocusListener() {
         @Override
         public void focusGained(FocusEvent e) {
             if (someField.getText().equals(defaultMessage)){
                 someField.setText("");
             }

         }

           @Override
           public void focusLost(FocusEvent e) {
               if (someField.getText().isEmpty()){
                   someField.setText(defaultMessage);

               }
           }
       });
    }

    private void listeningPassword(JPasswordField someField, String defaultMessage){
        someField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (new String(someField.getPassword()).equals(defaultMessage)){
                    someField.setText("");
                    someField.setEchoChar('*');
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (someField.getPassword().length==0){
                    someField.setText(defaultMessage);
                    someField.setEchoChar((char)0);
                }
            }
        });
    }

    private JLabel getLogText(){
        // Creating Label
        JLabel logText = new JLabel("Login");

        // Setting up Label
        logText.setFont(new Font("SansSerif", Font.BOLD, (int)(this.width/44.8)));
        logText.setForeground(this.cream);
        logText.setBackground(this.window_color);
        logText.setBounds((int)(this.width / 8.4), (this.width / 100), (this.width / 16), (this.width / 35));

        return logText;
    }

    private JPanel getLogPanel() {
        // Creates the boarder for the panel
        Border log_border = BorderFactory.createLineBorder(this.cream, (this.width/215));

        // Panel position and size
        int panelWidth = get_aspect_ratio(0.7, this.width);
        int panelHeight = get_aspect_ratio(0.7, this.height);
        int panelPx = get_aspect_ratio(0.65, this.width);
        int panelPy = get_aspect_ratio(0.7, this.height);

        // Creating login panel (panel)
        JPanel log_panel = new JPanel();

        // Setting up panel
        log_panel.setLayout(null);
        log_panel.setBounds(panelPx, panelPy, panelWidth, panelHeight);
        log_panel.setBackground(this.window_color);
        log_panel.setBorder(log_border);

        return log_panel;
    }

    private JPasswordField getPasswordField(double Py, double Px, double sizeX, double sizeY, String message){

        JPasswordField newPassField = new JPasswordField(message);
        Border newBoarder = BorderFactory.createLineBorder(this.cream, (this.width/230));

        // TextField position and size
        int textWidth = (int)(this.width/sizeX);
        int textHeight = (int)(this.width/sizeY);
        int textPx = (int)(this.width/Px);
        int textPy = (int)(this.width/Py);

        newPassField.setBounds(textPx, textPy, textWidth, textHeight);
        newPassField.setBackground(this.window_color);
        newPassField.setText(message);
        newPassField.setFont(new Font("SansSerif", Font.PLAIN, (int)(this.width/44.8)));
        newPassField.setForeground(this.cream);
        newPassField.setEchoChar((char)0);
        newPassField.setBorder(newBoarder);

        return newPassField;
    }

    // Makes a textfield
    private JTextField getTextField(double Py, double Px, double sizeX, double sizeY, Double boarder, String message){
        // Creating JTextField
        JTextField newTextfield = new JTextField();

        // Creating boarder for textfield
        if (boarder != null) {
            Border userBoarder = BorderFactory.createLineBorder(this.cream, (this.width / 230));
            newTextfield.setBorder(userBoarder);
        }

        // TextField position and size
        int textWidth = (int)(this.width/sizeX);
        int textHeight = (int)(this.width/sizeY);
        int textPx = (int)(this.width/Px);
        int textPy = (int)(this.width/Py);

        // Setting up text field
        newTextfield.setFont(new Font("SansSerif", Font.PLAIN, (int)(this.width/44.8)));
        newTextfield.setForeground(this.cream);
        newTextfield.setCaretColor(this.cream);
        newTextfield.setBackground(this.window_color);
        newTextfield.setBounds(textPx, textPy, textWidth, textHeight);
        if (message != null  ) {
            newTextfield.setText(message);
        }
        return newTextfield;
    }

    // Gets the monitor size and determines the window size
    static int getMonitorSize(Boolean width){
        int size_of_window;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        if (width){
            size_of_window = (int)(size.width - size.width * 0.25);
        }
        else{
            size_of_window = (int)(size.height - size.height * 0.25);
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

