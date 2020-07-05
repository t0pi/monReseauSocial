package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

// JSON Data structure
@Data
public class LikesJSON implements Serializable {

    private Long id;
    @NotEmpty
    @ManyToOne
    private Post post;
    @NotEmpty
    @OneToOne
    private User author;
}
