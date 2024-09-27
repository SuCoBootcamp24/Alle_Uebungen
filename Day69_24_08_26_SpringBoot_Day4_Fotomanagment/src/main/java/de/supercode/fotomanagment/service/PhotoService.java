package de.supercode.fotomanagment.service;

import de.supercode.fotomanagment.entity.Photo;
import de.supercode.fotomanagment.repository.PhotoRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoService {

    PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getPhotos() {
       return photoRepository.getPhotos();
    }

    public Photo getPhoto(String photoName) {
        return photoRepository.getPhotos().stream()
               .filter(photo -> photo.getFilename().equals(photoName))
               .findFirst()
               .orElse(null);
    }

    public List<Photo> getPhotosByFiltering(String filter) {
        return photoRepository.getPhotos().stream()
               .filter(photo -> photo.getFileType().contains(filter))
               .collect(Collectors.toList());
    }

    public List<Photo> getPhotosByPath(String path) {
        return photoRepository.getPhotos().stream()
               .filter(photo -> photo.getPath().contains(path))
               .collect(Collectors.toList());
    }


    public List<Photo> getPhotosBySorting(Boolean ascending) {
        return photoRepository.getPhotos().stream()
                .sorted(ascending? Comparator.comparing(Photo::getCreationDate) : Comparator.comparing(Photo::getCreationDate).reversed())
               .collect(Collectors.toList());
    }


    public boolean addPhoto(Photo newPhoto) {
        if (getPhoto(newPhoto.getFilename())!= null) {
            return false;
        }
        photoRepository.addPhoto(newPhoto);
        return true;
    }


    public boolean updatePhoto(String photoName, Photo photoJson) {
        Photo photo = getPhoto(photoName);
        if (photo == null) {
            return false;
        }
        photo.setFilename(photoJson.getFilename());
        photo.setSize(photoJson.getSize());
        photo.setCreationDate(photoJson.getCreationDate());
        photo.setFileType(photoJson.getFileType());
        photo.setPath(photoJson.getPath());
        return true;
    }

    public String deletePhoto(String photoName) {
        Photo photo = getPhoto(photoName);
        if (photo == null) {
            return "Photo not found";
        }
        photoRepository.deletePhoto(photo);
        return "Photo deleted";
    }


}
