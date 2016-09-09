package HighPerformanceSerialization;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by islabukhin on 09.09.16.
 */
public class EmployeeExternalisation implements Externalizable {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String position;
    private Date hireDate;
    private Double salary;
    private EmployeeExternalisation supervisor;
    private List<String> phoneNumbers;

    public EmployeeExternalisation() {
    }

    public EmployeeExternalisation(String firstName, String lastName, String socialSecurityNumber, String department, String position, Date hireDate, Double salary, EmployeeExternalisation supervisor, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.department = department;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.supervisor = supervisor;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeExternalisation getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(EmployeeExternalisation supervisor) {
        this.supervisor = supervisor;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(firstName);
        objectOutput.writeUTF(lastName);
        objectOutput.writeUTF(socialSecurityNumber);
        objectOutput.writeUTF(department);
        objectOutput.writeUTF(position);
        objectOutput.writeLong(hireDate.getTime());
        objectOutput.writeDouble(salary);

        byte[] attributeFlags = new byte[2];

        int attributeCount = 0;

        if (supervisor != null) {
            attributeFlags[0] = (byte) 1;
            attributeCount++;
        }
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            attributeFlags[1] = (byte) 1;
            attributeCount++;
        }

        objectOutput.write(attributeCount);

        byte[] attributes = new byte[attributeCount];

        int j = attributeCount;

        for (int i = 0; i < 2; i++)
            if (attributeFlags[i] == (byte) 1) {
                j--;
                attributes[j] = (byte) i;
            }

        objectOutput.write(attributes);

        for (int i = 0; i < attributeCount; i++) {
            byte attribute = attributes[i];

            switch (attribute) {
                case (byte) 0:
                    objectOutput.writeObject(supervisor);
                    break;
                case (byte) 1:
                    StringBuilder rowPhoneNumbers = new StringBuilder();
                    for (int k = 0; k < phoneNumbers.size(); k++)
                        rowPhoneNumbers.append(phoneNumbers.get(k) + ";");
                    rowPhoneNumbers.deleteCharAt(rowPhoneNumbers.lastIndexOf(";"));
                    objectOutput.writeUTF(rowPhoneNumbers.toString());
                    break;
            }
        }

    }


    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.firstName = objectInput.readUTF();
        this.lastName = objectInput.readUTF();
        this.socialSecurityNumber = objectInput.readUTF();
        this.department = objectInput.readUTF();
        this.position = objectInput.readUTF();
        this.hireDate = new Date(objectInput.readLong());
        this.salary = objectInput.readDouble();

        int attributeCount = objectInput.read();

        byte[] attributes = new byte[attributeCount];

        objectInput.readFully(attributes);

        for (int i = 0; i < attributeCount; i++) {
            byte attribute = attributes[i];

            switch (attribute) {
                case (byte) 0:
                    this.supervisor = (EmployeeExternalisation) objectInput.readObject();
                    break;
                case (byte) 1:
                    this.phoneNumbers = Arrays.asList(objectInput.readUTF().split(";"));
                    break;
            }
        }
    }


    public static byte[][] serializeObject(Externalizable object) throws Exception {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        byte[][] res = new byte[2][];

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            object.writeExternal(oos);
            oos.flush();

            res[0] = object.getClass().getName().getBytes();
            res[1] = baos.toByteArray();

        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if(oos != null)
                    oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }



    public static Externalizable deserializeObject(byte[][] rowObject) throws Exception {
        ObjectInputStream ois = null;
        String objectClassName = null;
        Externalizable res = null;

        try {

            objectClassName = new String(rowObject[0]);
            byte[] objectBytes = rowObject[1];

            ois = new ObjectInputStream(new ByteArrayInputStream(objectBytes));

            Class objectClass = Class.forName(objectClassName);
            res = (Externalizable) objectClass.newInstance();
            res.readExternal(ois);

        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if(ois != null)
                    ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return res;

    }

}
