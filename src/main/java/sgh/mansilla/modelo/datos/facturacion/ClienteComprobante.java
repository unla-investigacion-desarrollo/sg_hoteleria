package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.persona.TipoDocumento;

public class ClienteComprobante implements Identificable<Integer>{

	private Integer idClienteComprobante;
	private String nombre;
	private String apellido;
	private String razonSocial;
	private TipoDocumento tipoDocumento;
	private String documento;
	private String domicilio;
	private String localidad;
	private String mail;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idClienteComprobante;
	}
	
	public ClienteComprobante(){
		
	}

	public Integer getIdClienteComprobante() {
		return idClienteComprobante;
	}

	public void setIdClienteComprobante(Integer idClienteComprobante) {
		this.idClienteComprobante = idClienteComprobante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
