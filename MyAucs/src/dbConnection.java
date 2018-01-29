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
	public void AdminBrowse(String iusr){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String sql = "SELECT * FROM Products WHERE Type = 'Weapons'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String iebid = rs.getString("EndBid");
				String iuser = rs.getString("user");
				String item[]= {iname,ibid,ibuyo,iuser,iebid};
				
				AdminWindow.addwep(item);
				
			}
			rs.close();
			stmt.close();
			stmt = conn.createStatement();
			sql = "SELECT * FROM Products  WHERE Type = 'Armor'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String iebid = rs.getString("EndBid");
				String iuser = rs.getString("user");
				String item[]= {iname,ibid,ibuyo,iuser,iebid};
				
				AdminWindow.addarm(item);
				
			}
			rs.close();
			stmt.close();
			stmt = conn.createStatement();
			sql = "SELECT * FROM Products WHERE Type = 'Trinkets'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String iebid = rs.getString("EndBid");
				String iuser = rs.getString("user");
				String item[]= {iname,ibid,ibuyo,iuser,iebid};
				
				AdminWindow.addtrin(item);
				
			}
			rs.close();
			stmt.close();		
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
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
			
			String sql = "SELECT * FROM accounts WHERE username = '"+Main.usr+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Main.wal = rs.getFloat("balance");
			}
			//Main.wal = rs.getFloat("balance");
			
			sql = "SELECT * FROM Products WHERE Type = 'Weapons'";
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
			sql = "SELECT * FROM Products  WHERE Type = 'Armor'";
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
			sql = "SELECT * FROM Products WHERE Type = 'Trinkets'";
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
			String update = "UPDATE Products "+type+" SET Bid = '"+bid+"' WHERE Name ='"+name+"' AND Type = '"+type+"';";
			
			stmt.executeUpdate(update);		
			float newBalance= Main.wal- Float.parseFloat(bid);
			
			update = "UPDATE accounts SET balance = '"+newBalance+"' WHERE username ='"+Main.usr+"' ;";
			stmt.executeUpdate(update);	
			//stmt.close();		
			
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
			String update = "DELETE FROM Products "+type+" WHERE Name = '"+name+"' AND Type = '"+type+"';";			
			stmt.executeUpdate(update);		
			stmt.close();		
			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	public void DeleteAuction(String name) {
	
	try{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String update = "DELETE FROM Products WHERE Name = '"+name+"' AND user = '"+Main.usr+"'";
		stmt.executeUpdate(update);		
		stmt.close();		
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
}
	public void AdminDelete (String user,String name) {
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			String update = "DELETE FROM Products WHERE Name = '"+name+"' AND user = '"+user+"'";
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
			String sql = "SELECT * FROM Products WHERE user='"+iusr+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String iname = rs.getString("Name");
				String ibid =rs.getString("Bid");
				String ibuyo = rs.getString("Buyout");
				String iebid = rs.getString("EndBid");
				String item[]= {iname,ibid,ibuyo,iebid};
				
				
				MyAuctionsPage.add(item);
				
			}
			rs.close();
			stmt.close();
			
			
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void NewAuction(String iType,String iName,String iBid,String iBuyo,String iusr,String iEbid){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
				stmt = conn.createStatement();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			String sql = "INSERT INTO Products (Name,Bid,Buyout,user,EndBid,Type) VALUE ('"+iName+"','"+iBid+"','"+iBuyo+"','"+iusr+"','"+iEbid+"','"+iType+"');";
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public int SignIn(String uName, String Passwd){
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
			int flag = rs.getInt("adflg");

			if(pwd.equals(Passwd) && user.equals(uName) && flag==1) {
				
				return 1;
				
			}else if (pwd.equals(Passwd) && user.equals(uName) && flag==0) {
				
				return 2;
				
			}else {
				
			}
		}
		
		rs.close();
		stmt.close();
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}
	
	public int SignUp(String uName, String Passwd){
		
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
				String usr = rs.getString("username");	
				String pwd = rs.getString("pass");
				if(pwd.equals(Passwd) && usr.equals(uName)) {
					return 1;
				}					
			}
			String insert = "INSERT INTO Accounts (username,pass,balance,adflg) VALUE ('"+uName+"','"+Passwd+"',1000,0);";
			stmt.executeUpdate(insert);			
			
		} catch (Exception s) {
			s.printStackTrace();
		}
		return 0;
	}
	
}
