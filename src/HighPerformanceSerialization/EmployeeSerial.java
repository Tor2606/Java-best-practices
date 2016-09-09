package HighPerformanceSerialization;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by islabukhin on 09.09.16.
 */
public class EmployeeSerial implements Serializable {

    private static final long serialVersionUID = 3657773293974543890L;

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String position;
    private Date hireDate;
    private Double salary;
    private EmployeeSerial supervisor;
    private List<String> phoneNumbers;

    public EmployeeSerial() {
    }

    public EmployeeSerial(String firstName, String lastName, String socialSecurityNumber, String department, String position, Date hireDate, Double salary, EmployeeSerial supervisor, List<String> phoneNumbers) {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public EmployeeSerial getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(EmployeeSerial supervisor) {
        this.supervisor = supervisor;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public static byte[] serializeObject(Serializable object) throws Exception {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        byte[] res = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            oos.writeObject(object);
            oos.flush();

            res = baos.toByteArray();

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

    public static Serializable deserializeObject(byte[] rowObject) throws Exception {
        ObjectInputStream ois = null;
        Serializable res = null;

        try {

            ois = new ObjectInputStream(new ByteArrayInputStream(rowObject));
            res = (Serializable) ois.readObject();

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
