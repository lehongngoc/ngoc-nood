package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import MODEL.SachModel;

import MODEL.TaiKhoanModel;


public class SachDAO {
	private static Connection conn;
	public static void reloadData( DefaultTableModel model) {

		try {
			openConnection();
			List<SachModel> listStu = new ArrayList<SachModel>();
			listStu = loadData();
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			for(int i = 0 ; i < listStu.size();i++) {
				String[] row = {listStu.get(i).getBookid(),listStu.get(i).getName(),listStu.get(i).getAuthor(),listStu.get(i).getYear(),listStu.get(i).getPrice(),listStu.get(i).getCreateby()};
				model.addRow(row);
			}
			
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private static List<SachModel> loadData() {
		// TODO Auto-generated method stub
		List<SachModel> listStu = new ArrayList<SachModel>();
		SachModel sach = new SachModel();
		try {
			openConnection();

			Statement satement = conn.createStatement();
			String str ="SELECT * FROM book ";
			ResultSet resultset = satement.executeQuery(str);
			while(resultset.next()) {
				sach = new SachModel();
				sach.setBookid(resultset.getString("bookid"));
				sach.setName(resultset.getString("name"));
				sach.setAuthor(resultset.getString("author"));
				sach.setYear(resultset.getString("year"));
				sach.setPrice(resultset.getString("price"));
				sach.setCreateby(resultset.getString("createby"));
			listStu.add(sach);
			}
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listStu;
	}
	private static void closeConnection() throws SQLException {
		conn.close();
		
	}
	private static void openConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuviensach","root","quanghieuvp123");
		
	}
	public static void delete(int id) {
		
		try {
			openConnection();
			Statement satement = conn.createStatement();
			String str ="Delete  from book WHERE Id = "+id+"";
			satement.execute(str);
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public static boolean insertTaikhoan(TaiKhoanModel  nhanvien) {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		try {
			openConnection();
		Statement statement = conn.createStatement();
		String str = "select * from nhanvien where name ='"+nhanvien.getName()+"'";
		ResultSet resultSet = statement.executeQuery(str);
		boolean checkExit = resultSet.next();
		if(checkExit== true)
			return true;
		str = "INSERT INTO nhanvien (name, password, email) VALUES ('"+nhanvien.getName()+"', '"+nhanvien.getPassword()+"', '"+nhanvien.getEmail()+"')";
		statement.execute(str);
		closeConnection();
		
		}
		catch (Exception e){
			
		}
		
		return false;
	
		
	}

	}

	
	

