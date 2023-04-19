import java.util.*;




public class FileNavigator {
    private final Map<String, List<FileData>> files = new HashMap<>();

    public void add(String path, FileData file) {
        if (!path.equals(file.getPathToFile())) {
            System.out.printf("This path doesn't match the file path" + file.getFileName());
        } else if (files.containsKey(path)) {
            files.get(path).add(file);
        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(file);
            files.put(path, fileList);
        }
    }
    public List<String> find(String path) {
        List<String> result = new ArrayList<>();

        if (files.containsKey(path)) {
            for (FileData file : files.get(path)) {
                result.add(file.getFileName());
            }
        } else {
            System.out.printf("File path %s is not found in the file storage!%n", path);
        }
        return result;
    }
    public List<FileData> filterBySize(int size) {
        List<FileData> result = new ArrayList<>();

        for (List<FileData> filesValues : files.values()) {
            for (FileData file : filesValues) {
                if (file.getSize() <= size) {
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
        Collection<List<FileData>> sortedFiles = files.values();
        ArrayList<FileData> files = new ArrayList<>();
        for (List<FileData> file : sortedFiles) {files.addAll(file);
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
