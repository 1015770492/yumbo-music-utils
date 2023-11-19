package top.yumbo.util.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CommandUtil {
    /**
     * 执行CMD命令,并返回String字符串
     */
    public static String executeCmd(String strCmd) throws Exception {
        Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
        StringBuilder sbCmd = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
        String line;
        while ((line = br.readLine()) != null) {
            sbCmd.append(line + "\n");
        }
        return sbCmd.toString();
    }
}
