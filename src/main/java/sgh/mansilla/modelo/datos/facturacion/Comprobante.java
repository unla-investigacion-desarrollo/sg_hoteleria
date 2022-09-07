package sgh.mansilla.modelo.datos.facturacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.datos.usuario.Empleado;

public class Comprobante implements Identificable<Integer>  {

		private Integer idComprobante;
		private int nroComprobante;
		private int ptoVenta;
		private TipoComprobante tipoComprobante;
		private ClienteComprobante clienteComprobante;
		private Moneda moneda;
		private ConceptosAIncluir conceptosAIncluir;
		private FormaDePago formaDePago;
		private Date fechaComprobante; 
		private Date fechaFacturadoDesde;
		private Date fechaFacturadoHasta;
		private Date vencimientoPago;
		private List<Concepto> conceptos = new ArrayList<Concepto>();
		private Set<Alicuota> alicuotas = new HashSet<Alicuota>();
		private Set<Tributo> otrosTributos = new HashSet<Tributo>();
//		private Set<String> observaciones = new HashSet<String>();
		private double importeNeto; //ImpNeto
	    private double importeNoGravado; //ImpTotConc
	    private double totalIva;  //ImpIVA
		private double importeTotal; //ImpTotal
	    private double importeExcento; //ImpOpEx
		private double importeTributos; //ImpTrib
		private String cae;
		private Date vencimientoCae;
		
		@Override
		public Integer getId() {
			// TODO Auto-generated method stub
			return idComprobante;
		}

		public Comprobante() {
			super();
		}

		public Integer getIdComprobante() {
			return idComprobante;
		}

		public void setIdComprobante(Integer idComprobante) {
			this.idComprobante = idComprobante;
		}

		public int getNroComprobante() {
			return nroComprobante;
		}

		public void setNroComprobante(int nroComprobante) {
			this.nroComprobante = nroComprobante;
		}

		public int getPtoVenta() {
			return ptoVenta;
		}

		public void setPtoVenta(int ptoVenta) {
			this.ptoVenta = ptoVenta;
		}

		public TipoComprobante getTipoComprobante() {
			return tipoComprobante;
		}

		public void setTipoComprobante(TipoComprobante tipoComprobante) {
			this.tipoComprobante = tipoComprobante;
		}

		public ClienteComprobante getClienteComprobante() {
			return clienteComprobante;
		}

		public void setClienteComprobante(ClienteComprobante clienteComprobante) {
			this.clienteComprobante = clienteComprobante;
		}

		public Moneda getMoneda() {
			return moneda;
		}

		public void setMoneda(Moneda moneda) {
			this.moneda = moneda;
		}

		public ConceptosAIncluir getConceptosAIncluir() {
			return conceptosAIncluir;
		}

		public void setConceptosAIncluir(ConceptosAIncluir conceptosAIncluir) {
			this.conceptosAIncluir = conceptosAIncluir;
		}

		public FormaDePago getFormaDePago() {
			return formaDePago;
		}

		public void setFormaDePago(FormaDePago formaDePago) {
			this.formaDePago = formaDePago;
		}

		public Date getFechaComprobante() {
			return fechaComprobante;
		}

		public void setFechaComprobante(Date fechaComprobante) {
			this.fechaComprobante = fechaComprobante;
		}

		public Date getFechaFacturadoDesde() {
			return fechaFacturadoDesde;
		}

		public void setFechaFacturadoDesde(Date fechaFacturadoDesde) {
			this.fechaFacturadoDesde = fechaFacturadoDesde;
		}

		public Date getFechaFacturadoHasta() {
			return fechaFacturadoHasta;
		}

		public void setFechaFacturadoHasta(Date fechaFacturadoHasta) {
			this.fechaFacturadoHasta = fechaFacturadoHasta;
		}

		public Date getVencimientoPago() {
			return vencimientoPago;
		}

		public void setVencimientoPago(Date vencimientoPago) {
			this.vencimientoPago = vencimientoPago;
		}

		public List<Concepto> getConceptos() {
			return conceptos;
		}

		public void setConceptos(List<Concepto> conceptos) {
			this.conceptos = conceptos;
		}

		public Set<Alicuota> getAlicuotas() {
			return alicuotas;
		}

		public void setAlicuotas(Set<Alicuota> alicuotas) {
			this.alicuotas = alicuotas;
		}

		public Set<Tributo> getOtrosTributos() {
			return otrosTributos;
		}

		public void setOtrosTributos(Set<Tributo> otrosTributos) {
			this.otrosTributos = otrosTributos;
		}

//		public Set<String> getObservaciones() {
//			return observaciones;
//		}
//
//		public void setObservaciones(Set<String> observaciones) {
//			this.observaciones = observaciones;
//		}

		public String getCae() {
			return cae;
		}

		public void setCae(String cae) {
			this.cae = cae;
		}

		public Date getVencimientoCae() {
			return vencimientoCae;
		}

		public void setVencimientoCae(Date vencimientoCae) {
			this.vencimientoCae = vencimientoCae;
		}

		public double getImporteNeto() {
			return importeNeto;
		}

		public void setImporteNeto(double importeNeto) {
			this.importeNeto = importeNeto;
		}

		public double getImporteNoGravado() {
			return importeNoGravado;
		}

		public void setImporteNoGravado(double subtotal) {
			this.importeNoGravado = subtotal;
		}

		public double getTotalIva() {
			return totalIva;
		}

		public void setTotalIva(double totalIva) {
			this.totalIva = totalIva;
		}

		public double getImporteTotal() {
			return importeTotal;
		}

		public void setImporteTotal(double importeTotal) {
			this.importeTotal = importeTotal;
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
		
		
		//aaaaa
		public boolean esFacturaA() {
			if(this.getTipoComprobante().getCodigo().equals("001")) return true;
			return false;
		}
		
		public boolean esFacturaB() {
			if(this.getTipoComprobante().getCodigo().equals("006")) return true;
			return false;
		}
		

}

