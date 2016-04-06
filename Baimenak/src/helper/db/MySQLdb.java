package helper.db;


import java.sql.*;
import java.util.ArrayList;


import javax.websocket.Session;

import helper.info.BaimenakInfo;


public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/baimenak";
	private String user = "root"; 
	private String passwd = "euiti";
	private String driver = "com.mysql.jdbc.Driver";

	private Connection conn;

	public MySQLdb() {
		try {
			Class.forName(this.driver).newInstance();
			this.conn = DriverManager.getConnection(this.url,this.user,this.passwd);
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public String setUserInfo(String email, String password, String izenAbizen, 
			String abizen1, String abizen2, String NIF, String helbidea, String telefonoa) {
		if (email== "" || password == "" || izenAbizen== "" || abizen1 == "" ||
				abizen2=="" || NIF =="" || helbidea == ""){
			return "error";
		}
		if (telefonoa==""){
			telefonoa=null;
		}
		String query = "INSERT INTO user VALUES ('0', '" + email + "', '" + password + "', '" 
				+ izenAbizen + "', '" + abizen1 + "', '" + abizen2 + 
				"', '" + NIF + "', '" + helbidea + "', '" + telefonoa + "' );";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(query);  	
			return null;
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "error";
		}
	}

	public String getUsername(String email, String password) {
		String query = "SELECT izenAbizen FROM user WHERE email='" + email + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String izenAbizen = null;
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query); 
			while(res.next()) {
				izenAbizen = res.getString("izenAbizen");
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return izenAbizen;
	}

	public int getId(String email, String password) {
		String query = "SELECT iduser FROM user WHERE email='" + email + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		int id = 0;
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query); 
			while(res.next()) {
				id = res.getInt("iduser");
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return id;
	}

	public ArrayList<BaimenakInfo> getAllBaimenak(int id) {
		String query = "SELECT * FROM baimenak where EskatzaileId=" +id+ ";";
		System.out.println("     DB query: " + query);
		 ArrayList<BaimenakInfo> baimenakInfoList=new ArrayList<BaimenakInfo>();
		 BaimenakInfo bInfo = null;
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query); 
			while(res.next()) {
				bInfo= new BaimenakInfo(res.getInt("idbaimenak"), res.getString("baimenaIzena"), 
						res.getString("Kokalekua"), res.getString("EraikuntzaLanenKostua"), 
						res.getString("BaimenarenKostua"));
				baimenakInfoList.add(bInfo);
			} 	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return baimenakInfoList;
	}

	public ArrayList<Object> getBaimenarenPDF(String id, int userID) {
		String query = "SELECT * FROM baimenak WHERE idbaimenak='" + id + "';";
		String query1 = "SELECT izenAbizen,1abizena,NIF FROM user WHERE iduser='" + userID + "';";
		System.out.println("     DB query: " + query);
		System.out.println("     DB query1: " + query1);
		ArrayList<Object> baimenInfo=new ArrayList<Object>();
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query);
			Statement st1 = this.conn.createStatement();
			ResultSet res1 = st1.executeQuery(query1);

			while(res.next()) {
				baimenInfo.add(res.getObject("idbaimenak"));
				baimenInfo.add(res.getObject("baimenaIzena"));
				baimenInfo.add(res.getObject("Kokalekua"));
				baimenInfo.add(res.getObject("EraikuntzaLanenKostua"));
				baimenInfo.add(res.getObject("BaimenarenKostua"));
				baimenInfo.add(res.getObject("EskatzaileId"));
			}
			while (res1.next()){
				baimenInfo.add(res1.getObject("izenAbizen"));
				baimenInfo.add(res1.getObject("1abizena"));
				baimenInfo.add(res1.getObject("NIF"));
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return baimenInfo;

	}

	public String baimenaSartu(String izena, String kokalekua, String kostuaE, double kostuaB, int id) {
		if (izena== "" || kokalekua == "" || kostuaB== 0 || kostuaE == "") {
			return "error";
		}
		String query = "INSERT INTO baimenak VALUES ('0', '" + izena + "', '" + kokalekua + "', '" 
				+ kostuaE + "', '" + kostuaB + "', " + id + ") ;";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(query);
			return null;
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return e.getMessage();
		}

	}

	public void baimenaEguneratu(String izena, String kokalekua, String kostuaE, double kostuaB, String idB, String id) {
		String query = "CALL updateBaimena('" + izena + "','" + kokalekua + "', "
				+ "'" + kostuaE + "', '" + kostuaB + "', '" + idB + "', '" + id + "');";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

	}

	public boolean passZuzena(String passE, int id) {
		String query = "SELECT * FROM user WHERE iduser='" + id + "';";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query);
			res.next();
			System.out.println(res.getObject("password"));
			System.out.println(passE);
			if(res.getObject("password").equals(passE)){
				return true;
			}
			else{
				return false;
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}

	}

	public void UserEguneratu(String izena, String abizen1, 
			String abizen2, String nIF, String helbide, String telefono, int id) {

		String query = "CALL updateUser('" + izena + "', '" + abizen1 + "', '" + abizen2 + "', '" + nIF + "',"
				+ "'" + helbide + "', '" + telefono + "'," + id + ");";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

	}

	public ArrayList<Object> getBaimenarenId(String id) {
		String query = "SELECT idbaimenak FROM baimenak WHERE EskatzaileId='" + id + "';";
		System.out.println("     DB query: " + query);
		ArrayList<Object> baimenInfo=new ArrayList<Object>();
		try {
			Statement st = this.conn.createStatement();
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				baimenInfo.add(res.getObject("idbaimenak"));
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return baimenInfo;

	}

	public String PassEguneratu(String email, String pass, int id) {
		String query = "CALL updatePass('" + email + "', '" + pass + "', " + id + ");";
		System.out.println("     DB query: " + query);
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(query);
			return null;
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "email";
		}

	}





}