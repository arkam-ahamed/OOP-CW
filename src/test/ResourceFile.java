package test;

import org.junit.rules.ExternalResource;

import java.io.File;

public class ResourceFile extends ExternalResource
{
    File file = new File("skin_care_center.txt");

    public File getFile()
    {
        return file;
    }
}
