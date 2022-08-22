package ProductDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {
	public int insert(Product p) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getCon();
		if(con!=null) {
			System.out.println("connection is established");
		}
		else {
			System.out.println("connection failed");
		}
		
		String sql="insert into product values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, p.getPid());
		ps.setString(2, p.getProductname());
		ps.setString(3, p.getPprice());
		int row=ps.executeUpdate();
		return row;
	
	}
	
	public ResultSet retrieve() throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getCon();
		if(con!=null) {
			System.out.println("connection is established");
		}
		else {
			System.out.println("connection failed");
		}
		Statement st=con.createStatement();
		String sql="select * from product";
		//select
		ResultSet rs=st.executeQuery(sql);
		return rs;
		
	}

}


