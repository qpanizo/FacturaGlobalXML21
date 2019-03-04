package wsHomologador;


import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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

// alex 201801003 a


//String $PATH_XMLS_SIN_FIRMA





//@XmlRootElement(name = "cbc:InvoiceTypeCode")
//@XmlType(name="cbc:InvoiceTypeCode",propOrder={"listAgencyName","listName","listURI","listID","name","listSchemeURI"})

public class v21crearXMLcustom20ND_OSEefact {

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
	public static cabecera_nc myCabecera_nc = new cabecera_nc();
	public static aca myAca = new aca();
	public static ley[] myLey = new ley[100];
	public static detalle[] myDetalle = new detalle[100];
	public static documentos_relacionados21[] mydocumentos_relacionados = new documentos_relacionados21[100];
	public static String _letra_numero;

	public static String $FILE_PATH_NAME_XML="";
	public static String $FILE_PATH_NAME_HASH="";
	public static String $PATH_HASH="";
	public static String $PORCENTAJE_IGV="";

	public static String $HORA="00:00:00";
	public static String $CORREO="";
	public static String $ORDEN_DE_COMPRA="0000000000";





	public static void c_XML(DataHandler dh_det, DataHandler dh_cab, DataHandler dh_aca, DataHandler dh_ley, DataHandler dh_rel, String $FILE_NAME, parametros misParametros, String _firma_conecta) throws Exception  {


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



		// estas lineas con para escribir en el archivo log comentadas se va a consola
				FileOutputStream fos = new FileOutputStream(file_log);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);



		//	System.setOut(console);
		//	System.out.println("INICIO DE LOG PARA EL DOCUMENTO:"+$FILE_NAME);

		System.out.println("");

		System.out.println("");
		System.out.println($RUC+" "+$RAZON_SOCIAL+" "+$NOMBRE_COMERCIAL);
		System.out.println("");
		System.out.println("Version XML 2.1");
		System.out.println("");

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


		// leemos el archivo plano cabecera

		readPlainTextCab(dh_cab);

		// separa los campos
		int _tam_cabecera = myArrayCab[0].length();
		int _tam_detalle;


		for(int i=0; i<_tam_cabecera; i++) {
			_car = myArrayCab[0].substring(i,i+1);

			if (!"|".equals(_car)) {

				_cadena=_cadena+_car;
				//System.out.println(_car);


			} else {

				
				_num++;
				if (_num==1) {myCabecera_nc.set_fecha(_cadena);}
				if (_num==2) {myCabecera_nc.set_tipo_nota_cre(_cadena);}
				if (_num==3) {myCabecera_nc.set_motivo(_cadena);}
				if (_num==4) {myCabecera_nc.set_tipo_op(_cadena);}
				if (_num==5) {myCabecera_nc.set_num_doc_afec(_cadena);}
				if (_num==6) {myCabecera_nc.set_ident(_cadena);}
				if (_num==7) {myCabecera_nc.set_num_ident (_cadena);}
				if (_num==8) {myCabecera_nc.set_nombre (_cadena);}
				if (_num==9) {myCabecera_nc.set_moneda (_cadena);}
				if (_num==10) {myCabecera_nc.set_sum_cargos (Double.parseDouble(_cadena));}
				if (_num==11) {myCabecera_nc.set_tot_vta_gra (Double.parseDouble(_cadena));}
				if (_num==12) {myCabecera_nc.set_tot_vta_in (Double.parseDouble(_cadena));}
				if (_num==13) {myCabecera_nc.set_tot_vta_exo (Double.parseDouble(_cadena));}
				if (_num==14) {myCabecera_nc.set_sum_igv (Double.parseDouble(_cadena));}
				if (_num==15) {myCabecera_nc.set_sum_isc (Double.parseDouble(_cadena));}
				if (_num==16) {myCabecera_nc.set_sum_otros (Double.parseDouble(_cadena));}
				if (_num==17) {myCabecera_nc.set_importe_tot (Double.parseDouble(_cadena));}
				_cadena="";

				
				
				
				
				
				
				
				
				
				
				

	//			if (_num==1) {myCabecera.set_tipo_op(_cadena);}
	//			if (_num==2) {myCabecera.set_fecha(_cadena);}
	//			if (_num==3) {myCabecera.set_dom_fiscal(_cadena);}
	//			if (_num==4) {myCabecera.set_ident(_cadena);}
	//			if (_num==5) {myCabecera.set_num_ident (_cadena);}
	//			if (_num==6) {myCabecera.set_nombre (_cadena);}
	//			if (_num==7) {myCabecera.set_moneda (_cadena);}
	//			if (_num==8) {myCabecera.set_desc_glo (Double.parseDouble(_cadena));}
	//			if (_num==9) {myCabecera.set_sum_cargos (Double.parseDouble(_cadena));}
	//			if (_num==10) {myCabecera.set_tot_desc (Double.parseDouble(_cadena));}
	//			if (_num==11) {myCabecera.set_tot_vta_gra (Double.parseDouble(_cadena));}
	//			if (_num==12) {myCabecera.set_tot_vta_in (Double.parseDouble(_cadena));}
	//			if (_num==13) {myCabecera.set_tot_vta_exo (Double.parseDouble(_cadena));}
	//			if (_num==14) {myCabecera.set_sum_igv (Double.parseDouble(_cadena));}
	//			if (_num==15) {myCabecera.set_sum_isc (Double.parseDouble(_cadena));}
	//			if (_num==16) {myCabecera.set_sum_otros (Double.parseDouble(_cadena));}
	//			if (_num==17) {myCabecera.set_importe_tot (Double.parseDouble(_cadena));}
	//			_cadena="";

			}
		}

	//	myCabecera_nc.set_tipo_comprobante($TIPO_DOCUMENTO);



		System.out.println("Nombre del Archivos a Procesar:      "+$FILE_NAME);
		System.out.println("Cabecera-> Tipo de Operacion:        "+myCabecera_nc.get_tipo_nota_cre());
		System.out.println("Cabecera-> Fecha de Emision:         "+myCabecera_nc.get_fecha());
		System.out.println("Cabecera-> Tipo de Identificacion:   "+myCabecera_nc.get_ident());
		System.out.println("Cabecera-> Numero de Identidad:      "+myCabecera_nc.get_num_ident());
		System.out.println("Cabecera-> Nombre:                   "+myCabecera_nc.get_nombre());
		System.out.println("Cabecera-> Moneda:                   "+myCabecera_nc.get_moneda());
		System.out.println("Cabecera-> Suma de Cargos:           "+myCabecera_nc.get_sum_cargos());
		System.out.println("Cabecera-> Total Vta Gravada:        "+myCabecera_nc.get_tot_vta_gra());
		System.out.println("Cabecera-> Total Vta Inafectadas:    "+myCabecera_nc.get_tot_vta_in());
		System.out.println("Cabecera-> Total Vta Exonerada:      "+myCabecera_nc.get_tot_vta_exo());
		System.out.println("Cabecera-> Total Suma IGV:           "+myCabecera_nc.get_sum_igv());
		System.out.println("Cabecera-> Total Suma ISC:           "+myCabecera_nc.get_sum_isc());
		System.out.println("Cabecera-> Total Suma otros:         "+myCabecera_nc.get_sum_otros());
		System.out.println("Cabecera-> Importe Total:            "+myCabecera_nc.get_importe_tot());



		// leemos el arcivo plano de aca


		readPlainTextAca(dh_aca);

		// separa los campos
		int _tam_cabecera_aca = myArrayCab_Aca[0].length();
		_num=0;





		for(int i=0; i<_tam_cabecera_aca; i++) {
			_car = myArrayCab_Aca[0].substring(i,i+1);

			if (!"|".equals(_car)) {

				_cadena=_cadena+_car;
				//System.out.println(_car);


			} else {

				_num++;
				// System.out.println(_cadena);        		
				if (_num==1) {myAca.set_codRegPercepcion(_cadena);}
				if (_num==2) {myAca.set_mtoBaseImponiblePercepcion(Double.parseDouble(_cadena));}
				if (_num==3) {myAca.set_mtoPercepcion(Double.parseDouble(_cadena));}
				if (_num==4) {myAca.set_mtoTotalIncPercepcion(Double.parseDouble(_cadena));}
				if (_num==5) {myAca.set_mtoOperGratuitas(Double.parseDouble(_cadena));}
				if (_num==6) {myAca.set_mtoTotalAnticipo(Double.parseDouble(_cadena));}
				if (_num==7) {myAca.set_codPaisCliente(_cadena);}
				if (_num==8) {myAca.set_codUbigeoCliente(_cadena);}
				if (_num==9) {myAca.set_desDireccionCliente(_cadena);}
				if (_num==10) {myAca.set_codPaisEntrega(_cadena);}
				if (_num==11) {myAca.set_codUbigeoEntrega(_cadena);}


				//	if (_num==12) {myAca.set_desDireccionEntrega(_cadena);}
				if (_num==12) {myAca.set_guia(_cadena);}

				//	if (_num==13) {myAca.set_fecVencimiento(_cadena);}
				if (_num==13) {myAca.set_fecVencimiento(_cadena);}
				_cadena="";

			}
		}




		System.out.println("Aca-> Código de régimen de percepción:       "+myAca.get_codRegPercepcion());
		System.out.println("Aca-> Base imponible de percepción:          "+myAca.get_mtoBaseImponiblePercepcion());
		System.out.println("Aca-> Monto de la percepción:                "+myAca.get_mtoPercepcion());
		System.out.println("Aca-> Monto total incluido la percepción:    "+myAca.get_mtoTotalIncPercepcion());
		System.out.println("Aca-> Total valor de venta - Op. gratuitas:  "+myAca.get_mtoOperGratuitas());
		System.out.println("Aca-> Total Anticipos:                       "+myAca.get_mtoTotalAnticipo());
		System.out.println("Aca-> Dirección del cliente (Cód de país):   "+myAca.get_codPaisCliente());
		System.out.println("Aca-> Dirección del cliente (Cód de ubigeo): "+myAca.get_codUbigeoCliente());
		System.out.println("Aca-> Dir. cliente (Dir completa):           "+myAca.get_desDireccionCliente());
		//  System.out.println("Aca-> Cód de país en que se entrega el bien: "+myAca.get_codPaisEntrega());
		System.out.println("Aca-> Guia:                                  "+myAca.get_guia());
		//  System.out.println("Aca-> Cód ubigeo donde se entrega el bien:   "+myAca.get_codUbigeoEntrega());
		System.out.println("Aca-> Orden de Compre:					     "+myAca.get_OC());
		System.out.println("Aca-> Dir completa deonde se entrega el bien:"+myAca.get_desDireccionEntrega());
		System.out.println("Aca-> Fecha de vencimiento:                  "+myAca.get_fecVencimiento());








		// leemos el arcivo plano detalle
		//readPlainTextDet($PATH_ARCHIVOS_PLANOS+$FILE_NAME+".det",dh_det);
		readPlainTextDet(dh_det);

		_counterDet=_counterDet-1;

		for(int i=1; i<_counterDet; i++){
			myDetalle[i] = new detalle();
			_cadena="";
			_num=0;


			_tam_detalle = myArrayDet[i].length();
			for(int x=0; x<_tam_detalle; x++) {
				_car = myArrayDet[i].substring(x,x+1);

				if (!"|".equals(_car)) {
					_cadena=_cadena+_car;
				} else {
					_num++;

					if (_num==1) {myDetalle[i].set_unidad_med(_cadena);}
					if (_num==2) {myDetalle[i].set_cantidad(Double.parseDouble(_cadena));}
					if (_num==3) {myDetalle[i].set_producto(_cadena);}
					if (_num==4) {myDetalle[i].set_cod_sunat(_cadena);}
					if (_num==5) {myDetalle[i].set_descrip(_cadena);}
					if (_num==6) {myDetalle[i].set_valor_unit(Double.parseDouble(_cadena));}
					if (_num==7) {
				//		myCabecera.set_desc_detalle(myCabecera.get_desc_detalle()+myDetalle[i].get_desc_unit());
						myDetalle[i].set_desc_unit(Double.parseDouble(_cadena));
					}
					if (_num==8) {myDetalle[i].set_igv_unit(Double.parseDouble(_cadena));}
					if (_num==9) {myDetalle[i].set_afec_igv(_cadena);}
					if (_num==10) {myDetalle[i].set_isc_unit(Double.parseDouble(_cadena));}
					if (_num==11) {myDetalle[i].set_tipo_isc(_cadena);}
					if (_num==12) {myDetalle[i].set_precio_unit(Double.parseDouble(_cadena));}
					if (_num==13) {myDetalle[i].set_valor_tot(Double.parseDouble(_cadena));}
					if (_num==14) {myDetalle[i].set_extra(Double.parseDouble(_cadena));}
					_cadena="";
				}
			}



			System.out.println(" ");
			System.out.println("Detalle-> Unidad de Medida:             "+myDetalle[i].get_unidad_med());
			System.out.println("Detalle-> Cantidad:                     "+myDetalle[i].get_cantidad());
			System.out.println("Detalle-> Producto:                     "+myDetalle[i].get_producto());
			System.out.println("Detalle-> Codigo Sunat:                 "+myDetalle[i].get_cod_sunat());
			System.out.println("Detalle-> Codigo Descripcion:           "+myDetalle[i].get_descrip());
			System.out.println("Detalle-> Valor Unidad:                 "+myDetalle[i].get_valor_unit());
			System.out.println("Detalle-> Descuento de Unidad:          "+myDetalle[i].get_desc_unit());
		//	System.out.println("Detalle-> Descuento Acumulado:          "+myCabecera.get_desc_detalle());
			System.out.println("Detalle-> Monto de IGV por Unidad:      "+myDetalle[i].get_igv_unit());
			System.out.println("Detalle-> Tipo de Afectacion IGV:       "+myDetalle[i].get_afec_igv());
			System.out.println("Detalle-> Monto de ISC por Unidad:      "+myDetalle[i].get_isc_unit());
			System.out.println("Detalle-> Tipo de Afectacion ISC:       "+myDetalle[i].get_tipo_isc());
			System.out.println("Detalle-> Precio por Unidad:            "+myDetalle[i].get_precio_unit());
			System.out.println("Detalle-> Valor Total:                  "+myDetalle[i].get_valor_tot());

			//	        System.out.println("Nombre del Archivo                      "+$FILE_NAME);


	//		myCabecera.set_desc_detalle(myCabecera.get_desc_detalle()+myDetalle[i].get_desc_unit());


			// $SUM_IGV=$SUM_IGV+myDetalle[i].get_igv_unit();












			// leemos el arcivo plano relacionados

			readPlainTextRel(dh_rel);

			_counterRel=_counterRel-1;

			for(int r=1; r<_counterRel; r++){
				mydocumentos_relacionados[r] = new documentos_relacionados21();
				_cadena="";
				_num=0;


				_tam_detalle = myArrayRel[r].length();
				for(int x=0; x<_tam_detalle; x++) {
					_car = myArrayRel[r].substring(x,x+1);

					if (!"|".equals(_car)) {
						_cadena=_cadena+_car;
					} else {
						_num++;
					//	public String _indDocRelacionado;   // Indicador de documento relacionado (1: Guía, 2: Anticipo, 3: Orden de compra, 98: Documentos afectados (múltiples) por una Nota de Crédito / Débido,  99: Otros)
					//	public String _numIdeAnticipo;       // 	 Número identificador del anticipo (solo para el Caso: 2 Anticipo). PREDETERMINADO "-"
					//	public String _tipDocRelacionado;   //  Tipo de documento relacionado  Si es documento relacionado es: Guía / Documento Afectado: Catálogo N° 1/
					//	public String _numDocRelacionado;   // Número de documento relacionado aqui va el valor que varia o el dato que queremos mostrar en el xml
					//	public String _tipDocEmisor;         //  Tipo de documento del emisor del documento relacionado  ( 1 6 )
					//7	public String _numDocEmisor;		// Número de documento del emisor del documento relacionado
					//	public String _mtoDocRelacionado;    // Monto
							

						if (_num==1) {mydocumentos_relacionados[r].set_indDocRelacionado(_cadena);}
						if (_num==2) {mydocumentos_relacionados[r].set_numIdeAnticipo(_cadena);}
						if (_num==3) {mydocumentos_relacionados[r].set_tipDocRelacionado(_cadena);}
						if (_num==4) {mydocumentos_relacionados[r].set_numDocRelacionado(_cadena);}
						if (_num==5) {mydocumentos_relacionados[r].set_tipDocEmisor(_cadena);}
						if (_num==6) {mydocumentos_relacionados[r].set_numDocEmisor(_cadena);}		           		
						if (_num==7) {mydocumentos_relacionados[r].set_mtoDocRelacionado(_cadena);}

					//	System.out.println(_cadena+" "+_num);
						

						_cadena="";
					}
				}

				//         System.out.println("Documento Relacionado-> Ind:"+mydocumentos_relacionados[r].get_indDocRelacionado());
				//         System.out.println("Documento Relacionado-> Tipo:"+mydocumentos_relacionados[r].get_tipDocRelacionado());
				//         System.out.println("Documento Relacionado-> Num:"+mydocumentos_relacionados[r].get_numDocRelacionado()); 


			}


			// leemos el arcivo plano  ley

			readPlainTextLey(dh_ley);

			_counterLey=_counterLey-1;

			for(int l=1; l<_counterLey; l++){
				myLey[l] = new ley();
				_cadena="";
				_num=0;


				_tam_detalle = myArrayLey[l].length();
				for(int x=0; x<_tam_detalle; x++) {
					_car = myArrayLey[l].substring(x,x+1);

					if (!"|".equals(_car)) {
						_cadena=_cadena+_car;
					} else {
						_num++;

						if (_num==1) {myLey[l].set_codLeyenda(_cadena);}
						if (_num==2) {myLey[l].set_desLeyenda(_cadena);}





						_cadena="";
					}
				}

				System.out.println("Codigo de Leyenda->:"+myLey[l].get_codLeyenda());
				System.out.println("Descripcion Leyenda->:"+myLey[l].get_desLeyenda());


				if (myLey[l].get_codLeyenda().equals("1012")) {
					$CORREO=myLey[l].get_desLeyenda();

				}



				if (myLey[l].get_codLeyenda().equals("1013")) {
					$HORA=myLey[l].get_desLeyenda();

				}



				if (myLey[l].get_codLeyenda().equals("1015")) {
					$ORDEN_DE_COMPRA=myLey[l].get_desLeyenda();

				}



			}




			$PATH_HASH=misParametros.get_ruta_hash();

			$FILE_PATH_NAME_XML = $PATH_CON_FIRMA+$FILE_NAME+".xml";
			$FILE_PATH_NAME_HASH = $PATH_HASH+$FILE_NAME+".hash";
			$FILE_PATH_NAME_QR = $PATH_QR+$FILE_NAME+".png";
			$FILE_PATH_NAME_417 = $PATH_417+$FILE_NAME+".png";

		}


		$SUM_IGV=myCabecera_nc.get_sum_igv();

		writeXML($FILE_NAME_XML);

		// aqui quitar las etiquetas de los atributos
		//		String _xml_temp = readFile($FILE_NAME_XML);
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("","");
		//		_xml_temp=_xml_temp.replace("__07__","");
		//		_xml_temp=_xml_temp.replace("__08__","");
		//		_xml_temp=_xml_temp.replace("__09__","");
		//		_xml_temp=_xml_temp.replace("__10__","");
		//		_xml_temp=_xml_temp.replace("__11__","");
		//		_xml_temp=_xml_temp.replace("__12__","");
		//		_xml_temp=_xml_temp.replace("__13__","");

		//		  File archivo_hash=new File($FILE_NAME_XML);
		//		  archivo_hash.delete();
		//		  FileWriter chanel_write=new FileWriter($FILE_NAME_XML,true);
		//		  chanel_write.write(_xml_temp);
		//		  chanel_write.close();

		String _llave=verificaLlave.revisar(myCabecera_nc.get_fecha(),$RUC);

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




		//   String _llave_encontrada="La Llave no fue Encontrada...!!!";
		boolean permiso=false;

		for (int _x=0;_x<300;_x++)  {
			myParam[_x]="";
		}


		String _ruta_param=_path+_win+"data"+_win+$RUC+_win+"certificados"+_lin+$RUC+"-llaves.txt";
		readParam(_ruta_param);


		for (int _x=0;_x<300;_x++)  {



			if (myParam[_x].equals(_llave))  {
				//_llave_encontrada=myParam[_x];

				permiso=true;

				break;



			}
		}

		if (permiso) {
			System.out.println("La Llave SI fue Encontrada...!!! :");
		} else {

			System.out.println("La Llave NO fue Encontrada...!!! :");

			System.out.println("Comuniquese con Factura Global SAC    www.factura.global");
			email.main("alejandro.gandara33@gmail.com", $FILE_PATH_NAME_XML);
			TimeUnit.SECONDS.sleep(10);
		}


		if (permiso) {
		//	Firma_Documento.firmar($PATH_SIN_FIRMA,$PATH_CON_FIRMA,$FILE_NAME,misParametros);




		//	String _contenido_qr = $RUC+"|"+$TIPO_DOCUMENTO+"|"+$SERIE+"|"+$NUMERO+"|"+$SUM_IGV+"|"+
		//		myCabecera_nc.get_importe_tot()+"|"+myCabecera_nc.get_fecha()+"|"+
		//			myCabecera_nc.get_ident()+"|"+myCabecera_nc.get_num_ident();



		//	codigoQR.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_QR,_contenido_qr);
		//	codigo417.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_417,_contenido_qr);
		//	codigoHash.get($FILE_PATH_NAME_XML,$FILE_PATH_NAME_HASH);


			if (_firma_conecta.equals("C")) {
		//		System.out.println("CONEXION A SUNAT...");
		//		H_main.conectar($FILE_NAME,misParametros);
			}

		}


	}







	public static void separaCab() {
		// Str1.length()

	}


	public static void readPlainTextCab(DataHandler dh) throws Exception {
		Object content = dh.getContent();

		BufferedReader br = null;

		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {
				myArrayCab[0]=sCurrentLine;

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


	public static void readPlainTextAca(DataHandler dh) throws Exception {
		Object content = dh.getContent();

		BufferedReader br = null;

		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {
				myArrayCab_Aca[0]=sCurrentLine;

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



	public static void readPlainTextDet(DataHandler dh) throws Exception {
		Object content = dh.getContent();

		BufferedReader br = null;


		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {


				myArrayDet[_counterDet]=sCurrentLine;
				_counterDet=_counterDet+1;

			}
			_counterDet=_counterDet+1;

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


	public static void readPlainTextRel(DataHandler dh) throws Exception {
		Object content = dh.getContent();

		BufferedReader br = null;

		_counterRel=1;


		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {


				myArrayRel[_counterRel]=sCurrentLine;
				_counterRel=_counterRel+1;

			}
			_counterRel=_counterRel+1;


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



	public static void readPlainTextLey(DataHandler dh) throws Exception {
		Object content = dh.getContent();

		BufferedReader br = null;

		_counterLey=1;


		try {

			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader((InputStream) content));

			while ((sCurrentLine = br.readLine()) != null) {


				myArrayLey[_counterLey]=sCurrentLine;
				_counterLey=_counterLey+1;

			}
			_counterLey=_counterLey+1;


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



	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static void writeXML(String $FILE_NAME) throws Exception {

		DocumentBuilderFactory documentBuilderFctory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFctory.newDocumentBuilder();

		Document document = documentBuilder.newDocument();





		//	StringWriter sw = new StringWriter();
		//	StreamResult result = new StreamResult(sw);
		//	doc.setXmlStandalone(true);
		//	DOMSource source = new DOMSource(doc);
		//	trans.transform(source, result);
		//	String xmlString = sw.toString();



		// agregamos la nombre pricipal dentro de este iran todos los elementos
		Element element = document.createElement("DebitNote");
		document.appendChild(element);


		// xmlns="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2"
		Attr attr_xmlns = document.createAttribute("xmlns");
		attr_xmlns.setValue("urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2");
		element.setAttributeNode(attr_xmlns);

		// xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2"
		Attr attr_xmlns_cac = document.createAttribute("xmlns:cac");
		attr_xmlns_cac.setValue("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
		element.setAttributeNode(attr_xmlns_cac);


		// xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2"
		Attr attr_xmlns_cbc = document.createAttribute("xmlns:cbc");
		attr_xmlns_cbc.setValue("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
		element.setAttributeNode(attr_xmlns_cbc);


		//xmlns:ccts="urn:un:unece:uncefact:documentation:2"
		Attr attr_xmlns_ccts = document.createAttribute("xmlns:ccts");
		attr_xmlns_ccts.setValue("urn:un:unece:uncefact:documentation:2");
		element.setAttributeNode(attr_xmlns_ccts);


		//xmlns:ds="http://www.w3.org/2000/09/xmldsig#"
		Attr attr_xmlns_ds = document.createAttribute("xmlns:ds");
		attr_xmlns_ds.setValue("http://www.w3.org/2000/09/xmldsig#");
		element.setAttributeNode(attr_xmlns_ds);

		// xmlns:ext="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2"
		Attr attr_xmlns_ext = document.createAttribute("xmlns:ext");
		attr_xmlns_ext.setValue("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
		element.setAttributeNode(attr_xmlns_ext);



		// xmlns:qdt="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2"
		Attr attr_xmlns_qdt = document.createAttribute("xmlns:qdt");
		attr_xmlns_qdt.setValue("urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
		element.setAttributeNode(attr_xmlns_qdt);

		// xmlns:sac="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1"
		//		Attr attr_xmlns_sac = document.createAttribute("xmlns:sac");
		//		attr_xmlns_sac.setValue("urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
		//		element.setAttributeNode(attr_xmlns_sac);





		// xmlns:stat="urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0"	
		//		Attr attr_xmlns_stat = document.createAttribute("xmlns:stat");
		//		attr_xmlns_stat.setValue("urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0");
		//		element.setAttributeNode(attr_xmlns_stat);

		// xmlns:udt="urn:un:unece:uncefact:data:draft:UnqualifiedDataTypesSchemaModule:2"
		Attr attr_xmlns_udt = document.createAttribute("xmlns:udt");
		attr_xmlns_udt.setValue("urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2");
		element.setAttributeNode(attr_xmlns_udt);


		// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		Attr attr_xmlns_xsi = document.createAttribute("xmlns:xsi");
		attr_xmlns_xsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
		element.setAttributeNode(attr_xmlns_xsi);


		// definicion de variables 


		System.out.println("");
		System.out.println("RESUMEN DE DOCUMENTO");
		System.out.println("");

		double _base_gravable=myCabecera_nc.get_tot_vta_gra();
		double _base_exonerada=myCabecera_nc.get_tot_vta_exo();
		double _base_inafecta=myCabecera_nc.get_tot_vta_in();


		double _base=_base_gravable+
				_base_exonerada+
				_base_inafecta;

		System.out.println("Base Gravable___________"+Formato.neto(_base_gravable));
		System.out.println("Base Exoneradas_________"+Formato.neto(_base_exonerada));				
		System.out.println("Base Inafecta___________"+Formato.neto(_base_inafecta));
		System.out.println("BASE TOTAL______________"+Formato.neto(_base));
		System.out.println("");
		double _igv=myCabecera_nc.get_sum_igv();
		double _isc=myCabecera_nc.get_sum_isc();
		double _impuestos=_igv+_isc;



		System.out.println("IGV_____________________"+Formato.neto(_igv));				
		System.out.println("ISC_____________________"+Formato.neto(_isc));

		System.out.println("TOTAL IMPUESTOS_________"+Formato.neto(_impuestos));
		System.out.println("Porcentaje de IGV_______        "+$PORCENTAJE_IGV+"%");

		System.out.println("");




		System.out.println("");
		System.out.println("");

		double _neto=_base
				+_impuestos;

		System.out.println("NETO____________________"+Formato.dinero(_neto));

		System.out.println("");
		System.out.println("Lineas en Detalle_______"+Formato.neto(_counterDet));

		System.out.println("");








		/////////////////////////////////////////////////////////////////////////////


		/// NODO NUMERO 2  FIRMA DIGITAL  -- /Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/ds:Signature /Invoice/cac:Signature 


		/// NODO UBLExtensions

		Element UBLExtensions = document.createElement("ext:UBLExtensions");
		element.appendChild(UBLExtensions);

	


		// UBLVersionID
		Element UBLVersionID = document.createElement("cbc:UBLVersionID");
		UBLVersionID.appendChild(document.createTextNode("2.1"));
		element.appendChild(UBLVersionID);


		// cbc:CustomizationID
		Element CustomizationID = document.createElement("cbc:CustomizationID");
		CustomizationID.appendChild(document.createTextNode("2.0"));
		element.appendChild(CustomizationID);

		
/*		
		String _tipo_operacion=myCabecera_nc.get_tipo_op();
		String _profile = "0101";

		// venta interna
		if (_tipo_operacion.equals("01")) {
			_profile="0101";
		}

		// exportacion
		if (_tipo_operacion.equals("02")) {
			_profile="0102";
		}

		// no domicialiado
		if (_tipo_foperacion.equals("03")) {
			_profile="0103";
		}


		// anticipos
		if (_tipo_operacion.equals("04")) {
			_profile="0102";
		}


		
		
		// cbc:ProfileID
		Element ProfileID = document.createElement("cbc:ProfileID");
		ProfileID.appendChild(document.createTextNode(_profile));
		element.appendChild(ProfileID);

	*/


		/// NODO NUMERO 8  SERIE + NUMERO CORRELATIVO -- (Factura)    /Invoice/cbc:InvoiceTypeCode  

		// cbc:ID			
		Element SERIE = document.createElement("cbc:ID");
		SERIE.appendChild(document.createTextNode($SERIE+"-"+$NUMERO));
		element.appendChild(SERIE);

		///////////////////////////////////////////////// FIN NUMERO 7 -- TIPO DE DOCUMENTO





		/// NODO NUMERO 1  FECHA DE EMISION DEL DOCUMENTO -- fecEmision --- /Invoice/cbc:IssueDate 

		Element fecEmision = document.createElement("cbc:IssueDate");
		fecEmision.appendChild(document.createTextNode(myCabecera_nc.get_fecha()));
		element.appendChild(fecEmision);

		///////////////////////////////////////////////// FIN NUMERO 1 -- fecEmision	



		/// NODO NUMERO 1  FECHA DE EMISION DEL DOCUMENTO -- fecEmision --- /Invoice/cbc:IssueDate 

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simple_hora = new SimpleDateFormat("HH:mm:ss");
		String _hora = simple_hora.format(cal.getTime());


		Element hora = document.createElement("cbc:IssueTime");
		hora.appendChild(document.createTextNode($HORA));
		element.appendChild(hora);

		///////////////////////////////////////////////// FIN NUMERO 1 -- fecEmision	


		
		//////////////////////////////////////////////////////////
		///  aqui ira el tipo de documento


		

/*
		Element InvoiceTypeCode = document.createElement("cbc:InvoiceTypeCode");
		
		InvoiceTypeCode.appendChild(document.createTextNode($TIPO_DOCUMENTO));
		
		element.appendChild(InvoiceTypeCode);
		InvoiceTypeCode.setAttribute("listAgencyName", "PE:SUNAT");
		InvoiceTypeCode.setAttribute("listName", "Tipo de Documento");
		InvoiceTypeCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01");
		InvoiceTypeCode.setAttribute("listID", "0101");
		InvoiceTypeCode.setAttribute("name", "Tipo de Operacion");
		InvoiceTypeCode.setAttribute("listSchemeURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo51");

*/
		
		///***** agregando los docuentos relacionados













		System.out.println("Importe total:  "+myCabecera_nc.get_importe_tot());
		_letra_numero=denomina.main(myCabecera_nc.get_importe_tot(),"");

		if (myCabecera_nc.get_moneda().equals("PEN")) {
			_letra_numero=denomina.main(myCabecera_nc.get_importe_tot(),"MN");
		}

		if (myCabecera_nc.get_moneda().equals("USD")) {
			_letra_numero=denomina.main(+myCabecera_nc.get_importe_tot(),"DOLARES AMERICANOS");
		}

		//		_letra_numero=_letra_numero;

		// NUMERO EN LETRA   (con caracteres especiales)

		Element Note0 = document.createElement("cbc:Note");
		Node cdata_Note0 = document.createCDATASection(_letra_numero);
		Note0.appendChild(cdata_Note0);
		element.appendChild(Note0);

		Attr attr_Note0 = document.createAttribute("languageLocaleID");	
		attr_Note0.setValue("1000");
		Note0.setAttributeNode(attr_Note0);

		
		
		






		int _lineas=_counterDet-1;




		Element DocumentCurrencyCode = document.createElement("cbc:DocumentCurrencyCode");
		DocumentCurrencyCode.appendChild(document.createTextNode(myCabecera_nc.get_moneda()));
		element.appendChild(DocumentCurrencyCode);


		
		DocumentCurrencyCode.setAttribute("listAgencyName", "United Nations Economic Commission for Europe");
		DocumentCurrencyCode.setAttribute("listID", "ISO 4217 Alpha");
		DocumentCurrencyCode.setAttribute("listName", "Currency");


		// cbc:LineCountNumeric
		Element LineCountNumeric = document.createElement("cbc:LineCountNumeric");
		LineCountNumeric.appendChild(document.createTextNode(""+_lineas));
		element.appendChild(LineCountNumeric);


		//cac:DiscrepancyResponse
		Element DiscrepancyResponse = document.createElement("cac:DiscrepancyResponse");
		//DiscrepancyResponse.appendChild(document.createTextNode(myCabecera_nc.get_moneda()));
		element.appendChild(DiscrepancyResponse);

		// cbc:ReferenceID
		Element ReferenceID = document.createElement("cbc:ReferenceID");
		DiscrepancyResponse.appendChild(ReferenceID);
		ReferenceID.setTextContent(myCabecera_nc.get_num_doc_afec());


		// cbc:ResponseCode
		Element ResponseCode = document.createElement("cbc:ResponseCode");
		DiscrepancyResponse.appendChild(ResponseCode);
		ResponseCode.setTextContent(myCabecera_nc.get_tipo_nota_cre());
		ResponseCode.setAttribute("listAgencyName", "PE:SUNAT");
		ResponseCode.setAttribute("listName", "Tipo de nota de credito");
		ResponseCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo09");


		// cbc:Description
		Element Description = document.createElement("cbc:Description");
		DiscrepancyResponse.appendChild(Description);
		Description.setTextContent(myCabecera_nc.get_motivo());



		

		//cac:BillingReference
		Element BillingReference = document.createElement("cac:BillingReference");
		element.appendChild(BillingReference);

		//cac:InvoiceDocumentReference
		Element InvoiceDocumentReference = document.createElement("cac:InvoiceDocumentReference");
		BillingReference.appendChild(InvoiceDocumentReference);

		// cbc:ID
		Element ID_DocumentReference = document.createElement("cbc:ID");
		InvoiceDocumentReference.appendChild(ID_DocumentReference);
		ID_DocumentReference.setTextContent(myCabecera_nc.get_num_doc_afec());

		ID_DocumentReference.setAttribute("cbc:IssueDate", myCabecera_nc.get_fecha());
		
		//cbc:DocumentTypeCode
		Element DocumentTypeCode = document.createElement("cbc:DocumentTypeCode");
		InvoiceDocumentReference.appendChild(DocumentTypeCode);
		DocumentTypeCode.setTextContent(myCabecera_nc.get_tipo_op());

		DocumentTypeCode.setAttribute("listAgencyName","PE:SUNAT");
		DocumentTypeCode.setAttribute("listName", "Tipo de Documento");
		DocumentTypeCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01");
	
	




		
		
	/*	
		
		for (int linea=1; linea<_counterRel; linea++) {	


			if (mydocumentos_relacionados[linea].get_indDocRelacionado().equals("99")) {
				// cac:DespatchDocumentReference
				////////////////////////////////////////////////////////////////////
				// /Invoice/cac:AdditionalDocumentReference/cbc:ID	
				Element Despatch = document.createElement("cac:AdditionalDocumentReference");
				element.appendChild(Despatch);

				// cbc:ID
				Element _ID_Despatch = document.createElement("cbc:ID");
				//		_ID_Despatch.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_numDocEmisor()));
				System.out.println(mydocumentos_relacionados[linea].get_numDocEmisor());

					
				_ID_Despatch.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_numDocRelacionado()));					
				Despatch.appendChild(_ID_Despatch);


				Element DocumentTypeCode = document.createElement("cbc:DocumentTypeCode");
				DocumentTypeCode.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_tipDocRelacionado()));
				Despatch.appendChild(DocumentTypeCode);

				
			}

		}

*/


		// cac:Signature
		Element Signature = document.createElement("cac:Signature");
		element.appendChild(Signature);

		// id
		Element Signature_ID = document.createElement("cbc:ID");
		Signature_ID.appendChild(document.createTextNode("IDSignKG"));
		Signature.appendChild(Signature_ID);

		// cac:SignatoryParty

		Element SignatoryParty = document.createElement("cac:SignatoryParty");
		Signature.appendChild(SignatoryParty);

		// cac:PartyIdentification
		Element PartyIdentification = document.createElement("cac:PartyIdentification");
		SignatoryParty.appendChild(PartyIdentification);

		// id
		Element PartyIdentification_ID = document.createElement("cbc:ID");
		PartyIdentification_ID.appendChild(document.createTextNode("#SignST"));
		PartyIdentification.appendChild(PartyIdentification_ID);
		
		
		
		
		

		// cac:PartyName
		Element PartyName_SIG = document.createElement("cac:PartyName");
		SignatoryParty.appendChild(PartyName_SIG);


		// cbc:Name
		Element Name_ignature = document.createElement("cbc:Name");
		Node cdata_Name_ignature = document.createCDATASection($RAZON_SOCIAL);
		Name_ignature.appendChild(cdata_Name_ignature);
		PartyName_SIG.appendChild(Name_ignature);




		// cac:DigitalSignatureAttachment
		Element DigitalSignatureAttachment = document.createElement("cac:DigitalSignatureAttachment");
		Signature.appendChild(DigitalSignatureAttachment);

		// cac:ExternalReference
		Element ExternalReference = document.createElement("cac:ExternalReference");
		DigitalSignatureAttachment.appendChild(ExternalReference);


		// cbc:URI
		Element URI = document.createElement("cbc:URI");
		URI.appendChild(document.createTextNode($RUC));
		ExternalReference.appendChild(URI);





		// cac:AccountingSupplierParty EN RAIZ 
		Element AccountingSupplierParty = document.createElement("cac:AccountingSupplierParty");
		element.appendChild(AccountingSupplierParty);



		// cac:Party
		Element Party_EMISOR = document.createElement("cac:Party");
		AccountingSupplierParty.appendChild(Party_EMISOR);


		// cac:PartyIdentification

		Element PartyIdentification_EMISOR = document.createElement("cac:PartyIdentification");
		Party_EMISOR.appendChild(PartyIdentification_EMISOR);


		// id
		Element PartyIdentification_ID_EMISOR = document.createElement("cbc:ID");
		PartyIdentification_ID_EMISOR.appendChild(document.createTextNode($RUC));
		PartyIdentification_EMISOR.appendChild(PartyIdentification_ID_EMISOR);

		PartyIdentification_ID_EMISOR.setAttribute("schemeID", "6");
		PartyIdentification_ID_EMISOR.setAttribute("schemeName", "Documento de Identidad");
		PartyIdentification_ID_EMISOR.setAttribute("schemeAgencyName", "PE:SUNAT");
		PartyIdentification_ID_EMISOR.setAttribute("schemeURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06");





		// cac:PartyName
		Element PartyName_EMISOR = document.createElement("cac:PartyName");
		Party_EMISOR.appendChild(PartyName_EMISOR);

		// cbc:Name  (con caracteres especiales)
		Element Name_EMISOR = document.createElement("cbc:Name");
		Node cdata = document.createCDATASection($NOMBRE_COMERCIAL);
		Name_EMISOR.appendChild(cdata);
		PartyName_EMISOR.appendChild(Name_EMISOR);


		// cac:PartyLegalEntity
		Element PartyLegalEntity_EMISOR = document.createElement("cac:PartyLegalEntity");
		Party_EMISOR.appendChild(PartyLegalEntity_EMISOR);


		// cbc:RegistrationName
		Element RegistrationName_EMISOR = document.createElement("cbc:RegistrationName");
		Node cdataRegistrationName_EMISOR = document.createCDATASection($RAZON_SOCIAL);
		RegistrationName_EMISOR.appendChild(cdataRegistrationName_EMISOR);
		PartyLegalEntity_EMISOR.appendChild(RegistrationName_EMISOR);







		// cac:RegistrationAddress
		Element RegistrationAddress_EMISOR = document.createElement("cac:RegistrationAddress");
		PartyLegalEntity_EMISOR.appendChild(RegistrationAddress_EMISOR);

		// id ubigeo
		Element RegistrationAddress_ID = document.createElement("cbc:ID");
		RegistrationAddress_ID.appendChild(document.createTextNode($UBIGEO));
		RegistrationAddress_EMISOR.appendChild(RegistrationAddress_ID);

		//   <cbc:ID schemeAgencyName="PE:INEI" schemeName="Ubigeos">150131</cbc:ID> 

		RegistrationAddress_ID.setAttribute("schemeAgencyName", "PE:INEI");
		RegistrationAddress_ID.setAttribute("schemeName", " Ubigeos");

		
		// cbc:AddressTypeCode
		Element AddressTypeCode_EMISOR = document.createElement("cbc:AddressTypeCode");
		AddressTypeCode_EMISOR.appendChild(document.createTextNode("0000"));
		RegistrationAddress_EMISOR.appendChild(AddressTypeCode_EMISOR);


		AddressTypeCode_EMISOR.setAttribute("listAgencyName", "PE:SUNAT");
		AddressTypeCode_EMISOR.setAttribute("listName", "Establecimientos anexos");



		// <cbc:CitySubdivisionName>
		Element CitySubdivisionName_EMISOR = document.createElement("cbc:CitySubdivisionName");
		Node cdataCitySubdivisionName_EMISOR = document.createCDATASection($CIUDAD);
		CitySubdivisionName_EMISOR.appendChild(cdataCitySubdivisionName_EMISOR);
		RegistrationAddress_EMISOR.appendChild(CitySubdivisionName_EMISOR);





		// <cbc:CityName><![CDATA[PIURA]]></cbc:CityName>
		Element CityName_EMISOR = document.createElement("cbc:CityName");
		Node cdataCityName_EMISOR = document.createCDATASection($CIUDAD);
		CityName_EMISOR.appendChild(cdataCityName_EMISOR);
		RegistrationAddress_EMISOR.appendChild(CityName_EMISOR);





		// <cbc:CountrySubentity><![CDATA[PIURA]]></cbc:CountrySubentity>
		Element CountrySubentity_EMISOR = document.createElement("cbc:CountrySubentity");
		Node cdata_CountrySubentity_EMISOR = document.createCDATASection($DEPARTAMENTO);
		CountrySubentity_EMISOR.appendChild(cdata_CountrySubentity_EMISOR);
		RegistrationAddress_EMISOR.appendChild(CountrySubentity_EMISOR);



		// <cbc:CountrySubentityCode><![CDATA[200101]]></cbc:CountrySubentityCode>
		Element CountrySubentityCode_EMISOR = document.createElement("cbc:CountrySubentityCode");
		Node cdata_CountrySubentityCode_EMISOR = document.createCDATASection($UBIGEO);
		CountrySubentityCode_EMISOR.appendChild(cdata_CountrySubentityCode_EMISOR);
		RegistrationAddress_EMISOR.appendChild(CountrySubentityCode_EMISOR);


		// <cbc:District><![CDATA[PIURA]]></cbc:District>
		Element District_EMISOR = document.createElement("cbc:District");
		Node cdata_District_EMISOR = document.createCDATASection($DISTRITO);
		District_EMISOR.appendChild(cdata_District_EMISOR);
		RegistrationAddress_EMISOR.appendChild(District_EMISOR);

		// cac:AddressLine
		Element AddressLine_EMISOR = document.createElement("cac:AddressLine");
		RegistrationAddress_EMISOR.appendChild(AddressLine_EMISOR);				

		//cbc:Line
		Element Line_EMISOR = document.createElement("cbc:Line");
		Node cdata_Line_EMISOR = document.createCDATASection($DIRECCION);
		Line_EMISOR.appendChild(cdata_Line_EMISOR);
		AddressLine_EMISOR.appendChild(Line_EMISOR);


		// cac:Country
		Element Country_EMISOR = document.createElement("cac:Country");
		RegistrationAddress_EMISOR.appendChild(Country_EMISOR);				


		//cbc:IdentificationCode
		Element IdentificationCode_EMISOR = document.createElement("cbc:IdentificationCode");
		IdentificationCode_EMISOR.appendChild(document.createTextNode($PAIS));
		Country_EMISOR.appendChild(IdentificationCode_EMISOR);
		IdentificationCode_EMISOR.setAttribute("listAgencyName", "United Nations Economic Commission for Europe");
		IdentificationCode_EMISOR.setAttribute("listID", "ISO 3166-1");
		IdentificationCode_EMISOR.setAttribute("listName", "Country");
	




		////////////////  datos del emisor



		// cac:AccountingSupplierParty EN RAIZ 
		Element AccountingCustomerParty = document.createElement("cac:AccountingCustomerParty");
		element.appendChild(AccountingCustomerParty);



		// cac:Party
		Element Party_RECEPTOR = document.createElement("cac:Party");
		AccountingCustomerParty.appendChild(Party_RECEPTOR);


		// cac:PartyIdentification

		Element PartyIdentification_RECEPTOR = document.createElement("cac:PartyIdentification");
		Party_RECEPTOR.appendChild(PartyIdentification_RECEPTOR);


		// id
		Element PartyIdentification_ID_RECEPTOR = document.createElement("cbc:ID");
		PartyIdentification_ID_RECEPTOR.appendChild(document.createTextNode(myCabecera_nc.get_num_ident()));
		PartyIdentification_RECEPTOR.appendChild(PartyIdentification_ID_RECEPTOR);

		PartyIdentification_ID_RECEPTOR.setAttribute("schemeID", myCabecera_nc.get_ident());
		PartyIdentification_ID_RECEPTOR.setAttribute("schemeName", "Documento de Identidad");
		PartyIdentification_ID_RECEPTOR.setAttribute("schemeAgencyName", "PE:SUNAT");
		PartyIdentification_ID_RECEPTOR.setAttribute("schemeURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06");






		// cac:PartyLegalEntity
		Element PartyLegalEntity_RECEPTOR = document.createElement("cac:PartyLegalEntity");
		Party_RECEPTOR.appendChild(PartyLegalEntity_RECEPTOR);



		// cbc:RegistrationName
		Element RegistrationName_RECEPTOR = document.createElement("cbc:RegistrationName");
		Node cdataRegistrationName_RECEPTOR = document.createCDATASection(myCabecera_nc.get_nombre());
		RegistrationName_RECEPTOR.appendChild(cdataRegistrationName_RECEPTOR);
		PartyLegalEntity_RECEPTOR.appendChild(RegistrationName_RECEPTOR);



		// cbc:RegistrationName
		Element RegistrationAddress_RECEPTOR = document.createElement("cac:RegistrationAddress");
		//		Node cdataRegistrationAddress_RECEPTOR = document.createCDATASection(myCabecera.get_nombre());
		//		RegistrationAddress_RECEPTOR.appendChild(cdataRegistrationAddress_RECEPTOR);
		PartyLegalEntity_RECEPTOR.appendChild(RegistrationAddress_RECEPTOR);


		//cac:AddressLine
		Element AddressLine_RECEPTOR = document.createElement("cac:AddressLine");
		RegistrationAddress_RECEPTOR.appendChild(AddressLine_RECEPTOR);

		//cbc:Line
		Element Line_RECEPTOR = document.createElement("cbc:Line");
		Node cdataLine_RECEPTOR = document.createCDATASection($DIRECCION);
		Line_RECEPTOR.appendChild(cdataLine_RECEPTOR);
		AddressLine_RECEPTOR.appendChild(Line_RECEPTOR);

		// cac:Country
		Element Country_RECEPTOR = document.createElement("cac:Country");
		RegistrationAddress_RECEPTOR.appendChild(Country_RECEPTOR);				


		//cbc:IdentificationCode
		Element IdentificationCode_RECEPTOR = document.createElement("cbc:IdentificationCode");
		IdentificationCode_RECEPTOR.appendChild(document.createTextNode($PAIS));
		Country_RECEPTOR.appendChild(IdentificationCode_RECEPTOR);
		IdentificationCode_RECEPTOR.setAttribute("listAgencyName", "United Nations Economic Commission for Europe");
		IdentificationCode_RECEPTOR.setAttribute("listID", "ISO 3166-1");
		IdentificationCode_RECEPTOR.setAttribute("listName", "Country");
	
	


		// sacar la totallidad de los impouestos
		double _tax_total=myCabecera_nc.get_sum_igv()+myCabecera_nc.get_sum_isc();







		// cac:TaxTotal

		Element TaxTotal_Header = document.createElement("cac:TaxTotal");
		//	TaxTotal_Header.appendChild(document.createTextNode(""+_tax_total));
		element.appendChild(TaxTotal_Header);



		// cbc:TaxAmount
		Element TaxAmount_Header = document.createElement("cbc:TaxAmount");

		Attr attr_Moneda = document.createAttribute("currencyID");	
		attr_Moneda.setValue(myCabecera_nc.get_moneda());
		TaxAmount_Header.setAttributeNode(attr_Moneda);

		TaxAmount_Header.appendChild(document.createTextNode(""+Formato._xml(_impuestos)));
		TaxTotal_Header.appendChild(TaxAmount_Header);
		


		// gravadas ///
		////////////////////////////////////////////////////////////////
		// cac:TaxSubtotal
		Element TaxSubtotal_Header_Gra = document.createElement("cac:TaxSubtotal");
		TaxTotal_Header.appendChild(TaxSubtotal_Header_Gra);
		// cbc:TaxableAmount
		Element TaxableAmount_header_Gra = document.createElement("cbc:TaxableAmount");
		TaxableAmount_header_Gra.appendChild(document.createTextNode(""+Formato._xml(_base_gravable)));
		TaxSubtotal_Header_Gra.appendChild(TaxableAmount_header_Gra);
		Attr Atr_TaxableAmount_header_Gra = document.createAttribute("currencyID");	
		Atr_TaxableAmount_header_Gra.setValue(myCabecera_nc.get_moneda());
		TaxableAmount_header_Gra.setAttributeNode(Atr_TaxableAmount_header_Gra);
		// cbc:TaxAmount 
		Element TaxAmount_header_Gra = document.createElement("cbc:TaxAmount");
		TaxAmount_header_Gra.appendChild(document.createTextNode(""+Formato._xml(_igv)));
		TaxSubtotal_Header_Gra.appendChild(TaxAmount_header_Gra);
		Attr Atr_TaxAmount_header_Gra = document.createAttribute("currencyID");	
		Atr_TaxAmount_header_Gra.setValue(myCabecera_nc.get_moneda());
		TaxAmount_header_Gra.setAttributeNode(Atr_TaxAmount_header_Gra);
		// cac:TaxCategory
		Element TaxCategory_header_Gra = document.createElement("cac:TaxCategory");
		TaxSubtotal_Header_Gra.appendChild(TaxCategory_header_Gra);
		Element TaxCategory_header_ID0_Gra = document.createElement("cbc:ID");
	//	TaxCategory_header_ID0_Gra.appendChild(document.createTextNode("S"));
	//	TaxCategory_header_Gra.appendChild(TaxCategory_header_ID0_Gra);
	//	TaxCategory_header_ID0_Gra.setAttribute("schemeID", "UN/ECE 5305");
	//	TaxCategory_header_ID0_Gra.setAttribute("schemeName", "Tax Category Identifier");
	//	TaxCategory_header_ID0_Gra.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");

		//cac:TaxScheme
		Element TaxScheme_header_Gra = document.createElement("cac:TaxScheme");
		TaxCategory_header_Gra.appendChild(TaxScheme_header_Gra);
		Element TaxScheme_header_id_Gra = document.createElement("cbc:ID");
		TaxScheme_header_id_Gra.appendChild(document.createTextNode("1000"));
		TaxScheme_header_Gra.appendChild(TaxScheme_header_id_Gra);
		//schemeAgencyName="PE:SUNAT"
		Attr Atr_schemeAgencyNameID_Gra = document.createAttribute("schemeAgencyName");	
		Atr_schemeAgencyNameID_Gra.setValue("PE:SUNAT");
		TaxScheme_header_id_Gra.setAttributeNode(Atr_schemeAgencyNameID_Gra);
		TaxScheme_header_id_Gra.setAttribute("schemeID", "UN/ECE 5153");
		TaxScheme_header_id_Gra.setAttribute("schemeName", "Codigo de tributos");
		// cbc:Name
		Element TaxScheme_header_Name_Gra = document.createElement("cbc:Name");
		TaxScheme_header_Name_Gra.appendChild(document.createTextNode("IGV"));
		TaxScheme_header_Gra.appendChild(TaxScheme_header_Name_Gra);
		// cbc:TaxTypeCode
		Element TaxScheme_header_TaxTypeCode_Gra = document.createElement("cbc:TaxTypeCode");
		TaxScheme_header_TaxTypeCode_Gra.appendChild(document.createTextNode("VAT"));
		TaxScheme_header_Gra.appendChild(TaxScheme_header_TaxTypeCode_Gra);
		/////////////////////////////////////////////////////////// FIN DE GRABADAS

		
	
		
		// EXONERADAS ///
		////////////////////////////////////////////////////////////////
		// cac:TaxSubtotal
		Element TaxSubtotal_Header_Exo = document.createElement("cac:TaxSubtotal");
		//	TaxSubtotal_Header_Exo.appendChild(document.createTextNode(""+Formato._xml(_tax_total)));
		TaxTotal_Header.appendChild(TaxSubtotal_Header_Exo);

		// cbc:TaxableAmount
		Element TaxableAmount_header_Exo = document.createElement("cbc:TaxableAmount");
		TaxableAmount_header_Exo.appendChild(document.createTextNode(""+Formato._xml(_base_exonerada)));
		TaxSubtotal_Header_Exo.appendChild(TaxableAmount_header_Exo);

		Attr Atr_TaxableAmount_header_Exo = document.createAttribute("currencyID");	
		Atr_TaxableAmount_header_Exo.setValue(myCabecera_nc.get_moneda());
		TaxableAmount_header_Exo.setAttributeNode(Atr_TaxableAmount_header_Exo);

		// cbc:TaxAmount 
		Element TaxAmount_header_Exo = document.createElement("cbc:TaxAmount");
		TaxAmount_header_Exo.appendChild(document.createTextNode(""+Formato._xml(0)));
		TaxSubtotal_Header_Exo.appendChild(TaxAmount_header_Exo);

		Attr Atr_TaxAmount_header_Exo = document.createAttribute("currencyID");	
		Atr_TaxAmount_header_Exo.setValue(myCabecera_nc.get_moneda());
		TaxAmount_header_Exo.setAttributeNode(Atr_TaxAmount_header_Exo);

		// cac:TaxCategory
		Element TaxCategory_header_Exo = document.createElement("cac:TaxCategory");
		TaxSubtotal_Header_Exo.appendChild(TaxCategory_header_Exo);
	//	Element TaxCategory_header_ID0_Exo = document.createElement("cbc:ID");
	//	TaxCategory_header_ID0_Exo.appendChild(document.createTextNode("S"));
	//	TaxCategory_header_Exo.appendChild(TaxCategory_header_ID0_Exo);
	//	TaxCategory_header_ID0_Exo.setAttribute("schemeID", "UN/ECE 5305");
	//	TaxCategory_header_ID0_Exo.setAttribute("schemeName", "Tax Category Identifier");
	//	TaxCategory_header_ID0_Exo.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");

		//cac:TaxScheme
		Element TaxScheme_header_Exo = document.createElement("cac:TaxScheme");
		TaxCategory_header_Exo.appendChild(TaxScheme_header_Exo);
		Element TaxScheme_header_id_Exo = document.createElement("cbc:ID");
		TaxScheme_header_id_Exo.appendChild(document.createTextNode("9997"));
		TaxScheme_header_Exo.appendChild(TaxScheme_header_id_Exo);
		// schemeAgencyName="PE:SUNAT"
		
		
		Attr Atr_schemeAgencyNameID_Exo = document.createAttribute("schemeAgencyName");	
		Atr_schemeAgencyNameID_Exo.setValue("PE:SUNAT");
		TaxScheme_header_id_Exo.setAttributeNode(Atr_schemeAgencyNameID_Exo);
		TaxScheme_header_id_Exo.setAttribute("schemeID", "UN/ECE 5153");
		TaxScheme_header_id_Exo.setAttribute("schemeName", "Codigo de tributos");
	
		
		
		// cbc:Name
		Element TaxScheme_header_Name_Exo = document.createElement("cbc:Name");
		TaxScheme_header_Name_Exo.appendChild(document.createTextNode("EXO"));
		TaxScheme_header_Exo.appendChild(TaxScheme_header_Name_Exo);

		// cbc:TaxTypeCode
		Element TaxScheme_header_TaxTypeCode_Exo = document.createElement("cbc:TaxTypeCode");
		TaxScheme_header_TaxTypeCode_Exo.appendChild(document.createTextNode("VAT"));
		TaxScheme_header_Exo.appendChild(TaxScheme_header_TaxTypeCode_Exo);
		/////////////////////////////////////////////////////////// FIN DE EXONERADAS ///


		
		
			

		
		
		
		
		double _PayableAmount= _neto;


		// cac:LegalMonetaryTotal
		Element LegalMonetaryTotal_Header = document.createElement("cac:RequestedMonetaryTotal");
		element.appendChild(LegalMonetaryTotal_Header);

		
		// cbc:LineExtensionAmount
		
		Element LineExtensionAmount_tot = document.createElement("cbc:LineExtensionAmount");
		LineExtensionAmount_tot.appendChild(document.createTextNode(""+Formato._xml(_base)));
		LegalMonetaryTotal_Header.appendChild(LineExtensionAmount_tot);

		Attr Atr_LineExtensionAmount = document.createAttribute("currencyID");	
		Atr_LineExtensionAmount.setValue(myCabecera_nc.get_moneda());
		LineExtensionAmount_tot.setAttributeNode(Atr_LineExtensionAmount);

		
		
		
		
		// cbc:TaxInclusiveAmount
		Element TaxInclusiveAmount = document.createElement("cbc:TaxInclusiveAmount");
		TaxInclusiveAmount.appendChild(document.createTextNode(""+Formato._xml(_base+_impuestos)));
		LegalMonetaryTotal_Header.appendChild(TaxInclusiveAmount);

		Attr Atr_TaxInclusiveAmount = document.createAttribute("currencyID");	
		Atr_TaxInclusiveAmount.setValue(myCabecera_nc.get_moneda());
		TaxInclusiveAmount.setAttributeNode(Atr_TaxInclusiveAmount);
		
		
		// cbc:AllowanceTotalAmount
		Element AllowanceTotalAmount = document.createElement("cbc:AllowanceTotalAmount");
		AllowanceTotalAmount.appendChild(document.createTextNode(""+Formato._xml(0.00)));
		LegalMonetaryTotal_Header.appendChild(AllowanceTotalAmount);

		
		Attr Atr_AllowanceTotalAmount = document.createAttribute("currencyID");	
		Atr_AllowanceTotalAmount.setValue(myCabecera_nc.get_moneda());
		AllowanceTotalAmount.setAttributeNode(Atr_AllowanceTotalAmount);

			
		
		// cbc:ChargeTotalAmount
		Element ChargeTotalAmount = document.createElement("cbc:ChargeTotalAmount");
		ChargeTotalAmount.appendChild(document.createTextNode(""+Formato._xml(0)));
		LegalMonetaryTotal_Header.appendChild(ChargeTotalAmount);

		Attr Atr_ChargeTotalAmount = document.createAttribute("currencyID");	
		Atr_ChargeTotalAmount.setValue(myCabecera_nc.get_moneda());
		ChargeTotalAmount.setAttributeNode(Atr_ChargeTotalAmount);
		
		
		
		// cbc:PayableAmount
		Element PayableAmount = document.createElement("cbc:PayableAmount");
		PayableAmount.appendChild(document.createTextNode(""+Formato._xml(_neto)));
		LegalMonetaryTotal_Header.appendChild(PayableAmount);

		Attr Atr_PayableAmount = document.createAttribute("currencyID");	
		Atr_PayableAmount.setValue(myCabecera_nc.get_moneda());
		PayableAmount.setAttributeNode(Atr_PayableAmount);


		
		
		
		
		
		
		/// datelle de la factura
		


		for (int linea=1; linea<_counterDet; linea++) {	

			
			
			// sacar la totallidad de los impouestos
			double _igv_detalle=myDetalle[linea].get_igv_unit();
			double _base_gravable_detalle=myDetalle[linea].get_cantidad()*myDetalle[linea].get_precio_unit();
			double _isc_detalle=myDetalle[linea].get_isc_unit();
			double _tot_trubutos_detalle=_igv_detalle+_isc_detalle;
			String _tipo_igv=myDetalle[linea].get_afec_igv();
			String _tipo_isc=myDetalle[linea].get_tipo_isc();
			
			double _total_linea=_base_gravable_detalle+_tot_trubutos_detalle;

			// cac:InvoiceLine
			Element InvoiceLine = document.createElement("cac:DebitNoteLine");
			element.appendChild(InvoiceLine);		

			// cbc:ID
			Element ID_Item = document.createElement("cbc:ID");
			ID_Item.appendChild(document.createTextNode(""+linea));
			InvoiceLine.appendChild(ID_Item);		



			// CANTIDAD Y UNIDAD DE MEDIDA
			// cbc:InvoicedQuantity 
			Element InvoicedQuantity = document.createElement("cbc:DebitedQuantity");
			InvoicedQuantity.appendChild(document.createTextNode(""+myDetalle[linea].get_cantidad()));
			InvoiceLine.appendChild(InvoicedQuantity);

			InvoicedQuantity.setAttribute("unitCode", myDetalle[linea].get_unidad_med());
			//		InvoicedQuantity.setAttribute("unitCodeListID", "UN/ECE rec 20");
			//		InvoicedQuantity.setAttribute("unitCodeListAgencyName", "United Nations Economic Commission for Europe");


			// cbc:LineExtensionAmount
			Element LineExtensionAmount = document.createElement("cbc:LineExtensionAmount");
			LineExtensionAmount.appendChild(document.createTextNode(Formato.GranDinero(myDetalle[linea].get_valor_unit()*myDetalle[linea].get_cantidad())));
			InvoiceLine.appendChild(LineExtensionAmount);

			// currencyID
			Attr Atr_currencyID = document.createAttribute("currencyID");	
			Atr_currencyID.setValue(myCabecera_nc.get_moneda());
			LineExtensionAmount.setAttributeNode(Atr_currencyID);




			// cac:PricingReference
			Element PricingReference = document.createElement("cac:PricingReference");
			InvoiceLine.appendChild(PricingReference);

			// cac:AlternativeConditionPrice
			Element AlternativeConditionPrice = document.createElement("cac:AlternativeConditionPrice");
			PricingReference.appendChild(AlternativeConditionPrice);


			// cbc:PriceAmount
			Element PriceAmount_item_reference = document.createElement("cbc:PriceAmount");
		//	PriceAmount_item_reference.appendChild(document.createTextNode(Formato.GranDinero(myDetalle[linea].get_precio_unit()-myDetalle[linea].get_desc_unit()    )));
			PriceAmount_item_reference.appendChild(document.createTextNode(Formato.GranDinero(_total_linea)));
			AlternativeConditionPrice.appendChild(PriceAmount_item_reference);



			// currencyID
			Attr Atr_PriceAmount_Detail_ref = document.createAttribute("currencyID");	
			Atr_PriceAmount_Detail_ref.setValue(myCabecera_nc.get_moneda());
			PriceAmount_item_reference.setAttributeNode(Atr_PriceAmount_Detail_ref);

			String _codigo_precio="01";



			// cbc:PriceTypeCode
			Element PriceTypeCode = document.createElement("cbc:PriceTypeCode");
			PriceTypeCode.appendChild(document.createTextNode(_codigo_precio));
			AlternativeConditionPrice.appendChild(PriceTypeCode);

			PriceTypeCode.setAttribute("listAgencyName", "PE:SUNAT");
			PriceTypeCode.setAttribute("listName", "Tipo de Precio");
			PriceTypeCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo16");



	


			
			
			
			
			
			
			
			///////////////////////////////////////////////////////
			// 40 Descuentos por ítem
			// cac:AllowanceCharge

			if (myDetalle[linea].get_desc_unit()>0) {

				Element AllowanceCharge_Detail = document.createElement("cac:AllowanceCharge");
				InvoiceLine.appendChild(AllowanceCharge_Detail);

				// cbc:ChargeIndicator
				Element ChargeIndicator = document.createElement("cbc:ChargeIndicator");
				ChargeIndicator.appendChild(document.createTextNode("false"));
				AllowanceCharge_Detail.appendChild(ChargeIndicator);

				// cbc:AllowanceChargeReasonCode
				Element AllowanceChargeReasonCode_01 = document.createElement("cbc:AllowanceChargeReasonCode");
				AllowanceChargeReasonCode_01.appendChild(document.createTextNode("00"));
				AllowanceCharge_Detail.appendChild(AllowanceChargeReasonCode_01);


				double _MultiplierFactorNumeric=myDetalle[linea].get_desc_unit()/myDetalle[linea].get_valor_tot();


				// cbc:MultiplierFactorNumeric
				Element MultiplierFactorNumeric_01 = document.createElement("cbc:MultiplierFactorNumeric");
				MultiplierFactorNumeric_01.appendChild(document.createTextNode(Formato._xml(_MultiplierFactorNumeric)));
				AllowanceCharge_Detail.appendChild(MultiplierFactorNumeric_01);

				// cbc:Amount 
				Element Amount_Detail = document.createElement("cbc:Amount");
				Amount_Detail.appendChild(document.createTextNode(""+myDetalle[linea].get_desc_unit()));
				AllowanceCharge_Detail.appendChild(Amount_Detail);

				// currencyID
				Attr Atr_descuento_Detail = document.createAttribute("currencyID");	
				Atr_descuento_Detail.setValue(myCabecera_nc.get_moneda());
				Amount_Detail.setAttributeNode(Atr_descuento_Detail);

				// cbc:BaseAmount 
				Element BaseAmount_Detail = document.createElement("cbc:BaseAmount");
				BaseAmount_Detail.appendChild(document.createTextNode(""+myDetalle[linea].get_valor_tot()));
				AllowanceCharge_Detail.appendChild(BaseAmount_Detail);

				// currencyID
				Attr Atr_Base_descuento_Detail = document.createAttribute("currencyID");	
				Atr_Base_descuento_Detail.setValue(myCabecera_nc.get_moneda());
				BaseAmount_Detail.setAttributeNode(Atr_Base_descuento_Detail);



			}



			
			
			

			//////////////////////
			// OPERACIONES GRAVADAS


			if (_tipo_igv.equals("10")) {
				// cac:TaxTotal
				Element TaxTotal_Detalle = document.createElement("cac:TaxTotal");
				InvoiceLine.appendChild(TaxTotal_Detalle);
				// cac:TaxAmount
				Element TaxAmount_Detalle = document.createElement("cbc:TaxAmount");
				TaxAmount_Detalle.appendChild(document.createTextNode(""+_tot_trubutos_detalle));
				TaxTotal_Detalle.appendChild(TaxAmount_Detalle);
				Attr Atr_TaxableAmount_detalle_Gra01 = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra01.setValue(myCabecera_nc.get_moneda());
				TaxAmount_Detalle.setAttributeNode(Atr_TaxableAmount_detalle_Gra01);
				// cac:TaxSubtotal
				Element TaxSubtotal_detalle_Gra = document.createElement("cac:TaxSubtotal");
				TaxTotal_Detalle.appendChild(TaxSubtotal_detalle_Gra);
				// cbc:TaxableAmount
				Element TaxableAmount_detalle_Gra = document.createElement("cbc:TaxableAmount");
				TaxableAmount_detalle_Gra.appendChild(document.createTextNode(""+Formato.GranDinero(myDetalle[linea].get_valor_unit()*myDetalle[linea].get_cantidad())));
				TaxSubtotal_detalle_Gra.appendChild(TaxableAmount_detalle_Gra);
				Attr Atr_TaxableAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxableAmount_detalle_Gra.setAttributeNode(Atr_TaxableAmount_detalle_Gra);
				// cbc:TaxAmount 
				Element TaxAmount_detalle_Gra = document.createElement("cbc:TaxAmount");
				TaxAmount_detalle_Gra.appendChild(document.createTextNode(""+_igv_detalle));
				TaxSubtotal_detalle_Gra.appendChild(TaxAmount_detalle_Gra);
				Attr Atr_TaxAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxAmount_detalle_Gra.setAttributeNode(Atr_TaxAmount_detalle_Gra);
				// cac:TaxCategory
				Element TaxCategory_detalle_Gra = document.createElement("cac:TaxCategory");
				TaxSubtotal_detalle_Gra.appendChild(TaxCategory_detalle_Gra);
				// id
				Element TaxCategory_detalle_Gra_ID = document.createElement("cbc:ID");
				TaxCategory_detalle_Gra_ID.appendChild(document.createTextNode("S"));
				TaxCategory_detalle_Gra.appendChild(TaxCategory_detalle_Gra_ID);
				TaxCategory_detalle_Gra_ID.setAttribute("schemeID", "UN/ECE 5305");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeName", "Tax Category Identifier");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");
				// cbc:Percent
				Element Percent_igv = document.createElement("cbc:Percent");
				Percent_igv.appendChild(document.createTextNode("18"));
				TaxCategory_detalle_Gra.appendChild(Percent_igv);
				// cbc:TaxExemptionReasonCode
				Element TaxExemptionReasonCode = document.createElement("cbc:TaxExemptionReasonCode");
				TaxExemptionReasonCode.appendChild(document.createTextNode(_tipo_igv));
				TaxCategory_detalle_Gra.appendChild(TaxExemptionReasonCode);
				TaxExemptionReasonCode.setAttribute("listAgencyName", "PE:SUNAT");
				TaxExemptionReasonCode.setAttribute("listName", "Afectacion del IGV");
				TaxExemptionReasonCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				// listAgencyName
				Attr Atr_TaxExemptionReasonCode_slistAgencyName_Gra = document.createAttribute("listAgencyName");	
				Atr_TaxExemptionReasonCode_slistAgencyName_Gra.setValue("PE:SUNAT");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_slistAgencyName_Gra);

				//slistName
				Attr Atr_TaxExemptionReasonCode_listName_Gra = document.createAttribute("listName");	
				Atr_TaxExemptionReasonCode_listName_Gra.setValue("Afectacion del IGV");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listName_Gra);

				//listUR
				Attr Atr_TaxExemptionReasonCode_listUR_Gra = document.createAttribute("listURI");	
				Atr_TaxExemptionReasonCode_listUR_Gra.setValue("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listUR_Gra);

				//cac:TaxScheme
				Element TaxScheme_detail = document.createElement("cac:TaxScheme");
				TaxScheme_detail.appendChild(document.createTextNode(""));
				TaxCategory_detalle_Gra.appendChild(TaxScheme_detail);

				// cbc:ID
				Element TaxScheme_detalle_id_Gra = document.createElement("cbc:ID");
				TaxScheme_detalle_id_Gra.appendChild(document.createTextNode("1000"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_id_Gra);
				// schemeID="UN/ECE 5153"
				Attr Atr_id_schemeAgencyName_Gra = document.createAttribute("schemeAgencyName");	
				Atr_id_schemeAgencyName_Gra.setValue("PE:SUNAT");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeAgencyName_Gra);
				//  schemeName="Tax Scheme Identifier"
				Attr Atr_id_schemeID_Gra = document.createAttribute("schemeID");	
				Atr_id_schemeID_Gra.setValue("UN/ECE 5153");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeID_Gra);
				// schemeAgencyName="United Nations Economic Commission for Europe"
				Attr Atr_id_schemeName_Gra = document.createAttribute("schemeName");	
				Atr_id_schemeName_Gra.setValue("Codigo de tributos");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeName_Gra);
				// cbc:Name
				Element TaxScheme_detalle_Name_Gra = document.createElement("cbc:Name");
				TaxScheme_detalle_Name_Gra.appendChild(document.createTextNode("IGV"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_Name_Gra);
				// cbc:TaxTypeCode
				Element TaxScheme_detalle_TaxTypeCode_Gra = document.createElement("cbc:TaxTypeCode");
				TaxScheme_detalle_TaxTypeCode_Gra.appendChild(document.createTextNode("VAT"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_TaxTypeCode_Gra);
		
			

			
			
			
			}
			
			///////////////////////////////////////////////////////////  fin de operaciones gravadas



			//////////////////////
			// OPERACIONES EXONERADAS
			if (_tipo_igv.equals("20")) {
				// cac:TaxTotal
				Element TaxTotal_Detalle = document.createElement("cac:TaxTotal");
				InvoiceLine.appendChild(TaxTotal_Detalle);
				// cac:TaxAmount
				Element TaxAmount_Detalle = document.createElement("cbc:TaxAmount");
				TaxAmount_Detalle.appendChild(document.createTextNode(""+_igv_detalle));
				TaxTotal_Detalle.appendChild(TaxAmount_Detalle);
				Attr Atr_TaxableAmount_detalle_Gra01 = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra01.setValue(myCabecera_nc.get_moneda());
				TaxAmount_Detalle.setAttributeNode(Atr_TaxableAmount_detalle_Gra01);
				// cac:TaxSubtotal
				Element TaxSubtotal_detalle_Gra = document.createElement("cac:TaxSubtotal");
				TaxTotal_Detalle.appendChild(TaxSubtotal_detalle_Gra);
				// cbc:TaxableAmount
				Element TaxableAmount_detalle_Gra = document.createElement("cbc:TaxableAmount");
				TaxableAmount_detalle_Gra.appendChild(document.createTextNode(""+Formato.GranDinero(myDetalle[linea].get_valor_unit()*myDetalle[linea].get_cantidad())));
				TaxSubtotal_detalle_Gra.appendChild(TaxableAmount_detalle_Gra);
				Attr Atr_TaxableAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxableAmount_detalle_Gra.setAttributeNode(Atr_TaxableAmount_detalle_Gra);
				// cbc:TaxAmount 
				Element TaxAmount_detalle_Gra = document.createElement("cbc:TaxAmount");
				TaxAmount_detalle_Gra.appendChild(document.createTextNode(""+_igv_detalle));
				TaxSubtotal_detalle_Gra.appendChild(TaxAmount_detalle_Gra);
				Attr Atr_TaxAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxAmount_detalle_Gra.setAttributeNode(Atr_TaxAmount_detalle_Gra);
				// cac:TaxCategory
				Element TaxCategory_detalle_Gra = document.createElement("cac:TaxCategory");
				TaxSubtotal_detalle_Gra.appendChild(TaxCategory_detalle_Gra);
				// id
				Element TaxCategory_detalle_Gra_ID = document.createElement("cbc:ID");
				TaxCategory_detalle_Gra_ID.appendChild(document.createTextNode("S"));
				TaxCategory_detalle_Gra.appendChild(TaxCategory_detalle_Gra_ID);
				TaxCategory_detalle_Gra_ID.setAttribute("schemeID", "UN/ECE 5305");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeName", "Tax Category Identifier");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");
				// cbc:Percent
				Element Percent_igv = document.createElement("cbc:Percent");
				Percent_igv.appendChild(document.createTextNode("18"));
				TaxCategory_detalle_Gra.appendChild(Percent_igv);
				// cbc:TaxExemptionReasonCode
				Element TaxExemptionReasonCode = document.createElement("cbc:TaxExemptionReasonCode");
				TaxExemptionReasonCode.appendChild(document.createTextNode(_tipo_igv));
				TaxCategory_detalle_Gra.appendChild(TaxExemptionReasonCode);
				TaxExemptionReasonCode.setAttribute("listAgencyName", "PE:SUNAT");
				TaxExemptionReasonCode.setAttribute("listName", "Afectacion del IGV");
				TaxExemptionReasonCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				// listAgencyName
				Attr Atr_TaxExemptionReasonCode_slistAgencyName_Gra = document.createAttribute("listAgencyName");	
				Atr_TaxExemptionReasonCode_slistAgencyName_Gra.setValue("PE:SUNAT");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_slistAgencyName_Gra);
				//slistName
				Attr Atr_TaxExemptionReasonCode_listName_Gra = document.createAttribute("listName");	
				Atr_TaxExemptionReasonCode_listName_Gra.setValue("Afectacion del IGV");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listName_Gra);
				//listUR
				Attr Atr_TaxExemptionReasonCode_listUR_Gra = document.createAttribute("listURI");	
				Atr_TaxExemptionReasonCode_listUR_Gra.setValue("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listUR_Gra);
				//cac:TaxScheme
				Element TaxScheme_detail = document.createElement("cac:TaxScheme");
				TaxScheme_detail.appendChild(document.createTextNode(""));
				TaxCategory_detalle_Gra.appendChild(TaxScheme_detail);
				// cbc:ID
				Element TaxScheme_detalle_id_Gra = document.createElement("cbc:ID");
				TaxScheme_detalle_id_Gra.appendChild(document.createTextNode("9997"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_id_Gra);
				// schemeID="UN/ECE 5153"
				Attr Atr_id_schemeAgencyName_Gra = document.createAttribute("schemeAgencyName");	
				Atr_id_schemeAgencyName_Gra.setValue("PE:SUNAT");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeAgencyName_Gra);
				//  schemeName="Tax Scheme Identifier"
				Attr Atr_id_schemeID_Gra = document.createAttribute("schemeID");	
				Atr_id_schemeID_Gra.setValue("UN/ECE 5153");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeID_Gra);
				// schemeAgencyName="United Nations Economic Commission for Europe"
				Attr Atr_id_schemeName_Gra = document.createAttribute("schemeName");	
				Atr_id_schemeName_Gra.setValue("Codigo de tributos");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeName_Gra);
				// cbc:Name
				Element TaxScheme_detalle_Name_Gra = document.createElement("cbc:Name");
				TaxScheme_detalle_Name_Gra.appendChild(document.createTextNode("EXO"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_Name_Gra);
				// cbc:TaxTypeCode
				Element TaxScheme_detalle_TaxTypeCode_Gra = document.createElement("cbc:TaxTypeCode");
				TaxScheme_detalle_TaxTypeCode_Gra.appendChild(document.createTextNode("VAT"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_TaxTypeCode_Gra);
			}
			
			///////////////////////////////////////////////////////////  fin de operaciones EXONERADAS


			
			
			
			
			//////////////////////
			// OPERACIONES INAFECTAS
			if (_tipo_igv.equals("30")) {
				// cac:TaxTotal
				Element TaxTotal_Detalle = document.createElement("cac:TaxTotal");
				InvoiceLine.appendChild(TaxTotal_Detalle);
				// cac:TaxAmount
				Element TaxAmount_Detalle = document.createElement("cbc:TaxAmount");
				TaxAmount_Detalle.appendChild(document.createTextNode(""+_igv_detalle));
				TaxTotal_Detalle.appendChild(TaxAmount_Detalle);
				Attr Atr_TaxableAmount_detalle_Gra01 = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra01.setValue(myCabecera_nc.get_moneda());
				TaxAmount_Detalle.setAttributeNode(Atr_TaxableAmount_detalle_Gra01);
				// cac:TaxSubtotal
				Element TaxSubtotal_detalle_Gra = document.createElement("cac:TaxSubtotal");
				TaxTotal_Detalle.appendChild(TaxSubtotal_detalle_Gra);
				// cbc:TaxableAmount
				Element TaxableAmount_detalle_Gra = document.createElement("cbc:TaxableAmount");
				TaxableAmount_detalle_Gra.appendChild(document.createTextNode(""+Formato.GranDinero(myDetalle[linea].get_valor_unit()*myDetalle[linea].get_cantidad())));
				TaxSubtotal_detalle_Gra.appendChild(TaxableAmount_detalle_Gra);
				Attr Atr_TaxableAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxableAmount_detalle_Gra.setAttributeNode(Atr_TaxableAmount_detalle_Gra);
				// cbc:TaxAmount 
				Element TaxAmount_detalle_Gra = document.createElement("cbc:TaxAmount");
				TaxAmount_detalle_Gra.appendChild(document.createTextNode(""+_igv_detalle));
				TaxSubtotal_detalle_Gra.appendChild(TaxAmount_detalle_Gra);
				Attr Atr_TaxAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxAmount_detalle_Gra.setAttributeNode(Atr_TaxAmount_detalle_Gra);
				// cac:TaxCategory
				Element TaxCategory_detalle_Gra = document.createElement("cac:TaxCategory");
				TaxSubtotal_detalle_Gra.appendChild(TaxCategory_detalle_Gra);
				// id
				Element TaxCategory_detalle_Gra_ID = document.createElement("cbc:ID");
				TaxCategory_detalle_Gra_ID.appendChild(document.createTextNode("S"));
				TaxCategory_detalle_Gra.appendChild(TaxCategory_detalle_Gra_ID);
				TaxCategory_detalle_Gra_ID.setAttribute("schemeID", "UN/ECE 5305");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeName", "Tax Category Identifier");
				TaxCategory_detalle_Gra_ID.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");
				// cbc:Percent
				Element Percent_igv = document.createElement("cbc:Percent");
				Percent_igv.appendChild(document.createTextNode("18"));
				TaxCategory_detalle_Gra.appendChild(Percent_igv);
				// cbc:TaxExemptionReasonCode
				Element TaxExemptionReasonCode = document.createElement("cbc:TaxExemptionReasonCode");
				TaxExemptionReasonCode.appendChild(document.createTextNode(_tipo_igv));
				TaxCategory_detalle_Gra.appendChild(TaxExemptionReasonCode);
				TaxExemptionReasonCode.setAttribute("listAgencyName", "PE:SUNAT");
				TaxExemptionReasonCode.setAttribute("listName", "Afectacion del IGV");
				TaxExemptionReasonCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				// listAgencyName
				Attr Atr_TaxExemptionReasonCode_slistAgencyName_Gra = document.createAttribute("listAgencyName");	
				Atr_TaxExemptionReasonCode_slistAgencyName_Gra.setValue("PE:SUNAT");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_slistAgencyName_Gra);
				//slistName
				Attr Atr_TaxExemptionReasonCode_listName_Gra = document.createAttribute("listName");	
				Atr_TaxExemptionReasonCode_listName_Gra.setValue("Afectacion del IGV");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listName_Gra);
				//listUR
				Attr Atr_TaxExemptionReasonCode_listUR_Gra = document.createAttribute("listURI");	
				Atr_TaxExemptionReasonCode_listUR_Gra.setValue("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listUR_Gra);
				//cac:TaxScheme
				Element TaxScheme_detail = document.createElement("cac:TaxScheme");
				TaxScheme_detail.appendChild(document.createTextNode(""));
				TaxCategory_detalle_Gra.appendChild(TaxScheme_detail);
				// cbc:ID
				Element TaxScheme_detalle_id_Gra = document.createElement("cbc:ID");
				TaxScheme_detalle_id_Gra.appendChild(document.createTextNode("9998"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_id_Gra);
				// schemeID="UN/ECE 5153"
				Attr Atr_id_schemeAgencyName_Gra = document.createAttribute("schemeAgencyName");	
				Atr_id_schemeAgencyName_Gra.setValue("PE:SUNAT");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeAgencyName_Gra);
				//  schemeName="Tax Scheme Identifier"
				Attr Atr_id_schemeID_Gra = document.createAttribute("schemeID");	
				Atr_id_schemeID_Gra.setValue("UN/ECE 5153");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeID_Gra);
				// schemeAgencyName="United Nations Economic Commission for Europe"
				Attr Atr_id_schemeName_Gra = document.createAttribute("schemeName");	
				Atr_id_schemeName_Gra.setValue("Codigo de tributos");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeName_Gra);
				// cbc:Name
				Element TaxScheme_detalle_Name_Gra = document.createElement("cbc:Name");
				TaxScheme_detalle_Name_Gra.appendChild(document.createTextNode("INA"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_Name_Gra);
				// cbc:TaxTypeCode
				Element TaxScheme_detalle_TaxTypeCode_Gra = document.createElement("cbc:TaxTypeCode");
				TaxScheme_detalle_TaxTypeCode_Gra.appendChild(document.createTextNode("FRE"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_TaxTypeCode_Gra);
			}
			
			///////////////////////////////////////////////////////////  fin de operaciones EXONERADAS

			

			
			
			//////////////////////
			// OPERACIONES exaneradas gratuitas
			if (_tipo_igv.equals("21") || _tipo_igv.equals("37")) {
				// cac:TaxTotal
				Element TaxTotal_Detalle = document.createElement("cac:TaxTotal");
				InvoiceLine.appendChild(TaxTotal_Detalle);
				// cac:TaxAmount
				Element TaxAmount_Detalle = document.createElement("cbc:TaxAmount");
				TaxAmount_Detalle.appendChild(document.createTextNode(""+_igv_detalle));
				TaxTotal_Detalle.appendChild(TaxAmount_Detalle);
				Attr Atr_TaxableAmount_detalle_Gra01 = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra01.setValue(myCabecera_nc.get_moneda());
				TaxAmount_Detalle.setAttributeNode(Atr_TaxableAmount_detalle_Gra01);
				// cac:TaxSubtotal
				Element TaxSubtotal_detalle_Gra = document.createElement("cac:TaxSubtotal");
				TaxTotal_Detalle.appendChild(TaxSubtotal_detalle_Gra);
				// cbc:TaxableAmount
				Element TaxableAmount_detalle_Gra = document.createElement("cbc:TaxableAmount");
				TaxableAmount_detalle_Gra.appendChild(document.createTextNode(""+Formato.GranDinero(0)));
				TaxSubtotal_detalle_Gra.appendChild(TaxableAmount_detalle_Gra);
				Attr Atr_TaxableAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxableAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxableAmount_detalle_Gra.setAttributeNode(Atr_TaxableAmount_detalle_Gra);
				// cbc:TaxAmount 
				Element TaxAmount_detalle_Gra = document.createElement("cbc:TaxAmount");
				TaxAmount_detalle_Gra.appendChild(document.createTextNode(""+_igv_detalle));
				TaxSubtotal_detalle_Gra.appendChild(TaxAmount_detalle_Gra);
				Attr Atr_TaxAmount_detalle_Gra = document.createAttribute("currencyID");	
				Atr_TaxAmount_detalle_Gra.setValue(myCabecera_nc.get_moneda());
				TaxAmount_detalle_Gra.setAttributeNode(Atr_TaxAmount_detalle_Gra);
				// cac:TaxCategory
				Element TaxCategory_detalle_Gra = document.createElement("cac:TaxCategory");
				TaxSubtotal_detalle_Gra.appendChild(TaxCategory_detalle_Gra);
				// id
		//		Element TaxCategory_detalle_Gra_ID = document.createElement("cbc:ID");
		//		TaxCategory_detalle_Gra_ID.appendChild(document.createTextNode("S"));
		//		TaxCategory_detalle_Gra.appendChild(TaxCategory_detalle_Gra_ID);
		//		TaxCategory_detalle_Gra_ID.setAttribute("schemeID", "UN/ECE 5305");
		//		TaxCategory_detalle_Gra_ID.setAttribute("schemeName", "Tax Category Identifier");
		//		TaxCategory_detalle_Gra_ID.setAttribute("schemeAgencyName", "United Nations Economic Commission for Europe");
				// cbc:Percent
				Element Percent_igv = document.createElement("cbc:Percent");
				Percent_igv.appendChild(document.createTextNode("18"));
				TaxCategory_detalle_Gra.appendChild(Percent_igv);
				// cbc:TaxExemptionReasonCode
				Element TaxExemptionReasonCode = document.createElement("cbc:TaxExemptionReasonCode");
				TaxExemptionReasonCode.appendChild(document.createTextNode(_tipo_igv));
				TaxCategory_detalle_Gra.appendChild(TaxExemptionReasonCode);
				TaxExemptionReasonCode.setAttribute("listAgencyName", "PE:SUNAT");
				TaxExemptionReasonCode.setAttribute("listName", "Afectacion del IGV");
				TaxExemptionReasonCode.setAttribute("listURI", "urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				// listAgencyName
				Attr Atr_TaxExemptionReasonCode_slistAgencyName_Gra = document.createAttribute("listAgencyName");	
				Atr_TaxExemptionReasonCode_slistAgencyName_Gra.setValue("PE:SUNAT");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_slistAgencyName_Gra);
				//slistName
				Attr Atr_TaxExemptionReasonCode_listName_Gra = document.createAttribute("listName");	
				Atr_TaxExemptionReasonCode_listName_Gra.setValue("Afectacion del IGV");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listName_Gra);
				//listUR
				Attr Atr_TaxExemptionReasonCode_listUR_Gra = document.createAttribute("listURI");	
				Atr_TaxExemptionReasonCode_listUR_Gra.setValue("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo07");
				TaxExemptionReasonCode.setAttributeNode(Atr_TaxExemptionReasonCode_listUR_Gra);
				//cac:TaxScheme
				Element TaxScheme_detail = document.createElement("cac:TaxScheme");
				TaxScheme_detail.appendChild(document.createTextNode(""));
				TaxCategory_detalle_Gra.appendChild(TaxScheme_detail);
				// cbc:ID
				Element TaxScheme_detalle_id_Gra = document.createElement("cbc:ID");
				TaxScheme_detalle_id_Gra.appendChild(document.createTextNode("9996"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_id_Gra);
				// schemeID="UN/ECE 5153"
				Attr Atr_id_schemeAgencyName_Gra = document.createAttribute("schemeAgencyName");	
				Atr_id_schemeAgencyName_Gra.setValue("PE:SUNAT");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeAgencyName_Gra);
				//  schemeName="Tax Scheme Identifier"
				Attr Atr_id_schemeID_Gra = document.createAttribute("schemeID");	
				Atr_id_schemeID_Gra.setValue("UN/ECE 5153");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeID_Gra);
				// schemeAgencyName="United Nations Economic Commission for Europe"
				Attr Atr_id_schemeName_Gra = document.createAttribute("schemeName");	
				Atr_id_schemeName_Gra.setValue("Codigo de tributos");
				TaxScheme_detalle_id_Gra.setAttributeNode(Atr_id_schemeName_Gra);
				// cbc:Name
				Element TaxScheme_detalle_Name_Gra = document.createElement("cbc:Name");
				TaxScheme_detalle_Name_Gra.appendChild(document.createTextNode("GRA"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_Name_Gra);
				// cbc:TaxTypeCode
				Element TaxScheme_detalle_TaxTypeCode_Gra = document.createElement("cbc:TaxTypeCode");
				TaxScheme_detalle_TaxTypeCode_Gra.appendChild(document.createTextNode("FRE"));
				TaxScheme_detail.appendChild(TaxScheme_detalle_TaxTypeCode_Gra);
			}
			
			///////////////////////////////////////////////////////////  fin de operaciones EXONERADAS


			// PARA ISC
			

			
			

			// cac:Item

			Element Item = document.createElement("cac:Item");
			InvoiceLine.appendChild(Item);

			// cbc:Description
			//		Element Description = document.createElement("cbc:Description");
			//		Description.appendChild(document.createTextNode(myDetalle[linea].get_descrip()));
			//		Item.appendChild(Description);






			Element Description_det = document.createElement("cbc:Description");
			Node cdataDescription_det = document.createCDATASection(myDetalle[linea].get_descrip());
			Description_det.appendChild(cdataDescription_det);
			Item.appendChild(Description_det);



			// cac:SellersItemIdentification
			Element SellersItemIdentification = document.createElement("cac:SellersItemIdentification");
			//SellersItemIdentification.appendChild(document.createTextNode(""));
			Item.appendChild(SellersItemIdentification);


			//cbc:ID
			Element SellersItemIdentification_ID = document.createElement("cbc:ID");
			SellersItemIdentification_ID.appendChild(document.createTextNode(myDetalle[linea].get_producto()));
			SellersItemIdentification.appendChild(SellersItemIdentification_ID);



			// cac:Price
			Element Price_item = document.createElement("cac:Price");
			InvoiceLine.appendChild(Price_item);

			// cbc:PriceAmount
			Element PriceAmount_item = document.createElement("cbc:PriceAmount");
			PriceAmount_item.appendChild(document.createTextNode(Formato.GranDinero(myDetalle[linea].get_valor_unit())));
			Price_item.appendChild(PriceAmount_item);



			// currencyID
			Attr Atr_PriceAmount_Detail = document.createAttribute("currencyID");	
			Atr_PriceAmount_Detail.setValue(myCabecera_nc.get_moneda());
			PriceAmount_item.setAttributeNode(Atr_PriceAmount_Detail);


	




		}

		
		
		
		
		
		
	/*


		for (int linea=1; linea<_counterRel; linea++) {	

			try {
				String _status = mydocumentos_relacionados[linea].get_indDocRelacionado();

				if (mydocumentos_relacionados[linea].get_indDocRelacionado().equals("2")) {
					// cac:DespatchDocumentReference
					////////////////////////////////////////////////////////////////////

					// cac:PrepaidPayment
					Element PrepaidPayment = document.createElement("cac:PrepaidPayment");
					element.appendChild(PrepaidPayment);

					// PrepaidPaymentID
					Element PrepaidPaymentID = document.createElement("cbc:ID");
					PrepaidPaymentID.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_numDocRelacionado()));
					PrepaidPayment.appendChild(PrepaidPaymentID);

					// cbc:PaidAmount
					Element PaidAmount_rel = document.createElement("cbc:PaidAmount");
					PaidAmount_rel.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_mtoDocRelacionado()));
					PrepaidPayment.appendChild(PaidAmount_rel);


					// currencyID
					Attr currencyID_Pre = document.createAttribute("currencyID");
					currencyID_Pre.setValue(myCabecera_nc.get_moneda());
					PaidAmount_rel.setAttributeNode(currencyID_Pre);

					// cbc:InstructionID
					Element InstructionID = document.createElement("cbc:InstructionID");
					InstructionID.appendChild(document.createTextNode(mydocumentos_relacionados[linea].get_numDocEmisor()));
					PrepaidPayment.appendChild(InstructionID);




	
				}
			} catch (Exception e) {

				//	e.printStackTrace();
			}

		}		
		///////
	

		*/


		
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		//		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");


		//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//		Transformer transformer = transformerFactory.newTransformer();
		//		StringWriter sw = new StringWriter();

		//	StreamResult result = new StreamResult(sw);
		//	doc.setXmlStandalone(true);
		//	DOMSource source = new DOMSource(doc);
		//	trans.transform(source, result);
		//	String xmlString = sw.toString();


		document.setXmlStandalone(true);
		DOMSource source = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File($FILE_NAME_XML));	
		transformer.transform(source, streamResult);



		File archivo_letras=new File($FILE_NAME_CANTIDAD_LETRAS);
		archivo_letras.delete();
		FileWriter chanel_write=new FileWriter(archivo_letras,true);
		chanel_write.write(_letra_numero);
		chanel_write.close();







		// _letra_numero	

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


	public static String readFile(String filename) throws IOException
	{
		String content = null;
		File file = new File(filename); //for ex foo.txt
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader !=null){reader.close();}
		}
		return content;
	}



}