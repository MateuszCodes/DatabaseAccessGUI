import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class AlterWindow {

    JFrame alterFrame;
    JPanel alterPanel;
    JButton submitBut;
    JLabel instructLabel;
    JTextArea sqlCommand;

    public AlterWindow(){

        alterFrame = new JFrame("Alter Window");
        alterFrame.setSize(500,500);
        alterFrame.setLocationRelativeTo(null);

        alterPanel = new JPanel();
        alterPanel.setLayout(new BorderLayout());

        instructLabel = new JLabel("Enter SQL Command:");

        sqlCommand = new JTextArea();
        sqlCommand.setLineWrap(true);

        submitBut = new JButton("Submit");
        submitBut.addActionListener(new submitListener());

        alterFrame.add(alterPanel);

        alterPanel.add(instructLabel, BorderLayout.NORTH);
        alterPanel.add(sqlCommand, BorderLayout.CENTER);
        alterPanel.add(submitBut, BorderLayout.SOUTH);
        alterFrame.setVisible(true);

    }

    public class submitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String sql = sqlCommand.getText();
            try {
                ViewPanel.rs = ViewPanel.stmt.executeQuery(sql);
                ViewPanel.displayResult();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            alterFrame.dispatchEvent(new WindowEvent(alterFrame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
