/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Francisco Maldonado
 */
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileService {

    public static final String SAVE_LOCATION = "C:/wamp64/www/archivosVIALIS/";
    public static final String SAVE_LOCATION_COTIZACION = "C:/wamp64/www/archivosCotizacionVIALIS/";

    public String saveFile(MultipartFile multipartFile) {

        String result = null;

        String fileName = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION;

        File pathFile = new File(location);

        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        pathFile = new File(location + fileName);

        try {

            multipartFile.transferTo(pathFile);
            result = pathFile.toString();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileName;
    }

    public String saveFileCotizacion(MultipartFile multipartFile) {

        String result = null;

        String fileName = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION_COTIZACION;

        File pathFile = new File(location);

        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        pathFile = new File(location + fileName);

        try {

            multipartFile.transferTo(pathFile);
            result = pathFile.toString();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileName;
    }

}
