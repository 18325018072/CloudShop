package com.kevin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName order
 */
@TableName(value = "`order`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableField("userId")
    private Long userId;

    /**
     *
     */
    @TableField("storeId")
    private Long storeId;

    /**
     *
     */
    @TableField("num")
    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}