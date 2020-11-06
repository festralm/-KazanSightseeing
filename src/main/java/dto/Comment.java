package dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private int id;
    private int userId;
    private int SightId;
    private String description;
    private Date datetime;

    public Comment(int userId, int sightId, String description) {
        this.userId = userId;
        SightId = sightId;
        this.description = description;
    }

    public Comment(int id, int userId, int sightId, String description, Date datetime) {
        this.id = id;
        this.userId = userId;
        SightId = sightId;
        this.description = description;
        this.datetime = datetime;
    }
}
