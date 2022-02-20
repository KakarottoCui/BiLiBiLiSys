package cilicili.jz2.pojo;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Video implements Serializable {
    private Integer id;

    private String title;

    private String url;

    private Integer uploadUserid;

    private ZonedDateTime uploadTime;

    private Integer countPlay;

    private Integer countLike;

    private String picUrl;

    private String description;

    public Video(Integer id, String title, String url, Integer uploadUserid, ZonedDateTime uploadTime, Integer countPlay, Integer countLike, String picUrl, String description) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.uploadUserid = uploadUserid;
        this.uploadTime = uploadTime;
        this.countPlay = countPlay;
        this.countLike = countLike;
        this.picUrl = picUrl;
        this.description = description;
    }

    public Video() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUploadUserid() {
        return uploadUserid;
    }

    public void setUploadUserid(Integer uploadUserid) {
        this.uploadUserid = uploadUserid;
    }

    public ZonedDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(ZonedDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getCountPlay() {
        return countPlay;
    }

    public void setCountPlay(Integer countPlay) {
        this.countPlay = countPlay;
    }

    public Integer getCountLike() {
        return countLike;
    }

    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}