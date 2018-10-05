
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    
  public int HowMany(String stringA, String stringB) {
        int Count = 0;
        int currIndex = 0;
        while(stringB.indexOf(stringA, currIndex) != -1) {
            
            Count +=1;
            currIndex = stringB.indexOf(stringA,currIndex) + stringA.length();
        }
        
        //HELLOLLO
        //
        
      
      return Count;
}
      public void testSamples() {
          
          String a = "atgggaccdtaaatgggaccgataatttcggatcaaatgtaacgttggcgtgaaatccttgagacattggagcgcatgtgcgagcatacgtactcggagtcttgtatcgagaatgaggatctctaaagaagattgcaccgtcatgaaccatcgttagcatga";
          System.out.println(HowMany("GAA", "ATGAACGAATTGAATC"));
          System.out.println(HowMany("AA", "ATAAAAAA"));
          String b = "atgggaccgatatttcggatcaaatgttacg";
          String c= "ATGTAA";
          
          String d = "ATGATGATGTTAA";
        
                              
            
        }
}
