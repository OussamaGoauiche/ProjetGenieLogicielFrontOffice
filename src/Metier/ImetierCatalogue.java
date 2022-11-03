package Metier;
import java.sql.SQLException;
import java.util.*;

import Beans.Citoyen;
import Beans.Demande;
public interface ImetierCatalogue {
public boolean signup( Citoyen c) throws SQLException;
public boolean signin( String cin,String email, String password) throws SQLException;
public Citoyen getUnique(String cin) throws SQLException;
public boolean creerDemande(Demande d) throws SQLException;
}