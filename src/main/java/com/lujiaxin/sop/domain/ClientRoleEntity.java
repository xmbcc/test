package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "client_role")
public class ClientRoleEntity {

    @TableField(value = "client_id")
    private Long clientId;
    @TableField(value = "role_id")
    private Long roleId;

}
