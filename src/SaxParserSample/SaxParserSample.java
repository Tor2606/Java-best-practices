package SaxParserSample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SaxParserSample extends DefaultHandler {
    private String filePath;
    private List<Book> books;
    private String tmpValue;
    private Book bookTmp;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

    public SaxParserSample(String filePath) {
        this.filePath = filePath;
        books = newArrayList();
        parseDocument();
    }

    public List getBooks() {
        return books;
    }

    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(filePath, this);
        } catch (ParserConfigurationException e) {
            System.out.println("Config exception." + e);
        } catch (SAXException e) {
            System.out.println("SAX exception." + e);
            ;
        } catch (IOException e) {
            System.out.println("IO exc." + e);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tmpValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            books.add(bookTmp);
        }
        if (qName.equalsIgnoreCase("isbn")) {
            bookTmp.setIsbn(tmpValue);
        }
        if (qName.equalsIgnoreCase("title")){
            bookTmp.setTitle(tmpValue);
        }
        if(qName.equalsIgnoreCase("author")){
            bookTmp.getAuthors().add(tmpValue);
        }
        if(qName.equalsIgnoreCase("price")){
            bookTmp.setPrice(Integer.parseInt(tmpValue));
        }
        if (qName.equalsIgnoreCase("regDate")){
            try {
                bookTmp.setRegDate(simpleDateFormat.parse(tmpValue));
            } catch (ParseException e) {
                System.out.println("Date parsing error");
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookTmp = new Book();
            bookTmp.setId(attributes.getValue("id"));
            bookTmp.setLang(attributes.getValue("lang"));
        }

        if (qName.equalsIgnoreCase("publisher")) {
            bookTmp.setPublisher(attributes.getValue("country"));
        }
    }

    public static void main(String[] args) {
        List<Book> books = new SaxParserSample("/home/islabukhin/IdeaProjects/Java-best-practice/src/SaxParserSample/books.xml").getBooks();
        books.stream().forEach((el) -> System.out.println(el.toString()));
    }
}
