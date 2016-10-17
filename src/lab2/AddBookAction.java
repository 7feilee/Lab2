package lab2;

import java.sql.*;

public class AddBookAction{
	private String ISBN;
	private String Title;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private String Price;
	
	public void setISBN(String ISBN){
		this.ISBN=new String(ISBN);
	}
	public String getISBN(){
		return ISBN;
	}
	
	public void setTitle(String Title){
		this.Title=new String(Title);
	}
	public String getTite(){
		return Title;
	}
	
	public void setAuthorID(String AuthorID){
		this.AuthorID=new String(AuthorID);
	}
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setPublisher(String Publisher){
		this.Publisher= new String(Publisher);
	}
	public String getPublisher(){
		return Publisher;
	}
	
	public void setPublishDate(String PublishDate){
		this.PublishDate = new String(PublishDate);
	}
	public String getPublishDate(){
		return PublishDate;
	}
	
	public void setPrice(String Price){
		this.Price=Price;
	}
	public String getPrice(){
		return Price;
	}
	
	Connection con;
	Statement st;
	public static Connection getConnection()
	{
		Connection con = null;
			try
			{
				try
				{
		        //����Class.forName()����������������
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("�ɹ�����MySQL������");
		    	}catch(ClassNotFoundException e1){
		        System.out.println("�Ҳ���MySQL����!");
		        e1.printStackTrace();
		    }
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","coding");
			}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			st = con.createStatement();
			String sql = "INSERT INTO book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)"
			+"VALUES("+"'"+ISBN+"','"+Title+"','"+AuthorID+"','"+Publisher+"','"+PublishDate+"','"+Price+"')";
			int count = st.executeUpdate(sql);
			System.out.println("Insert Successful.DataNum:"+count);
			String sq2 = "select * from author";
			ResultSet res = st.executeQuery(sq2);
			while(res.next())
				if(AuthorID.equals(res.getString("AuthorID")))
				{
					con.close();
					return "Success";
				}
			con.close();
			return "AddAuthor";
		}catch(SQLException e){
			return "Failed";
		}
	}
}
