package com.yz.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wallpaper_category", schema = "wallpaper", catalog = "")
public class WallpaperCategory {
    private int id;
    private String wallpaperId;
    private Integer categoryId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wallpaper_id", nullable = true, length = 60)
    public String getWallpaperId() {
        return wallpaperId;
    }

    public void setWallpaperId(String wallpaperId) {
        this.wallpaperId = wallpaperId;
    }

    @Basic
    @Column(name = "category_id", nullable = true)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallpaperCategory that = (WallpaperCategory) o;
        return id == that.id &&
                Objects.equals(wallpaperId, that.wallpaperId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, wallpaperId, categoryId);
    }
}
