
import java.sql.ResultSet;
import java.sql.Statement;


public class DAO {
    
    public String getOrderID1() {
        String order = null;
        try {
            String query = "SELECT * FROM customers WHERE ID='1';";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            res.next();
                order = res.getString("ordernumber")+", "+res.getString("name")+", "+res.getString("adress")+", "+res.getString("zipcode");
                System.out.println(order);
                return order;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }
    
    public String getOrderID2() {
        String order = null;
        try {
            String query = "SELECT * FROM customers WHERE ID='2';";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            res.next();
                order = res.getString("ordernumber")+", "+res.getString("name")+", "+res.getString("adress")+", "+res.getString("zipcode");
                System.out.println(order);
                return order;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }
    public String getOrderID3() {
        String order = null;
        try {
            String query = "SELECT * FROM customers WHERE ID='3';";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            res.next();
                order = res.getString("ordernumber")+", "+res.getString("name")+", "+res.getString("adress")+", "+res.getString("zipcode");
                System.out.println(order);
                return order;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }
    
}
