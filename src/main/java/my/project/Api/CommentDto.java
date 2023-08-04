package my.project.Api;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String message;
    private String username;
    private String commentDate;
}
