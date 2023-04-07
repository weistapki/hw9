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
    public List<FileData> filterBySize(int findSize) {
        List<FileData> result = new ArrayList<>();

        for (List<FileData> allFile : files.values()) {
            for (FileData file : allFile) {
                if (file.getSize() <= findSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }
    public void remove(String path) {
        if(files.containsKey(path)) {
            files.remove(path);
        } else {
            System.out.println("Path not found");
        }
    }
    public List<FileData> sortBySize() {
        Collection<List<FileData>> values = files.values();
        ArrayList<FileData> files = new ArrayList<>();
        for (List<FileData> file : values) {files.addAll(file);
        }
        files.sort(Comparator.comparing(FileData::getSize));
        return files;
    }
    @Override
    public String toString() {
        return "FileNavigator{" +
                "files=" + files +
                '}';
    }
}
