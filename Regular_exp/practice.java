package Regular_exp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class practice {
    public static void main(String[] args){
        String email = "sharjeel@gmail.com";
        String phone = "312-1198483";
        System.out.println(email_check(email));
        String phone_patt = "(?://+92-?|0)?3\\d{2}-?\\d{7}";
        Pattern patternobj = Pattern.compile(phone_patt);
        Matcher matcherobj = patternobj.matcher(phone);
        if(matcherobj.find()){
            System.out.println("Correct no");
        }else{
            System.out.println("Not correct");
        }
    }
    public static boolean email_check(String email){
        String[] whatToSearch = {"\\@","\\.com|\\.org|\\.net"};
        boolean is_email=false;
        for(int i=0;i<2;i++){
            String pattern = whatToSearch[i];
            Pattern patternobj = Pattern.compile(pattern);
            Matcher matcherobj = patternobj.matcher(email);
            if(matcherobj.find()){
                is_email=true;
            }else{
                is_email=false;
                break;
            }
        }
        return is_email;
    }
}
