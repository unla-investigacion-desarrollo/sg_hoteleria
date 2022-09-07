package sgh.mansilla.modelo.datos.persona;

import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;

public class TipoDocumento implements Identificable<Integer>  {

	Integer idTipoDocumento;
	String descripcion;
	int idDocumentoAfip;

	@Transient
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTipoDocumento;
	}

	public TipoDocumento() {
	}

	public TipoDocumento(Integer idTipoDocumento, String descripcion, int idDocumentoAfip) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
		this.idDocumentoAfip = idDocumentoAfip;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdDocumentoAfip() {
		return idDocumentoAfip;
	}

	public void setIdDocumentoAfip(int idDocumentoAfip) {
		this.idDocumentoAfip = idDocumentoAfip;
	}

}
