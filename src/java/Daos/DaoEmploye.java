/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Models.Departement;
import Models.Employe;
import Models.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asus
 */
public class DaoEmploye {
     private static Session session;
    private static Transaction tx;
    
    public void SaveEmploye(Employe Emp){
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.save(Emp);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Employe> getAllEmploye(){
      Transaction transaction  =null;
        List<Employe> MaListe =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            MaListe  =session.createQuery("from Employe").list();
         
           
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
           return MaListe;
    }
    public void UpdateEmploye(Employe Emp){
    
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.update(Emp);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    
    }
    public void DeleteEmploye(String CNE){
    
        Transaction transaction  =null;
        try
        {   
            //start transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
           //delete a user
           Employe Emp=(Employe)session.get(Employe.class,CNE);
           if(Emp !=null){
                session.delete(Emp);
                System.out.println("user is delected");
           }
           transaction.commit();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    
    
    
    }
       
    
    public Employe getEmploye(String CNE){
    
     Transaction transaction  =null;
     Employe Emp=null;
        try
        {   
            //start transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
           //delete a user
            Emp=(Employe)session.get(Employe.class,CNE);
           
           transaction.commit();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return Emp;
    }
    
    public String CountEmploye(Departement Dep)
    {
        Transaction transaction  =null;
        String count = "0";
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            Query query=session.createQuery("select * from Employe e where e.departement = :Dep");
            query.setEntity("Dep", Dep);
            count = query.uniqueResult().toString();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
           return count;
    }
    
    public List<Employe> getEmployeParDept(Departement Dep){
      Transaction transaction  =null;
        List<Employe> MaListe =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            Query query  =session.createQuery("select * from Employe e where e.departement = :Dep");
            query.setEntity("Dep", Dep);
            MaListe = query.list();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
           return MaListe;
    }
}
