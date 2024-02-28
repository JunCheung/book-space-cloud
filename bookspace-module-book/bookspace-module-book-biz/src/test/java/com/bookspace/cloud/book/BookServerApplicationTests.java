package com.bookspace.cloud.book;

import com.bookspace.cloud.book.controller.book.vo.BookCreateReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookUpdateReqVO;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.book.service.BookService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServerApplicationTests {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private BookService bookService;

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void testCreateAngGetBook() {
        BookCreateReqVO bookCreateReqVO = new BookCreateReqVO();
        bookCreateReqVO.setAuthor("Jun Cheung");
        bookCreateReqVO.setName("Java Programming");
        Long bookId = bookService.createBook(bookCreateReqVO);
        assertThat(bookId).isNotNull();
        BookDO bookDO = bookService.getBook(bookId);
        assertThat(bookDO).isNotNull();
    }

    @Test
    void testUpdateBook() {
        BookCreateReqVO bookCreateReqVO = new BookCreateReqVO();
        bookCreateReqVO.setAuthor("Jun Cheung");
        bookCreateReqVO.setName("Get Java Programming");
        Long bookId = bookService.createBook(bookCreateReqVO);
        BookUpdateReqVO bookUpdateReqVO = new BookUpdateReqVO();
        String name = "Web 3.0 Programming";
        String author = "Jun";
        String isbn = "isbn2";
        LocalDate publication = LocalDate.now();
        String cover = "https://bookspace.com/";
        bookUpdateReqVO.setId(bookId);
        bookUpdateReqVO.setName(name);
        bookUpdateReqVO.setAuthor(author);
        bookUpdateReqVO.setIsbn(isbn);
        bookUpdateReqVO.setPublication(publication);
        bookUpdateReqVO.setCover(cover);
        bookService.updateBook(bookUpdateReqVO);
        BookDO updatedBookDO = bookService.getBook(bookId);
        Assertions.assertEquals(name, updatedBookDO.getName());
        Assertions.assertEquals(author, updatedBookDO.getAuthor());
        Assertions.assertEquals(publication, updatedBookDO.getPublication());
        Assertions.assertEquals(cover, updatedBookDO.getCover());
        Assertions.assertEquals(isbn, updatedBookDO.getIsbn());

    }

    @Test
    void testDeleteBookById() {
        BookCreateReqVO bookCreateReqVO = new BookCreateReqVO();
        bookCreateReqVO.setName("Java Programming");
        Long bookId = bookService.createBook(bookCreateReqVO);
        assertThat(bookId).isNotNull();
        bookService.deleteBookById(bookId);
        BookDO deletedBookDO = bookService.getBook(bookId);
        assertThat(deletedBookDO).isNull();
    }
}
