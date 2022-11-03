package Web;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Beans.Citoyen;
import Beans.Demande;
import Metier.ImetierCatalogue;
import Metier.MetierImpl;

@WebServlet("/")
public class ControleurServlet extends HttpServlet {
	
private ImetierCatalogue metier;
public static final int TAILLE_TAMPON = 10240;
public static final String CHEMIN_FICHIERS="C:\\Users\\AIMANEJAMAL-EDDYN\\Desktop\\documents_upload";
@Override
public void init() throws ServletException {
metier=new MetierImpl();
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	doGet(request, response);

}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String action = request.getServletPath();
	try {
		switch (action) {
		case "/signup":
			signup(request, response);
			break;
		case "/signin":
			signin(request, response);
			break;
		case "/creerDemande":
			creerDemande(request, response);
			break;
		case "/logout":
			logout(request, response);
			break;
				
		  /*case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateTodo(request, response);
			break;
		default:
			listTodo(request, response);
			break;
			*/
		}
	} catch (SQLException ex) {
		throw new ServletException(ex);
	}
}

private void signup(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	String cin=request.getParameter("cin");
	String nom=request.getParameter("nom");
	String prenom=request.getParameter("prenom");
	String email=request.getParameter("email");
	String adresse=request.getParameter("adresse");
	String phone=request.getParameter("phone");
	String password=request.getParameter("passwd");
	
	Citoyen c =new Citoyen(cin,nom,prenom,email,adresse,phone,password);
	try {
		if(metier.signup(c))
		{
			HttpSession session = request.getSession();
			session.setAttribute( "nom", c.getNom());
			session.setAttribute( "cin", c.getCin());
		request.getRequestDispatcher("Acceuil.jsp").forward(request,response);
		}
		else
		{
			String err="ce cin deja existe vous pouvez faire  sign in";
			request.setAttribute("message", err);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


private void signin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	String cin=request.getParameter("cin");
	String email=request.getParameter("email");
	String password=request.getParameter("passwd");
	
	try {
		if(metier.signin(cin, email, password))
		{
			Citoyen c=metier.getUnique(cin);
			HttpSession session = request.getSession();
			session.setAttribute( "nom", c.getNom());
			session.setAttribute( "cin", c.getCin());
		  request.getRequestDispatcher("/Acceuil.jsp").forward(request,response);
		}
		else
		{
			String err="vous avez insérer des informations incorrects";
			request.setAttribute("message2", err);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void creerDemande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	
	String description=request.getParameter("description");
	String choix=request.getParameter("choix2");

    // On récupère le champ du fichier
    Part part = request.getPart("files");
        
    // On vérifie qu'on a bien reçu un fichier
    String nomFichier = getNomFichier(part);
    System.out.println(nomFichier);

    // Si on a bien un fichier
    if (nomFichier != null && !nomFichier.isEmpty()) {
        String nomChamp = part.getName();
      

        // On écrit définitivement le fichier sur le disque
        ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

    }
    String url =CHEMIN_FICHIERS+"/"+nomFichier;

	
	try {
		HttpSession session = request.getSession();
		String cin = (String) session.getAttribute("cin");
		Citoyen c=metier.getUnique(cin);
		Demande d=new Demande(description,url,choix,c);
		if(metier.creerDemande(d))
		{
			String message="votre demande est bien creer";
			request.setAttribute("message2", message);
			request.getRequestDispatcher("Deposer.jsp").forward(request,response);
		}
		


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	
	if(request.getSession().getAttribute("cin")!=null){
		request.getSession().removeAttribute("cin");
		request.getSession().removeAttribute("nom");
		response.sendRedirect("login.jsp");
	}
	else
		response.sendRedirect("login.jsp");
}

private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
    BufferedInputStream entree = null;
    BufferedOutputStream sortie = null;
    try {
        entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
        sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

        byte[] tampon = new byte[TAILLE_TAMPON];
        int longueur;
        while ((longueur = entree.read(tampon)) > 0) {
            sortie.write(tampon, 0, longueur);
        }
    } finally {
        try {
            sortie.close();
        } catch (IOException ignore) {
        }
        try {
            entree.close();
        } catch (IOException ignore) {
        }
    }
}


private static String getNomFichier( Part part ) {
    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
        if ( contentDisposition.trim().startsWith( "filename" ) ) {
            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim();
        }
    }
    return null;
}   



}



