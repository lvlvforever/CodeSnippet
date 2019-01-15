/**
 * Description:
 * User: daipeng
 * Date: 2018-12-06 9:55
 * Project:CodeSnippet
 */

public class TestEnum {

    private String name = "aaa";
    private String b;
    private static final String number = "2";
    public TestEnum() {
        System.err.println(name);
        System.err.println(b);
    }
    static {
        System.err.println("static block");
        System.err.println(number);

    }



    public static void main(String[] args) {
        new TestEnum();

    }
}
