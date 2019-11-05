package Models;
// Generated 2 nov. 2019 20:17:52 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="ginf3_jee"
)
public class User  implements java.io.Serializable {


     private String login;
     private String mdp;
     private String nom;
     private String prenom;

    public User() {
    }

    public User(String login, String mdp, String nom, String prenom) {
       this.login = login;
       this.mdp = mdp;
       this.nom = nom;
       this.prenom = prenom;
    }
   
     @Id 

    
    @Column(name="Login", unique=true, nullable=false)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="Mdp", nullable=false)
    public String getMdp() {
        return this.mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    @Column(name="Nom", nullable=false)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="Prenom", nullable=false)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }




}


