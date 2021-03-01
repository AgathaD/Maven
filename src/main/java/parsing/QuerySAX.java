package parsing;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class QuerySAX {

        public static void main(String[] args) {

            try {
                File inputFile = new File("src/main/java/parsing/file.xml");
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                UserHandler1 userhandler = new UserHandler1();
                saxParser.parse(inputFile, userhandler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class UserHandler1 extends DefaultHandler {

        boolean bName = false;
        boolean bYears = false;
        boolean bCountry = false;
        String nr = null;

        @Override
        public void startElement(String uri,
                                 String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("painter")) {
                nr = attributes.getValue("nr");
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("years")) {
                bYears = true;
            } else if (qName.equalsIgnoreCase("country")) {
                bCountry = true;
            }
        }




        @Override
        public void characters(
                char ch[], int start, int length) throws SAXException {

            if (bName && ("1").equals(nr)) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bYears && ("1").equals(nr)) {
                System.out.println("Years: " + new String(ch, start, length));
                bYears = false;
            } else if (bCountry && ("1").equals(nr)) {
                System.out.println("Country: " + new String(ch, start, length));
                bCountry = false;
            }
        }
    }

