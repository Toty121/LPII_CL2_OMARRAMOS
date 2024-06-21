package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IProducto;
import model.TblProductocl2;

public class TblProductoImp implements IProducto {

    private EntityManagerFactory emf;

    public TblProductoImp() {
        emf = Persistence.createEntityManagerFactory("LPII_CL2_OMARRAMOS");
    }

    @Override
    public void RegistrarProducto(TblProductocl2 producto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            System.out.println("Producto registrado en la base de datos");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void ActualizarProducto(TblProductocl2 producto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TblProductocl2 productoActualizado = em.find(TblProductocl2.class, producto.getIdproductocl2());
            if (productoActualizado != null) {
                productoActualizado.setNombrecl2(producto.getNombrecl2());
                productoActualizado.setPrecioventacl2(producto.getPrecioventacl2());
                productoActualizado.setPreciocompcl2(producto.getPreciocompcl2());
                productoActualizado.setEstadocl2(producto.getEstadocl2());
                productoActualizado.setDescripcl2(producto.getDescripcl2());
                em.getTransaction().commit();
                System.out.println("Producto actualizado en la base de datos");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void EliminarProducto(TblProductocl2 producto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TblProductocl2 productoAEliminar = em.find(TblProductocl2.class, producto.getIdproductocl2());
            if (productoAEliminar != null) {
                em.remove(productoAEliminar);
                em.getTransaction().commit();
                System.out.println("Producto eliminado de la base de datos");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public TblProductocl2 BuscarProducto(TblProductocl2 producto) {
        EntityManager em = emf.createEntityManager();
        TblProductocl2 productoEncontrado = null;
        try {
            productoEncontrado = em.find(TblProductocl2.class, producto.getIdproductocl2());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return productoEncontrado;
    }

    @Override
    public List<TblProductocl2> ListarProducto() {
        EntityManager em = emf.createEntityManager();
        List<TblProductocl2> listado = null;
        try {
            TypedQuery<TblProductocl2> query = em.createQuery("SELECT p FROM TblProductocl2 p", TblProductocl2.class);
            listado = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return listado;
    }
}
