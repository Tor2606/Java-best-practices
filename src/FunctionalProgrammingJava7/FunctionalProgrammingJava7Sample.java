package FunctionalProgrammingJava7;

import JAXB_SAX_DOM_Performance.Person;
import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class FunctionalProgrammingJava7Sample {
    private List<PurchaseOrder> orders;
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        FunctionalProgrammingJava7Sample sample = new FunctionalProgrammingJava7Sample();
        sample.orders = newArrayList(new PurchaseOrder(person1), new PurchaseOrder(person2));
    }

    public List<PurchaseOrder> listOrdersByCustomer(Person customer){
        final List<PurchaseOrder> selection = newArrayList();
        for(PurchaseOrder order : orders){
            if(order.getPerson().equals(customer)){
                selection.add(order);
            }
        }
        return selection;
    }

    public List<PurchaseOrder> listRecentOrders(Date fromDate){
        final List<PurchaseOrder> selection = newArrayList();
        for(PurchaseOrder order : orders){
            if(order.getDate().equals(fromDate)){
                selection.add(order);
            }
        }
        return selection;
    }

    public List<PurchaseOrder> listOrders(Predicate<PurchaseOrder>condition) {
        final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
        for (PurchaseOrder order : orders) {
            if (condition.apply(order)) {
                selection.add(order);
            }
        }
        return selection;
    }

    final Person customer = new Person();
    final Predicate<PurchaseOrder> condition = new Predicate<PurchaseOrder>() {
        public boolean apply(PurchaseOrder order) {
            return order.getPerson().equals(customer);
        }
    };
}
