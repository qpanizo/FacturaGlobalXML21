package wsHomologador;


import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.soap.util.mime.ByteArrayDataSource;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

// alex

public class v21_envia_xmlB {

	public static String[] myParam = new String[300];

	public static String[] myArrayCab = new String[1];
	public static int _counterCab=1;

	public static String[] myArrayCab_Aca = new String[1];
	public static int _counterCab_aca=1;


	public static String[] myArrayLey = new String[100];
	public static int _counterley=1;

	public static String[] myArrayDet = new String[100];
	public static int _counterDet=1; 


	public static String[] myArrayRel = new String[100];
	public static int _counterRel=1; 
	public static int _counterLey=1; 

	public static String $PATH="";

	public static String $FILE_NAME="";

	// RUTAS Y ARCHIVOS
	public static String $PATH_ARCHIVOS_PLANOS="";
	public static String $PATH_SIN_FIRMA="";
	public static String $PATH_CON_FIRMA="";
	public static String $FILE_NAME_XML="";
	public static String $FILE_NAME_CANTIDAD_LETRAS="";
	public static String $FILE_NAME_LOGS="";
	public static String $PATH_RESPUESTAS="";
	public static String $PATH_PDFS="";
	public static String $PATH_TICKETS="";
	public static String $PATH_RESPUESTAS_STATUS="";
	public static String $PATH_CERTIFICADOS="";
	public static String $PATH_CANTIDAD_LETRAS="";
	public static String $PATH_QR="";
	public static String $PATH_417="";
	public static String $PATH_LOGS="";


	public static String $FILE_PATH_NAME_QR="";
	public static String $FILE_PATH_NAME_417="";

	// DATOS DEL EMISOR
	public static String $RUC="";
	public static String $RAZON_SOCIAL="";
	public static String $CODIGO_POSTAL="";
	public static String $DIRECCION="";
	public static String $DISTRITO="";
	public static String $DEPARTAMENTO="";
	public static String $CIUDAD="";
	public static String $UBIGEO="";
	public static String $PAIS="";
	public static String $NOMBRE_COMERCIAL="";


	// DATOS DE LA LLAVE
	public static String $KEYSTORE="";
	public static String $PASSWORD_KEYSTORE="";
	public static String $PASSWORD_CERTIFICADO="";
	public static String $ALIAS_CERTIFICADO="";


	public static double $SUM_IGV=0;


	public static String $SERIE="";
	public static String $NUMERO="";
	public static String $TIPO_DOCUMENTO="";

	// declaracion de objeto tipo cabecera
	public static cabecera myCabecera = new cabecera();
	public static aca myAca = new aca();
	public static ley[] myLey = new ley[100];
	public static detalle[] myDetalle = new detalle[100];
	public static documentos_relacionados[] mydocumentos_relacionados = new documentos_relacionados[100];
	public static String _letra_numero;

	public static String $FILE_PATH_NAME_XML="";
	public static String $FILE_PATH_NAME_HASH="";
	public static String $PATH_HASH="";
	public static String $PORCENTAJE_IGV="";

	public static String $HORA="00:00:00";
	public static String $CORREO="";
	public static String $ORDEN_DE_COMPRA="0000000000";




	//String $PATH_XMLS_SIN_FIRMA

	public static void c_XML(String $FILE_NAME, parametros misParametros, String _firma_conecta) throws Exception  {
	//	System.out.println(".x.x.x.x.x.");

		$FILE_NAME=misParametros.get_file_name();


		$PATH_ARCHIVOS_PLANOS=misParametros.get_ruta_base();
		$PATH_SIN_FIRMA=misParametros.get_ruta_xml_sin_firma();
		$PATH_CON_FIRMA=misParametros.get_ruta_xml_con_firma();
		$PATH_RESPUESTAS=misParametros.get_ruta_respuestas_status();
		$PATH_PDFS=misParametros.get_ruta_pdfs();
		$PATH_TICKETS=misParametros.get_ruta_tickets();
		$PATH_RESPUESTAS_STATUS=misParametros.get_ruta_respuestas_status();
		$PATH_CERTIFICADOS=misParametros.get_ruta_certificados();
		$PATH_CANTIDAD_LETRAS=misParametros.get_ruta_cantidad_en_letras();
		$PATH_QR=misParametros.get_ruta_qr();
		$PATH_417=misParametros.get_ruta_417();
		$PATH_LOGS=misParametros.get_ruta_logs();
		$PORCENTAJE_IGV=misParametros.get_porcentaje_igv();




		$RUC=misParametros.get_ruc();
		$RAZON_SOCIAL=misParametros.get_razon_social();
		$CODIGO_POSTAL=misParametros.get_codigo_postal();
		$DIRECCION=misParametros.get_direccion();
		$DISTRITO=misParametros.get_distrito();
		$DEPARTAMENTO=misParametros.get_departamento();
		$CIUDAD=misParametros.get_ciudad();
		$UBIGEO=misParametros.get_codigo_postal();


		$PAIS=misParametros.get_pais();
		$NOMBRE_COMERCIAL=misParametros.get_nombre_comercial();



		$KEYSTORE=misParametros.get_keystore();
		$PASSWORD_KEYSTORE=misParametros.get_password_keystore();
		$PASSWORD_CERTIFICADO=misParametros.get_password_certificado();
		$ALIAS_CERTIFICADO=misParametros.get_alias_certificado();


		$FILE_NAME_XML = $PATH_SIN_FIRMA+$FILE_NAME+".xml";
		$FILE_NAME_CANTIDAD_LETRAS = $PATH_CANTIDAD_LETRAS+$FILE_NAME+".cnt";

		$FILE_NAME_LOGS=$PATH_LOGS+$FILE_NAME+".TXT";

		System.out.println("Conector Factura Global Ver 2.0");
		System.out.println($RUC+" "+$RAZON_SOCIAL+" "+$NOMBRE_COMERCIAL);
		System.out.println("Version XML 2.1");

		//PrintStream console = System.out;

		File file_log = new File($FILE_NAME_LOGS);

		// if file doesnt exists, then create it
		if (!file_log.exists()) {
			file_log.createNewFile();
		}






		System.out.println("");

		System.out.println("");
		System.out.println($RUC+" "+$RAZON_SOCIAL+" "+$NOMBRE_COMERCIAL);

		System.out.println("DOCUMENTO: "+$FILE_NAME);
		System.out.println("");
		System.out.println("");

		$SERIE=$FILE_NAME.substring(15,19);
		$TIPO_DOCUMENTO=$FILE_NAME.substring(12,14);
		int _tam = $FILE_NAME.length(); 
		$NUMERO=$FILE_NAME.substring(20,_tam);



		String _cadena="";
		String _car="";
		int _num=0;




	





		String _win="\\";
		String _lin="/";

		myParam[0]="";


		readParam("path.fg");
		String _path=myParam[0];

		int _tam_path = myParam[0].length();

		if (_tam_path>0) {
			_path=myParam[0];
		} else {
			_path=".";
		}

		misParametros.set_ruta_path(_path);


		myParam[0]="";








			//	CreateSignature.main($KEYSTORE, $PASSWORD_KEYSTORE, $PASSWORD_CERTIFICADO, $ALIAS_CERTIFICADO, $PATH_SIN_FIRMA, $PATH_CON_FIRMA, $FILE_NAME );


			//	public static void main(String _keystore_file, 
			//		    String _keystore_password, 
			//		    String _private_key_password, 
			//		    String _private_key_alias, 
			//		    String _xml_origen, 
			//		    String _xml_destino) throws Exception {

		
		$PATH_HASH=misParametros.get_ruta_hash();

		$FILE_PATH_NAME_XML = $PATH_CON_FIRMA+$FILE_NAME+".xml";
		$FILE_PATH_NAME_HASH = $PATH_HASH+$FILE_NAME+".hash";
		$FILE_PATH_NAME_QR = $PATH_QR+$FILE_NAME+".png";
		$FILE_PATH_NAME_417 = $PATH_417+$FILE_NAME+".png";

		
			Firma_Documento.firmar($PATH_SIN_FIRMA,$PATH_CON_FIRMA,$FILE_NAME,misParametros);

			
		
			
			


			codigoQR_plus.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_QR,$FILE_NAME);
	//		codigo417.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_417,_contenido_qr);
			codigoHash.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_HASH);

			System.out.println("Conecta:"+_firma_conecta);


		
			if (_firma_conecta.substring(0,1).equals("C")) {
				System.out.println("CONEXION A SUNAT...");
				H_main.conectar($FILE_NAME,misParametros);
			}



	}







	public static void readParam(String _file_parametros) throws Exception {

		InputStream is_param = new FileInputStream(_file_parametros);
		DataSource ds_param = new ByteArrayDataSource(is_param,"application/octet-stream");
		DataHandler dhandler_param = new DataHandler(ds_param);

		Object content = dhandler_param.getContent();

		BufferedReader br = null;
		int _cont=0;

		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {

				myParam[_cont]=sCurrentLine;
				_cont++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}



}