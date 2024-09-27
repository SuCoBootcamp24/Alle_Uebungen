package de.supercode.fotomanagment.controller;


import de.supercode.fotomanagment.entity.Photo;
import de.supercode.fotomanagment.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/api/v1/photo")
public class PhotoController {

    PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping
    public List<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @GetMapping("/{photoName}")
    public ResponseEntity<Photo> getPhoto(@PathVariable String photoName) {
        Photo existPhoto = photoService.getPhoto(photoName);

        if (existPhoto == null) {
            return ResponseEntity.notFound().build();
        } else return new ResponseEntity<>(existPhoto, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public List<Photo> getPhotosByFiltering(@RequestParam String filter) {
        return photoService.getPhotosByFiltering(filter);
    }

    @GetMapping("/filterByPath")
    public List<Photo> getPhotosByPath(@RequestParam String path) {
        return photoService.getPhotosByPath(path);
    }

    @GetMapping("/sort")
    public List<Photo> getPhotosBySorting(@RequestParam Boolean ascending) {
        return photoService.getPhotosBySorting(ascending);
    }

    @PostMapping
    public boolean addPhoto(@RequestBody Photo newPhoto) {
        return photoService.addPhoto(newPhoto);
    }

    @PutMapping("/{photoName}")
    public boolean updatePhoto(@PathVariable String photoName, @RequestBody Photo photoJson) {
        return photoService.updatePhoto(photoName, photoJson);
    }

    @DeleteMapping("/{photoName}")
    public String deletePhoto(@PathVariable String photoName) {
        return photoService.deletePhoto(photoName);
    }
}
