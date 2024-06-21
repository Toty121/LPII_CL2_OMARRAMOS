package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

public class TblUsuarioImp implements IUsuario {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_OMARRAMOS");

    @Override
    public TblUsuariocl2 obtenerUsuario(String usuario) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<TblUsuariocl2> query = em.createQuery("SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :usuario", TblUsuariocl2.class);
        query.setParameter("usuario", usuario);
        TblUsuariocl2 usuarioEncontrado = null;
        try {
            usuarioEncontrado = query.getSingleResult();
        } catch (Exception e) {
            // Manejar excepciones (usuario no encontrado, etc.)
        } finally {
            em.close();
        }
        return usuarioEncontrado;
    }
}