package UsingJAXBToGenerateXMLFromXSD;

/**
 * Created by islabukhin on 15.09.16.
 */

import javax.xml.bind.JAXBException;

public class GenerateXML{
    public static void main(String[] args) throws JAXBException {
/*
        ObjectFactory factory = new ObjectFactory();

        UserT user = factory.createUserT();
        user.setUserName("Sanaulla");
        ItemT item = factory.createItemT();
        item.setItemName("Seagate External HDD");
        item.setPurchasedOn("August 24, 2010");
        item.setAmount(new BigDecimal("6776.5"));

        ItemListT itemList = factory.createItemListT();
        itemList.getItem().add(item);

        ExpenseT expense = factory.createExpenseT();
        expense.setUser(user);
        expense.setItems(itemList);

        JAXBContext context = JAXBContext.newInstance("generated");
        JAXBElement<ExpenseT> element = factory.createExpenseReport(expense);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.marshal(element, System.out);*/
    }

}