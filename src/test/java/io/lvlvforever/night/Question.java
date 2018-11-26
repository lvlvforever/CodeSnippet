package io.lvlvforever.night;

import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public class Question {
    private String question;
    private List<String> options;
    private Integer currectAnswer;
    private Description description;


    // video
    public Question(String question, List<String> options, Integer currectAnswer, String episode) {
        this(question, options, currectAnswer);
        this.description = new Description();
        this.description.source = "video";
        this.description.episode = episode;
    }
    //book
    public Question(String question, List<String> options, Integer currectAnswer, String bid, String cid,String episode) {
        this(question, options, currectAnswer);
        this.description = new Description();
        this.description.source = "book";
        this.description.bid = bid;
        this.description.cid = cid;
        this.description.episode = episode;
    }

    private Question(String question, List<String> options, Integer currectAnswer) {
        this.question = question;
        this.options = options;
        this.currectAnswer = currectAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getCurrectAnswer() {
        return currectAnswer;
    }

    public void setCurrectAnswer(Integer currectAnswer) {
        this.currectAnswer = currectAnswer;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", currectAnswer=" + currectAnswer +
                ", description=" + description +
                '}';
    }
}

class Description {
    public String source;
    public String episode;
    public String bid;
    public String cid;

    @Override
    public String toString() {
        return "Description{" +
                "source='" + source + '\'' +
                ", episode='" + episode + '\'' +
                ", bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}

