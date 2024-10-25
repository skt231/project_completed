package com.library.pr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long bid;

    @NotEmpty
    @Size(min=1,max=100)
    private String btitle;

    @NotEmpty
    private String author;

    @NotEmpty
    private String publisher;

    @NotEmpty
    private String isbn;

    @NotNull(message = "Year is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate byear;

}
