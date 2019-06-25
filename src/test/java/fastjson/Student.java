/**
 * Description:
 * User: daipeng
 * Date: 2019-02-01 9:51
 * Project:CodeSnippet
 */
package fastjson;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private String name;
    private Course course;
}
@Data
@ToString
class Course{
    private String name;




}