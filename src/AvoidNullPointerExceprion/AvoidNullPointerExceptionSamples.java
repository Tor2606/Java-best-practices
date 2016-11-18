package AvoidNullPointerExceprion;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class AvoidNullPointerExceptionSamples {
    public static void main(String[] args) {
        System.out.println(isFinished(null));
        System.out.println(getEmployees().size());

        //assure that null value not exist
        String myName = "Mahmud A. El-Sayed";
        List list = Collections.EMPTY_LIST;
        boolean exist = list.contains(myName);
        int index = list.indexOf(myName);
        boolean isEmpty = list.isEmpty();

        Map map = Collections.EMPTY_MAP;
        exist = map.containsKey(myName);
        exist = map.containsKey(myName);
        isEmpty = map.isEmpty();

        Set set = Collections.EMPTY_SET;
        exist = set.contains(myName);
        isEmpty = set.isEmpty();

        Iterator iterator = set.iterator();
        exist = iterator.hasNext();
        System.out.println(exist);


        String managerId = getManager(null);
        if(managerId != null){
            System.out.println(managerId.toString());
        }else{
            System.out.println("Null manager");
        }

        StringUtils.isNotEmpty(null);
        StringUtils.isBlank(null);
        System.out.println(StringUtils.equals(null, "something"));
    }

    private static Boolean isFinished(String status) {
        if("Finish".equalsIgnoreCase(status)){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public static List getEmployees(){
        List list = Collections.emptyList();
        //not list = null;
        return list;
    }


    private static String getManager(String s) {
        return s;
    }

}
