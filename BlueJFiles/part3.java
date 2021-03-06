
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.StorageResource;
import edu.duke.FileResource;

public class part3 {

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

public String findGene(String dna) {

    String geneFound = "";
    int currIndex = 0;
    int startCodon = dna.indexOf("ATG", currIndex);
    //System.out.println("ATG: " + startCodon);
    if (startCodon == -1) {
        return "Not Found";
    }
    //ATGGGACCGATATAACGGATCAAATGTTACG
    //^^^         ^^^        ^^^        
    int taaCodon = findStopCodon(dna, 0, "TAA"); //12
    //System.out.println("TAA Codon is at " + taaCodon);
    int tgaCodon = findStopCodon(dna, 0, "TGA"); //-1
    //    System.out.println("Tga Codon is at " + tgaCodon);
    int tagCodon  = findStopCodon(dna, 0, "TAG"); //-1
     //   System.out.println("Tag Codon is at " + tagCodon);
       
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
            
            if(taaCodon != -1 && tgaCodon != -1) { //if tag exists, and tga exists
                temp = Math.min(taaCodon, tgaCodon);
                
              if (tagCodon == -1) { //if tag does not exist
                  smallestInt = temp;
                }
                  if (tagCodon != -1) { //if tag exists
                  smallestInt = Math.min(temp, tagCodon);
                }
            }
            
    
         if(smallestInt == -1 ) {
             return "No String Found";
            }
            
        //    System.out.println("smallest int is" + smallestInt);

            
            if(smallestInt > 0 && smallestInt > startCodon) {
                geneFound = dna.substring(startCodon, smallestInt + 3); //
                //System.out.println(findGene(dna.substring(smallestInt)));
            }
             
          return  geneFound;
  
}

public String printAllGenes(String dna) {
   

    int currIndex = 0;
    
    int accumlator = 0;
while(true) {
        
        int startCodon = dna.indexOf("ATG", accumlator);
       // System.out.println("accumlator " + accumlator);
//System.out.println( "Start Codon Value is " + startCodon);
        String currentGene = findGene(dna.substring(startCodon, dna.length()));
        
       System.out.println("currentGene is " + currentGene);
        
      int  currentFoundGene = currentGene.length();
     //  System.out.println("Current Found Gene's Length is " + currentFoundGene);
       
        //      accumlator = accumlator + currentFoundGene;
       // System.out.println("accumlator " + accumlator);
               startCodon = dna.indexOf("ATG", accumlator+3);
            accumlator = accumlator + (startCodon - accumlator);


      // System.out.println("accumlator " + accumlator);
        //System.out.println("New Start Codon is " + startCodon);
    if(currentFoundGene == 0) {
           
            break;
        }
    
    
    }
    return "Strings returned";
}
public int countAllGenes(String dna) {
   
//ATGGGACCGATATAACGGATCAAATGTAACG
    int currIndex = 0;
    int genesFound = 0;
    //String geneFound = "";
    while(true) {
        
        int startCodon = dna.indexOf("ATG", currIndex);
        

        String currentGene = findGene(dna.substring(startCodon, dna.length()));
        
        System.out.println("Found genes " + currentGene);
        if (currentGene.isEmpty() == false ) {
            genesFound ++;
        }
      int  currentFoundGene = currentGene.length() - startCodon;

       currIndex = dna.indexOf("ATG", currentFoundGene);
       startCodon = dna.indexOf("ATG", currIndex);
       
    if(startCodon == 0) {
            //Not FOUND
            //System.out.println("NOT FOUND! ");
            break;
        }
    
      
    }
    return genesFound;
}


public StorageResource getAllGenes(String dna) {

   StorageResource genes = new StorageResource();
   
    int currIndex = 0;
    
    int accumlator = 0;
while (true) {
        int startCodon = dna.indexOf("ATG", accumlator);
       // System.out.println("accumlator " + accumlator);
//System.out.println( "Start Codon Value is " + startCodon);
        String currentGene = findGene(dna.substring(startCodon, dna.length()));
        genes.add(currentGene);
      // System.out.println("currentGene is " + currentGene);
        
      int  currentFoundGene = currentGene.length();
     //  System.out.println("Current Found Gene's Length is " + currentFoundGene);
       
        //      accumlator = accumlator + currentFoundGene;
       // System.out.println("accumlator " + accumlator);
               startCodon = dna.indexOf("ATG", accumlator+3);
            accumlator = accumlator + (startCodon - accumlator);
 
    if(currentFoundGene == 0) {
           
            break;
        }
    }
    System.out.println(genes.data());
    return genes;
}


public float cgRatio(String dna) {
    float cNumber = 0;

    float gNumber = 0;
    
int currIndexC = 0;
int currIndexG = 0;

while(true) {
 
    if (dna.indexOf("C", currIndexC) == -1) {
        break;
    }
    currIndexC = dna.indexOf("C", currIndexC) + 1;
    cNumber = cNumber + 1;

 
//System.out.println("c is " + cNumber);
//System.out.println("currindexC is " + currIndexC);

}

while(true) {
    
     if (dna.indexOf("G", currIndexG) == -1) {
        break;
    }
 currIndexG = dna.indexOf("G", currIndexG) + 1;
gNumber = gNumber + 1;

 
//System.out.println("g is " + gNumber);
//System.out.println("currindexG is " + currIndexG);
}


    return cNumber/gNumber;
        
        
    }
    /*
     * print all the Strings in sr that are longer than 9 characters
print the number of Strings in sr that are longer than 9 characters
print the Strings in sr whose C-G-ratio is higher than 0.35
print the number of strings in sr whose C-G-ratio is higher than 0.35
print the length of the longest gene in sr

     */
    public void processGenes(String file) {
StorageResource sr = getAllGenes(file);
                            System.out.println(sr.data());
int countLessThan9Strings = 0;
int cgRatioHigher = 0;
int longerThan60 = 0;
int totalGenes = 0;
String longestGene = "";

        for(String s : sr.data()) {
                            System.out.println("adding to Total Genes");
totalGenes ++;
              if(s.length() > 9) {
                System.out.println(s);
            
            }
                        if(s.length() < 9) {
                            countLessThan9Strings ++;
                                                        System.out.println("Counting less than 9 strings");
                            //make sure to return this number later
                        }
                        if(cgRatio(s) > .35) {
                                            System.out.println("CG Ratio is > .35 " + s);
                                            cgRatioHigher ++;
                      }
                         if (s.length() > longestGene.length()) {
                             longestGene = s;
                            }
                            if (s.length() > 60) {
                             longerThan60 ++;
                            }
             
        }
                System.out.println("Total Genes:  "  + totalGenes);
        System.out.println("Longer than 60: "  + longerThan60);
        System.out.println("cgRatio of Strings higher than .35 is "+ cgRatioHigher);
                System.out.println("Strings that are less than 9 are " + countLessThan9Strings);
                System.out.println("Longest Gene is " + longestGene);
    }
    

public void testProcessGene() {
    FileResource fr = new FileResource("NewFile.fa");
String dna = fr.asString();
String dna1 = dna.toUpperCase();
//System.out.println(dna1);
    String a = "ATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGAATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGA";
  String b = "AACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTCACCCTTCTAACTGGACTCTGACCCTGATTGTTGAGGGCTGCAAAGAGGAAGAATTTTATTTACCGTCGCTGTGGCCCCGAGTTGTCCCAAAGCGAGGTAATGCCCGCAAGGTCTGTGCTGATCAGGACGCAGCTCTGCCTTCGGGGTGCCCCTGGACTGCCCGCCCGCCCGGGTCTGTGCTGAGGAGAACGCTGCTCCGCCTCCGCGGTACTCCGGACATATGTGCAGAGAAGAACGCAGCTGCGCCCTCGCCATGCTCTGCGAGTCTCTGCTGATGAGAACACAGCTTCACTTTCGCAAAGGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCCCGAACCCGAACCCTAATGCCGTCATAAGAGCCCTAGGGAGACCTTAGGGAACAAGCATTAAACTGACACTCGATTCTGTAGCCGGCTCTGCCAAGAGACATGGCGTTGCGGTGATATGAGGGCAGGGGTCATGGAAGAAAGCCTTCTGGTTTTAGACCCACAGGAAGATCTGTGACGCGCTCTTGGGTAGAGCACACGTTGCTGGGCGTGCGCTTGAAAAGAGCCTAAGAAGAGGGGGCGTCTGGAAGGAACCGCAACGCCAAGGGAGGGTGTCCAGCCTTCCCGCTTCAACACCTGGACACATTCTGGAAAGTTTCCTAAGAAAGCCAGAAAAATAATTTAAAAAAAAATCCAGAGGCCAGACGGGCTAATGGGGCTTTACTGCGACTATCTGGCTTAATCCTCCAAACAACCTTGCCATACCAGCCCATCAGTCCTCTGAGACAGGTGAAGAACCTGAGGTCGCAGGAGGACACCCAGAAGGTCCAGAGAGAGCCTCCTAGGCCCCCCACCTCCCCCCGTGGCAGCTCCAACCCCAGCTTTTTCACTAGTAAGGCAGTCGGGCCCCTGGGCCACGCCCACTCCCCCAAGCGGGGAAGGAGCTTCGCGCTGCCGCTTGGCTGGGGACTGGGCACCGCCCTCCCGCGGCTCCTGAGCCGGCTGCCACCAGGGGGCGCGCCAGCGGTGTCCGGGAGCCTAGCGGCGCGTGTGCAGCGGCCAGTGCACCTGCTCTGGCCCTCGCCGCGGTCTCTGCCAGGACCCCGACGCCCAGCCTGACCCTGCCATTCAGCGGGGCTGCGGCTCCACGGCCTGCGACAGCAGCCCCACCTGGCATTCAGCGCGCTCCCGGGGGCAGAGGTCGCGGTGTCCTCACGCTGTGGTGCCGGCCTACAACCCCCACGCCGGGCTCGGGCCCGGCGGAGGAGGGCGATGCTCCCCGGGTAGGACAAACCGGTCACCTGGGCTGCGACGGCGGCTTAGGGGCAGAAGCGGCGGTCCAGGGCCGCCTGGCGCAGCAGCCTGTCCCAGCCGCGGTCCCTGCAGTCCCTCCCTGGCGGCTGCGCAGCCGTCCCACGACAGGGGCCATAAACTCTCCAGAGCGGAAAGCCGCACCCTGGTGGCCCGGCCCCGCGCCCAGACCTGGCGGCCGCTGGCACCTGACCCGCTGCATGGGTCTCCAGGGAGCTCGCTGCCCACCCGGCGCTGCAGGCTCGGCTCCCTCGTACACTCTCTGGTAGGTGCTAGGGACGACCCTATGGGCCAGCTTGCCATGCCCAGTCCCCAGGCCGCACCCACCCTGGCTCCCTGGGCTAGGGGACTGGCTCCTCCTGTGAGTCGTGGGTCTGGGAGGCAGGGGCGTTAGGGGAGAGTGAGGGACCGAGGGCAGCCCCTGCTGTGTGCACAGCGAGGTCGTGCACAGGCGTCTGTTGCAGAGCGTGCAGCTTCAGATGAGACTGGATTGCAGGTGGAGATGACTGTGGGTGCGCACACCTGGAGGTGAAGGGGAGGCAGCCTGTCTACCTGACCCATGAAATACAGGAGACTGTACCCCAGAAGCAGCGGGTTCACTGCTCCATTGATTAAGCAAGTCTGGGACACACATGTAGCTAAGCTGTGAGTTCTGTACCAGCGATCCCAACACCCACGCCCTCAGAAAGACACTGGTGTGGGGCCTGGGTGCTTGTCAGGCCTGAAAGTGGAGAGCACGGGCCAGAGACACTGAGTAGGGGGAACCCACCCTAGGGCTCTGAGGGACGACGATGTGGGGAGCTGGTGACAGAGCCTGAGCTGGCCCAATGTTGCACGGTGGGGACAGATTCGAGGTACAGTGGGGACTGGTGACCTCAGTTCCCAGTGTCCCAGCCTGGCCTCCCAGTCCACCCAGCAATTAGTGGGTGCTGCCCTGCAAAGACTCTGGGGGTGCCTCAGCCCTCCTCATCACACGTGACTGGTGACTTCTGTGTCCACCCGCACAATAAGAGGGATCTTCTCTCACTTTCAGGCAAGCCCAAGAAAGTCAGGGGCCTATGTGAGCCAAAGAGGAGAGAAGGTGATGCCTCAGCCCAGTGTTTCTGCCCCACCTCGCTTGTGGCCTTCGGAACTTGATTTGCACCGCAGGAAAATGGGCAATGAAAACCCCTCCCTAACTGGCTTCTCAGTCCACTCTGACCAGCCCACTGCACAGCGCCCACCCTGCAGCTCCAGGTACAGAGGCTGGGATGGCTCTGGGCTGACCTAAGGGCCTTCTGATGGCTCCAACCCTCGGGATGCCTCATGCTCACCCTTTGGCACCCACCTGACAGCTCAGCATCTCTGCTCTCTGCCATCCTCAATGCCTGCTCTAGACAAGCCCAAGTCCCCCAGGAGTGGCAGAGGGAACTGAGCCGAAAACTAAGTCTCGGCTCACTGAACCCCAAGTGGGCTGTCCAGCCTCGCCCTTCAGTTCACAACCCCAGGCAGGTTCCCTCCAGGGATGTGATCCCAGGGGCCACAGCAGCACATTCTGGCCTAACCTATCCACTATTTAAACAGTTACTGAAAAGGCCAGGATGGCCGTGGGCCCTGACATTAATCCCCTTTCTCTGTGAGGGGGCTGGGTTGGGTTTGCCATCCTGATGTCTTTGTGGAAAGAGCTGGCAGGTGAAGCAAGTCTCAGGGGCCAGCCATGGGACAAGGAACCTAGGACTGGCCTCTGCTGGAACCCTCTGAGGCCCCTGCGGACAGGAGGATCCAATGGAGGTCTAGCCACCCCTCCCAGGTTGGTGCTCACAGCCCCTCCCTGGCCCACTCCCTGCACACCTGCACCTGCTGGTCTCTGGGAGAGGAGCATCCATCCATCTTGTGCGCATAGCTTTCGGCTCCATTTTCATGAGGATGGTCTCCTTGGCAGAAATGCCCATTAGGGGATCCTGAGCCTGTGCTAGCTCTTCTCTAAGTGCCAAAGCCAGTGAGAGGGACTTGAAAACTCAAGACTTATTAACAGTATTTTCTGCATTTTGTGCTTTCAGGGTTGTTTTTTCCTTAAAATGTGTAAAAACAAACATTGAGATTTCTATCTTTTATATAATTTGGATTCTGTTATCACACGGACTTTTCCTGAAATTTATTTTTATGTATGTATATCAAACATTGAATTTCTGTTTTCTTCTTTACTGGAATTGTTAACTGTTTTATAGGCCAAATCTTTTAAAAAAAACACATCTCTCTAATTTCTCTAAACATTTCTAATTACATATATATTTACTATACCTAATACACTACTTTGGAATTCCTTGAGGCCTAAATGCATCGGGGTGCTCTGGTTTTGTTGTTGTTATTTCTGAATGACATTTACTTTGGTGCTCTTTATTTTGCGTATTTAAAACTATTAGATCGTGTGATTATATTTGACAGGTCTTAATTGACGCGCTGTTCAGCCCTTTGAGTTCGGTTGAGTTTTGGGTTGGAGAATTTTCTTCCACAAGGGATTGTCTTGGATTTTTCTGTTTCTCCCTCAATATCCACCTGGAAAACATTTCAATTAATTTATATTTACTTAAATATTTCTGTGCAAAAACTGTGTACAAAAGCCCCAAAGCATAATTTGTGCAGTTGAGCGCATGTTCTGTTGTTCAGCATTTATGGTGGTTGGTAGTGGAAAAGATTTTTAGAATATGTGGATTTTCGGGATATTCCCAGAAGCCCAGATAGCGACACTTTACCTTTGGAGGAATTACTTCTCAGAATATTGCACACAATCAATCGCCTTTGGAAGGAGCATATATCCCCAGCAAAAGCTCTGGTTTTTTGAAGTCTGTATTGTGTGTTACTTCCAGGAGAATATGCAATGATGACAATGTTATTAGATGATTCAAATATGAAGTGCTGTTATGCCAAACAATGAATCTTTGTGTTATACATTATGCCTAACTATAAATCTTTGTGTTATACATTTTAATGTCATTGGAGAGTACTCCTGTCTTCTTGGCATTATTGATAATTAGATTCTAATTGCTAATAAGTCAGAAAAATTAGGAACACCAAATTTCAGTTGTCTCAAAAGCACTCCTCTTATTAAATTTGGATGTTTACCTTTATCACATCAAAAGAAATATTGTTAGAAAGGTGTTTAATGTTTTGCAGATGGATAGATTACTGTTATTAGTTCTCATTTCATTGTTAATTTTTAAAACCATAAGGTTGGAAGTATCAATATGCCTTTCAATATACCTTAGTGGAATTTATTAAATTTTCATGGATGTCCTTTAGGGGGTTCAGGAAGTTATTTCTATTGCTAGATTTCTGGAAGATTTATCAGGAATGAGTGTCAGACATTGTCAGACGTCCATTGAAATCATCATGGTCTTTTCCTTTATTCTATTAATATGATGTATTACACTGATTGATTTTTAAATTTGTATTGGTAGGATAATTCCACTTGGTTATATTGTCTAACTTTTTTCTAATTTTCTTTCATTTTTATTACAGATGAGGCCTCACTCTGTCACCCAGGTTGGGGTGGAGTGGCACAGTCACAGCTCACTATAACCTCAAGCTCCTGGGCTCAAGTGATCCTGCCACCTCAGCCTCCTAAGTAGCTGGAACTACAGATGTGCACTGCCATGCCAGGCTTGTCTAACATTTTTATGTGTTGCTTCATCCAGTTTGCTAGAGTTTTTGGAGATTTCTGTCTTCATTCATGAGGGATAATAGTCTGCACTTTTATTTTCTTGTGATACTTTTGTCTGATTTGTTATCTGGGTAATACTGGCCTTGAAAATGAATTGATGTTTTCCTGCTTCTCTGCTTTGCAAGTGTTTGTGAAGGATTGGTTATTCATTAAGTGTTTAATAGAATTCACTAGTGAAGCTATGTGAGCCAGGGCTAGACTGATGAAGAGTTTTCATTAGTCTAATCTGTTTACTTGCTGTATAAGTACGCATATATTCTCTTTCTTCTTGATTTAATTTTACACTTTGTGTATAGCAGGGAATCTGTGTCTAATTTGTAGTATTTCATGCTTCTAGGTTTTCATGGCAGTTGAGATGTAAGAATAACAATAATGTTGGGAGAAGGAAGTTGTGGACAATCCATGAATATCCCAACATCTGTTGTAGGAAGGTTAAGATTACTTTTTTTTTTTTTGCTGTACTGAACTGAATACTCTTATTTATAATGTCAGACAAATGTAATGTTGTATATAAATAGAACTAGGAAAATGTGCCATTTGTCTTAGTATTTAATCAAGATGGAAGTCTGGGCCTACCTCCTCTCTTTTATTAATATGTAGACAGGACACCAACACAAATTAGAATGAAGACAAACAAAATGTTAGCAAATGAAGAATGGTATCAATTGGTTAAAATGTGATGAAATAGAGTGGTGAATATTTACATAGAATCCATGATGTGTTAGGTGCTATTTCAAGCTATTTGCACATATAGTTTTAATACCAATGACGTTAAAATGTATAACACAAAGATTCATATAAATAAAAATTACAACATTGTAAATAATATTAGGTGACACTAAAACTGTCATAGAAATACACATTTATATAAAACATAAAGTAACATGAAGTATTAAATTTTAGAAACTTTGATTACTAATCAGATGAACAACTGATTAGCCTTTTTATCCAGTAAAAAAGGCATACATATTATTTTCAAATTCCAGAGACAAATATTTTAAATATTGAAGTTGAAGACCTAAAAATGTGTCACTGACCTCATGGAAGTAGATATTCACTAGGTGATATTTTCTAGGCTCTCTGAAATTATATCAGAAAAATGTGAATTAGAATATAACCCATAAATAATATCTGGCCACATACAAAGTAATTGAAGATCAATTTAAATGGCTATTGGATTAAGAAATAGGGACTGAGGTAAATTTGCAGTGTCAGGGAGGATCTAAGGAGGAAGCATTGACACTGGAGCCCAAGGACCTGGGATCACAGAACAGATTCTACCAGTGCTAACTTACTGCTCCACAGAAAACATCAATTCTGCTCATGCGCAGGTACAATTCATCAAGAAAGGAATTACAACTTCAGAAATGTGTTCAAAATATATCCATACTTTGACATATTAATGAAGTAATCACATTCTACACATAACTACTCCATATGGAATACTGGGGAGGAGGTGTTCCAAATAAAGAGACTGAGGATTTCTCATGAGAACTCAGTGTCTGCTAGAAAATATCTAAGTAAAATATTTTACTTATGTGGAAAGTGTGGATGTTTGTGCATCAAAAGTTTCAAGAATCCCTAAAATTTACAATGGAGATGAGGAGAAAATATCAGAATTTCCCAGCACCAGAAATAAGGCAAGAAAAAATTCAGAGGGGTTGTAAATGTGAAAAGCCAATGGCTGGTCACACAGCAACATTGATAACCTTGTGCCTGGACAACTAGAATAAATACATAAACATACACATTGAAAATATTTCCAATATTAGATCTCCCTCATGTGAGAACTAAATTATAAAGATTGAAGCATAGAAGAAAATAAGCTACCAGAATAAATTTGATTACACATAAATTTCTGATATTGAAACTGTCACAAATGTTTAAGTTGGTAGTGGAAGACAAAGGACATATAATCTTGGGAGTCCTAAGGCCCTGCCCACTGCCAGTCCCTCCACACTACTACAGCTGATGCTTTCTGGAAATCACCACCTCCTGGCAGGAGCCCAACCAGCACAAATATAGAGCATTAAACCACCAAAGCTAAGGAGGCTCACAGAGTCTATTGCACCCTTCACCACCTCCACTGGAACAGGCGCTGGTATCCATGGCTCAGAGACCCAAAGATGGTTCACATCACAGGGCTCTATGCAGACAACCCCCAGTACCAGCCCAAAGCCACGTAGACCTGCTGGGTGGCTAGACCCAGAAGAGAGACAACAATCAATGCACTTTGGCTTACAGGAAGCCATGCCCATAGGAAAAAGGGGAGAGTACTACGTCAAGGGAACACCCCGTGGGATGAAAGAGTCTGAACAACAGTCTTCAGCCCTAGACCTTTCCTCTGACAGAGTCTACCAAAATGAGAAGGAACCAGAAAACCAACCCTGGTAATCTGACAAAACAAGAATCTTCAACACCCCCCAAAAAATCACACCAGTTCATCACCAATGGATCCAAACAAAGAAGAAATCACTGATTCATCTAAAAAAAAATTCAGGTTAGTTATTAAGCTAATCAGGGAGGGGCCAGAGAAAGATGAAGCCCAATGCAAGAAAATCCAAAAAATGATACAATACGTGAAGGGAGAATTATTCAAGGAAATAGATAGCTTAAATAAAAAAATAAAAAATCAGGAAACTTTGGACGTACTTTTAGAAATGTGAAATGCTCTGGAAAGTCTCAGCAATAGAATTGAACAAGTAGAAGAAAGAAATTCAGAATTCGAAGACAAGGTCTTTGATTTAACCCAATCCAATAAAGACAAAGAAAAAAGAATAAGAAAATATGAGCAAAGTCTCCAAGGAGTCTGGCATTCTGTTAAATGATGAAACCTAACACTAATTGGTGTACCTGAGGAAGAAGTGAATTCTAAAAGCCAGGAAAACATATTTGGGAGAATAATCTAGGAAAACTTCCATGGCCTTGTGAGAGACCTAGACATCCAAATACAAGAACCACAAATAACACCTGGGAAATTCATCACAAAAAGATCTTAGCCTAGGCACATTGTCATTAGGTTATCCAAAGTTAAGACAAAGGAAAGAATCTTAAGAGCTGTGAGACAGAAGCACTAGGTAACCTATAAAGGAAAACCTGTCAAATTAACAGCAGATTTCACAGCAGGAACCTTACAAGCTAGATGGGATTGGGGCCCTTTCTTCAGCCTCCTCAAACAAAACAATTATCAGCCAAGAATTTTGTATCCAGCAAAACTAAACATCATATATGAAGGAAAGATACAGTCATTTTCAGACAAACAAATGCTGACAGAATTTGCCATTACCAAGCCAGGACTCTAAGAACTGCTAAAAGGAGCTCTAAATCATGAAACAAATCCTGGAAACACATCAAAACAGAACTTCATTAACGCATAAATCACACAGGACCTATAAAACAAAAATACAAGTTAAAAAACAAAAACAAAGTACAGAGGCAACAAAGAGCATGATGAAAGCAATGGTACCTCACTTTTTAATACTAATGTTGGTTGTAAATGGCTTAAATGCTCCACTTACAAGATACAGAACCACAGAATGGATAACAACTCACCAACTAACTATCTGCTGCCTTCAGGAGACTCACCTAACACATAACGACTTACATAAACTTAAGGAAAGTGGTAGAAAAAGGCATTTCATGCAAATGGACACCAAAAGCAAGCAGCAGTAACTATTCTCATATGAGACAAAACAAACTTTAAAGCAACAGTAGCTAAAAGAGACAAAGAGAGACAGTATATCATCTGTCACCTGACAGTCTCATCCAACAGAAAAATATGACAATCCTAAACATATGTGAACCTAACACTGGAGCTCCCAAATTTATAAAACAATTACTAGTAGACATAAGAAATAAGATAGACAGCAACACAATAATAGTGGGGGACTTCAATACTCCACTGACAGCACTAGACAGGTCATCAAGACAGAAAGTCAACAAAGAAACAATGGATTTAAACTATACTTTGGAACAAATGGACTTAACAGATATATATAGAACATTTCATCCAACAACCACAGAATACACATTCTATTCAACAGCACATGGAATTTTCTCCAAGATAGACCATATGATAGGCCATAAAATGAGTCTCAATAAATTTAAGAAAATTGAAATTGTATCACGCACTCTCTCACATCACAATGGAATAAAACTGAAAATCAACTCCAAAAGGAATCTTCGAAACCATGCAAATACATGGAAATTAAATAACCTGCTCCTGAATGAGCATTGGGTGAAAAACGAAATCAAGATGGAAATGTAAAAAATTTCTTCGAACTGGATGACACAACCTATCAAGACCTCTGGGATACAGCAAAGGCAGTGCTAAGAGGAAAGTTTATAGCACTAAACACCTACGTCGAAAAGTCTGAAAGAGCACAGACAATCTAAGTTCACATCTCAGGGAACTAGAGAAGGAGGAACAAGCCAAACCCAATCCCAGCAAACAAAGGAAATAACCAAGATCAGAGCAGAACTAAATGAAATTGACACAACAACAACAACAACAAAAATACAAAACATAAATAAAACAAAAATTTGGTTATTTGAAAAGATA";
  String c = "ATGGGACCGATATAACGGATCAAATGTAACG";
  String ff ="ATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGA";
   String d = "ATGGGACCGATATAACGGATCAAATGTAACG";
             String f = "ATGBBCAA";
            // getAllGenes(ff);
             processGenes(dna1);
   /*
    * processGenes(b);
    processGenes(c);
    processGenes(d);
    */ 
    
}

  public void testSamples() {
          
          String a = "ATGTGAGGACCDTBATGAATGGGACCGATAATTTCGGATCAAATGTAACGTTGGCGTGAAATCCTTGAGACATTGGAGCGCATGTGCGAGCATACGTACTCGGAGTCTTGTATCGAGAATGAGGATCTCTAAAGAAGATTGCACCGTCATGAACCATCGTTAGCATGA";
                   // ^^^      ^^^             ^^^              ^^^                                
          String b = "ATGGGACCGATATAACGGATCAAATGTAACG";
          String c = "CCCG";
          String e = "ATGBBCAA";
       
          String d = "ATGBBCAA";
        

                //   System.out.println("Printing all genes b " + findGene(e));
          //System.out.println("The Gene b " + printAllGenes(b));
          //System.out.println("The Gene c " + printAllGenes(c));
           //System.out.println("The Gene cis " + findGene(c));
          // System.out.println("The Gene dis " + findGene(d));   
        }
public int countGenes(String dna) {
    
    return 1;
}

}
