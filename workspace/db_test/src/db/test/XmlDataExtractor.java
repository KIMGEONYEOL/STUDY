package db.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDataExtractor {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document document = builder.parse("dbtest.xml");
            document.getDocumentElement().normalize();
            
            // Extract and print data
            printElementData(document, "TITLE");
            printElementData(document, "CNTC_INSTT_NM");
            printElementData(document, "COLLECTED_DATE");
            printElementData(document, "ISSUED_DATE");
            printElementData(document, "DESCRIPTION");
            printElementData(document, "IMAGE_OBJECT");
            printElementData(document, "LOCAL_ID");
            printElementData(document, "URL");
            printElementData(document, "EVENT_SITE");
            printElementData(document, "CONTRIBUTOR");
            printElementData(document, "PERIOD");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementData(Document document, String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String textContent = element.getTextContent().trim();
                System.out.println(tagName + ": " + textContent);
            }
        }
    }
}
