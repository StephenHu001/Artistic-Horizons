package com.stephenhu.artistichorizons.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_artworks
 */
@TableName(value ="t_artworks")
@Data
public class Artworks implements Serializable {
    /**
     * 
     */
    @TableId
    private Long artworkId;

    /**
     * 
     */
    private String artworkName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Date dateTime;

    /**
     * 
     */
    private Integer isDel;

    /**
     * 
     */
    private Long materialId;

    /**
     * 
     */
    private Long colorId;

    /**
     * 
     */
    private Long artistId;

    /**
     * 
     */
    private Long eventId;

    /**
     * 
     */
    private Long collectionId;

    /**
     * 
     */
    private Long themeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Artworks other = (Artworks) that;
        return (this.getArtworkId() == null ? other.getArtworkId() == null : this.getArtworkId().equals(other.getArtworkId()))
            && (this.getArtworkName() == null ? other.getArtworkName() == null : this.getArtworkName().equals(other.getArtworkName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getColorId() == null ? other.getColorId() == null : this.getColorId().equals(other.getColorId()))
            && (this.getArtistId() == null ? other.getArtistId() == null : this.getArtistId().equals(other.getArtistId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getCollectionId() == null ? other.getCollectionId() == null : this.getCollectionId().equals(other.getCollectionId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArtworkId() == null) ? 0 : getArtworkId().hashCode());
        result = prime * result + ((getArtworkName() == null) ? 0 : getArtworkName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getColorId() == null) ? 0 : getColorId().hashCode());
        result = prime * result + ((getArtistId() == null) ? 0 : getArtistId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getCollectionId() == null) ? 0 : getCollectionId().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artworkId=").append(artworkId);
        sb.append(", artworkName=").append(artworkName);
        sb.append(", createTime=").append(createTime);
        sb.append(", description=").append(description);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", materialId=").append(materialId);
        sb.append(", colorId=").append(colorId);
        sb.append(", artistId=").append(artistId);
        sb.append(", eventId=").append(eventId);
        sb.append(", collectionId=").append(collectionId);
        sb.append(", themeId=").append(themeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}