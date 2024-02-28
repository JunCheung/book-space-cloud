package com.bookspace.cloud.book.service.impl;

import com.bookspace.cloud.book.controller.book.vo.BookCreateReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookPageReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookUpdateReqVO;
import com.bookspace.cloud.book.convert.book.BookConvert;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.book.dal.mysql.book.BookMapper;
import com.bookspace.cloud.book.service.BookService;
import com.bookspace.cloud.framework.common.pojo.PageResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Long createBook(BookCreateReqVO createReqVO) {
        BookDO bookDO = BookConvert.INSTANCE.convert(createReqVO);
        bookMapper.insert(bookDO);
        return bookDO.getId();
    }

    @Override
    public BookDO getBook(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    public void updateBook(BookUpdateReqVO updateReqVO) {
        BookDO bookDO = BookConvert.INSTANCE.convert(updateReqVO);
        bookMapper.updateById(bookDO);
    }

    @Override
    public PageResult<BookDO> getBookPage(BookPageReqVO pageReqVO) {
        return bookMapper.selectPage(pageReqVO);
    }

    @Override
    public void deleteBookById(Long id) {
        bookMapper.deleteById(id);
    }
}
