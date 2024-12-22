package com.stephenhu.artistichorizons.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Stephen Hu
 * @TableName t_artworks
 */
@TableName(value ="t_artworks")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "艺术品")
public final class Artworks implements Serializable {
    @TableId
    @Schema(description = "艺术品主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long artworkId;
    @Schema(description = "艺术品名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String artworkName;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date createTime;
    @Schema(description = "艺术品描述", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(description = "艺术品创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date dateTime;
    @Schema(description = "是否删除", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isDel;
    @Schema(description = "外键，关联材质主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long materialId;
    @Schema(description = "外键，关联颜色主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long colorId;
    @Schema(description = "外键，关联艺术家主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long artistId;
    @Schema(description = "外键，关联事件主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long eventId;
    @Schema(description = "外键，关联藏馆主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long collectionId;
    @Schema(description = "外键，关联主题主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
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