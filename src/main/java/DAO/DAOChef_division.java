package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Chef_division;
import Beans.Citoyen;
import Beans.Employe;
import connection.SingletonConnection;

public class DAOChef_division {

	static Connection conn=SingletonConnection.getConnection();

	
	public  static List<Chef_division> getAll() throws SQLException
	{
		List<Chef_division> chefs= new ArrayList<Chef_division>();

		PreparedStatement ps= conn.prepareStatement("select * from chef_division ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Chef_division c = new Chef_division();
			c.setCin(rs.getString("cin"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setEmail(rs.getString("email"));
			c.setAdresse(rs.getString("adresse"));
			c.setTelephone(rs.getString("phone"));
			chefs.add(c);
			}
		return chefs;

	}
	
	public static Chef_division getUnique(String cin) throws SQLException
	{
		String requete="select * from chef_division where cin='"+cin+"'";
		Statement st =conn.createStatement();
		ResultSet rs=st.executeQuery(requete);
		Chef_division c = new Chef_division();

      while(rs.next())
      {
			c.setCin(rs.getString("cin"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setEmail(rs.getString("email"));
			c.setAdresse(rs.getString("adresse"));
			c.setTelephone(rs.getString("phone"));
			
			  return c; 
   	   
      }
      return null;

		

	}
	
	public static void ajouter(Chef_division c) throws SQLException
	 {
		 String requete="insert into chef_division values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(requete);
			ps.setString(1, c.getCin());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setString(6, c.getTelephone());

		    ps.execute();	 
		
	 }

	 public static void modifier (String cin,Chef_division e1) throws SQLException
	 {	Statement st =conn.createStatement(); 
		 String requete3="update  chef_division set cin='"+e1.getCin()+"',nom='"+e1.getNom()+
	        "',prenom='"+e1.getPrenom()+"',email='"+e1.getEmail()+"',adresse='"+e1.getAdresse()+"',phone='"+e1.getTelephone()+"'"+" where cin='"+cin+"'";
	        st.executeUpdate(requete3);
		 
	 }
	
	public static void supprimer(String cin1) throws SQLException {
		Statement st =conn.createStatement();
		String requete="delete from chef_division where cin='"+cin1+"'";
		st.execute(requete);
              
               
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Chef_division c=new Chef_division("Q123","khalid","yasser","qwerty@gmail.com","Safi","074323456");
		 //ajouter(c);
		/*List<Chef_division> chefs= new ArrayList<Chef_division>();
		chefs=getAll();
       for(Chef_division c1:chefs)
       	System.out.println(c1);
         */
		
		//Chef_division c2=getUnique("Q123");
		//System.out.println(c2);
		
		//supprimer("W12");
		
		//Chef_division c3=new Chef_division("WQ212","khalid","oussama","oussama@gmail.com","Agadir","074323456");
		//modifier("Q123",c3);
	}
	
}
