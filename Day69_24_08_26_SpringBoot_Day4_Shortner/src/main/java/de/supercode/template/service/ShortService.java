package de.supercode.template.service;

import de.supercode.template.dtos.UserUrlDto;
import de.supercode.template.entity.UserUrl;
import de.supercode.template.repository.ShortRepository;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class ShortService {

    ShortRepository shortRepository;

    public ShortService(ShortRepository shortRepository) {
        this.shortRepository = shortRepository;
    }

    // Generiert die Short URL und speichert sie in der Repository
    public String makeItShort(UserUrlDto dto) {
        UserUrl newUserURL = new UserUrl();
        String longURL = dto.getLongUrl();
        newUserURL.setLongUrl(longURL);
        newUserURL.setShortUrl(generateShortUrl(longURL));
        shortRepository.addUrl(newUserURL);
        return newUserURL.getShortUrl();
    }


    public UserUrlDto getUserUrl(String shortUrl) {
        UserUrl existUserUrl = shortRepository.findByShortURL(shortUrl);
        if (existUserUrl == null) {
            return null;
        }
        UserUrlDto dto = new UserUrlDto();
        dto.setLongUrl(existUserUrl.getLongUrl());
        dto.setShortUrl(existUserUrl.getShortUrl());
        return dto;

    }

    // Generiert eine Short URL basierend auf einem Hashwert
    private String generateShortUrl(String longUrl) {
        // SecureRandom für die Erzeugung eines zufälligen Werts verwenden
        SecureRandom random = new SecureRandom();
        int randomInt = random.nextInt();

        // Kombiniere die lange URL mit einem zufälligen Wert
        String input = longUrl + randomInt;

        // SHA-256 Hash der kombinierten Eingabe erzeugen und in einen hexadezimalen String konvertieren
        String hexHash = Hex.encodeHexString(DigestUtils.sha256(input));

        // Kürze den Hash auf die ersten 6 Zeichen (3 Bytes)
        String shortUrl = hexHash.substring(0, 6);

        // Kollisionsprüfung
        while (shortRepository.findByShortURL(shortUrl) != null) {
            // Wenn die generierte URL bereits existiert, nimm einen neuen Zufallswert
            randomInt = random.nextInt();
            input = longUrl + randomInt;
            hexHash = Hex.encodeHexString(DigestUtils.sha256(input));
            shortUrl = hexHash.substring(0, 6);
        }

        return shortUrl;
    }
}