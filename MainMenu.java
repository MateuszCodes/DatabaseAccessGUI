import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainMenu extends OptionsBar{

    static JFrame main;

    private static JLabel sqlCommand;
    private static JTextField inputCommand;
    static JPanel mainPan, northPan;
    OptionsBar bar;
    static ViewPanel viewPan;
    static QueryPanel queryPanel;

    public MainMenu() throws SQLException {

        main = new JFrame("Shopper Drug POS Database");
        mainPan= new JPanel();
        northPan = new JPanel();
        main.setSize(1300, 800);
        main.setLayout(new FlowLayout());
        main.setLocationRelativeTo(null);

        main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        bar = new OptionsBar();

        mainPan.setLayout(new BorderLayout());
        northPan.setLayout(new BorderLayout());
        main.add(mainPan);
        main.setJMenuBar(bar);

        viewPan= new ViewPanel();
        queryPanel= new QueryPanel(0);

        //Imputing a command for query
        sqlCommand = new JLabel("Enter an SQL command");
        inputCommand = new JTextField(30);

        mainPan.add(viewPan, BorderLayout.NORTH);
        mainPan.add(queryPanel, BorderLayout.SOUTH);

        main.setVisible(true);
    }
}
