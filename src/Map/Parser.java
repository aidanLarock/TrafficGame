package Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.util.LinkedList;

/**
 * The parser class simply validates the schemea from the XSD file and builds a
 * map from the given schema using the XML file.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see TrafficMain
 * @see Graph
 */
public class Parser {

    private static final String FILENAME = "../assets/Map.xml"; // build use ../assets/Map.xml
    private static final String FILENAMEX = "../assets/Map.xsd";
    private String length;
    private LinkedList<Integer> arr = new LinkedList<>();

    /**
     * This method returns the length of a row.
     * 
     * @return an integer of the length of row.
     */
    public int getLength() {
        return Integer.parseInt(length);
    }

    /**
     * Creates a dynamically sized array with the sizes
     * of the road segments.
     * 
     * @return A linkedlist containing the road values.
     */
    public LinkedList<Integer> getTableList() {
        return arr;
    }

    /**
     * This constructor does the heavy lifting in parsing and proccessing the data.
     */
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