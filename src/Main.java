public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData fileData1 = new FileData("files1.java", (byte) 5,"/path/java/files1");
        FileData fileData2 = new FileData("files2.java", (byte) 10,"/path/java/files2");
        FileData fileData3 = new FileData("files3.java", (byte) 15,"/path/java/files3");
        FileData fileData4 = new FileData("files4.java", (byte) 20,"/path/java/files4");
        FileData fileData5 = new FileData("files5.java", (byte) 25,"/path/java/files5");

        fileNavigator.add("/path/java/files1",fileData1);
        fileNavigator.add("/path/java/files2",fileData2);
        fileNavigator.add("/path/java/files3",fileData3);
        fileNavigator.add("/path/java/files4",fileData4);
        fileNavigator.add("/path/java/files5",fileData5);

        System.out.println();
        System.out.println("Result after using method add = " + fileNavigator);
        System.out.println();
        System.out.println("Result after using method find = " +
                fileNavigator.find("/path/java/files5"));
        System.out.println();
        System.out.println("Result after using method filterBySize = " + fileNavigator.filterBySize((byte) 10));
        System.out.println();
        fileNavigator.remove("/path/java/files5");
        System.out.println("Result after using method remove = " + fileNavigator);
    }
}
