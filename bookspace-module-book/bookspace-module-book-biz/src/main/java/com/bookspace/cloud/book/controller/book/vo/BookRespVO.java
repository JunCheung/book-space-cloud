package com.bookspace.cloud.book.controller.book.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Book Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BookRespVO extends BookBaseVO {

    @Schema(description = "Book's ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Book's ID cannot be null")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Schema(description = "create time")
    private LocalDateTime createTime;

    @Schema(description = "update time")
    private LocalDateTime updateTime;
}
