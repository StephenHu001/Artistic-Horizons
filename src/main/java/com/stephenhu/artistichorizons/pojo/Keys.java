package com.stephenhu.artistichorizons.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Stephen Hu
 */
@TableName(value ="t_keys")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "钥匙库")
public final class Keys {
    @TableId
    @Schema(description = "钥匙表主键", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long keyId;

    @Schema(description = "公钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publicKey;

    @Schema(description = "私钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String privateKey;
}
