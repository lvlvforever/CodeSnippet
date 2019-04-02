/**
 * Description:
 * User: daipeng
 * Date: 2019-01-24 16:19
 * Project:CodeSnippet
 */
package basic;

public class TestAutoClose {
    public static void main(String[] args) {


        System.err.println(Integer.MAX_VALUE / 15800);
        try (Local local = new Local();) {

            System.err.println("in try");

            return;

        } catch (Exception e) {

            System.err.println("exception");
        }
        System.err.println("over");


    }
}
