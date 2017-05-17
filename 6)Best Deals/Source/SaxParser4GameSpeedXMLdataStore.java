





import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




 public class SaxParser4GameSpeedXMLdataStore extends DefaultHandler {
    item it;
    public List<item> items;
    String consoleXmlFileName;
    String elementValueRead;


    public SaxParser4GameSpeedXMLdataStore(String consoleXmlFileName) throws IOException {
        this.consoleXmlFileName = consoleXmlFileName;
        items = new ArrayList<item>();
        parseDocument();
       // prettyPrint();
    }


    private void parseDocument() throws IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");}

    }


    private void prettyPrint() {

        for (item it: items) {
            	System.out.println("id:"+ it.id);
		System.out.println("retailer: " + it.retailer);
		System.out.println("name: " + it.name);
		System.out.println("Condition: " + it.condition);
		System.out.println("Price: " + it.price);
		for (String accessory: it.accessories) {
			System.out.println("accessory: " + accessory);
		}
        }
    }








    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("item")) {
            it = new item();
            it.setId(attributes.getValue("id"));
            it.setRetailer(attributes.getValue("retailer"));
        }

    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {

        if (element.equals("item")) {
            items.add(it);
	    return;
        }
        if (element.equalsIgnoreCase("image")) {
            it.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("name")) {
            it.setName(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("accessory")){
           it.getAccessories().add(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("price")){
            it.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
	if(element.equalsIgnoreCase("condition")){
            it.setCondition(elementValueRead);
	    return;
        }

    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }






}
