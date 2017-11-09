import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo application");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placeComponents(frame);
        frame.setVisible(true);
    }

    private static void placeComponents(JFrame frame) {
        frame.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        frame.add(userText);

        JLabel passText = new JLabel("Password");
        passText.setBounds(10, 40, 80, 25);
        frame.add(passText);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        frame.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        frame.add(loginButton);

        ActionListener loginButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                JOptionPane.showMessageDialog(source, userText.getText());
                String username = userText.getText();                       //User inputs username
                String pass = passwordText.getText();                       //User inputs password
                int status = 0;
                DBConnect connect = new DBConnect();
                status = connect.getLogin(username,pass);                   //Sends user input to be verified
                System.out.println(status);

                if (status == 1)
                {
                            //User login here
                }else if (status == 2){
                            //Admin login here
                }else{
                    JOptionPane.showMessageDialog(source,"Incorrect Login");
                }
            }
        };
        loginButton.addActionListener(loginButtonListener);

    }

}
