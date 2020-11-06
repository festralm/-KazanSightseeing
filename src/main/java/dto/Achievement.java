package dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Achievement {
    private int id;
    private String name;
    private String photoPath;
    private String description;

    public Achievement(int id, String name, String photoPath, String description) {
        this.id = id;
        this.name = name;
        this.photoPath = photoPath;
        this.description = description;
    }
}
