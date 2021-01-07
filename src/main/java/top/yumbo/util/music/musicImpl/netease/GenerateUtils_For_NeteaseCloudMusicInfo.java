package top.yumbo.util.music.musicImpl.netease;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 *
 */
public class GenerateUtils_For_NeteaseCloudMusicInfo {
    public static void main(String[] args) throws IOException {
        String absolutePath = System.getProperty("user.dir") + "/src/main/java/top/yumbo/util/music/musicImpl/netease/README.md";
        System.out.println(absolutePath);
        final File file = new File(absolutePath);

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null) {

            if (line.startsWith("### ")) {
                count = 1; // 开始获取
            } else {
                count = 2;
            }

            if (count == 1) {
                System.out.println(line);
            } else if (count == 2) {
                count = 1;
            }
        }
        br.close();


    }
}
