package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("role")
public class RoleEntity {

    @TableId(value = "role_id",type = IdType.AUTO)
    private Long roleId;

    @TableField("role_name")
    private String roleName;

    @TableField("role_code")
    private String roleCode;

}
