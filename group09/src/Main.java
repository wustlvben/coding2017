import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请问组长是男是女？");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("男")) {
            System.out.println("组长威武");
        } else {
            System.out.println("组长霸气");
        }

    }

}
