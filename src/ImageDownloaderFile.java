import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageDownloaderFile {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Пользователь\\Documents\\downloadImage\\pathImage.txt"; // Путь к файлу с ссылками
        String saveDirectory = "C:\\Users\\Пользователь\\Documents\\downloadImage\\";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String imageUrl = line;
                String fileName = "Image.jpg"; // Можно задать разное имя для каждой музыки
                String savePath = saveDirectory + fileName;
                downloadImage(imageUrl, savePath);
            }
        }
    }

    private static void downloadImage(String imageUrl, String savePath) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream()) {
            Files.copy(in, new File(savePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
