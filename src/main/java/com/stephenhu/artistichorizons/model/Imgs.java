package com.stephenhu.artistichorizons.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @author Stephen Hu
 * @TableName t_imgs
 */
@TableName(value ="t_imgs")
@Data
@Schema(description = "图片")
public class Imgs implements Serializable {
    @TableId
    @Schema(description = "图片主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long imgId;
    @Schema(description = "图片路径", requiredMode = Schema.RequiredMode.REQUIRED)
    private String imgPath;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date dateTime;
    @Schema(description = "是否删除", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isDel;
    @Schema(description = "外键，关联颜色主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long colorId;
    @Schema(description = "外键，关联材质主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long materialId;
    @Schema(description = "外键，关联国家主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long countryId;
    @Schema(description = "外键，关联地区主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long districtId;
    @Schema(description = "外键，关联城市主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long cityId;
    @Schema(description = "外键，关联城市主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long collectionId;
    @Schema(description = "外键，关联历史人物主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long figureId;
    @Schema(description = "外键，关联作者主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long artistId;
    @Schema(description = "外键，关联主题主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long themeId;
    @Schema(description = "外键，关联事件主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long eventId;
    @Schema(description = "外键，关联艺术品主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long artworkId;

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
        Imgs other = (Imgs) that;
        return (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getImgPath() == null ? other.getImgPath() == null : this.getImgPath().equals(other.getImgPath()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getColorId() == null ? other.getColorId() == null : this.getColorId().equals(other.getColorId()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
            && (this.getDistrictId() == null ? other.getDistrictId() == null : this.getDistrictId().equals(other.getDistrictId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCollectionId() == null ? other.getCollectionId() == null : this.getCollectionId().equals(other.getCollectionId()))
            && (this.getFigureId() == null ? other.getFigureId() == null : this.getFigureId().equals(other.getFigureId()))
            && (this.getArtistId() == null ? other.getArtistId() == null : this.getArtistId().equals(other.getArtistId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getArtworkId() == null ? other.getArtworkId() == null : this.getArtworkId().equals(other.getArtworkId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getImgPath() == null) ? 0 : getImgPath().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getColorId() == null) ? 0 : getColorId().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getDistrictId() == null) ? 0 : getDistrictId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCollectionId() == null) ? 0 : getCollectionId().hashCode());
        result = prime * result + ((getFigureId() == null) ? 0 : getFigureId().hashCode());
        result = prime * result + ((getArtistId() == null) ? 0 : getArtistId().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getArtworkId() == null) ? 0 : getArtworkId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", imgPath=").append(imgPath);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", colorId=").append(colorId);
        sb.append(", materialId=").append(materialId);
        sb.append(", countryId=").append(countryId);
        sb.append(", districtId=").append(districtId);
        sb.append(", cityId=").append(cityId);
        sb.append(", collectionId=").append(collectionId);
        sb.append(", figureId=").append(figureId);
        sb.append(", artistId=").append(artistId);
        sb.append(", themeId=").append(themeId);
        sb.append(", eventId=").append(eventId);
        sb.append(", artworkId=").append(artworkId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}