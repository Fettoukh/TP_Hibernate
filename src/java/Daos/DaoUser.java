/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Models.HibernateUtil;
import Models.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asus
 */
public class DaoUser {
    private static Session session;
    private static Transaction tx;
    
    public void SaveUser(User user){
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.save(user);
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
    public List<User> getAllUSer(){
      Transaction transaction  =null;
        List<User> MaListe =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            MaListe  =session.createQuery("from User").list();  
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
    public void UpdateUser(User user){
    
     Transaction transaction  =null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            session.update(user);
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
           User user=(User)session.get(User.class,id);
           if(user !=null){
                session.delete(user);
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
    
    public int AuthentificationUser(String login , String mdp){
      Transaction transaction  =null;
      int Result = 0 ;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            Query query=session.createQuery("from User u where u.login = :login ")  ;
            query.setString("login", login);
            //query.setString("mdp", mdp);
            Result = query.getFirstResult();
        }
        catch(HibernateException e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
           return Result;
    }
}