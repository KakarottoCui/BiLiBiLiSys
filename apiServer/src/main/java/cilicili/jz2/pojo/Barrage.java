package cilicili.jz2.pojo;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Barrage implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private ZonedDateTime sendtime;

    private String content;

    private String color;

    private Integer offtime;

    private Byte position;

    public Barrage(Integer id, Integer userId, Integer videoId, ZonedDateTime sendtime, String content, String color, Integer offtime, Byte position) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.sendtime = sendtime;
        this.content = content;
        this.color = color;
        this.offtime = offtime;
        this.position = position;
    }

    public Barrage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public ZonedDateTime getSendtime() {
        return sendtime;
    }

    public void setSendtime(ZonedDateTime sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getOfftime() {
        return offtime;
    }

    public void setOfftime(Integer offtime) {
        this.offtime = offtime;
    }

    public Byte getPosition() {
        return position;
    }

    public void setPosition(Byte position) {
        this.position = position;
    }
}