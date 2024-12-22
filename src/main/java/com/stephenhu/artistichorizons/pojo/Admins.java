package com.stephenhu.artistichorizons.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Stephen Hu
 * @TableName t_admin
 */
@TableName(value ="t_admin")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "管理员")
public final class Admins implements Serializable {
    @TableId
    @Schema(description = "管理员主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long adminId;
    @Schema(description = "管理员姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String adminName;
    @Schema(description = "管理员账户", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long account;
    @Schema(description = "管理员密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "管理员状态", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;
    @Schema(description = "keyId", requiredMode = Schema.RequiredMode.REQUIRED)
    private String keyId;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}