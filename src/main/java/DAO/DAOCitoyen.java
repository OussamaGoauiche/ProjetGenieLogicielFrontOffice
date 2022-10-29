package DAO;

import java.sql.*;
import java.util.*;

import Beans.Citoyen;
import connection.SingletonConnection;

public class DAOCitoyen {
	static Connection conn=SingletonConnection.getConnection();

	
	public  static List<Citoyen> getAll() throws SQLException
	{
		List<Citoyen> citoyens= new ArrayList<Citoyen>();

		PreparedStatement ps= conn.prepareStatement("select * from citoyen ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Citoyen c = new Citoyen();
			c.setCin(rs.getString("cin"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setEmail(rs.getString("email"));
			c.setAdresse(rs.getString("adresse"));
			c.setTelephone(rs.getString("phone"));
			citoyens.add(c);
			}
		return citoyens;

	}
	
	public static Citoyen getUnique(String cin) throws SQLException
	{
		String requete="select * from citoyen where cin='"+cin+"'";
		Statement st =conn.createStatement();
		ResultSet rs=st.executeQuery(requete);
 	   Citoyen c = new Citoyen();

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
	
	public static void ajouter(Citoyen c) throws SQLException
	 {
		 String requete="insert into citoyen values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(requete);
			ps.setString(1, c.getCin());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setString(6, c.getTelephone());

		    ps.execute();	 
		
	 }

	 public static void modifier (String cin,Citoyen e1) throws SQLException
	 {	Statement st =conn.createStatement(); 
		 String requete3="update  citoyen set cin='"+e1.getCin()+"',nom='"+e1.getNom()+
	        "',prenom='"+e1.getPrenom()+"',email='"+e1.getEmail()+"',adresse='"+e1.getAdresse()+"',phone='"+e1.getTelephone()+"'"+" where cin='"+cin+"'";
	        st.executeUpdate(requete3);
		 
	 }
	
	public static void supprimer(String cin1) throws SQLException {
		Statement st =conn.createStatement();
		String requete="delete from citoyen where cin='"+cin1+"'";
		st.execute(requete);
               
                
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Citoyen c=new Citoyen("WA212","khalid","oussama","aimane@gmail.com","Casablanca","074323456");
		//DAOCitoyen.ajouter(c);
		/*List<Citoyen> citoyens= new ArrayList<Citoyen>();
		citoyens=DAOCitoyen.getAll();
        for(Citoyen c1:citoyens)
        	System.out.println(c1);
          */
		
		//Citoyen c2=getUnique("WA2121");
		//System.out.println(c2);
		//supprimer("WA212");
		
		Citoyen c3=new Citoyen("WQ212","khalid","oussama","oussama@gmail.com","Agadir","074323456");
		//modifier("WA21",c3);
	}

}
