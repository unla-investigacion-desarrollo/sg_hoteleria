package sgh.mansilla.modelo.dto.facturacion;

import java.util.Date;

import sgh.mansilla.modelo.dao.Identificable;

public class TicketAcceso implements Identificable<Integer>{
	private Integer idTicketAcceso;
	private String sign;
	private String token;
	private String cuit;
	private Date fechaHoraExpiracion;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTicketAcceso;
	}
	
	public TicketAcceso(){
		
	}
	
	public TicketAcceso(String token,String sign,String cuit) {
		super();
		this.sign = sign;
		this.token = token;
		this.cuit = cuit;
	}
	
	public TicketAcceso(String token,String sign ) {
		super();
		this.sign = sign;
		this.token = token;
	}

	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Integer getIdTicketAcceso() {
		return idTicketAcceso;
	}

	public void setIdTicketAcceso(Integer idTicketAcceso) {
		this.idTicketAcceso = idTicketAcceso;
	}

	public Date getFechaHoraExpiracion() {
		return fechaHoraExpiracion;
	}

	public void setFechaHoraExpiracion(Date fechaHoraExpiracion) {
		this.fechaHoraExpiracion = fechaHoraExpiracion;
	}
	
	
	
	
}
