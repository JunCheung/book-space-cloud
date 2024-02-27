package com.bookspace.cloud.book.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base Data Object
 */
@Data
public abstract class BaseDO implements Serializable {

    /**
     * Create Time
     */
    private LocalDateTime createTime;
    /**
     * Update Time
     */
    private LocalDateTime updateTime;
    /**
     * Deleted
     */
    @TableLogic
    private Boolean deleted;

}
