import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
	String connectionUrl = "jdbc:mysql://localhost:3306/MyDB";
	String connectionUser = "root";
	String connectionPassword = "";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void Browse(String iusr){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String sql = "SELECT * FROM Weapons";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String item[]= {iname,ibid,ibuyo};
				
				BrowsePage.addwep(item);
				
			}
			rs.close();
			stmt.close();
			stmt = conn.createStatement();
			sql = "SELECT * FROM Armor";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String item[]= {iname,ibid,ibuyo};
				
				BrowsePage.addarm(item);
				
			}
			rs.close();
			stmt.close();
			stmt = conn.createStatement();
			sql = "SELECT * FROM Trinkets";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String item[]= {iname,ibid,ibuyo};
				
				BrowsePage.addtrin(item);
				
			}
			rs.close();
			stmt.close();			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void Bid(String type,String bid,String name) {
		
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String update = "UPDATE "+type+" SET Bid = '"+bid+"' WHERE Name ='"+name+"';";
			
			stmt.executeUpdate(update);		
			stmt.close();		
			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
public void Buyout(String type,String buyout,String name) {
		
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String update = "DELETE FROM "+type+" WHERE Name = '"+name+"' ;";
			
			stmt.executeUpdate(update);		
			stmt.close();		
			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public void MyAuctions(String iusr){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String sql = "SELECT * FROM Weapons WHERE user='"+iusr+"' UNION SELECT * FROM Armor WHERE user='"+iusr+"' UNION SELECT * FROM Trinkets WHERE user='"+iusr+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String item[]= {iname,ibid,ibuyo};
				
				
				MyAuctionsPage.add(item);
				
			}
			rs.close();
			stmt.close();
			
			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void NewAuction(String iType,String iName,String iBid,String iBuyo,String iusr){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String sql = "INSERT INTO "+iType+" (Name,Bid,Buyout,user) VALUE ('"+iName+"','"+iBid+"','"+iBuyo+"','"+iusr+"');";
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public boolean SignIn(String uName, String Passwd){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		String sql = ("SELECT * FROM accounts");
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			String user = rs.getString("username");
			String pwd = rs.getString("pass");

			if(pwd.equals(Passwd) && user.equals(uName))
			{
				
				return true;
			}//end if
		}
		rs.close();
		stmt.close();
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
	public boolean AdminSignIn(String uName, String Passwd){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		String sql = ("SELECT * FROM adminaccounts");
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			String user = rs.getString("adName");
			String pwd = rs.getString("adPass");

			if(pwd.equals(Passwd) && user.equals(uName))
			{			
				return true;
				
			}//end if
		}
		rs.close();
		stmt.close();
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
}
