import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.JMenuBar;

public class LoginMenu {

    public static JTextField username;
    public static JPasswordField password;
    static JFrame frame;
    static JLabel passwordL;
    static JLabel usernameL;
    static JButton login;

    static JPanel loginMenu, passMenu;

	public static void main(String args[])
	{
		frame = new JFrame();
		frame.setSize(375, 150);
		frame.setTitle("Login Menu");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		loginMenu = new JPanel();
        	passMenu = new JPanel();
		login = new JButton("Login");
		
        	usernameL = new JLabel("Username:");

        	passwordL = new JLabel("Password:");
		username = new JTextField(15);
        	password = new JPasswordField(15);
        	password.setEchoChar('*');

        	loginMenu.add(usernameL, BorderLayout.NORTH);
        	loginMenu.add(username, BorderLayout.SOUTH);

        	passMenu.add(passwordL,BorderLayout.NORTH);
        	passMenu.add(password, BorderLayout.SOUTH);

        	frame.getContentPane().add(loginMenu,BorderLayout.NORTH);
        	frame.getContentPane().add(passMenu,BorderLayout.CENTER);
        	frame.getContentPane().add(login,BorderLayout.SOUTH);
        
        	login.addActionListener(new LoginListener());
		password.addActionListener(new LoginListener());
        	frame.setVisible(true);
	}
	public static class LoginListener implements ActionListener
    	{
	        public LoginListener()
	        {
	
	        }

	        public void actionPerformed(ActionEvent e)
	        {
	            String input_user= "";
	            String input_pass= "";
	
	            if(!username.getText().equals(""))
	            {
	                input_user = username.getText();
	                System.out.println("userName Set");
	            }
	            if(!password.getPassword().equals(""))
	            {
	                input_pass = String.valueOf(password.getPassword());
	                System.out.println("password Set");
	            }
	            //System.out.println("Test user " + input_user + " Test Pass " + input_pass);
	
	            if(input_user != "" && input_pass != ""){
	                try {
	                    SQLConnect.connect(input_user, input_pass);
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	
	        }

    	}

    public static class LogoutListener implements ActionListener
    {
        public LogoutListener()
        {

        }

        public void actionPerformed(ActionEvent e)
        {
            try {
                SQLConnect.closeConnection();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            System.exit(0);

        }

    }

    public static void updateLoginBox(){
        frame.remove(passMenu);
        username.setEditable(false);
        frame.remove(login);
        frame.getContentPane().setBackground(Color.green);

        usernameL.setText("Logged in successful as: ");
        JButton logOut = new JButton("Logout");
        logOut.addActionListener(new LogoutListener());
        loginMenu.setBackground(Color.green);
        frame.add(logOut,BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
    }
	
}
