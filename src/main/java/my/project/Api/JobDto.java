package my.project.Api;

import lombok.Data;

@Data
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private Double price;

}