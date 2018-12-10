package wsHomologador;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class codigoQR_plus {
	
	
	public static void get(String xml_file_name, String qr_file_name, String _file_name) {
	//	String raya="------------------------------------------------";
		  try {

			  
			  
			  File fXmlFile = new File(xml_file_name);
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  			  
			  Document doc = dBuilder.parse(fXmlFile);
			  doc.getDocumentElement().normalize();
			  
			  String _RUC=_file_name.substring(0, 11);
			  String _TIPO_DOCUMENTO=_file_name.substring(12, 14);
			  String _TIPO_IDENT="6";
			  if (_TIPO_DOCUMENTO.equals("03")) {
				_TIPO_IDENT="1";  
			  } 
			  String _SERIE=_file_name.substring(15, 19);
			  String _FOLIO= _file_name.substring(20);
			  double _SUM_IGV=0;
			  double _TOTAL=0;
			  String _FECHA="";
			  
			  
			  
			  

				// cbc:TaxAmount
				NodeList nList_TaxAmount = doc.getElementsByTagName("cbc:TaxAmount");
				Node nNode_TaxAmount = nList_TaxAmount.item(0);
				_SUM_IGV=Double.parseDouble(nNode_TaxAmount.getTextContent());
							  
		  
				// cbc:PayableAmount
				NodeList nList_PayableAmount = doc.getElementsByTagName("cbc:PayableAmount");
				Node nNode_PayableAmount = nList_PayableAmount.item(0);
				_TOTAL=Double.parseDouble(nNode_PayableAmount.getTextContent());
				

				// cbc:IssueDate
				NodeList nList_IssueDate = doc.getElementsByTagName("cbc:IssueDate");
				Node nNode_IssueDate = nList_IssueDate.item(0);
				_FECHA = nNode_IssueDate.getTextContent();

				NodeList nodeList_AccountingCustomerParty = doc.getElementsByTagName("cac:AccountingCustomerParty").item(0).getChildNodes();
				Node nNode_AccountingCustomerParty = nodeList_AccountingCustomerParty.item(0);
				String _RUC_RECEPTOR=nNode_AccountingCustomerParty.getTextContent().substring(0, 11);
			  
				String _contenido_qr = _RUC+"|"+_TIPO_DOCUMENTO+"|"+_SERIE+"|"+_FOLIO+"|"+_SUM_IGV+"|"+_TOTAL+"|"+_FECHA+"|"+_TIPO_IDENT+"|"+_RUC_RECEPTOR;
				
			  
//				String _contenido_qr = _RUC+"|"+$TIPO_DOCUMENTO+"|"+$SERIE+"|"+$NUMERO+"|"+$SUM_IGV+"|"+
//						myCabecera.get_importe_tot()+"|"+myCabecera.get_fecha()+"|"+
//						myCabecera.get_ident()+"|"+myCabecera.get_num_ident();

			  
			  // DigestValue
			  NodeList nList_DigestValue = doc.getElementsByTagName("DigestValue");
			  Node nNode_DigestValue = nList_DigestValue.item(0);
			  System.out.println("" + nNode_DigestValue.getNodeName());
			  System.out.println("Generando Codigo QR.");
			  		  
			  String filePath = qr_file_name;
	  			int size = 500;
	  			String fileType = "png";
	  			File qrFile = new File(filePath);
	  			_contenido_qr=_contenido_qr+"|"+nNode_DigestValue.getTextContent();
	  		
	  		
	  	//	String _contenido_qr=qr_value;
	  		createQRImage(qrFile, _contenido_qr, size, fileType);
	 // 		System.out.println("QR CODE WAS GENERATE. "+qr_file_name);

			 
			
			  
			  
		  } catch (Exception e) {
		  		e.printStackTrace();
	    	}
	}

	
	
	private static void createQRImage(File qrFile, String qrCodeText, int size,
			String fileType) throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable hintMap = new Hashtable();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,
				BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,
				BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}	

	
	
}
