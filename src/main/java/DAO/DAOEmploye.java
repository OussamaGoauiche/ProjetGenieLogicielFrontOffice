package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Citoyen;
import Beans.Employe;
import connection.SingletonConnection;

public class DAOEmploye {
	static Connection conn=SingletonConnection.getConnection();

	
	public  static List<Employe> getAll() throws SQLException
	{
		List<Employe> employes= new ArrayList<Employe>();

		PreparedStatement ps= conn.prepareStatement("select * from employe ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employe e = new Employe();
			e.setCin(rs.getString("cin"));
			e.setNom(rs.getString("nom"));
			e.setPrenom(rs.getString("prenom"));
			e.setEmail(rs.getString("email"));
			e.setAdresse(rs.getString("adresse"));
			e.setTelephone(rs.getString("phone"));
			employes.add(e);
			}
		return employes;

	}
	
	public static Employe getUnique(String cin) throws SQLException
	{
		String requete="select * from employe where cin='"+cin+"'";
		Statement st =conn.createStatement();
		ResultSet rs=st.executeQuery(requete);
		Employe e = new Employe();

      while(rs.next())
      {
    	    e.setCin(rs.getString("cin"));
			e.setNom(rs.getString("nom"));
			e.setPrenom(rs.getString("prenom"));
			e.setEmail(rs.getString("email"));
			e.setAdresse(rs.getString("adresse"));
			e.setTelephone(rs.getString("phone"));
			
			 return e; 
   	   
      }
        return null;
		

	}
	
	public static void ajouter(Employe c) throws SQLException
	 {
		 String requete="insert into employe values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(requete);
			ps.setString(1, c.getCin());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setString(6, c.getTelephone());

		    ps.execute();	 
		
	 }

	 public static void modifier (String cin,Employe e1) throws SQLException
	 {	Statement st =conn.createStatement(); 
		 String requete3="update  employe set cin='"+e1.getCin()+"',nom='"+e1.getNom()+
	        "',prenom='"+e1.getPrenom()+"',email='"+e1.getEmail()+"',adresse='"+e1.getAdresse()+"',phone='"+e1.getTelephone()+"'"+" where cin='"+cin+"'";
	        st.executeUpdate(requete3);
		 
	 }
	
	public static void supprimer(String cin1) throws SQLException {
		Statement st =conn.createStatement();
		String requete="delete from employe where cin='"+cin1+"'";
		st.execute(requete);
              
               
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Employe c=new Employe("WA2122","khalid","oussama","azerty@gmail.com","Tanger","074323456");
		//ajouter(c);
		/*List<Employe> employes= new ArrayList<Employe>();
		employes=getAll();
       for(Employe c1:employes)
       	System.out.println(c1);
         
		*/
		//Employe c2=getUnique("WA212");
		  // System.out.println(c2);
		   //supprimer("WA212");
		
		//Employe c3=new Employe("WQ212","khalid","oussama","oussama@gmail.com","Agadir","074323456");
		//modifier("WA2122",c3);
	}
}
