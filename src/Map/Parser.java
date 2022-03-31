package Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.util.LinkedList;

/**
 * Parser
 */
public class Parser {

    private static final String FILENAME = "assets/Map.xml";
    private static final String FILENAMEX = "assets/Map.xsd";
    private String length;
    private LinkedList<Integer> arr = new LinkedList<>();

    public int getLength() {
        return Integer.parseInt(length);
    }

    public LinkedList<Integer> getTableList() {
        return arr;
    }

    public Parser() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = schemaFactory.newSchema(new File(FILENAMEX));
            dbf.setSchema(schema);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Schema File Not Correct!");
        }

        try {
            dbf.setValidating(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("Row");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    length = element.getAttribute("length");

                    for (int i = 0; i < Integer.parseInt(length); i++) {
                        String key = element.getElementsByTagName("int").item(i).getTextContent();
                        arr.add(Integer.parseInt(key));
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("Not a valid map format. Change the XML map file to conform with the XSD file.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Uh-oh, check your file path!");
        }
    }
}