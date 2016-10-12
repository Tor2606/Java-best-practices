package JAXB_SAX_DOM_Performance;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "persons")
public class PersonList {
    @XmlElement(name = "person")
    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersons() {
        return personList;
    }

    public void setPersons(List<Person> persons) {
        this.personList = persons;
    }
}
