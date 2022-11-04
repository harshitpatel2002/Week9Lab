package dataaccess;

import models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDB {
    public List<User> getAll() throws Exception 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try 
        {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {

        }
    }
    
    public User get(String email) throws Exception 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try 
        {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }

    }
    
    public void insert(User user) throws Exception 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tranc = em.getTransaction();
        try 
        {
            tranc.begin();
            em.persist(user);
            tranc.commit();
        }  catch(Exception e) {
            tranc.rollback();
        } finally {
            
        }
    }

    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tranc = em.getTransaction();
        try 
        {
            tranc.begin();
            em.merge(user);
            tranc.commit();
        }  catch(Exception e) {
            tranc.rollback();
        } finally {
            
        }
    }

    public void delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tranc = em.getTransaction();
        try 
        {
            tranc.begin();
            em.remove(em.merge(user));
            tranc.commit();
        }  catch(Exception e) {
            tranc.rollback();
        } finally {
            
        }
    }

}
