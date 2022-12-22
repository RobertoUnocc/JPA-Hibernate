package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEliminar {


    public static void main(String[] args) {
        EntityManager em= JpaUtil.getEntityManager();

        try {

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID del Cliente a Eliminar: "));
            Cliente c= em.find(Cliente.class,id);

            em.getTransaction().begin();
            /* */
            em.remove(c); /* CON ESTO ELIMINAMOS EN EL CONTEXTO*/
            /* */
            em.getTransaction().commit();

            System.out.println(c);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
