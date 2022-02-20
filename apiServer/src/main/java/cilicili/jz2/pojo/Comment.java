package cilicili.jz2.pojo;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Comment implements Serializable {
    private Integer id;

    private Integer videoId;

    private Integer userId;

    private String content;

    private ZonedDateTime sendtime;

    private Integer countLike;

    public Comment(Integer id, Integer videoId, Integer userId, String content, ZonedDateTime sendtime, Integer countLike) {
        this.id = id;
        this.videoId = videoId;
        this.userId = userId;
        this.content = content;
        this.sendtime = sendtime;
        this.countLike = countLike;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public ZonedDateTime getSendtime() {
        return sendtime;
    }

    public void setSendtime(ZonedDateTime sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getCountLike() {
        return countLike;
    }

    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }
}