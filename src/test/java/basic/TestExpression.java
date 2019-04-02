/**
 * Description:
 * User: daipeng
 * Date: 2019-02-22 15:15
 * Project:CodeSnippet
 */
package basic;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TestExpression {

    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();




    public boolean validateExpression(String formula) {

        if (StringUtils.isBlank(formula)) {
            return false;
        }
        for (Character ch : formula.toCharArray()) {
            if (!CharUtils.isAscii(ch)) {
                continue;
            }
            if (BracketEnum.RIGHT_LITTLE_BRACKET.getKey().equals(ch)) {

                if (left.isEmpty()) {
                    return false;
                }

                Character curCh = left.pop();
                if (!CharUtils.isAsciiNumeric(curCh)) {
                    return false;
                }
                if (left.isEmpty()) {
                    return false;
                }

                curCh = left.pop();

                if(curCh.equals(BracketEnum.LEFT_LITTLE_BRACKET.getKey())){
                    continue;
                } else if (curCh.equals(OperatorEnum.NOT.toString())) {
                    if (left.isEmpty()) {
                        return false;
                    }
                    curCh = left.pop();

                }






            }


        }


        return false;




    }








    enum OperatorEnum {

        INTERSECTION("&",2),
        UNION("|",2),
        NOT("!",1),
        ;

        private String key;
        private Integer type;

        OperatorEnum(String key, Integer type){
            this.key = key;
            this.type = type;
        }
        @Override
        public String toString() {
            return this.key;
        }
    }


    enum BracketEnum {


        LEFT_LITTLE_BRACKET('(',1,2),
        RIGHT_LITTLE_BRACKET(')', 2, 1),;


        private Character key;
        private Integer value;
        private Integer brother;

        BracketEnum(Character key,Integer value,Integer brother) {
            this.brother = brother;
            this.value = value;
            this.key = key;
        }

        public Integer getValue() {
            return this.value;
        }

        public Character getKey() {
            return this.key;
        }

        public Integer getBrother() {
            return this.brother;
        }

        public static BracketEnum getInstance(Character key) {

            for (BracketEnum type : BracketEnum.values()) {
                if (type.getKey().equals(key)) {
                    return type;
                }
            }
            return null;
        }
        public static BracketEnum getInstance(Integer value) {

            for (BracketEnum type : BracketEnum.values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }
        public static BracketEnum getBrother(Character key) {
            BracketEnum obj = getInstance(key);
            return getInstance(obj.getBrother());
        }

    }





}


