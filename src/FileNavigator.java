import java.util.*;




public class FileNavigator {
    private final Map<String, List<FileData>> files = new HashMap<>();

    public void add(String path, FileData newFile) {
        if (!path.equals(newFile.getPathToFile())) {
            System.out.printf("This path doesn't match the file path" + newFile.getFileName());
        } else if (files.containsKey(path)) {
            files.get(path).add(newFile);
        } else {
            List<FileData> file = new ArrayList<>();
            file.add(newFile);
            files.put(path, file);
        }
    }
    @Override
    public String toString() {
        return "FileNavigator{" +
                "files=" + files +
                '}';
    }
}
