package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Beans.Citoyen;
import Beans.Demande;
import Beans.Employe;
import connection.SingletonConnection;
public class DAODemande {

	static Connection conn=SingletonConnection.getConnection();

	 static int getLastId() throws SQLException{
		  int id=0;
		  String requete="select max(id) from demande";
		  Statement st=conn.createStatement();
		  ResultSet rs=st.executeQuery(requete);
		  while(rs.next())
		  {
		  return rs.getInt(1);
		  }
		  return id;
		  }
	
	public  static List<Demande> getAll() throws SQLException
	{
		List<Demande> demandes= new ArrayList<Demande>();

		PreparedStatement ps= conn.prepareStatement("select * from demande ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Demande d = new Demande();
		     d.setId(rs.getInt("id"));
		     d.setDescription(rs.getString("description"));
		     d.setEtat(rs.getString("etat"));
		     d.setUrl_document(rs.getString("url_document"));
		     d.setProcedure(rs.getString("nom_procedure"));
		     d.setCin_chef(rs.getString("cin_chef"));
		     d.setCin_citoyen(rs.getString("cin_employe"));
		     d.setCin_citoyen(rs.getString("cin_citoyen"));
		     d.setJeton(rs.getString("jeton"));
			demandes.add(d);
			}
		return demandes;

	}
	
	public static Demande getUnique(int id) throws SQLException
	{
		String requete="select * from demande where id='"+id+"'";
		Statement st =conn.createStatement();
		ResultSet rs=st.executeQuery(requete);
		Demande d = new Demande();

      while(rs.next())
      {
    	     d.setId(rs.getInt("id"));
		     d.setDescription(rs.getString("description"));
		     d.setEtat(rs.getString("etat"));
		     d.setUrl_document(rs.getString("url_document"));
		     d.setProcedure(rs.getString("nom_procedure"));
		     d.setCin_chef(rs.getString("cin_chef"));
		     d.setCin_citoyen(rs.getString("cin_employe"));
		     d.setCin_citoyen(rs.getString("cin_citoyen"));
		     d.setJeton(rs.getString("jeton"));
			
		     return d;
   	   
      }
      return null;

		

	}
	
	public static void ajouter(Demande c) throws SQLException
	 {
		Citoyen ct =DAOCitoyen.getUnique(c.getCin_citoyen());
		if(ct!=null)
		{
		 String requete="insert into demande values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(requete);
			int id=getLastId();
			ps.setInt(1,id+1);
			ps.setString(2, c.getDescription());
			ps.setString(3, "none");
			ps.setString(4, c.getUrl_document());
			ps.setString(5, c.getProcedure());
			ps.setString(6, "none");
			ps.setString(7, c.getCin_citoyen());
			ps.setString(8, "none");
			ps.setString(9, "none");
		    ps.execute();	 
		}
		else
			System.out.println("ce citoyen ne se trouve pas dans la base de donné");
		
	 }

	 public static void modifier (int id,Demande e1) throws SQLException
	 {	
		 Citoyen ct =DAOCitoyen.getUnique(e1.getCin_citoyen());
		if(ct!=null)
		{
		 Statement st =conn.createStatement(); 
		 String requete3="update  demande set description='"+e1.getDescription()+"',url_document='"
		 +e1.getUrl_document()+"',nom_procedure='"+e1.getProcedure()+"',cin_citoyen='"+e1.getCin_citoyen()+"'where id="+id;
	        st.executeUpdate(requete3);
	        
	    }
		else
			System.out.println("ce citoyen ne se trouve pas dans la base de donné");

	 	 
	 }
	
	public static void supprimer(int id) throws SQLException {
		Statement st =conn.createStatement();
		String requete="delete from demande where id="+id;
		st.execute(requete);
              
               
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	      // Demande c=new Demande("declarer","qwerty","aswqd","WA212");
		    //ajouter(c);
		/*List<Demande> demandes= new ArrayList<Demande>();
		demandes=getAll();
       for(Demande c1:demandes)
       	System.out.println(c1);
         */
		
		//Demande c2=getUnique(4);
		//System.out.println(c2);
		//Scanner sc=new Scanner(System.in);
		//System.out.println("donner id du demande à supprimer");
		//int id = sc.nextInt();
		  //supprimer(id);
		
		Demande c3=new Demande("relver de note","azerty","qwsdd","WA212");
		modifier(3,c3);
	}
	
}
