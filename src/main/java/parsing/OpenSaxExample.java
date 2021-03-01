package parsing;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OpenSaxExample {

    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/java/parsing/file.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bName = false;
    boolean bYears = false;
    boolean bCountry = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("painter")) {
            String nr = attributes.getValue("nr");
            System.out.println("Nr : " + nr);
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("years")) {
            bYears = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("painter")) {
            System.out.println("Profession :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bYears) {
            System.out.println("Years: " + new String(ch, start, length));
            bYears = false;
        } else if (bCountry) {
            System.out.println("Country: " + new String(ch, start, length));
            bCountry = false;
        }
        }
    }
