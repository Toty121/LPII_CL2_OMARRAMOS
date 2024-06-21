package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TblProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        //super();
        // TODO Auto-generated constructor stub
    }  //fin del constructor...

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciamos las clases pertinentes
        TblProductocl2 producto = new TblProductocl2();
        TblProductoImp crud = new TblProductoImp();

        // Listamos todos los productos disponibles
        List<TblProductocl2> listadoproducto = crud.ListarProducto();

        // Asignamos el listado de productos recuperados de la BD al request
        request.setAttribute("listadoproducto", listadoproducto);

        // Redireccionamos hacia el listado de productos
        request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
    }
  //fin del metodo doget...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos los datos del formulario
        String nombrecl2 = request.getParameter("nombre");
        double precioventa = Double.parseDouble(request.getParameter("precioventa"));
        double preciocompra = Double.parseDouble(request.getParameter("preciocompra"));
        String estadocl2 = request.getParameter("estado");
        String descripcl2 = request.getParameter("descripcion");

        // Instanciamos las clases pertinentes
        TblProductocl2 producto = new TblProductocl2();
        TblProductoImp crud = new TblProductoImp();

        // Asignamos valores al objeto producto
        producto.setNombrecl2(nombrecl2);
        producto.setPrecioventacl2(precioventa);
        producto.setPreciocompcl2(preciocompra);
        producto.setEstadocl2(estadocl2);
        producto.setDescripcl2(descripcl2);

        // Invocamos al método de registrar producto en la BD
        crud.RegistrarProducto(producto);

        // Actualizamos el listado de productos después de registrar
        List<TblProductocl2> listadoproducto = crud.ListarProducto();

        // Asignamos el listado de productos recuperados de la BD al request
        request.setAttribute("listadoproducto", listadoproducto);

        // Redireccionamos hacia el listado de productos
        request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
    }
}
