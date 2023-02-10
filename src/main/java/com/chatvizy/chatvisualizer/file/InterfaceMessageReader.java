package com.chatvizy.chatvisualizer.file;

import com.chatvizy.chatvisualizer.model.Message;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public interface InterfaceMessageReader {
    //reads a file, processes it into a list and returns it
    List<Message> readFile(InputStream inputStream)
            throws FileNotFoundException;
}

