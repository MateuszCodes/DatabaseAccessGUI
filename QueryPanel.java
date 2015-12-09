import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class QueryPanel extends JPanel {

    //static JScrollPane scrollPaneBottom;
    static JPanel northPanel, centerPanel, southPanel;
    static JButton findPointsBut, findMemberBut, findTransBut, findTransTypeBut, findItemById, findMenuItemById, findTransByIDSqrd;
    static JLabel fNameLabel, lNameLabel, cityLabel, dateLabel, transTypeLabel, itemIdLabel, menuItemIdLabel, memberIdLabel;
    static JTextField fNameInput, lNameInput, cityInput, dateInput, transTypeInput, itemIdInput, menuItemIdInput, memberIDInput;
    static String firstName, lastName, city, date, transType, itemId, menuItemId, memberID;

    public QueryPanel(int choice){

//        scrollPaneBottom = new JScrollPane();
//        scrollPaneBottom.setPreferredSize(new Dimension(1200,200));
//        add(scrollPaneBottom);

        setLayout(new BorderLayout());

//        validate();

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());


        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());


        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());


        switch(choice){
            case 1:

                fNameLabel = new JLabel("Please Enter First Name: ");
                northPanel.add(fNameLabel, BorderLayout.WEST);

                fNameInput = new JTextField(50);
                northPanel.add(fNameInput, BorderLayout.CENTER);

                lNameLabel = new JLabel("Please Enter Last Name: ");
                centerPanel.add(lNameLabel, BorderLayout.WEST);

                lNameInput = new JTextField(50);
                lNameInput.addActionListener(new findPointsForMem());
                centerPanel.add(lNameInput, BorderLayout.CENTER);

                findPointsBut = new JButton("Search");
                findPointsBut.addActionListener(new findPointsForMem());
                southPanel.add(findPointsBut, BorderLayout.SOUTH);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 2:

                cityLabel = new JLabel("Please Enter City: ");
                northPanel.add(cityLabel, BorderLayout.WEST);

                cityInput = new JTextField(50);
                cityInput.addActionListener(new findMember());
                northPanel.add(cityInput, BorderLayout.CENTER);

                findMemberBut = new JButton("Search");
                findMemberBut.addActionListener(new findMember());
                southPanel.add(findMemberBut, BorderLayout.SOUTH);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 3:
                dateLabel = new JLabel("Please Enter Date: ");
                northPanel.add(dateLabel, BorderLayout.WEST);

                dateInput = new JTextField(50);
                dateInput.addActionListener(new findTransForDate());
                northPanel.add(dateInput, BorderLayout.CENTER);

                findTransBut = new JButton("Search");
                findTransBut.addActionListener(new findTransForDate());
                southPanel.add(findTransBut, BorderLayout.SOUTH);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 4:
                transTypeLabel = new JLabel("Please Enter Transaction Type: ");
                northPanel.add(transTypeLabel, BorderLayout.WEST);

                transTypeInput = new JTextField(50);
                transTypeInput.addActionListener(new findTransForType());
                northPanel.add(transTypeInput, BorderLayout.CENTER);

                findTransTypeBut = new JButton("Search");
                findTransTypeBut.addActionListener(new findTransForType());
                southPanel.add(findTransTypeBut, BorderLayout.SOUTH);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 5:
                itemIdLabel = new JLabel("Please Enter Item ID: ");
                northPanel.add(itemIdLabel, BorderLayout.WEST);

                itemIdInput = new JTextField(50);
                itemIdInput.addActionListener(new findItemByID());
                northPanel.add(itemIdInput,BorderLayout.CENTER);

                findItemById = new JButton("Search");
                findItemById.addActionListener(new findItemByID());
                southPanel.add(findItemById);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 6:
                menuItemIdLabel = new JLabel("Please Enter Menu Item ID: ");
                northPanel.add(menuItemIdLabel, BorderLayout.WEST);

                menuItemIdInput = new JTextField(50);
                menuItemIdInput.addActionListener(new findMenuItemByID());
                northPanel.add(menuItemIdInput,BorderLayout.CENTER);

                findMenuItemById = new JButton("Search");
                findMenuItemById.addActionListener(new findMenuItemByID());
                southPanel.add(findMenuItemById);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

            case 7:
                dateLabel = new JLabel("Please Enter Date: ");
                northPanel.add(dateLabel, BorderLayout.WEST);

                dateInput = new JTextField(50);
                northPanel.add(dateInput, BorderLayout.CENTER);

                memberIdLabel = new JLabel("Please Enter Member ID: ");
                centerPanel.add(memberIdLabel, BorderLayout.WEST);

                memberIDInput = new JTextField(50);
                memberIDInput.addActionListener(new findTransByIDSqrd());
                centerPanel.add(memberIDInput, BorderLayout.CENTER);

                findTransByIDSqrd = new JButton("Search");
                findTransByIDSqrd.addActionListener(new findTransByIDSqrd());
                southPanel.add(findTransByIDSqrd);

                add(northPanel, BorderLayout.NORTH);
                add(centerPanel, BorderLayout.CENTER);
                add(southPanel, BorderLayout.SOUTH);

                break;

        }
    }

    class findPointsForMem implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                firstName = fNameInput.getText();
                lastName = lNameInput.getText();
                ViewPanel.viewPointForMem(firstName, lastName);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findMember implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                city = cityInput.getText();
                ViewPanel.viewMember(city);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findTransForDate implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                date = dateInput.getText();
                ViewPanel.viewTransForDate(date);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findTransForType implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                transType = transTypeInput.getText();
                ViewPanel.viewTransForType(transType);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findItemByID implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                itemId = itemIdInput.getText();
                ViewPanel.viewItemForID(itemId);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findMenuItemByID implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                menuItemId = menuItemIdInput.getText();

                ViewPanel.viewMenuItemForID(menuItemId);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

    class findTransByIDSqrd implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e){
            try {

                date = dateInput.getText();
                memberID = memberIDInput.getText();

                ViewPanel.viewTransByIDSqrd(date, memberID);
            }catch (SQLException e1){
                System.out.println("Search action: " + e1);
            }

        }
    }

}
