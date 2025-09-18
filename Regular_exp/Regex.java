package Regular_exp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {
    public static void main(String[] args){
        // "^[a]" at starting point || "[^a]" everything except a || "[aeiou]" If anyone of them found it give its index
        // "[a]$" at end of string  || "[//?//.]" // remove actual meaning and find them as char  ||"[a-z]" all char in range
        // "[0-9]" all digit in raneg || "\\d" any digit || "\\d{2}" give 2 digit number || "\\d{2,4}" give 2,3 and 4 digit numbers
        // "\\d{4}|\\d{2}" give only 2 and 4 digit number || "\\d{2}-\\d{2}-\\d{4}" for 02-09-2025 || "\\d{1,2}-\\d{1,2}-\\d{4}" for 02-9-2025 2-09-2025
        // "\\d{1,2}-\\d{1,2}-\\d{4}|\\d{1,2}-\\d{1,2}-\\d{2}" for all types of date
        String whatToSearch = "";
        String textToSearchIn = "This is a book of a maths publish on 02-09-2025 and 02-9-2025 and 2-9-2025 and 2-9-25  ";

        Pattern patternobj = Pattern.compile(whatToSearch);
        Matcher matcherobj = patternobj.matcher(textToSearchIn);

        while(matcherobj.find()){
            System.out.println("Found "+matcherobj.group()+" at index : "+matcherobj.start());
        }
    }
    
}
