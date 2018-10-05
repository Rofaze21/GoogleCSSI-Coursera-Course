
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Find gene where stop codon can be TAA TGA or TAG
//Find 
/*
   
   3. Write the method findStopCodon that has three parameters, a String parameter named dna, an integer parameter named startIndex that represents
   where the first occurrence of ATG occurs in dna, and a String parameter named stopCodon.This method returns the index of the first occurrence of 
   stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns
   the length of the dna strand.

4. Write the void method testFindStopCodon that calls the method findStopCodon with several examples and prints out the results 
to check if findStopCodon is working correctly. Think about what types of examples you should check. For example, you may want
 to check some strings of DNA that have genes and some that do not.
 What other examples should you check?
   */
public class part1 {

    public String StringsFirstAssignments(String string) {
        String dnaStrand = string.toUpperCase();
       
         int startCodon = dnaStrand.indexOf("ATG");
        int stopCodon = dnaStrand.indexOf("TAA", startCodon + 3);
        
        if (startCodon == -1) {
            return "";
        }
          if (stopCodon == -1) {
            return "";
        }
      
        String gene = dnaStrand.substring(startCodon, stopCodon+3);
          if ((gene.length()) % 3 == 0) {
        return gene;
    } else {
        
        return "not Found";
    }
    
 
    
}

public int findStopCodon(String dna, int startIndex, String stopCodon) {

    
    int startCodon = dna.indexOf("ATG", startIndex);
     int currIndex = dna.indexOf(stopCodon, startCodon+3);
     
     while(currIndex != -1) {
         if ((currIndex - startCodon) % 3 == 0) {

             return currIndex;
            }
         else {
             currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
         //Check startIndex to CurrIndex is multiple of 3
            //Return the first Gene in String form 
         //If not multiple of 3
            //Set Curr Index to 
         
        }
    
    if (dna.indexOf(stopCodon) == -1) {
        return dna.length();
    }
    
    
    
   // System.out.println("The Gene ais " + findStopCodon(a,0,"TAA"));
      //      System.out.println("The Gene bis " + findStopCodon(b,0,"TAA"));
        //    System.out.println("The Gene cis " + findStopCodon(c,0,"TAA"));
     //If no  StopCodons found > Return length of DNA
    //Check from Startcodon+3 till stopCodon to see if it exists. 
    //If it exists do StopCodon - startcodon and see if it is a multiple of 3
    //If multiple of 3 > Return index of occurse
    //If not multiple of 3 > Search Again
    return -1;
}

public String findGene(String dna) {
    String geneFound = "";
    int startCodon = dna.indexOf("ATG");
    if (startCodon == -1) {
        return geneFound;
    }
    
    int taaCodon = findStopCodon(dna, 0, "TAA"); //9
    int tgaCodon = findStopCodon(dna, 0, "TGA"); //159
    int tagCodon  = findStopCodon(dna, 0, "TAG"); //-1
         int temp = 0;
         int smallestInt = 0;
         if(taaCodon == -1) { //If TAA doesnt exist
             temp = tgaCodon;
          
       if (tagCodon != -1 && temp == -1) { // TAG exists, temp doesnt 
           smallestInt = tagCodon;
        }
       
        if(tagCodon == -1 && temp != -1){ //If tag doesnt exist, temp exists
            smallestInt = temp;
        }
        
        if(tagCodon != -1 && temp != -1) { //if tag does exist, temp does exist too
            smallestInt = Math.min(tagCodon, temp);
            
        }
        
        
            }
            
            if(taaCodon != -1 && tgaCodon == -1) { //IF TAA Exists and TGA doesnt exist 
                temp = taaCodon;
                
                 if (tagCodon != -1) { //If TAG exists
           smallestInt = Math.min(tagCodon, taaCodon);
        }
       
        if(tagCodon == -1){ //If tag doesnt exist
            smallestInt = taaCodon;
        }
     
            }
            
            if(taaCodon != -1 && tgaCodon != -1) {
                temp = Math.min(taaCodon, tgaCodon);
                
              if (tagCodon == -1) {
                  smallestInt = temp;
                }
                  if (tagCodon != -1) {
                  smallestInt = Math.min(temp, tagCodon);
                }
            }
            
            
         if(smallestInt == -1 ) {
             return "No String Found";
            }
            
            geneFound = dna.substring(startCodon, smallestInt+ 3);
          return  geneFound;
  
}
      public void testSamples() {
          
          //String a = "AATGCTAACTAGCTGACTAAT";
         // String b = "ATGGGACCGATATAACGGATCAAATGTTACG";
        //  String c= "ATGTAA";
          
         // String d = "ATGAsABTGATGTAATAA";
         // System.out.println("The TGA Found in ais " + findStopCodon(a,0,"TGA"));
        /////  System.out.println("The Gene ais " + findGene(a));
         // System.out.println("The Gene bis " + findGene(b));
        //   System.out.println("The Gene cis " + findGene(c));
           System.out.println("Mystry" + mystery("HELLOTHITBETET"));
                              
            
        }
public String mystery(String dna) {
  int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}
        
    }
    

        
        
   

