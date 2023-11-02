import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class ImageDownloaderKeyboard {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL картинки: ");
        String imageUrl = scanner.nextLine();

        String fileName = "Image.jpg";
        String savePath = "C:\\Users\\Пользователь\\Documents\\downloadImage\\" + fileName;
        downloadImage(imageUrl, savePath);
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
