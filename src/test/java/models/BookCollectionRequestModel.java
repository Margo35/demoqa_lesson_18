package models;

import lombok.Data;

import java.util.List;

@Data
public class BookCollectionRequestModel {
    private String userId;
    private List<IsbnModel> collectionOfIsbns;
}
