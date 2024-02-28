package com.bookspace.cloud.book.convert.book;

import com.bookspace.cloud.book.controller.book.vo.BookCreateReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookRespVO;
import com.bookspace.cloud.book.controller.book.vo.BookUpdateReqVO;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookConvert {

    BookConvert INSTANCE = Mappers.getMapper(BookConvert.class);

    BookDO convert(BookCreateReqVO bean);

    BookRespVO convert(BookDO bean);

    PageResult<BookRespVO> convertPage(PageResult<BookDO> pageResult);

    BookDO convert(BookUpdateReqVO updateReqVO);
}
