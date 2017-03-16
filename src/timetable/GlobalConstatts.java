/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import com.sun.xml.internal.ws.api.ha.HaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author cisco
 */
public class GlobalConstatts {
   public static  String[] subjectsArray = {"Eng","Kis","Maths","Agr","Business","Hsc","Cre","Hist","Geo","Chem","Bio","Phy"};
    
    public static String[] periods = {"8-9","9-10","10-11","11-12","12-1","1-2","2-3","3-4","4-5"};
    
    public static String[] classes = {"1","2","3","4"};
    
    public static String days[] = {"Mon","Tue","Wed","Thurs","Frid"};
    
    public static HashMap<String,Integer> lessonsPerWeek = new HashMap<String, Integer>();
    
    public static List<List<String>> output = new ArrayList<>();
    
    public GlobalConstatts(){
        lessonsPerWeek.put("Eng", 5);
        lessonsPerWeek.put("Kis", 5);
        lessonsPerWeek.put("Maths", 6);
        lessonsPerWeek.put("Agr", 4);
        lessonsPerWeek.put("Business", 4);
        lessonsPerWeek.put("Hsc", 4);
        lessonsPerWeek.put("Cre", 3);
        lessonsPerWeek.put("Hist", 3);
        lessonsPerWeek.put("Geo", 3);
        lessonsPerWeek.put("Chem", 4);
        lessonsPerWeek.put("Bio", 4);
        lessonsPerWeek.put("Phy", 4);
    }
    
}
