package com.bookspace.cloud.book.controller.book.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Book Base VO, for creation/ update / query detail VO
 */
@Data
public class BookBaseVO {

    @Schema(description = "Book's name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Harry Potter")
    @NotNull(message = "Book's name cannot be null")
    private String name;

    @Schema(description = "Book's cover", example = "https://www.bookspace.com/cover.jpg")
    private String cover;

    @Schema(description = "Book's author", example = "J.K. Rowling")
    private String author;

    @Schema(description = "Book's publication", example = "2024-02-02")
    private LocalDate publication;

    @Schema(description = "Book's ISBN", example = "978-3-16-148410-0")
    private String isbn;
}
