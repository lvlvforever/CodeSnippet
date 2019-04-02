/**
 * Description:
 * User: daipeng
 * Date: 2019-01-24 16:19
 * Project:CodeSnippet
 */
package basic;

public class Local implements AutoCloseable{




    @Override
    public void close() throws Exception {
        System.err.println("colse");

    }
}
