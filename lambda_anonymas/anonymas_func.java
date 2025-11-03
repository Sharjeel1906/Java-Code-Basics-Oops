package lambda_anonymas;


class ShowA{
    public void show(){
        System.out.println("Show of A");
    }
}
// If we want to alter show func we need to make another class and to write another function of same name
// Anonymous class: a class without a name used to override methods of a class or interface temporarily.

class ShowB extends ShowA{
    public void show(){
        System.out.println("Show of B");
    }
}
public class anonymas_func {
    public static void main(String[] args){
        ShowA obja = new ShowA();
        obja.show();
        //using showb class to alter func
        ShowA objb = new ShowB();
        objb.show();

        // To avoid to make a new class to overwrite  function we use anonymus function
        ShowA objc = new ShowA(){
            public void show(){
                System.out.println("Show of Anonymus");
            }
        };
        objc.show();
    }
}
