package com.bookspace.cloud.book.dal.dataobject.book;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bookspace.cloud.book.dal.dataobject.BaseDO;
import lombok.*;

import java.time.LocalDate;

@TableName("books")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDO extends BaseDO {

    /**
     * Book's ID
     */
    @TableId
    private Long id;

    /**
     * Book's name
     */
    private String name;

    /**
     * Book's cover url
     */
    private String cover;

    /**
     * Book's author
     */
    private String author;

    /**
     * Book's publication
     */
    private LocalDate publication;

    /**
     * Book's ISBN
     */
    private String isbn;
}
