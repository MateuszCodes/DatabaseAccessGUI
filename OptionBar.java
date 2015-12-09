import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OptionsBar extends JMenuBar {

    JMenuBar menBar = new JMenuBar();

    public OptionsBar(){
        super.add(menBar, BorderLayout.NORTH);

        JMenu viewMenu = new JMenu("View");
        menBar.add(viewMenu);

        JMenuItem inventoryItem = new JMenuItem("Inventory");
        inventoryItem.addActionListener(new viewInventory());
        viewMenu.add(inventoryItem);

        JMenuItem personalItem = new JMenuItem("Personal");
        personalItem.addActionListener(new viewPersonal());
        viewMenu.add(personalItem);

        JMenuItem transactionItem = new JMenuItem("Transaction");
        transactionItem.addActionListener(new viewTransaction());
        viewMenu.add(transactionItem);

        JMenuItem membershipItem = new JMenuItem("Membership");
        membershipItem.addActionListener(new viewMembership());
        viewMenu.add(membershipItem);

        JMenuItem menuItemItem = new JMenuItem("Menu Item");
        menuItemItem.addActionListener(new viewMenuItem());
        viewMenu.add(menuItemItem);

        JMenu queryMenu = new JMenu("Query");
        menBar.add(queryMenu);

        JMenuItem noInventItem = new JMenuItem("View items out of stock");
        noInventItem.addActionListener(new viewNoInventItem());
        queryMenu.add(noInventItem);

        JMenuItem transWithMem = new JMenuItem("View purchases ordered by name and amount");
        transWithMem.addActionListener(new viewPurchaseNameItem());
        queryMenu.add(transWithMem);

        JMenuItem showPointForMem = new JMenuItem("View points for member");
        showPointForMem.addActionListener(new viewPointsForMem());
        queryMenu.add(showPointForMem);

        JMenuItem showFindMem = new JMenuItem("View members in the city");
        showFindMem.addActionListener(new viewMemCity());
        queryMenu.add(showFindMem);

        JMenuItem showTransDate = new JMenuItem("View transactions from date");
        showTransDate.addActionListener(new viewTransDate());
        queryMenu.add(showTransDate);

        JMenuItem showTransType = new JMenuItem("View transactions by type");
        showTransType.addActionListener(new viewTransType());
        queryMenu.add(showTransType);

        JMenuItem showItemID = new JMenuItem("View Item by ID");
        showItemID.addActionListener(new viewItemID());
        queryMenu.add(showItemID);

        JMenuItem showMenuItemID = new JMenuItem("View Menu Item by ID");
        showMenuItemID.addActionListener(new viewMenuItemID());
        queryMenu.add(showMenuItemID);

        JMenuItem showTransByIDSqrd = new JMenuItem("View transaction by date and member ID");
        showTransByIDSqrd.addActionListener(new viewTransByIDSqrd());
        queryMenu.add(showTransByIDSqrd);

        JMenu alterMenu = new JMenu("Alter");
        menBar.add(alterMenu);

        JMenuItem enterSQL = new JMenuItem("Enter SQL Code");
        enterSQL.addActionListener(new alterTables());
        alterMenu.add(enterSQL);
    }

    public class viewInventory implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ViewPanel.displayInventory();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class viewMembership implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ViewPanel.displayMembership();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class viewPersonal implements ActionListener{

        public void actionPerformed(ActionEvent e){
            try{
                ViewPanel.displayPersonal();
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    public class viewTransaction implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            try{
                ViewPanel.displayTransaction();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        }
    }

    public class viewMenuItem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                ViewPanel.displayMenuItem();
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    public class viewNoInventItem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                ViewPanel.showNoInvent();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

    public class viewPurchaseNameItem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                ViewPanel.showPurchaseName();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

    public class viewPointsForMem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(1);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewMemCity implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(2);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewTransDate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(3);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewTransType implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(4);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewItemID implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(5);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewMenuItemID implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(6);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class viewTransByIDSqrd implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainMenu.mainPan.remove(MainMenu.queryPanel);
            MainMenu.queryPanel = new QueryPanel(7);
            MainMenu.mainPan.add(MainMenu.queryPanel, BorderLayout.SOUTH);
            MainMenu.mainPan.revalidate();
            MainMenu.mainPan.repaint();

        }
    }

    public class alterTables implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            AlterWindow altWin = new AlterWindow();

        }
    }

}
