package com.bookspace.cloud.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "Page Param")
@Data
public class PageParam implements Serializable {

    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;

    /**
     * Do not page
     */
    public static final Integer PAGE_SIZE_NONE = -1;

    @Schema(description = "Page No，start from 1", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Page No can not be null")
    @Min(value = 1, message = "Page No can not smaller than 1")
    private Integer pageNo = PAGE_NO;

    @Schema(description = "Page size， Maximum 100", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Page Size Can Not be Null")
    @Min(value = 1, message = "Page Size Minimum 1")
    @Max(value = 100, message = "Page size Maximum 100")
    private Integer pageSize = PAGE_SIZE;

}
