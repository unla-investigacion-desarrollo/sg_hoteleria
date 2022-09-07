package sgh.mansilla.modelo.dto.facturacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import sgh.mansilla.modelo.dto.facturacion.afip.AlicIva;
import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;



public class ComprobanteDTO {
	private String codigoComprobante;
	private String codigoDocumento;
	private String nroDocumentoCliente;
	private int numeroComprobante;
	private GregorianCalendar fecha;
	private double importeNeto;
    private double impuesto;
    private double subtotal;
    private double totalIva;
    private double porcentajeIva;
	private double importeTotal;
    private String remitoNro;
    private String condicionVenta;
    private int cantidadRegistros;
	private int idConcepto;
    private int idIva;
    private AlicIva [] alicIvas;
    private double importeExcento;
	private double importeTributos;
	private String idMoneda;
    private double cotizacionMoneda;

	public ComprobanteDTO() {
	}

	public ComprobanteDTO(TipoComprobante tipoComprobante,
			int numeroComprobante, GregorianCalendar fecha, double importeNeto) {
		super();
		this.numeroComprobante = numeroComprobante;
		this.fecha = fecha;
		this.importeNeto = importeNeto;
	}

    public ComprobanteDTO(TipoComprobante tipoComprobante, int numeroComprobante, GregorianCalendar fecha, double importeNeto, double impuesto, double subtotal, double totalIva, double porcentajeIva, String remitoNro, String condicionVenta) {
        this.numeroComprobante = numeroComprobante;
        this.fecha = fecha;
        this.importeNeto = importeNeto;
        this.impuesto = impuesto;
        this.subtotal = subtotal;
        this.totalIva = totalIva;
        this.porcentajeIva = porcentajeIva;
        this.remitoNro = remitoNro;
        this.condicionVenta = condicionVenta;
        
    }

    public String getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(String condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public String getRemitoNro() {
        return remitoNro;
    }

    public void setRemitoNro(String remitoNro) {
        this.remitoNro = remitoNro;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(double totalIva) {
        this.totalIva = totalIva;
    }

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public int getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
	}

	public int getIdIva() {
		return idIva;
	}

	public void setIdIva(int idIva) {
		this.idIva = idIva;
	}

	public int getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(int numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getImporteNeto() {
		return importeNeto;
	}

	public void setImporteNeto(double importeNeto) {
		this.importeNeto = importeNeto;
	}

	public double getImporteTotal(){
		return this.importeTotal;
	}

	public void setImporteTotal(double importeTotal){
		this.importeTotal = importeTotal;
	}

	public AlicIva[] getAlicIvas() {
		return alicIvas;
	}

	public void setAlicIvas(AlicIva[] alicIvas) {
		this.alicIvas = alicIvas;
	}

	public double getImporteExcento() {
		return importeExcento;
	}

	public void setImporteExcento(double importeExcento) {
		this.importeExcento = importeExcento;
	}

	public double getImporteTributos() {
		return importeTributos;
	}

	public void setImporteTributos(double importeTributos) {
		this.importeTributos = importeTributos;
	}

	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public double getCotizacionMoneda() {
		return cotizacionMoneda;
	}

	public void setCotizacionMoneda(double cotizacionMoneda) {
		this.cotizacionMoneda = cotizacionMoneda;
	}
	
	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getNroDocumentoCliente() {
		return nroDocumentoCliente;
	}

	public void setNroDocumentoCliente(String nroDocumentoCliente) {
		this.nroDocumentoCliente = nroDocumentoCliente;
	}

	public String getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(String codigoComprobante) {
		this.codigoComprobante = codigoComprobante;
	}

	public String getFechaFormateada() {
		int mes=fecha.get(Calendar.MONTH)+1;
		String mesString=String.valueOf(mes);

		if(mesString.length()==1){
			mesString="0"+mesString;
		}

		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String diaString = String.valueOf(dia);

		if(diaString.length() == 1){
			diaString = "0" + diaString;
		}

		return String.valueOf(fecha.get(Calendar.YEAR)) + mesString + diaString;
	}
	
	public String getFechaString()
	{
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	    fmt.setCalendar(this.fecha);
	    String dateFormatted = fmt.format(this.fecha.getTime());
	    return dateFormatted;

	}

	public boolean esFacturaA(){
		boolean bandera=false;
		if(codigoComprobante.equalsIgnoreCase("001")){
			bandera=true;
		}
		return bandera;
	}
	public boolean esFacturaB(){
		boolean bandera=false;
		if(codigoComprobante.equalsIgnoreCase("006")){
			bandera=true;
		}
		return bandera;
	}

	}
