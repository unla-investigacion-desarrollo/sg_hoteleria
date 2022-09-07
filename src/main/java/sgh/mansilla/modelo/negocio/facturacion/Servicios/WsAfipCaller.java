// El Departamento de Seguridad Informatica de la AFIP (DeSeIn/AFIP), pone a disposicion
// el siguiente codigo para su utilizacion con el WebService de Autenticacion y Autorizacion
// de la AFIP.
//
// El mismo no puede ser re-distribuido, publicado o descargado en forma total o parcial, ya sea
// en forma electronica, mecanica u optica, sin la autorizacion de DeSeIn/AFIP. El uso no
// autorizado del mismo esta prohibido.
//
// DeSeIn/AFIP no asume ninguna responsabilidad de los errores que pueda contener el codigo ni la
// obligacion de subsanar dichos errores o informar de la existencia de los mismos.
//
// DeSeIn/AFIP no asume ninguna responsabilidad que surja de la utilizacion del codigo, ya sea por
// utilizacion ilegal de patentes, perdida de beneficios, perdida de informacion o cualquier otro
// inconveniente.
//
// Bajo ninguna circunstancia DeSeIn/AFIP podra ser indicada como responsable por consecuencias y/o
// incidentes ya sean directos o indirectos que puedan surgir de la utilizacion del codigo.
//
// DeSeIn/AFIP no da ninguna garantia, expresa o implicita, de la utilidad del codigo, si el mismo es
// correcto, o si cumple con los requerimientos de algun proposito en particular.
//
// DeSeIn/AFIP puede realizar cambios en cualquier momento en el codigo sin previo aviso.
//
// El codigo debera ser evaluado, verificado, corregido y/o adaptado por personal tecnico calificado
// de las entidades que lo utilicen.
//
// EL SIGUIENTE CODIGO ES DISTRIBUIDO PARA EVALUACION, CON TODOS SUS ERRORES Y OMISIONES. LA
// RESPONSABILIDAD DEL CORRECTO FUNCIONAMIENTO DEL MISMO YA SEA POR SI SOLO O COMO PARTE DE
// OTRA APLICACION, QUEDA A CARGO DE LAS ENTIDADES QUE LO UTILICEN. LA UTILIZACION DEL CODIGO
// SIGNIFICA LA ACEPTACION DE TODOS LOS TERMINOS Y CONDICIONES MENCIONADAS ANTERIORMENTE.
//
// Version 1.0
// gp/rg/OF.G. DeSeIn-AFIP
//

package sgh.mansilla.modelo.negocio.facturacion.Servicios;
import java.io.File;
// El Departamento de Seguridad Informatica de la AFIP (DeSeIn/AFIP), pone a disposicion
// el siguiente codigo para su utilizacion con el WebService de Autenticacion y Autorizacion
// de la AFIP.
//
// El mismo no puede ser re-distribuido, publicado o descargado en forma total o parcial, ya sea
// en forma electronica, mecanica u optica, sin la autorizacion de DeSeIn/AFIP. El uso no
// autorizado del mismo esta prohibido.
//
// DeSeIn/AFIP no asume ninguna responsabilidad de los errores que pueda contener el codigo ni la
// obligacion de subsanar dichos errores o informar de la existencia de los mismos.
//
// DeSeIn/AFIP no asume ninguna responsabilidad que surja de la utilizacion del codigo, ya sea por
// utilizacion ilegal de patentes, perdida de beneficios, perdida de informacion o cualquier otro
// inconveniente.
//
// Bajo ninguna circunstancia DeSeIn/AFIP podra ser indicada como responsable por consecuencias y/o
// incidentes ya sean directos o indirectos que puedan surgir de la utilizacion del codigo.
//
// DeSeIn/AFIP no da ninguna garantia, expresa o implicita, de la utilidad del codigo, si el mismo es
// correcto, o si cumple con los requerimientos de algun proposito en particular.
//
// DeSeIn/AFIP puede realizar cambios en cualquier momento en el codigo sin previo aviso.
//
// El codigo debera ser evaluado, verificado, corregido y/o adaptado por personal tecnico calificado
// de las entidades que lo utilicen.
//
// EL SIGUIENTE CODIGO ES DISTRIBUIDO PARA EVALUACION, CON TODOS SUS ERRORES Y OMISIONES. LA
// RESPONSABILIDAD DEL CORRECTO FUNCIONAMIENTO DEL MISMO YA SEA POR SI SOLO O COMO PARTE DE
// OTRA APLICACION, QUEDA A CARGO DE LAS ENTIDADES QUE LO UTILICEN. LA UTILIZACION DEL CODIGO
// SIGNIFICA LA ACEPTACION DE TODOS LOS TERMINOS Y CONDICIONES MENCIONADAS ANTERIORMENTE.
//
// Version 1.0
// gp/rg/OF.G. DeSeIn-AFIP
//
import java.io.FileInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import sgh.mansilla.modelo.dto.facturacion.ComprobanteDTO;
import sgh.mansilla.modelo.dto.facturacion.TicketAcceso;
import sgh.mansilla.modelo.dto.facturacion.afip.*;
import sgh.mansilla.modelo.dto.facturacion.clientesoap.*;
import sgh.mansilla.modelo.datos.facturacion.*;

public class WsAfipCaller {

	/**
	 * Metodo que indica cual fue el ultimo comprobante que autorizó la AFIP
	 * por tipo de Factura (A,B,Etc), punto de venta =2
	 * TicketAcceso contiene firma y token
	 * Si la respuesta es -1 el metodo no efectuo la consulta correctamente
	 * @param ticketAcceso
	 * @param tipoDeFactura
	 * @param urlSolicitarCAE
	 * @return
	 */
	public static UltimoComprobante getUltimoComprobanteAutorizado(TicketAcceso ticketAcceso,int tipoDeFactura,long cuit, String urlSolicitarCAE,int puntoDeVenta)throws RemoteException,Exception{
		ServiceSoapImplementacion serviceSoapImplementacion=new ServiceSoapImplementacion();
		FEAuthRequest feAuthRequest=new FEAuthRequest(ticketAcceso.getToken(), ticketAcceso.getSign(), cuit);
		UltimoComprobante ultimoComprobante = serviceSoapImplementacion.FECompUltimoAutorizado(feAuthRequest, puntoDeVenta, tipoDeFactura, urlSolicitarCAE);
		return ultimoComprobante;
	}

	/**
	 *
	 * @param urlServicio
	 * @return devuelve el ticket de acceso con la firma, el token y la fecha de expiracion
	 * @throws Exception en caso de que falle alguno de los parametros
	 * @throws java.net.SocketTimeoutException si no responde el ws
	 */
	public static TicketAcceso invocarWSAA(File file,String p12pass,String  signer,String dstDN,String service,Long ticketTime, String urlServicio) throws Exception,java.net.SocketTimeoutException {
		TicketAcceso ticketAcceso = null;
		String loginTicketResponse = null;
		byte [] loginTicketRequestXmlCms = createXmlCMS(file, p12pass, signer, dstDN, service, ticketTime);
		Call call = crearCall("loginCms",urlServicio);
		String base64=Base64.encode(loginTicketRequestXmlCms);
		loginTicketResponse = (String)call.invoke(new Object [] { base64 });
		Reader tokenReader = new StringReader(loginTicketResponse);
		Document tokenDoc = new SAXReader(false).read(tokenReader);
		String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
		String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");
		String fechaExpiracionString = tokenDoc.valueOf("/loginTicketResponse/header/expirationTime");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date fechaExpiracion = format.parse(fechaExpiracionString);
		ticketAcceso = new TicketAcceso(token,sign);
		ticketAcceso.setFechaHoraExpiracion(fechaExpiracion);
		return ticketAcceso;
	}

	private static Call crearCall(String operationName,String urlServicio) throws Exception{
		Service serviceCall = new Service();
		Call call = (Call) serviceCall.createCall();
		call.setTargetEndpointAddress( new java.net.URL(urlServicio) );
		call.setOperationName(operationName);
		call.setTimeout(20000);
		call.addParameter( "in0", XMLType.XSD_STRING, ParameterMode.IN );
		call.setReturnType( XMLType.XSD_STRING );
		return call;
	}

	/**
	 * Metodo que crea el xml para despues cifrarlo y pasarlo a la afip
	 */
	public static byte [] createXmlCMS (File file, String p12pass, String signer, String dstDN, String service, Long TicketTime) {

		PrivateKey pKey = null;
		X509Certificate pCertificate = null;
		byte [] asn1_cms = null;
		CertStore cstore = null;
		String loginTicketRequestXml;
		String signerDN = null;

		//
		// Manage Keys & Certificates
		//
		try {
			// Create a keystore using keys from the pkcs#12 p12file
			KeyStore ks = KeyStore.getInstance("pkcs12");
			

			FileInputStream p12stream = new FileInputStream ( file ) ;
			ks.load(p12stream, p12pass.toCharArray());
			p12stream.close();

			pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());
			pCertificate = (X509Certificate)ks.getCertificate(signer);
			signerDN = pCertificate.getSubjectDN().toString();

			// Create a list of Certificates to include in the final CMS
			ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
			certList.add(pCertificate);

			if (Security.getProvider("BC") == null) {
				Security.addProvider(new BouncyCastleProvider());
			}
			cstore = CertStore.getInstance("Collection", new CollectionCertStoreParameters (certList), "BC");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//
		// Create XML Message
		//
		loginTicketRequestXml = createLoginTicketRequest(signerDN, dstDN, service, TicketTime);

		//
		// Create CMS Message
		//
		try {
			// Create a new empty CMS Message
			CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

			// Add a Signer to the Message
			gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);

			// Add the Certificate to the Message
			gen.addCertificatesAndCRLs(cstore);

			// Add the data (XML) to the Message
			CMSProcessable data = new CMSProcessableByteArray(loginTicketRequestXml.getBytes());

			// Add a Sign of the Data to the Message
			CMSSignedData signed = gen.generate(data, true, "BC");

			//
			asn1_cms = signed.getEncoded();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return (asn1_cms);
	}

	//
	// Create XML Message for AFIP wsaa
	//
	public static String createLoginTicketRequest (String SignerDN, String dstDN, String service, Long ticketTime) {

		String LoginTicketRequest_xml;

		Date GenTime = new Date();
		GregorianCalendar gentime = new GregorianCalendar();
		gentime.setTime(new Date(GenTime.getTime()-36000));
		
		GregorianCalendar exptime = new GregorianCalendar();
		String UniqueId = new Long(GenTime.getTime() / 1000).toString();

		exptime.setTime(new Date(GenTime.getTime()+ticketTime));
		
		XMLGregorianCalendar XMLGenTime = null;
		XMLGregorianCalendar XMLExpTime = null;
		DatatypeFactory datatypeFactory;
		try {
			datatypeFactory = DatatypeFactory.newInstance();
			XMLGenTime = datatypeFactory.newXMLGregorianCalendar(gentime);
			XMLExpTime = datatypeFactory.newXMLGregorianCalendar(exptime);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LoginTicketRequest_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+"<loginTicketRequest version=\"1.0\">"
				+"<header>"
				+"<source>" + SignerDN + "</source>"
				+"<destination>" + dstDN + "</destination>"
				+"<uniqueId>" + UniqueId + "</uniqueId>"
				+"<generationTime>" + XMLGenTime + "</generationTime>"
				+"<expirationTime>" + XMLExpTime + "</expirationTime>"
				+"</header>"
				+"<service>" + service + "</service>"
				+"</loginTicketRequest>";

		System.out.println("XML TICKET ACCESO: " + LoginTicketRequest_xml);

		return (LoginTicketRequest_xml);
	}
	public static FECompConsultaResponse consultaCAE(FEAuthRequest auth,FECompConsultaReq feCompConsReq,String urlSolicitarCAE) throws RemoteException{
		ServiceSoapImplementacion serviceSoapImplementacion=new ServiceSoapImplementacion();
		FECompConsultaResponse respuesta=serviceSoapImplementacion.FECompConsultar(auth, feCompConsReq,urlSolicitarCAE);
		return respuesta;
	}
	public static RespuestaAFIP getCAE(TicketAcceso ticketAcceso, String urlSolicitarCAE,ComprobanteDTO comprobante,int puntoDeVenta) throws Exception{
		ErrorAfip errorAfip = validarDatos(comprobante, puntoDeVenta);
		RespuestaAFIP respuesta;
		FECAEResponse fecaeResponse = null;
		if(errorAfip==null){
			FEAuthRequest authRequest = new FEAuthRequest(ticketAcceso.getToken(), ticketAcceso.getSign(), Long.parseLong(ticketAcceso.getCuit()));
			FECAERequest fecaeRequest = null;

			//int cantidadRegistros=1; //Averiguar
			//int concepto=1; //Averiguar
			//int idIva=5; //Averiguar

			//double importeExcento=0;
			//double importeTributos=0;
			try{
				FECAEDetRequest fecaeDetRequest = new FECAEDetRequest();
				fecaeDetRequest.setConcepto(comprobante.getIdConcepto());
				fecaeDetRequest.setDocTipo(Integer.parseInt(comprobante.getCodigoDocumento()));
				fecaeDetRequest.setDocNro(Long.parseLong(comprobante.getNroDocumentoCliente()));
				fecaeDetRequest.setCbteDesde(comprobante.getNumeroComprobante());
				fecaeDetRequest.setCbteHasta(comprobante.getNumeroComprobante());
				fecaeDetRequest.setCbteFch(comprobante.getFechaFormateada());
				fecaeDetRequest.setImpTotal(comprobante.getImporteTotal());
				fecaeDetRequest.setImpNeto(comprobante.getSubtotal());
				fecaeDetRequest.setImpOpEx(comprobante.getImporteExcento()); //Averiguar que significa
				fecaeDetRequest.setImpTrib(comprobante.getImporteTributos()); //Averiguar que significa
				fecaeDetRequest.setImpIVA(comprobante.getTotalIva());
				fecaeDetRequest.setMonId(comprobante.getIdMoneda());
				fecaeDetRequest.setMonCotiz(comprobante.getCotizacionMoneda());
				//fecaeDetRequest.setMonId("PES");
				//fecaeDetRequest.setMonCotiz(1);

				//AlicIva [] alicIvas = {new AlicIva(idIva,factura.getSubtotal(), fecaeDetRequest.getImpIVA())};
				AlicIva [] alicIvas = comprobante.getAlicIvas();
				fecaeDetRequest.setIva(alicIvas);

				FECAECabRequest feCabReq = new FECAECabRequest(comprobante.getCantidadRegistros(),puntoDeVenta,Integer.parseInt(comprobante.getCodigoComprobante()));
				Collection<FECAEDetRequest> fecaeDetRequests = new ArrayList<FECAEDetRequest>();
				fecaeDetRequests.add(fecaeDetRequest);
				FECAEDetRequest [] detRequests = fecaeDetRequests.toArray(new FECAEDetRequest[0]);

				fecaeRequest = new FECAERequest(feCabReq, detRequests);
				WSFEClient wsfeClient=new WSFEClientImplementacion();
				fecaeResponse = wsfeClient.obtenerCAE(authRequest, fecaeRequest,urlSolicitarCAE);
			}
			catch(SocketTimeoutException timeoutException){
				//Veo si llego el comprobante
				timeoutException.printStackTrace();
				//Reintentar descarga
				fecaeResponse = validarCAE(authRequest,urlSolicitarCAE,fecaeRequest);
			}
			catch(AxisFault axisFault){
				//Timeout?
				axisFault.printStackTrace();
				fecaeResponse = validarCAE(authRequest,urlSolicitarCAE,fecaeRequest);

			}
			catch(UnknownHostException unknownHostException){
				//Se perdio la conexion antes del llamado ?
				unknownHostException.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			respuesta=getRespuestaAFIP(fecaeResponse);
		}
		else{
			// no cumplio la validacion inicial
			fecaeResponse = new FECAEResponse();
			ErrorAfip errores[] = new ErrorAfip[1];
			errores[0] = errorAfip;
			//CREO UN OBJETO RESPUESTA CON SOLO EL ERROR ADENTRO
			respuesta = new RespuestaAFIP(null);
			respuesta.setErrores(errores);

		}

		//convierto la respuesta de la afip para setearselo a la factura

		return respuesta;
	}

	/**
	 * Metodo que convierte la respuesta de la afip a la clase con los datos necesitados por el modelo
	 * @param fecaeResponse
	 * @return
	 */
	private static RespuestaAFIP getRespuestaAFIP(FECAEResponse fecaeResponse) {
		RespuestaAFIP respuestaAfip = new RespuestaAFIP(fecaeResponse.getFeDetResp()[0].getCAE());
		respuestaAfip.setResultado(fecaeResponse.getFeDetResp()[0].getResultado());
		respuestaAfip.setErrores(fecaeResponse.getErrors());
		respuestaAfip.setObservaciones(fecaeResponse.getFeDetResp()[0].getObservaciones());
		respuestaAfip.setResultado(fecaeResponse.getFeDetResp()[0].getResultado());
		String fechaExpiracionString = fecaeResponse.getFeDetResp()[0].getCAEFchVto();
		GregorianCalendar fechaExpiracion = null;
		if(fechaExpiracionString!=null&& !fechaExpiracionString.isEmpty()){
			fechaExpiracion = getGregorianCalendar(fechaExpiracionString);
		}
		respuestaAfip.setFechaExpiracion(fechaExpiracion);
		return respuestaAfip;
	}

	private static GregorianCalendar getGregorianCalendar(String fecha){
		int anio = Integer.parseInt(fecha.substring(0,4));
		int mes = Integer.parseInt(fecha.substring(4,6))-1;
		int dia = Integer.parseInt(fecha.substring(6,8));
		GregorianCalendar fechaRetorno = new GregorianCalendar(anio,mes,dia);
		return fechaRetorno;
	}
	private static FECAEResponse validarCAE(FEAuthRequest authRequest, String urlSolicitarCAE,FECAERequest request) throws Exception {
		FECAEResponse respuesta = new FECAEResponse();
		FECompConsultaReq consultaCAE=new FECompConsultaReq(request.getFeCabReq().getCbteTipo(),request.getFeDetReq()[0].getCbteDesde() ,request.getFeCabReq().getPtoVta());
		FECompConsultaResponse respuestaConsulta = consultaCAE(authRequest,consultaCAE,urlSolicitarCAE);
		if(respuestaConsulta.getResultGet()==null){
			WSFEClient wsfeClient=new WSFEClientImplementacion();
			respuesta = wsfeClient.obtenerCAE(authRequest, request,urlSolicitarCAE);
		}
		else{
			FECAEDetResponse[] caeDetalleArray = new FECAEDetResponse[1];
			FECAEDetResponse caeDetalle=new FECAEDetResponse();
			caeDetalle.setCAE(respuestaConsulta.getResultGet().getCodAutorizacion());
			caeDetalle.setObservaciones(respuestaConsulta.getResultGet().getObservaciones());
			caeDetalle.setResultado(respuestaConsulta.getResultGet().getResultado());
			caeDetalleArray[0] = caeDetalle;
			respuesta.setFeDetResp(caeDetalleArray);
			respuesta.setFeDetResp(caeDetalleArray); //Crear y setear los objetos para que se pueda levantar el CAE
		}
		return respuesta;
	}


	/**
	 * Metodo que valida los datos de la factura, devuelve null si todo esta bien, sino el errorAfip de acuerdo al
	 * manual_desarrollador_COMPG_v2_4.pdf de afip
	 * @param factura
	 * @return
	 */

	private static ErrorAfip validarDatos(ComprobanteDTO factura,int puntoDeVenta){
		ErrorAfip errorAfip = null;
		int errorCode = -1;
		String errorMsg = null;
		if(puntoDeVenta<1||puntoDeVenta>9998){
			errorCode = 10004;
			errorMsg = "El campo punto de venta debe estar comprendido entre 1 y 9998.";
		}
		else if(factura.getNumeroComprobante()<1||factura.getNumeroComprobante()>99999999){
			errorCode = 10010;
			errorMsg = "El campo número de comprobante debe estar comprendido entre 1 y 99999999.";
		}
		else if(factura.esFacturaA()&&Integer.parseInt(factura.getCodigoDocumento())!=80){
			//Para los casos que la factura es A, el tipo doc tiene q ser 80 (CUIT)
			errorCode = 10013;
			errorMsg = "Para comprobantes tipo A el tipo de documento debe ser CUIT";
		}
		else if(factura.esFacturaB()&&Integer.parseInt(factura.getCodigoDocumento())==99&& ( !factura.getNroDocumentoCliente().equalsIgnoreCase("0"))){
			errorCode = 10015;
			errorMsg = "Para comprobantes tipo B, si el campo tipo documento es \"otro\", el campo numero de documento deberá ser cero.";
		}
//			else if(factura.esFacturaB()&& (Integer.parseInt(factura.getCliente().getTipoDocumento().getCodigo())==80|Integer.parseInt(factura.getCliente().getTipoDocumento().getCodigo())==86|Integer.parseInt(factura.getCliente().getTipoDocumento().getCodigo())==87)){
//			esto no lo puedo validar (que este inscripto en la afip)
//			}
		else if( (factura.esFacturaB()&&factura.getImporteNeto()>=1000) &&((Integer.parseInt(factura.getCodigoDocumento())==99)|| (factura.getNroDocumentoCliente()==null) || (factura.getCodigoDocumento().equalsIgnoreCase("0")))){
			errorCode = 10015;
			errorMsg = "Para comprobante tipo B, si el importe neto es mayor a $1000 el tipo de documento no puede ser \"otro\" y debe informar el numero de documento";
		}

		if(errorCode!=-1){
			// si tiene un error seteo el error y mensaje en el errorAfip que se retorna, sino queda en null (sin errores)
			errorAfip = new ErrorAfip(errorCode, errorMsg);
		}

		return errorAfip;
	}


}