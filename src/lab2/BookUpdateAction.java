package lab2;

import java.sql.*;

public class BookUpdateAction {
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private String Price;
	private String ISBN;
	
	public void setAuthorID(String AuthorID){
		this.AuthorID=new String(AuthorID);
	}
	public void setPublisher(String Publisher){
		this.Publisher=new String(Publisher);
	}
	public void setPublishDate(String PublishDate){
		this.PublishDate=new String(PublishDate);
	}
	public void setPrice(String Price){
		this.Price=Price;
	}
	public void setISBN(String ISBN){
		this.ISBN=new String(ISBN);
	}
	
	Connection con;
	Statement st;
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","coding");
		}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql1="update Book set Publisher='"+Publisher+"',PublishDate='"+PublishDate+"',Price='"+Price+"',AuthorID='"+AuthorID+"' where ISBN='"+ISBN+"'";
			st = (Statement)con.createStatement();
			System.out.println(sql1);
			String sql2="select * from author";
			ResultSet res = st.executeQuery(sql2);
			while(res.next()){
				if(AuthorID.equals(res.getString("AuthorID"))){
					con.close();
					return "Success";
				}
			}
			con.close();
			return "AddAuthor";
		}catch(SQLException e){
			System.out.println("Update Failed.");
			return "Failed";
		}
	}
}