package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.TblUsuarioImp;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorLogin
 */
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        TblUsuarioImp usuarioDAO = new TblUsuarioImp();
        TblUsuariocl2 usuarioValidado = usuarioDAO.obtenerUsuario(usuario);

        if (usuarioValidado != null && usuarioValidado.getPasswordcl2().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioValidado);

            // Redireccionar a la página principal o a otra página de tu aplicación
            response.sendRedirect("index.jsp");
        } else {
            // Si el usuario no es válido, redirigir de vuelta al formulario de login con un mensaje de error
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}