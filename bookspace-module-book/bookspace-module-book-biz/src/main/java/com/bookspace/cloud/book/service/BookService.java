package com.bookspace.cloud.book.service;

import com.bookspace.cloud.book.controller.book.vo.BookCreateReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookPageReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookUpdateReqVO;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.framework.common.pojo.PageResult;

public interface BookService {

    /**
     * Create a book
     *
     * @param createReqVO book info
     * @return book id
     */
    Long createBook(BookCreateReqVO createReqVO);

    /**
     * Get a book by id
     *
     * @param id book's id
     * @return book info
     */
    BookDO getBook(Long id);

    /**
     * Update a book
     *
     * @param updateReqVO book info
     */
    void updateBook(BookUpdateReqVO updateReqVO);

    /**
     * Get book with page
     *
     * @param pageReqVO page request vo
     * @return book page result
     */
    PageResult<BookDO> getBookPage(BookPageReqVO pageReqVO);

    /**
     * Delete a book
     *
     * @param id book id
     */
    void deleteBookById(Long id);

}
