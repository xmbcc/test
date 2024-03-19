package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "module")
public class ModuleEntity implements Serializable {

    @TableId(value = "module_id",type = IdType.AUTO)
    private Long moduleId;

    @TableField(value = "module_name")
    private String moduleName;

    @TableField(value = "system_no")
    private String systemNo;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "module_icon")
    private String moduleIcon;

    @TableField(value = "module_level")
    private Integer moduleLevel;


    @TableField(value = "has_leaf")
    private Boolean hasLeaf;

    @TableField(value = "full_index")
    private Boolean fullIndex;

    @TableField(value = "module_order")
    private Integer moduleOrder;

    @TableField(value = "module_nodes")
    private String moduleNodes;

    @TableField(value = "module_url")
    private String moduleUrl;

    @TableField(value = "add_user")
    private Long addUser;

    @TableField(value = "add_user")
    private Long editUser;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "add_time")
    private Date addTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "edit_time")
    private Date editTime;





}
