
/**
 * Write a description of Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.StorageResource;
public class Blue {
    
    
    
    public int findStopCodon(String dna, int startIndex, String stopCodon) {

    int startCodon = dna.indexOf("ATG", startIndex); //Find ATG
        //System.out.println("ATG: " + startCodon);
     int currIndex = dna.indexOf(stopCodon, startCodon + 3); //Find where the current Stop codon is
     
     while(true) {
         if(currIndex == -1) {
             break;
            }
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
        return -1;
    }
    
    
    return -1;
}
    
StorageResource getAllGenes(String oldDna) {
        // set variables currIndex and occurrence
        int atgIndex = -3;
        int minIndex = -3;
        String dna = oldDna.toUpperCase();
        StorageResource genes = new StorageResource();
        
        // look for "ATG" in dna as long as the end of the string has not been reached
        while (atgIndex != -1) {
            // look for "ATG" in dna
            atgIndex = dna.indexOf("ATG", minIndex+3);
            // if found, store in variable, otherwise return empty string
            if (atgIndex == -1) {
                break;
            }
            // find the stopCodon TAA
            int taaIndex = findStopCodon(dna, atgIndex, "TAA");
            // find the stopCodon TAG
            int tagIndex = findStopCodon(dna, atgIndex, "TAG");
            // find the stopCodon TGA
            int tgaIndex = findStopCodon(dna, atgIndex, "TGA");
            // return variable with gene in it
            minIndex = Math.min(Math.min(taaIndex, tagIndex), tgaIndex);
            if (minIndex == dna.length()) {
                break;
            }
            System.out.println();
            genes.add(dna.substring(atgIndex, minIndex+3));
        }
System.out.println(genes.data());
        return genes;
    }
    
    public void testProcess() {
          String ff ="ATGTGAGGACCTGA";
          System.out.println(getAllGenes(ff));
    }
}
