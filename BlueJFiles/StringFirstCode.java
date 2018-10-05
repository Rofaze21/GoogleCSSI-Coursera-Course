
/**
 * Write a description of StringFirstCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringFirstCode {

    public String findSimpleGene(String dna) {
       String geneFound = "";
        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1) {
return geneFound;
           
        }
       
       int stopCodon = dna.indexOf("TAA", startCodon);
        if(stopCodon == -1) {
return geneFound;
           
        }
       if((stopCodon - startCodon) % 3 == 0) {
           geneFound = dna.substring(startCodon, stopCodon);
           
        }

    
        return geneFound; 
        
    }
    
    public void testMyFunction() {
    dna = "AATATGFAJD"
    
}
}


