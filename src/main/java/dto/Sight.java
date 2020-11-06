package dto;

import lombok.Data;

@Data
public class Sight {
    private int id;
    private String name;
    private String description;
    private String photoPath;

    private String[] archivePhotoPaths;

    public Sight(int id, String name, String description, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }

    public Sight(String name, String description, String photoPath) {
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }
}
