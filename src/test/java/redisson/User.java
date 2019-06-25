/**
 * Description:
 * User: daipeng
 * Date: 2019-05-28 11:31
 * Project:CodeSnippet
 */
package redisson;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Integer number;

    private Long score;

    private double text;
    private boolean good;

    public User() {

    }
    public User(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public double getText() {
        return text;
    }

    public void setText(double text) {
        this.text = text;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
