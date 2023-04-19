

public class FileData {
    private final String fileName;
    private final byte size;
    private final String pathToFile;

    public FileData(String fileName, byte size, String pathToFile) {
        this.fileName = fileName;
        this.size = size;
        this.pathToFile = pathToFile;
    }

    public String getFileName() {
        return fileName;
    }

    public byte getSize() {
        return size;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", size=" + size +
                ", pathToFile='" + pathToFile + '\'' +
                '}';
    }
}
