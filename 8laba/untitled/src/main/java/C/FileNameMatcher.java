package C;

public class FileNameMatcher {
    public static boolean matches(String mask, String fileName) {
        String regex = mask.replace("?", ".?").replace("*", ".*");
        return fileName.matches(regex);
    }
}