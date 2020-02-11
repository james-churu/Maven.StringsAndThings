package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        Integer counter = 0;

        for(int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);

            if(letter == 'y' || letter == 'z') {

                if(i+1 != input.length()){

                    if(input.charAt(i+1) == ' ') {
                        counter++;
                    }
                }else if(i == input.length() -1){
                    counter++;

                }
            }

        }

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        String answer = base.replace(remove,"");

        return answer;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){

        int length = input.length();

        String postIsString = input.replaceAll("is","");
        int postIs = postIsString.length();

        String postNotString = input.replaceAll("not","");
        int postNot = postNotString.length();

        int numOfIs = (length - postIs) / 2;
        int numOfNot = (length - postNot) / 3;

        if(numOfIs == numOfNot){
            return true;
        }else {
            return false;
        }
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){


        int firstG = 0;
        int numOfG = 0;
        String gAdded = "";

        for(int x = 0; x < input.length(); x++){
            char gee = input.charAt(x);
            if(gee == 'g'){
                numOfG++;
                gAdded += 'g';
                if(firstG == 0){
                    firstG = x;
                }
            }
        }

        if(gAdded.length() == 1){
            return false;
        }else{

            String findGs = input.substring(firstG,firstG + gAdded.length());

            if(findGs.equals(gAdded)){
                return true;
            }else{
                return false;
            }
        }



    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

        Integer numOf3 = 0;
        for(int i = 1; i < input.length() - 1; i++){
            char place = input.charAt(i);

            if(input.charAt(i-1) == place && input.charAt(i+1) == place){
                numOf3++;
            }

        }
        return numOf3;
    }
}
