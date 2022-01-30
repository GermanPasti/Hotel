/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Empleado;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author germa
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
            public ReservaJpaController()
    {
    
    emf = Persistence.createEntityManagerFactory("HotelPU");
        
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion != null) {
                habitacion = em.getReference(habitacion.getClass(), habitacion.getId_habitacion());
                reserva.setHabitacion(habitacion);
            }
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped = em.getReference(huesped.getClass(), huesped.getDni());
                reserva.setHuesped(huesped);
            }
            Empleado empleado = reserva.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getDni());
                reserva.setEmpleado(empleado);
            }
            em.persist(reserva);
            if (habitacion != null) {
                habitacion.getListaReservas().add(reserva);
                habitacion = em.merge(habitacion);
            }
            if (huesped != null) {
                huesped.getListaReservas().add(reserva);
                huesped = em.merge(huesped);
            }
            if (empleado != null) {
                empleado.getListaReservas().add(reserva);
                empleado = em.merge(empleado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId_reserva());
            Habitacion habitacionOld = persistentReserva.getHabitacion();
            Habitacion habitacionNew = reserva.getHabitacion();
            Huesped huespedOld = persistentReserva.getHuesped();
            Huesped huespedNew = reserva.getHuesped();
            Empleado empleadoOld = persistentReserva.getEmpleado();
            Empleado empleadoNew = reserva.getEmpleado();
            if (habitacionNew != null) {
                habitacionNew = em.getReference(habitacionNew.getClass(), habitacionNew.getId_habitacion());
                reserva.setHabitacion(habitacionNew);
            }
            if (huespedNew != null) {
                huespedNew = em.getReference(huespedNew.getClass(), huespedNew.getDni());
                reserva.setHuesped(huespedNew);
            }
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getDni());
                reserva.setEmpleado(empleadoNew);
            }
            reserva = em.merge(reserva);
            if (habitacionOld != null && !habitacionOld.equals(habitacionNew)) {
                habitacionOld.getListaReservas().remove(reserva);
                habitacionOld = em.merge(habitacionOld);
            }
            if (habitacionNew != null && !habitacionNew.equals(habitacionOld)) {
                habitacionNew.getListaReservas().add(reserva);
                habitacionNew = em.merge(habitacionNew);
            }
            if (huespedOld != null && !huespedOld.equals(huespedNew)) {
                huespedOld.getListaReservas().remove(reserva);
                huespedOld = em.merge(huespedOld);
            }
            if (huespedNew != null && !huespedNew.equals(huespedOld)) {
                huespedNew.getListaReservas().add(reserva);
                huespedNew = em.merge(huespedNew);
            }
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getListaReservas().remove(reserva);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getListaReservas().add(reserva);
                empleadoNew = em.merge(empleadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reserva.getId_reserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId_reserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion != null) {
                habitacion.getListaReservas().remove(reserva);
                habitacion = em.merge(habitacion);
            }
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped.getListaReservas().remove(reserva);
                huesped = em.merge(huesped);
            }
            Empleado empleado = reserva.getEmpleado();
            if (empleado != null) {
                empleado.getListaReservas().remove(reserva);
                empleado = em.merge(empleado);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reserva findReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
