import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewPanel extends JPanel {

    static ResultSet rs;
    static Statement stmt;
    static JTable queryResult;
    static JScrollPane scrollPane;

    public ViewPanel() throws SQLException {

        queryResult = new JTable();
        //scrollArea = new JTextArea();
        scrollPane = new JScrollPane(queryResult);
        scrollPane.setPreferredSize(new Dimension(1200,200));

        stmt = SQLConnect.conn.createStatement();

        add(scrollPane);

    }

    public static void displayInventory() throws SQLException {
        String sql = "SELECT * FROM INVENTORY";
        rs = stmt.executeQuery(sql);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void displayMembership() throws SQLException {
        String sql = "SELECT * FROM MEMBERSHIP";
        rs = stmt.executeQuery(sql);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void displayPersonal() throws SQLException{
        String sq1 = "SELECT * FROM PERSONAL";
        rs = stmt.executeQuery(sq1);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void displayTransaction() throws SQLException{
        String sq1 = "SELECT * FROM TRANSACTION ";
        rs = stmt.executeQuery(sq1);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void displayMenuItem() throws SQLException{
        String sq1 = "SELECT * FROM MENU_ITEM";
        rs = stmt.executeQuery(sq1);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void showNoInvent() throws SQLException{
        String sql = "SELECT ITEMID, ITEMNAME, QUANITY FROM INVENTORY WHERE QUANITY = 0 ORDER BY ITEMID ASC";
        rs = stmt.executeQuery(sql);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void showPurchaseName() throws SQLException{
        String sql = "SELECT MEMBERSHIP.FIRSTNAME, MEMBERSHIP.LASTNAME, MEMBERSHIP.P_MEMBERID AS MEMBERID, TRANSACTION.SUBTOTAL, TRANSACTION.TOTAL \n" +
                "FROM TRANSACTION, MEMBERSHIP \n" +
                "WHERE TRANSACTION.MEMBERID = MEMBERSHIP.P_MEMBERID \n" +
                "ORDER BY MEMBERSHIP.LASTNAME ASC, MEMBERSHIP.FIRSTNAME ASC, TRANSACTION.TOTAL DESC";
        rs = stmt.executeQuery(sql);
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewPointForMem(String firstNameMeth, String lastNameMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT FIRSTNAME, LASTNAME, BALANCE FROM MEMBERSHIP WHERE FIRSTNAME = ? AND LASTNAME = ?");
        sql.setString(1, firstNameMeth);
        sql.setString(2, lastNameMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewMember(String cityMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT MEMBERSHIP.FIRSTNAME, MEMBERSHIP.LASTNAME, MEMBERSHIP.BALANCE \n" +
                "FROM MEMBERSHIP, PERSONAL \n" +
                "WHERE PERSONAL.CITY= ? AND MEMBERSHIP.INTERNALID = PERSONAL.P_INTERNAL_ID\n" +
                "ORDER BY MEMBERSHIP.BALANCE ASC");
        sql.setString(1, cityMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewTransForDate(String dateMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT MEMBERSHIP.FIRSTNAME, MEMBERSHIP.LASTNAME, MEMBERSHIP.P_MEMBERID, TRANSACTION.SUBTOTAL, TRANSACTION.TOTAL , TRANSACTION.TRANSACTIONDATE\n" +
                "FROM TRANSACTION, MEMBERSHIP \n" +
                "WHERE TRANSACTION.MEMBERID = MEMBERSHIP.P_MEMBERID AND TRANSACTION.TRANSACTIONDATE >= ? \n" +
                "ORDER BY MEMBERSHIP.LASTNAME ASC, MEMBERSHIP.FIRSTNAME ASC, TRANSACTION.TOTAL DESC");
        sql.setString(1, dateMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewTransForType(String typeMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT MEMBERSHIP.FIRSTNAME, MEMBERSHIP.LASTNAME, MEMBERSHIP.P_MEMBERID, TRANSACTION.SUBTOTAL, TRANSACTION.TOTAL , TRANSACTION.TRANSACTIONTYPE\n" +
                "FROM TRANSACTION, MEMBERSHIP \n" +
                "WHERE TRANSACTION.MEMBERID = MEMBERSHIP.P_MEMBERID AND TRANSACTION.TRANSACTIONTYPE = ? \n" +
                "ORDER BY MEMBERSHIP.LASTNAME ASC, MEMBERSHIP.FIRSTNAME ASC, TRANSACTION.TOTAL DESC");
        sql.setString(1, typeMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewItemForID(String itemIDMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT INVENTORY.ITEMID, \n" +
                "  INVENTORY.ITEMNAME, \n" +
                "  INVENTORY.QUANITY \n" +
                "FROM INVENTORY \n" +
                "WHERE ITEMID=?");
        sql.setString(1, itemIDMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewMenuItemForID(String menuItemIDMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT MENU_ITEM.STATUS,\n" +
                "  MENU_ITEM.ITEMNAME,\n" +
                "  MENU_ITEM.ITEMPRICE,\n" +
                "  MENU_ITEM.P_ITEMID\n" +
                "FROM MENU_ITEM\n" +
                "WHERE P_ITEMID = ?");
        sql.setString(1, menuItemIDMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void viewTransByIDSqrd(String dateMeth, String memberIDMeth) throws SQLException {
        PreparedStatement sql = SQLConnect.conn.prepareStatement("SELECT TRANSACTION.TRANSACTIONDATE,\n" +
                "  TRANSACTION.TOTAL,\n" +
                "  TRANSACTION.TAXTOTAL,\n" +
                "  TRANSACTION.SUBTOTAL,\n" +
                "  TRANSACTION.MEMBERID,\n" +
                "  TRANSACTION.TRANSACTIONTYPE\n" +
                "FROM TRANSACTION\n" +
                "WHERE TRANSACTIONDATE >= ? \n" +
                "AND MEMBERID = ?");
        sql.setString(1, dateMeth);
        sql.setString(2, memberIDMeth);
        rs = sql.executeQuery();
        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    }

    public static void displayResult() throws SQLException {

        queryResult.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();

    }

}
