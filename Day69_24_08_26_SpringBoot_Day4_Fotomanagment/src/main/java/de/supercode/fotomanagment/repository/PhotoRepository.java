package de.supercode.fotomanagment.repository;

import de.supercode.fotomanagment.entity.Photo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class PhotoRepository {

    private ArrayList<Photo> photos;





    public PhotoRepository() {
        this.photos = new ArrayList<>();
    }



    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public void deletePhoto(Photo photo) {
        photos.remove(photo);
    }


}
