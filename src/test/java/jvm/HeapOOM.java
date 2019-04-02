/**
 * Description:
 * User: daipeng
 * Date: 2019-01-15 15:48
 * Project:CodeSnippet
 */
package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    public static void main(String[] args) {
        List<HeapOOM> oos = new ArrayList<>();
        int i = 0;
        while (true) {
            System.err.println(i++);
            oos.add(new HeapOOM());
        }
    }
}
