package wsHomologador;

//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.DataHandler;
import javax.activation.DataSource;
//import javax.swing.text.Document;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;

import org.apache.soap.util.mime.ByteArrayDataSource;
//import org.xml.sax.SAXException;
//import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;
//import org.w3c.dom.Element;

import pe.gob.sunat.servicio.registro.comppago.factura.gem.service.BillService;
import pe.gob.sunat.servicio.registro.comppago.factura.gem.service.BillService_Service;


public class H_main_consulta {
		
	// RUTAS Y ARCHIVOS
	public static String $PATH_ARCHIVOS_PLANOS="";
	public static String $PATH_SIN_FIRMA="";
	public static String $PATH_CON_FIRMA="";
	public static String $FILE_NAME_XML="";
	public static String $PATH_RESPUESTAS="";
	public static String $PATH_PDFS="";
	public static String $PATH_TICKETS="";
	public static String $PATH_RESPUESTAS_STATUS="";
	public static String $PATH_CERTIFICADOS="";
	public static String $PATH_HASH="";
			
	// DATOS DEL EMISOR
	public static String $RUC="";
	public static String $RAZON_SOCIAL="";
	public static String $CODIGO_POSTAL="";
	public static String $DIRECCION="";
	public static String $CIUDAD="";
	public static String $PAIS="";
			
	// DATOS DE LA LLAVE
	public static String $KEYSTORE="";
	public static String $PASSWORD_KEYSTORE="";
	public static String $PASSWORD_CERTIFICADO="";
	public static String $ALIAS_CERTIFICADO="";

	public static String $FILE_PATH_NAME_XML="";
	public static String $FILE_PATH_NAME_RESPUESTA="";
	public static String $FILE_PATH_NAME_RESPUESTA_XML="";
	public static String $FILE_PATH_NAME_ZIP="";
	public static String $FILE_NAME_ZIP="";
	public static String $FILE_PATH_NAME_HASH="";
	
	public static void conectar(String $FILE_NAME, parametros misParametros) throws Exception {
		
		
		$PATH_ARCHIVOS_PLANOS=misParametros.get_ruta_base();
		$PATH_SIN_FIRMA=misParametros.get_ruta_xml_sin_firma();
		$PATH_CON_FIRMA=misParametros.get_ruta_xml_con_firma();
		$PATH_RESPUESTAS=misParametros.get_ruta_respuestas();
		$PATH_PDFS=misParametros.get_ruta_pdfs();
		$PATH_TICKETS=misParametros.get_ruta_tickets();
		$PATH_RESPUESTAS_STATUS=misParametros.get_ruta_respuestas_status();
		$PATH_CERTIFICADOS=misParametros.get_ruta_certificados();
		$PATH_HASH=misParametros.get_ruta_hash();
		
		
		$RUC=misParametros.get_ruc();
		$RAZON_SOCIAL=misParametros.get_razon_social();
		$CODIGO_POSTAL=misParametros.get_codigo_postal();
		$DIRECCION=misParametros.get_direccion();
		$CIUDAD=misParametros.get_ciudad();
		$PAIS=misParametros.get_pais();
		
		$KEYSTORE=misParametros.get_keystore();
		$PASSWORD_KEYSTORE=misParametros.get_password_keystore();
		$PASSWORD_CERTIFICADO=misParametros.get_password_certificado();
		$ALIAS_CERTIFICADO=misParametros.get_alias_certificado();
		
		$FILE_PATH_NAME_XML = $PATH_CON_FIRMA+$FILE_NAME+".xml";
		$FILE_PATH_NAME_ZIP = $PATH_CON_FIRMA+$FILE_NAME+".zip";
		$FILE_PATH_NAME_HASH = $PATH_HASH+$FILE_NAME+".hash";
		
		$FILE_NAME_ZIP=$FILE_NAME+".zip";
		$FILE_PATH_NAME_RESPUESTA=$PATH_RESPUESTAS+"R-"+$FILE_NAME+".zip";
		$FILE_PATH_NAME_RESPUESTA_XML=$PATH_RESPUESTAS+"R-"+$FILE_NAME+".xml";
		
		BillService_Service service = new BillService_Service();
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		service.setHandlerResolver(handlerResolver);
		BillService port = service.getBillServicePort();
		
		InputStream is = new FileInputStream($FILE_PATH_NAME_ZIP);
		
		
		DataSource ds = new ByteArrayDataSource(is,"application/octet-stream");
		H_main_consulta objeto = new H_main_consulta();
		DataHandler contentFile = new DataHandler(ds);
		 
	//	 System.out.println("zip              : "+$FILE_NAME);
	//	 System.out.println("Archivo a Enviar    : "+$FILE_PATH_NAME_ZIP);
	//	 System.out.println("Archivo de Resp.    : "+$FILE_PATH_NAME_RESPUESTA);
		 
		
		try{
			byte[] resultado = port.sendBill($FILE_NAME+".zip", contentFile);
			objeto.writeSmallBinaryFile(resultado,$FILE_PATH_NAME_RESPUESTA);
			UnZip.descomprimir($FILE_PATH_NAME_RESPUESTA,$PATH_RESPUESTAS);
			ReadXMLFile.get_respuesta($FILE_PATH_NAME_RESPUESTA_XML);
			codigoHash.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_HASH);
		}catch(javax.xml.ws.soap.SOAPFaultException soapFaultException){
			
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault();
		    System.out.println("El error es: "+fault.getFaultCode());
		}
	}
	     
	void writeSmallBinaryFile(byte[] aBytes, String aFileName)  throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aBytes);
	  }
	
	//static void avisos(String aFileXML) throws IOException, ParserConfigurationException, SAXException {
	//	File fXmlFile = new File(aFileXML);
		
	//	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	//	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	//	Document doc = (Document) dBuilder.parse(fXmlFile);
		
	//	((org.w3c.dom.Document) doc).getDocumentElement().normalize();

	//	System.out.println("Root element :" + doc.getRootElements());
		
		
	//}
}