/**
 * ServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sgh.mansilla.modelo.dto.facturacion.afip;

import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

public class ServiceSoapImplementacion extends org.apache.axis.client.Stub implements ServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();
    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FECAESolicitar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEAuthRequest"), FEAuthRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FeCAEReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAERequest"), FECAERequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEResponse"));
        oper.setReturnClass(FECAEResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAESolicitarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEDummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DummyResponse"));
        oper.setReturnClass(DummyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEDummyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FECompUltimoAutorizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEAuthRequest"), FEAuthRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "PtoVta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteTipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FERecuperaLastCbteResponse"));
        oper.setReturnClass(UltimoComprobante.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompUltimoAutorizadoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FECompConsultar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEAuthRequest"), FEAuthRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FeCompConsReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultaReq"), FECompConsultaReq.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultaResponse"));
        oper.setReturnClass(FECompConsultaResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

       
        
    }

        
    public ServiceSoapImplementacion() throws org.apache.axis.AxisFault {
        this(null);
   }

   public ServiceSoapImplementacion(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
   }

   public ServiceSoapImplementacion(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
       if (service == null) {
           super.service = new org.apache.axis.client.Service();
       } else {
           super.service = service;
       }
       ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "AlicIva");
            cachedSerQNames.add(qName);
            cls = AlicIva.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfAlicIva");
            cachedSerQNames.add(qName);
            cls = AlicIva[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "AlicIva");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "AlicIva");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfCbteAsoc");
            cachedSerQNames.add(qName);
            cls = CbteAsoc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteAsoc");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteAsoc");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfCbteTipo");
            cachedSerQNames.add(qName);
            cls = CbteTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfConceptoTipo");
            cachedSerQNames.add(qName);
            cls = ConceptoTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ConceptoTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ConceptoTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfDocTipo");
            cachedSerQNames.add(qName);
            cls = DocTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DocTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DocTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfErr");
            cachedSerQNames.add(qName);
            cls = ErrorAfip[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Err");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Err");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfEvt");
            cachedSerQNames.add(qName);
            cls = Evt[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Evt");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Evt");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfFECAEADetRequest");
            cachedSerQNames.add(qName);
            cls = FECAEADetRequest[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetRequest");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetRequest");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfFECAEADetResponse");
            cachedSerQNames.add(qName);
            cls = FECAEADetResponse[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetResponse");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfFECAEASinMov");
            cachedSerQNames.add(qName);
            cls = FECAEASinMov[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEASinMov");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEASinMov");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfFECAEDetRequest");
            cachedSerQNames.add(qName);
            cls = FECAEDetRequest[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetRequest");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetRequest");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfFECAEDetResponse");
            cachedSerQNames.add(qName);
            cls = FECAEDetResponse[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetResponse");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfIvaTipo");
            cachedSerQNames.add(qName);
            cls = IvaTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "IvaTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "IvaTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfMoneda");
            cachedSerQNames.add(qName);
            cls = Moneda[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Moneda");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Moneda");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfObs");
            cachedSerQNames.add(qName);
            cls = Observacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Obs");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Obs");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfOpcional");
            cachedSerQNames.add(qName);
            cls = Opcional[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Opcional");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Opcional");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfOpcionalTipo");
            cachedSerQNames.add(qName);
            cls = OpcionalTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "OpcionalTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "OpcionalTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfPtoVenta");
            cachedSerQNames.add(qName);
            cls = PtoVenta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "PtoVenta");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "PtoVenta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfTributo");
            cachedSerQNames.add(qName);
            cls = Tributo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Tributo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Tributo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ArrayOfTributoTipo");
            cachedSerQNames.add(qName);
            cls = TributoTipo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "TributoTipo");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "TributoTipo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteAsoc");
            cachedSerQNames.add(qName);
            cls = CbteAsoc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteTipo");
            cachedSerQNames.add(qName);
            cls = CbteTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteTipoResponse");
            cachedSerQNames.add(qName);
            cls = CbteTipoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ConceptoTipo");
            cachedSerQNames.add(qName);
            cls = ConceptoTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "ConceptoTipoResponse");
            cachedSerQNames.add(qName);
            cls = ConceptoTipoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Cotizacion");
            cachedSerQNames.add(qName);
            cls = Cotizacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DocTipo");
            cachedSerQNames.add(qName);
            cls = DocTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DocTipoResponse");
            cachedSerQNames.add(qName);
            cls = DocTipoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "DummyResponse");
            cachedSerQNames.add(qName);
            cls = DummyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Err");
            cachedSerQNames.add(qName);
            cls = ErrorAfip.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Evt");
            cachedSerQNames.add(qName);
            cls = Evt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEAuthRequest");
            cachedSerQNames.add(qName);
            cls = FEAuthRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECabRequest");
            cachedSerQNames.add(qName);
            cls = FECabRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECabResponse");
            cachedSerQNames.add(qName);
            cls = FECabResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEACabRequest");
            cachedSerQNames.add(qName);
            cls = FECAEACabRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEACabResponse");
            cachedSerQNames.add(qName);
            cls = FECAEACabResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetRequest");
            cachedSerQNames.add(qName);
            cls = FECAEADetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetResponse");
            cachedSerQNames.add(qName);
            cls = FECAEADetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEAGet");
            cachedSerQNames.add(qName);
            cls = FECAEAGet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEAGetResponse");
            cachedSerQNames.add(qName);
            cls = FECAEAGetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEARequest");
            cachedSerQNames.add(qName);
            cls = FECAEARequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEAResponse");
            cachedSerQNames.add(qName);
            cls = FECAEAResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEASinMov");
            cachedSerQNames.add(qName);
            cls = FECAEASinMov.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEASinMovConsResponse");
            cachedSerQNames.add(qName);
            cls = FECAEASinMovConsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEASinMovResponse");
            cachedSerQNames.add(qName);
            cls = FECAEASinMovResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAECabRequest");
            cachedSerQNames.add(qName);
            cls = FECAECabRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAECabResponse");
            cachedSerQNames.add(qName);
            cls = FECAECabResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetRequest");
            cachedSerQNames.add(qName);
            cls = FECAEDetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetResponse");
            cachedSerQNames.add(qName);
            cls = FECAEDetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAERequest");
            cachedSerQNames.add(qName);
            cls = FECAERequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEResponse");
            cachedSerQNames.add(qName);
            cls = FECAEResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsResponse");
            cachedSerQNames.add(qName);
            cls = FECompConsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultaReq");
            cachedSerQNames.add(qName);
            cls = FECompConsultaReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultaResponse");
            cachedSerQNames.add(qName);
            cls = FECompConsultaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECotizacionResponse");
            cachedSerQNames.add(qName);
            cls = FECotizacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEDetRequest");
            cachedSerQNames.add(qName);
            cls = FEDetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEDetResponse");
            cachedSerQNames.add(qName);
            cls = FEDetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEPtoVentaResponse");
            cachedSerQNames.add(qName);
            cls = FEPtoVentaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FERecuperaLastCbteResponse");
            cachedSerQNames.add(qName);
            cls = UltimoComprobante.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FERegXReqResponse");
            cachedSerQNames.add(qName);
            cls = FERegXReqResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FETributoResponse");
            cachedSerQNames.add(qName);
            cls = FETributoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "IvaTipo");
            cachedSerQNames.add(qName);
            cls = IvaTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "IvaTipoResponse");
            cachedSerQNames.add(qName);
            cls = IvaTipoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Moneda");
            cachedSerQNames.add(qName);
            cls = Moneda.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "MonedaResponse");
            cachedSerQNames.add(qName);
            cls = MonedaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Obs");
            cachedSerQNames.add(qName);
            cls = Observacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Opcional");
            cachedSerQNames.add(qName);
            cls = Opcional.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "OpcionalTipo");
            cachedSerQNames.add(qName);
            cls = OpcionalTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "OpcionalTipoResponse");
            cachedSerQNames.add(qName);
            cls = OpcionalTipoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "PtoVenta");
            cachedSerQNames.add(qName);
            cls = PtoVenta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Tributo");
            cachedSerQNames.add(qName);
            cls = Tributo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "TributoTipo");
            cachedSerQNames.add(qName);
            cls = TributoTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public FECAEResponse FECAESolicitar(FEAuthRequest auth, FECAERequest feCAEReq,String urlSolicitarCAE) throws AxisFault,java.rmi.RemoteException,SocketTimeoutException {
        org.apache.axis.client.Call call = createCall();
        call.setOperation(_operations[0]);
        call.setUseSOAPAction(true);
        FECAEResponse respuesta;
       // _call.setSOAPActionURI("http://ar.gov.afip.dif.FEV1/FECAESolicitar");
        call.setSOAPActionURI("http://ar.gov.afip.dif.FEV1/FECAESolicitar");
        try {
			call.setTargetEndpointAddress(new java.net.URL(urlSolicitarCAE));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAESolicitar"));
       // _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAESolicitar"));
        
        setRequestHeaders(call);
        setAttachments(call);
       	java.lang.Object respService = call.invoke(new java.lang.Object[] {auth, feCAEReq});
       	if (respService instanceof java.rmi.RemoteException) {
       		throw (java.rmi.RemoteException)respService;
	    }
	    else {
	        extractAttachments(call);
	        try {
	            respuesta=(FECAEResponse) respService;
	        } 
	        catch (java.lang.Exception _exception) {
	            respuesta = (FECAEResponse) org.apache.axis.utils.JavaUtils.convert(respService, FECAEResponse.class);
	        }
       }
       	return respuesta;
    }

  
    public DummyResponse FEDummy() throws java.rmi.RemoteException {
    	org.apache.axis.client.Call call = createCall();
    	DummyResponse respuesta;
        call.setOperation(_operations[1]);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("http://ar.gov.afip.dif.FEV1/FEDummy");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FEDummy"));

        setRequestHeaders(call);
        setAttachments(call);
        try {   
        	java.lang.Object respuestaServicio = call.invoke(new java.lang.Object[] {});

        if (respuestaServicio instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)respuestaServicio;
        }
        else {
            extractAttachments(call);
            try {
                respuesta= (DummyResponse) respuestaServicio;
            }
            catch (java.lang.Exception _exception) {
            	respuesta= (DummyResponse) org.apache.axis.utils.JavaUtils.convert(respuestaServicio, DummyResponse.class);
            	}
        	}
        }
		catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
      return respuesta;
    }

   
    public FECompConsultaResponse FECompConsultar(FEAuthRequest auth, FECompConsultaReq feCompConsReq,String urlSolicitar) throws java.rmi.RemoteException {
        org.apache.axis.client.Call call = createCall();
        call.setOperation(_operations[3]);
        FECompConsultaResponse respuesta;
        call.setUseSOAPAction(true);
         try {
 			call.setTargetEndpointAddress(new java.net.URL(urlSolicitar));
 		} catch (MalformedURLException e) {
 			e.printStackTrace();
 		} 
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("http://ar.gov.afip.dif.FEV1/FECompConsultar");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompConsultar"));

        setRequestHeaders(call);
        setAttachments(call);
        try {
        	java.lang.Object respuestaServidor = call.invoke(new java.lang.Object[] {auth, feCompConsReq});
        if (respuestaServidor instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)respuestaServidor;
        }
        else {
            extractAttachments(call);
            try {
                respuesta=(FECompConsultaResponse) respuestaServidor;
            } catch (java.lang.Exception _exception) {
               respuesta=(FECompConsultaResponse) org.apache.axis.utils.JavaUtils.convert(respuestaServidor, FECompConsultaResponse.class);
            }
        }
		}
        catch (org.apache.axis.AxisFault axisFaultException) {
        	throw axisFaultException;
		}
        return respuesta;
    }

    @Override
	public UltimoComprobante FECompUltimoAutorizado(FEAuthRequest auth,int ptoVta, int cbteTipo,String url) throws RemoteException {
    	org.apache.axis.client.Call call = createCall();
    	UltimoComprobante respuesta;
        call.setOperation(_operations[2]);
        call.setUseSOAPAction(true);
         try {
        	 call.setTargetEndpointAddress(new java.net.URL(url));
 		} 
        catch (MalformedURLException e) {
 			e.printStackTrace();
 		} 
        call.setSOAPActionURI("http://ar.gov.afip.dif.FEV1/FECompUltimoAutorizado");
        call.setEncodingStyle(null);
        call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECompUltimoAutorizado"));

        setRequestHeaders(call);
        setAttachments(call);
        try {  
        	java.lang.Object respuestaServidor = call.invoke(new java.lang.Object[] {auth, new java.lang.Integer(ptoVta), new java.lang.Integer(cbteTipo)});
        	if (respuestaServidor instanceof java.rmi.RemoteException) {
        		throw (java.rmi.RemoteException)respuestaServidor;
        	}
        	else {
        		extractAttachments(call);
        		try {
        			respuesta = (UltimoComprobante) respuestaServidor;
        		}
        		catch (java.lang.Exception _exception) {
        			respuesta = (UltimoComprobante) org.apache.axis.utils.JavaUtils.convert(respuestaServidor, FERecuperaLastCbteResponse.class);
        		}
        	}
        } 
        catch (org.apache.axis.AxisFault axisFaultException) {
        	throw axisFaultException;
        	}
    	
    	return respuesta;
    }
}
	


