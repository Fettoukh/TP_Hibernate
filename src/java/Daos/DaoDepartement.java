/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Models.Departement;
import Models.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asus
 */
public class DaoDepartement {
     private static Session session;
    private static Transaction tx;
    
    public void SaveDepartement(Departement Dept){
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.save(Dept);
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
    public List<Departement> getAllDepartement(){
      Transaction transaction  =null;
        List<Departement> MaListe =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            MaListe  =session.createQuery("from Departement").list();
         
           
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
    public void UpdateDepartement(Departement Dept){
    
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.update(Dept);
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
    public void DeleteDepartement(String id){
    
        Transaction transaction  =null;
        try
        {   
            //start transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
           //delete a user
           Departement Dept=(Departement)session.get(Departement.class,id);
           if(Dept !=null){
                session.delete(Dept);
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
       
    
    public Departement getDepartement(String id){
    
     Transaction transaction  =null;
     Departement Dept=null;
        try
        {   
            //start transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
           //delete a user
            Dept=(Departement)session.get(Departement.class,id);
           
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
        return Dept;
}
    
}
