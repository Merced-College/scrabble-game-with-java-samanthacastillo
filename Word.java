public class Word implements Comparable<Word>{
    //data variables
    private String word;
    private String definition;

    //constructors
    public Word() {
        word = "none";
        definition = "none";
    }

    public Word (String word, String definition) { 
        this.word = word;
        this.definition = definition; 
    }

   public String getWord() {
    return word;
   }

   public void setWord (String word){
    this.word = word;
   }

   public String getDefinition () {
    return definition;
   }

   public void setDefinition(String definition) {
    this.definition = definition;
   }

   @Override
   public String toString() {
    return word + ": " + definition;
   }

    @Override
   public int compareTo(Word other) {
    return this.word.compareTo(other.word);
   }



} // end class word