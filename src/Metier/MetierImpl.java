package Metier;
import java.sql.*;


import java.util.*;

import Beans.Citoyen;
import Beans.Demande;
import DAO.DAOCitoyen;
import DAO.DAODemande;
public class MetierImpl implements ImetierCatalogue {

	public boolean signup( Citoyen c) throws SQLException {
		// TODO Auto-generated method stub
		if(DAOCitoyen.ajouter(c))
		return true;
		else
		return false;
		
	}
	public boolean signin( String cin,String email, String password) throws SQLException {
		if(DAOCitoyen.validate(cin, email, password))
			return true;
			else
			return false;
	}
	@Override
	public Citoyen getUnique(String cin) throws SQLException {
		// TODO Auto-generated method stub
		return DAOCitoyen.getUnique(cin);
	}
	@Override
	public boolean creerDemande(Demande d) throws SQLException {
		// TODO Auto-generated method stub
		if(DAODemande.ajouter(d))
			return true;
		else
		return false;
		
	}
	

	
	
}