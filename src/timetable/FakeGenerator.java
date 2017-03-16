/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cisco
 */
public class FakeGenerator {
    
    private static HashMap<String, Integer> respectiveCount = new HashMap<>();
    private static int initialcount = 0;
    
    public static void main(String args[]){
        
        //initialize some variables
        GlobalConstatts gc = new GlobalConstatts();
        respectiveCount.put("Eng", initialcount);
        respectiveCount.put("Kis", initialcount);
        respectiveCount.put("Maths", initialcount);
        respectiveCount.put("Agr", initialcount);
        respectiveCount.put("Business", initialcount);
        respectiveCount.put("Hsc", initialcount);
        respectiveCount.put("Cre", initialcount);
        respectiveCount.put("Hist", initialcount);
        respectiveCount.put("Geo", initialcount);
        respectiveCount.put("Chem", initialcount);
        respectiveCount.put("Bio", initialcount);
        respectiveCount.put("Phy", initialcount);

        HashMap<String, List<List<String>>> mapResults = new HashMap<>();
        
        
        //loop through classes
        for( String klass : GlobalConstatts.classes ){
            
            List<List<String>> result = new ArrayList<>();
            
        //loop through days
        for( String day : GlobalConstatts.days ){
            
              //loop through periods
              List<String> daysSelectedSubjectsList = new ArrayList<String>();
              
              for ( String period : GlobalConstatts.periods){
                  
                  //pick random subject
                  String selectedSubject = (GlobalConstatts.subjectsArray[new Random().nextInt(GlobalConstatts.subjectsArray.length)]);
                  //check whether subject already selected ---randomize again

                  
                  while(selectedSearch(daysSelectedSubjectsList, selectedSubject)){
                      
                       selectedSubject = (GlobalConstatts.subjectsArray[new Random().nextInt(GlobalConstatts.subjectsArray.length)]);
                       
                  }
                  
                  while( isLessonsExceeded(selectedSubject)){
                      selectedSubject = (GlobalConstatts.subjectsArray[new Random().nextInt(GlobalConstatts.subjectsArray.length)]);
                  }

                  daysSelectedSubjectsList.add(selectedSubject);
                  
                  

                  
              }//end periods loop
              
              //check for lessons exceeded
              result.add(daysSelectedSubjectsList);
            
        }//end days loop
        
        mapResults.put(klass, result);
        
    }//end classes loop


    List<List<List<String>>> lstt = new ArrayList<>();
    Iterator it = mapResults.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Object lst = pair.getValue();
        List<List<String>> ls = (List<List<String>>) lst;

         printOccurences(ls);
        for( List<String> lss : ls ){
            System.out.println("::::KEY:::" + pair.getKey() + ":::VALUES:::" + lss);
           
        }

    }

    }
    
    public static boolean selectedSearch(List<String> result, String selectedSubject){
        if(result.contains(selectedSubject)){
            return true;
        }
        return false;
    }
    
    public static boolean lessonsExceeded(List<List<String>> lst, String selectedSubject){
        
        int count = 0;
         for ( List<String> lstt : lst ){
            int occurrences = Collections.frequency(lstt, selectedSubject);
            count += occurrences;
            
        }

         System.out.println(lst);
         System.out.println("######### count ::::" + count);
         System.out.println("######### lessons ::::" + GlobalConstatts.lessonsPerWeek.get(selectedSubject));
        if(count >= GlobalConstatts.lessonsPerWeek.get(selectedSubject)){
            return true;
        }
        return false;
    }
    
    public static boolean isLessonsExceeded( String subject ){
        
        respectiveCount = updateCounts(respectiveCount, subject);
        

           int   occurences = respectiveCount.get(subject);
 
        int requiredOccurences = GlobalConstatts.lessonsPerWeek.get(subject);
        if( occurences > requiredOccurences){
            return true;
        }
        
        return false;
        
    }
    
    public static void printOccurences( List<List<String>> result){
        
        int count = 0;
        //loop through all subjects
        for( String subject : GlobalConstatts.subjectsArray){
            //loop through lists
        for ( List<String> lst : result ){
            int occurrences = Collections.frequency(lst, subject);
            count += occurrences;
            
        }
        System.out.println("----" + subject + "-----" + "=====" + count + "====");
        count = 0;
            
        }

        
    }
    
    
    public static void allignOutPut(List<List<String>> result){
        int count = 0;
        for( String subject : GlobalConstatts.subjectsArray){
            //loop through lists
            count = result.stream().map((lst) -> Collections.frequency(lst, subject)).map((occurrences) -> occurrences).reduce(count, Integer::sum);
            System.out.println("----" + subject + "-----" + "=====" + count + "====");
            //check exceeded
            if ( count >= GlobalConstatts.lessonsPerWeek.get(subject)){
                
            }
            count = 0;
            
        }
    }
    
    public static HashMap<String, Integer> updateCounts(HashMap<String, Integer> map , String subject) {
        //int count = map.get(subject);
        map.computeIfPresent(subject, (k, v) -> v + 1);
        return map;
    }
    
}

