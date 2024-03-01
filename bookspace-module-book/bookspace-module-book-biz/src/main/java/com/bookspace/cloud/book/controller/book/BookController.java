package com.bookspace.cloud.book.controller.book;

import com.bookspace.cloud.book.controller.book.vo.BookCreateReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookPageReqVO;
import com.bookspace.cloud.book.controller.book.vo.BookRespVO;
import com.bookspace.cloud.book.controller.book.vo.BookUpdateReqVO;
import com.bookspace.cloud.book.convert.book.BookConvert;
import com.bookspace.cloud.book.dal.dataobject.book.BookDO;
import com.bookspace.cloud.book.service.BookService;
import com.bookspace.cloud.framework.common.pojo.CommonResult;
import com.bookspace.cloud.framework.common.pojo.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Book Management")
@RestController
@RequestMapping("/book")
@Validated
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("/create")
    @Operation(summary = "Create book")
    public CommonResult<String> createBook(@Valid @RequestBody BookCreateReqVO createReqVO) {
        return CommonResult.success(String.valueOf(bookService.createBook(createReqVO)));
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get book by id")
    public CommonResult<BookRespVO> getBookById(@PathVariable("id") Long id) {
        return CommonResult.success(BookConvert.INSTANCE.convert(bookService.getBook(id)));
    }

    @PutMapping("/update")
    @Operation(summary = "Update a book")
    public CommonResult<Boolean> updateBook(@Valid @RequestBody BookUpdateReqVO updateReqVO) {
        bookService.updateBook(updateReqVO);
        return CommonResult.success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "Get book with page")
    public CommonResult<PageResult<BookRespVO>> getBookPage(@Valid BookPageReqVO pageReqVO) {
        PageResult<BookDO> pageResult = bookService.getBookPage(pageReqVO);
        return CommonResult.success(BookConvert.INSTANCE.convertPage(pageResult));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a book")
    public CommonResult<Boolean> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return CommonResult.success(true);
    }
}
