package fillDB;

import service.SightArchivePhotoService;
import service.SightService;

public class FillSightArchivePhoto {
    public static void main(String[] args) {
        SightArchivePhotoService sightArchivePhotoService =
                new SightArchivePhotoService();
        for (int sightId = 1; sightId <= 9; sightId++) {
            int photoNum = 0;
            switch (sightId) {
                case 1:
                case 3:
                    photoNum = 6;
                    break;
                case 2:
                case 4:
                    photoNum = 5;
                    break;
                case 5:
                case 6:
                    photoNum = 4;
                    break;
                case 7:
                case 8:
                case 9:
                    photoNum = 3;
                    break;
            }

            for (int j = 1; j <= photoNum; j++) {
                sightArchivePhotoService.addNewSightArchivePhoto(sightId,
                        "photo/" + sightId + "/" + j + ".jpg");
            }
        }
    }
}
