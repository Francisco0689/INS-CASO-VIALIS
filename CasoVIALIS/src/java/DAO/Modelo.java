/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fmaldonc
 */
public abstract class Modelo<T> {

    public String nombreModelo;

    public String getNombreModelo() {

        return nombreModelo;
    }

    public List<T> listar() {

        List<T> entidades = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from " + getNombreModelo();
            Query q = sesion.createQuery(hql);

            entidades = q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return entidades;
    }

    public boolean agregar(T entidad) {

        boolean fueAgregado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = sesion.beginTransaction();
            sesion.save(entidad);
            tx.commit();
            fueAgregado = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return fueAgregado;
    }

    public boolean modificar(T entidad) {

        boolean fueModificado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(entidad);
            tx.commit();
            fueModificado = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return fueModificado;
    }

    public boolean eliminar(T entidad) {

        boolean fueEliminado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = sesion.beginTransaction();
            sesion.delete(entidad);
            tx.commit();
            fueEliminado = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return fueEliminado;
    }

    public T buscarPorId(int id) {
        T entidad = null;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select t from " + getNombreModelo() + " t where t.id = :id";
            Query q = sesion.createQuery(hql);
            q.setInteger("id", id);

            entidad = (T) q.list().get(0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return entidad;
    }

    public T buscarPorRutTrabajador(int rut) {
        T entidad = null;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select t from Trabajador t where t.id = :rut";
            Query q = sesion.createQuery(hql);
            q.setInteger("id", rut);

            entidad = (T) q.list().get(0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return entidad;
    }

}
