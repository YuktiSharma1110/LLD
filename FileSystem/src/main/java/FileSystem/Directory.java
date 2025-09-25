package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem
{
    String directoryName;
    List<FileSystem> fileSystemList;

    Directory(String dirName)
    {
        this.directoryName = dirName;
        fileSystemList = new ArrayList<>();
    }
    public void add(FileSystem fileSystemObj)
    {
        fileSystemList.add(fileSystemObj);
    }

    public void ls()
    {
        System.out.println("Directory name is " + directoryName);
        System.out.println("Files inside this " +directoryName+ "directory are: " );

        for(FileSystem fileObj : fileSystemList)
        {
            fileObj.ls();
        }
    }
}
