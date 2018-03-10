package com.yz.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wallpaper {
    private String id;
    private String thumbUrl;
    private String imgUrl;
    private String previewUrl;
    private String tag;

    @Id
    @Column(name = "id", nullable = false, length = 60)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "thumb_url", nullable = true, length = 255)
    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @Basic
    @Column(name = "img_url", nullable = true, length = 255)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "preview_url", nullable = true, length = 255)
    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    @Basic
    @Column(name = "tag", nullable = true, length = 20)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallpaper wallpaper = (Wallpaper) o;
        return Objects.equals(id, wallpaper.id) &&
                Objects.equals(thumbUrl, wallpaper.thumbUrl) &&
                Objects.equals(imgUrl, wallpaper.imgUrl) &&
                Objects.equals(previewUrl, wallpaper.previewUrl) &&
                Objects.equals(tag, wallpaper.tag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, thumbUrl, imgUrl, previewUrl, tag);
    }
}
