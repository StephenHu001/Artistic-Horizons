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
 * @TableName t_countries
 */
@TableName(value ="t_countries")
@Data
@Schema(description = "国家")
public class Countries implements Serializable {
    @TableId
    @Schema(description = "国家主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long countryId;
    @Schema(description = "国家名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String countryName;
    @Schema(description = "国家描述", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date dateTime;
    @Schema(description = "是否删除", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isDel;

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
        Countries other = (Countries) that;
        return (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
            && (this.getCountryName() == null ? other.getCountryName() == null : this.getCountryName().equals(other.getCountryName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDateTime() == null ? other.getDateTime() == null : this.getDateTime().equals(other.getDateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getCountryName() == null) ? 0 : getCountryName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDateTime() == null) ? 0 : getDateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countryId=").append(countryId);
        sb.append(", countryName=").append(countryName);
        sb.append(", description=").append(description);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}