package lab2;

import java.sql.*;

public class getDetails {
	private String ISBN;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private String Price;
	private String Name;
	private int Age;
	private String Country;
	private String Title;
	
	private String BookTitle = null;
	public String getBookTitle(){
		return BookTitle;
	}
	public void setBookTitle(String BookTitle){
		this.BookTitle = new String(BookTitle);
	}
	
	public String getISBN(){
		return ISBN;
	}
	public String getAuthorID(){
		return AuthorID;
	}
	public String getPublisher(){
		return Publisher;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public String getPrice(){
		return Price;
	}
	public String getName(){
	return Name;
	}
	public int getAge(){
	return Age;
	}
	public String getCountry(){
	return Country;
	}
	public String getTitle(){
	return Title;
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
		System.out.println(BookTitle);
		try{
			String sql = "select * from book";
			st = (Statement)con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				if(BookTitle.equals(res.getString("Title"))){
					Title=BookTitle;
					ISBN = new String(res.getString("ISBN"));
					AuthorID = new String(res.getString("AuthorID"));
					Publisher = new String(res.getString("Publisher"));
					PublishDate = new String(res.getString("PublishDate"));
					Price = res.getString("Price");
				}
			}
			String sq2 = "select * from author";
			res = st.executeQuery(sq2);
			while(res.next()){
				if(AuthorID.equals(res.getString("AuthorID"))){
					Name = new String(res.getString("Name"));
					Age = res.getInt("Age");
					Country = new String(res.getString("Country"));
				}
			}
			con.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Connect Failed."+e.getMessage());
			return "Failed";
		}
	}
}
