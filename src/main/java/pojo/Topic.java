package pojo;

import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 02.11.2016.
 */
public class Topic {

    private Integer topicID;
    private Integer forum_id; // к какому разделу форума принадлежит
    private String titleOfTopic; // заголовок
    private String message; // description
    private String authorOfMessage;
    private Date dateOfCreate;
    private Date dateOfUpdate;
    private Integer numberOfAnswers;
    private List<Tag> tagOfTopic;

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public Integer getTopicID() {
        return topicID;
    }

    public void setTopicID(Integer topicID) {
        this.topicID = topicID;
    }

    public String getTitleOfTopic() {
        return titleOfTopic;
    }

    public void setTitleOfTopic(String titleOfTopic) {
        this.titleOfTopic = titleOfTopic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(java.sql.Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Integer getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(Integer numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public List<Tag> getTagOfTopic() {
        return tagOfTopic;
    }

    public void setTagOfTopic(List<Tag> tagOfTopic) {
        this.tagOfTopic = tagOfTopic;
    }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public String getAuthorOfMessage() {
        return authorOfMessage;
    }

    public void setAuthorOfMessage(String authorOfMessage) {
        this.authorOfMessage = authorOfMessage;
    }
}
