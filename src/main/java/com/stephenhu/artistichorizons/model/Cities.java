package com.stephenhu.artistichorizons.model;

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
 * @TableName t_cities
 */
@TableName(value ="t_cities")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "城市")
public class Cities implements Serializable {
    @TableId
    @Schema(description = "城市主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long cityId;
    @Schema(description = "城市名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cityName;
    @Schema(description = "城市描述", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date dateTime;
    @Schema(description = "是否删除", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isDel;
    @Schema(description = "外键，关联地区主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long districtId;
    @Schema(description = "外键，关联邮政编码主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long postalCodeId;
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
        Cities other = (Cities) that;
        return (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getDistrictId() == null ? other.getDistrictId() == null : this.getDistrictId().equals(other.getDistrictId()))
            && (this.getPostalCodeId() == null ? other.getPostalCodeId() == null : this.getPostalCodeId().equals(other.getPostalCodeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getDistrictId() == null) ? 0 : getDistrictId().hashCode());
        result = prime * result + ((getPostalCodeId() == null) ? 0 : getPostalCodeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", description=").append(description);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", districtId=").append(districtId);
        sb.append(", postalCodeId=").append(postalCodeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}