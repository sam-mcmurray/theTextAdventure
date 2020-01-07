package project1E7.Model;

import com.google.gson.Gson;
import project1E7.GameManager;

import java.io.File;

public class Load {
    File file;
    String fileName;

    public Load(File file, String fileName) {
        this.file = file;
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
