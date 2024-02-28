package com.bookspace.cloud.book.dal.mysql.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookspace.cloud.book.controller.book.vo.BookPageReqVO;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.framework.common.pojo.PageParam;
import com.bookspace.cloud.framework.common.pojo.PageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<BookDO> {

    default PageResult<BookDO> selectPage(BookPageReqVO reqVO) {
        QueryWrapper<BookDO> queryWrapper = new QueryWrapper<BookDO>()
                .orderByDesc("id");

        if (PageParam.PAGE_SIZE_NONE.equals(reqVO.getPageSize())) {
            List<BookDO> list = selectList(queryWrapper);
            return new PageResult<>(list, (long) list.size());
        }

        IPage<BookDO> mpPage = new Page<>(reqVO.getPageNo(), reqVO.getPageSize());
        selectPage(mpPage, queryWrapper);
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }
}
