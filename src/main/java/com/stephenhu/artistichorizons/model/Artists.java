package com.stephenhu.artistichorizons.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author Stephen Hu
 * @TableName t_artists
 */
@TableName(value ="t_artists")
@Data
public class Artists implements Serializable {
    /**
     * 
     */
    @TableId
    private Long artistId;

    /**
     * 
     */
    private String artistName;

    /**
     * 
     */
    private Date birthDate;

    /**
     * 
     */
    private Date deathDate;

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
    private Long cityId;

    /**
     * 
     */
    private Long themeId;

    /**
     * 
     */
    private Long eventId;

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
        Artists other = (Artists) that;
        return (this.getArtistId() == null ? other.getArtistId() == null : this.getArtistId().equals(other.getArtistId()))
            && (this.getArtistName() == null ? other.getArtistName() == null : this.getArtistName().equals(other.getArtistName()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getDeathDate() == null ? other.getDeathDate() == null : this.getDeathDate().equals(other.getDeathDate()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArtistId() == null) ? 0 : getArtistId().hashCode());
        result = prime * result + ((getArtistName() == null) ? 0 : getArtistName().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getDeathDate() == null) ? 0 : getDeathDate().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artistId=").append(artistId);
        sb.append(", artistName=").append(artistName);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", deathDate=").append(deathDate);
        sb.append(", description=").append(description);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", cityId=").append(cityId);
        sb.append(", themeId=").append(themeId);
        sb.append(", eventId=").append(eventId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}