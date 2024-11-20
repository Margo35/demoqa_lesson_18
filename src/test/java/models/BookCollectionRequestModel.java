package models;

import lombok.Data;

import java.util.List;

@Data
public class BookCollectionRequestModel {
    String userId;
    List<IsbnModel> collectionOfIsbns;
}
