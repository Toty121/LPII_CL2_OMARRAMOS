package Interfaces;

import java.util.List;

import model.TblProductocl2;

public interface IProducto {
	
	//declaramos los metodos
		public void RegistrarProducto(TblProductocl2 producto);
		public void ActualizarProducto(TblProductocl2 producto);
		public void EliminarProducto(TblProductocl2 producto);
		public TblProductocl2 BuscarProducto(TblProductocl2 producto);
		public List<TblProductocl2> ListarProducto();

}  //fin de la interface
