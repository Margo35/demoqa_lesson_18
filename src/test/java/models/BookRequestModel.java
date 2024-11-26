package models;

import lombok.Data;

@Data
public class BookRequestModel {
    private String userId, isbn;
}
