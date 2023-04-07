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
    public List<String> find(String path) {
        List<String> namesToReturn = new ArrayList<>();

        if (files.containsKey(path)) {
            for (FileData elem : files.get(path)) {
                namesToReturn.add(elem.getFileName());
            }
        } else {
            System.out.printf("File path %s is not found in the file storage!%n", path);
        }
        return namesToReturn;
    }
    @Override
    public String toString() {
        return "FileNavigator{" +
                "files=" + files +
                '}';
    }
}
