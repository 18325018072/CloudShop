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
 * 
 * @TableName store
 */
@TableName(value ="store")
@Data@AllArgsConstructor@NoArgsConstructor
public class Store implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String goods;

    /**
     * 
     */
    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}