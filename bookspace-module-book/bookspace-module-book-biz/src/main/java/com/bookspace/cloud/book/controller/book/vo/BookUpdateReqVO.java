package com.bookspace.cloud.book.controller.book.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Book Update Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BookUpdateReqVO extends BookBaseVO {

    @Schema(description = "Book's ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Book's ID cannot be null")
    private Long id;
}
