package Test;

import java.util.List;

import Dao.TblProductoImp;
import model.TblProductocl2;

public class TestProducto {

    public static void main(String[] args) {
        // Insertar un producto
       TblProductocl2 producto = new TblProductocl2();
        producto.setNombrecl2("jarra");
        producto.setPrecioventacl2(10.0);
        producto.setPreciocompcl2(20.0);
        producto.setEstadocl2("disponible");
        producto.setDescripcl2("azul");

        TblProductoImp crud = new TblProductoImp();
        crud.RegistrarProducto(producto);

        // Listar todos los productos
        List<TblProductocl2> listado = crud.ListarProducto();

        // Imprimir resultados
        for (TblProductocl2 p : listado) {
            System.out.println("ID: " + p.getIdproductocl2() +
                               ", Nombre: " + p.getNombrecl2() +
                               ", Precio Venta: " + p.getPrecioventacl2() +
                               ", Precio Compra: " + p.getPreciocompcl2() +
                               ", Estado: " + p.getEstadocl2() +
                               ", Descripción: " + p.getDescripcl2());
        }
    }
}