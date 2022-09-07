package sgh.mansilla.modelo.negocio;

import java.util.List;

public interface ABM<ID, ENTIDAD> {

	public ENTIDAD buscarPorId(ID id);

	public void guardar(ENTIDAD entidad);

	public List<ENTIDAD> listar();

	public void eliminarPorId(ID id);

	public void actualizar(ENTIDAD entidad);
}
