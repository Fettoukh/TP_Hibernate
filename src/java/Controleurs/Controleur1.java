/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Daos.DaoDepartement;
import Daos.DaoEmploye;
import Daos.DaoUser;
import Models.Departement;
import Models.Employe;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class Controleur1 extends HttpServlet {
    DaoDepartement DaoD ;
    DaoEmploye DaoE;
    DaoUser DaoU;
    HttpSession S;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void init() 
            throws ServletException 
    {
       DaoD = new DaoDepartement();
       DaoE = new DaoEmploye();
       DaoU = new DaoUser();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action)
        {
            case "LoginUser" :
                SeConnecter(request , response);
                break;
            case "LogoutUser" : 
                SeDeconnecter(request , response);
            case "ShowDepartement" : 
                AfficherDepartement(request , response);
                break;
            case "AddDepartement" : 
                AjouterDepartement (request , response);
                break;
            case "DeleteDepartement" :
                SupprimerDepartement (request , response);
                break;
            case "UpdateDepartement" :
                ModifierDepartement (request , response);
                break;
            case "SaveDepartement" : 
                SauvegarderDepartement (request , response);
                break;
                        
            case "ShowEmploye" :
                AfficherEmploye(request , response);
                break;
            case "AddEmploye" : 
                AjouterEmploye(request , response);
            case "DeleteEmploye" : 
                SupprimerEmploye (request , response);
                break;
            case "UpdateEmploye" : 
                ModifierEmploye (request , response);
                break;
            case "SaveEmploye" :
                SauvegarderEmploye (request , response);
                break;
                
     
        }
    }
    
    protected void SeConnecter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        S = request.getSession();
        boolean trouvé = false;
        String login = request.getParameter("login");
        String Pass = request.getParameter("password");
        List<User> Users = DaoU.getAllUSer();
        for(User temp : Users)
        {
            System.out.println(temp.getLogin() + " " + login + " " +temp.getMdp() +" " +Pass);
            if(temp.getLogin().equals(login) && temp.getMdp().equals(Pass))
            {
                S.setAttribute("User", temp);
                request.getRequestDispatcher("Accueil.jsp").forward(request, response); 
            }
        }
        String Erreur = "Données Invalides !!";
        request.setAttribute("Erreur", Erreur);
        request.getRequestDispatcher("Login.jsp").forward(request, response); 
    }
    
    protected void SeDeconnecter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        S.invalidate();  
        request.getRequestDispatcher("Login.jsp").forward(request, response); 
    }
    
    protected void AfficherDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<Departement> Deps = DaoD.getAllDepartement();
        request.setAttribute("ListDept", Deps);
        request.getRequestDispatcher("IndexDep.jsp").forward(request, response); 
    }
    
    protected void AjouterDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("IDD");
        String Nom = request.getParameter("NomD");
        Departement D = new Departement(ID , Nom);
        DaoD.SaveDepartement(D);  
        AfficherDepartement(request , response);
    }
    
    protected void SupprimerDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("iddsupp");
        Departement D = DaoD.getDepartement(ID);
        for (Employe Emp : D.getEmployes())
        {
            D.getEmployes().remove(Emp);
            Emp.setDepartement(null);
            DaoE.UpdateEmploye(Emp);
        }
        DaoD.DeleteDepartement(ID);
        AfficherDepartement(request, response);
    }
    
    protected void ModifierDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("iddmodif");
        Departement D = DaoD.getDepartement(ID);
        request.setAttribute("DeptModif", D);
        AfficherDepartement(request, response);
    }
    
     protected void SauvegarderDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("iddsave");
        String Nom = request.getParameter("NomD");
        Departement D = DaoD.getDepartement(ID);
        Departement NewD = new Departement(ID , Nom , D.getNombreEmp());
        
        DaoD.UpdateDepartement(NewD);  
        AfficherDepartement(request , response);
    }
    
    protected void AfficherEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Departement> Deps = DaoD.getAllDepartement();
        List<Employe> Emps = DaoE.getAllEmploye();
        String Dep = request.getParameter("Myidd");
        if(Dep != null)
        {
            Departement D = DaoD.getDepartement(Dep);
            request.setAttribute("D", D);
        }      
        request.setAttribute("Deps", Deps);
        request.setAttribute("Emps", Emps);
        request.getRequestDispatcher("IndexEmp.jsp").forward(request, response); 
        }
    
    protected void AjouterEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String SEPARATEUR = " ";
        Departement D;
        Employe E;
        String IDE = request.getParameter("IDE");
        String Nom = request.getParameter("NomE");
        String prenom = request.getParameter("PrenomE");
        int Salaire = Integer.parseInt(request.getParameter("SalaireE"));
        String mots[] = request.getParameter("DepartementE").split(SEPARATEUR);
        if(!"N'affecte a aucun departement".equals(request.getParameter("DepartementE")))
        {  
            D = DaoD.getDepartement(mots[0]); 
            E = new Employe(IDE , D , Nom , prenom , Salaire);
            D.getEmployes().add(E);
            D.setNombreEmp(D.getEmployes().size());
            System.out.println("Departement" + D.getNombreEmp());
            D= new Departement(D.getIdDep(), D.getNom(), D.getNombreEmp());
            DaoD.UpdateDepartement(D); 
            E.setDepartement(D);
        }
        else
        {
           E = new Employe (IDE , Nom , prenom , Salaire);
        }         
        DaoE.SaveEmploye(E); 
        
        AfficherEmploye(request , response);
        }
    
     protected void SupprimerEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String CNE = request.getParameter("idesupp");
         Employe E = DaoE.getEmploye(CNE);
         Departement D = E.getDepartement();
         if(D!=null)
         {
            D.getEmployes().remove(E);
            D.setNombreEmp(D.getEmployes().size());
            D= new Departement(D.getIdDep(), D.getNom(), D.getNombreEmp());
            DaoD.UpdateDepartement(D);
         }
         DaoE.DeleteEmploye(CNE);
         AfficherEmploye(request, response);
        }
     
     protected void ModifierEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("idemodif");
        Employe E = DaoE.getEmploye(ID);
        request.setAttribute("EmpModif", E);
        AfficherEmploye(request, response);
    }
     
     protected void SauvegarderEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Departement D;
        Employe E;
        String SEPARATEUR = " ";        
        String IDE = request.getParameter("idesave");
        String Nom = request.getParameter("NomE");
        String prenom = request.getParameter("PrenomE");
        int Salaire = Integer.parseInt(request.getParameter("SalaireE"));
        String mots[] = request.getParameter("DepartementE").split(SEPARATEUR); 
        E = DaoE.getEmploye(IDE);
        if(!"N'affecte a aucun departement".equals(request.getParameter("DepartementE")))
        {
            if(E.getDepartement()!=null)
            {
                D = E.getDepartement();
                D.getEmployes().remove(E);
                D.setNombreEmp(D.getEmployes().size());
                D= new Departement(D.getIdDep(), D.getNom(), D.getNombreEmp()); 
                DaoD.UpdateDepartement(D);
            }
            D = DaoD.getDepartement(mots[0]);
            D.getEmployes().add(E);
            D.setNombreEmp(D.getEmployes().size());
            D= new Departement(D.getIdDep(), D.getNom(), D.getNombreEmp()); 
            E = new Employe(IDE , D , Nom , prenom , Salaire);
            DaoD.UpdateDepartement(D); 
        }
        else
        {
            if(E.getDepartement()!=null)
            {
                D = E.getDepartement();
                D.getEmployes().remove(E);
                D.setNombreEmp(D.getEmployes().size());
                D= new Departement(D.getIdDep(), D.getNom(), D.getNombreEmp()); 
                DaoD.UpdateDepartement(D);
            }
           E = new Employe (IDE , Nom , prenom , Salaire);
        } 

        DaoE.UpdateEmploye(E);
        AfficherEmploye(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
