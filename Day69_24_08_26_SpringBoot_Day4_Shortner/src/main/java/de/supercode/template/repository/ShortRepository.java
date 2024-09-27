package de.supercode.template.repository;

import de.supercode.template.entity.UserUrl;
import org.springframework.stereotype.Component;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class ShortRepository {

    private static final String FILE_NAME = "shortURL.repo";

    private List<UserUrl> userUrlList;



    public ShortRepository(List<UserUrl> userUrlList) {
        this.userUrlList = userUrlList;
        loadFromFile();
    }



    public List<UserUrl> getUserUrlList() {
        return userUrlList;
    }

    public void addUrl(UserUrl userUrl) {
        userUrlList.add(userUrl);
        saveToFile();
    }


    public UserUrl findByShortURL(String shortUrl) {
        return userUrlList.stream()
                .filter(url -> url.getShortUrl().equals(shortUrl))
                .findFirst()
                .orElse(null);
    }

    private void saveToFile() {
       try (FileOutputStream fileOutput = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
           objectOutput.writeObject(userUrlList);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (FileInputStream fileInput = new FileInputStream(FILE_NAME);
                 ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
                userUrlList = (List<UserUrl>) objectInput.readObject();
                System.out.println(userUrlList.size() + " URL's eingelesen");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            userUrlList = new ArrayList<>();
            System.out.println("Neue Datei wird erstellt");
        }
    }
}
