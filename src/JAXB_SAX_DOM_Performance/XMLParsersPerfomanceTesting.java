package JAXB_SAX_DOM_Performance;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParsersPerfomanceTesting {
    private static final String FILEPATH = "/home/islabukhin/IdeaProjects/Java-best-practice/src/JAXB_SAX_DOM_Performance/file.xml";

    @Test
    public void unMarshallUsingJAXB() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PersonList personList = (PersonList) unmarshaller.unmarshal(new File(FILEPATH));
        System.out.println(personList.getPersons().get(0).getName());
    }

    @Test
    public void unMarshallWithStAX() throws FileNotFoundException, JAXBException, XMLStreamException {
        FileReader fr = new FileReader(FILEPATH);
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(fr);
        PersonList list = (PersonList) unmarshaller.unmarshal(xmlStreamReader);
        System.out.println(list.getPersons().get(1).getName());
    }

    @Test
    public void unMarshallingWithStreamsource() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StreamSource source = new StreamSource(new File(FILEPATH));
        PersonList list = (PersonList) unmarshaller.unmarshal(source);
        System.out.println(list.getPersons().get(2).getName());
    }

    @Test//do not work properly
    public void parsingWithDomTest() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document doc = builder.parse(FILEPATH);
        List<Person> personsAsList = new ArrayList<>();
        NodeList persons = doc.getElementsByTagName("person");
        for (int i = 0; i < persons.getLength(); i++) {
            Node person =  persons.item(i);
            NodeList children = person.getChildNodes();
            Person newPerson = new Person();
            for (int j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if(child.getNodeName().equalsIgnoreCase("id")){
                    newPerson.setId(child.getNodeValue());
                }else if(child.getNodeName().equals("name")){
                    newPerson.setName(child.getNodeValue());
                }
            }
            personsAsList.add(newPerson);
        }
        System.out.println(personsAsList.get(0));
    }

    @Test//The Fastest parser(+ it works)
    public void parsingWithSaxTest() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        final  List<Person> persons = new ArrayList<>();
        DefaultHandler defaultHandler = new DefaultHandler(){
            boolean bpersonId = false;
            boolean bpersonName = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes){
                if(qName.equalsIgnoreCase("id")){
                    bpersonId = true;
                    Person person = new Person();
                    persons.add(person);
                }else if(qName.equalsIgnoreCase("name")){
                    bpersonName = true;
                }
            }

            public void endElement(String uri, String localName, String qName) {

            }

            public void characters(char ch[], int start, int length){
                if(bpersonId){
                    String personID = new String(ch, start, length);
                    bpersonId = false;
                    Person person = persons.get(persons.size()-1);
                    person.setId(personID);
                }else if(bpersonName){
                    String name = new String(ch, start, length);
                    bpersonName = false;
                    Person person = persons.get(persons.size()-1);
                    person.setName(name);
                }
            }
        };
        saxParser.parse(FILEPATH, defaultHandler);

        System.out.println(persons.get(0).getName());
    }
}
