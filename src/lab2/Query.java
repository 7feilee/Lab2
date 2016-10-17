package lab2;

import java.util.*;
import java.sql.*;

public class Query{
	Connection con;
	Statement st;

	private String Authorname;
	private ArrayList<String> BookList = new ArrayList<String>();
	
	public static Connection getConnection()
	{
		Connection con = null;
			try
			{
				try
				{
		        //调用Class.forName()方法加载驱动程序
		        Class.forName("com.mysql.jdbc.Driver");
		        System.out.println("成功加载MySQL驱动！");
		    	}catch(ClassNotFoundException e1){
		        System.out.println("找不到MySQL驱动!");
		        e1.printStackTrace();
		    }
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","coding");
			}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}

	
	public String getAuthorname(){
		return Authorname;
	}
	
	public void setAuthorname(String Author){
		this.Authorname = new String(Author);
	}
	
	public ArrayList<String> getBookList(){
		return BookList;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql = "select * from author;";
			st = (Statement)con.createStatement();
			ResultSet res = st.executeQuery(sql);
			boolean flag = false;
			String TeAuthorID = null;
			
			while(res.next()){
				if(Authorname.equals(res.getString("Name"))){
					TeAuthorID=new String(res.getString("AuthorID"));
					flag = true;
					break;
				}
			}
			if(flag){
				String sq2 = "select * from book";
				res = st.executeQuery(sq2);
				while(res.next())
					if(TeAuthorID.equals(res.getString("AuthorID")))
						BookList.add(new String(res.getString("Title")));
				con.close();
				if(BookList.isEmpty())
					return "Failed";
				return "Success";
			}	
			else{ 
				con.close();
				return "Failed";
			}
		}catch(Exception e){
			System.out.println("Errors."+e.getMessage());
			return "Else";
		}
	}
}
