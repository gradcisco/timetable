/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;
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
    
    public static void main(String args[]){
        StringBuffer sbuff = new StringBuffer();
        
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

                  sbuff.append(selectedSubject);
                  daysSelectedSubjectsList.add(selectedSubject);
              }//end periods loop
              result.add(daysSelectedSubjectsList);
              sbuff.append("####\n");
            
        }//end days loop
        mapResults.put(klass, result);
    }//end classes loop
        
     //   System.out.println(result.size() + "::::" + mapResults);

    List<List<List<String>>> lstt = new ArrayList<>();
    Iterator it = mapResults.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        Object lst = pair.getValue();
        List<List<String>> ls = (List<List<String>>) lst;
       // System.out.println("" + ls + "::::" + ls.size());
        //lstt.add(ls);
        for( List<String> lss : ls ){
            System.out.println("::::KEY:::" + pair.getKey() + ":::VALUES:::" + lss);
        }
            //System.out.println( "KEYYYY::::" + pair.getKey() + "VALUESSS::::" + ls );
        //System.out.println(mapResults.get(pair.getKey()));
        //System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
    
//    for ( List<List<String>> lss : lstt ){
//       // System.out.println(lss + ":::" + lss.size());
//    }
    }
    
    public static boolean selectedSearch(List<String> result, String selectedSubject){
        if(result.contains(selectedSubject)){
            return true;
        }
        return false;
    }
    
}
