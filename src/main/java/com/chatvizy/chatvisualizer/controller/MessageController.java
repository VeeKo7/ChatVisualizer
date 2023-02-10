package com.chatvizy.chatvisualizer.controller;

import com.chatvizy.chatvisualizer.file.WhatsUpMessageReader;
import com.chatvizy.chatvisualizer.model.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create apis for different requests.
 * */

@RestController
@RequestMapping(value = "api/v1")
public class MessageController {
    @PostMapping("/post/file")
    public List<Message> handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {
        WhatsUpMessageReader whatsUpMessageReader = new WhatsUpMessageReader();
        List<Message> messages = whatsUpMessageReader.readFile(file.getInputStream());
        return messages;
    }

    @PostMapping("/post/file/users")
    public Set<String> handleFileUploadUsers(@RequestParam("file") MultipartFile file,
                                          RedirectAttributes redirectAttributes) throws IOException {
        WhatsUpMessageReader whatsUpMessageReader = new WhatsUpMessageReader();
        List<Message> messages = whatsUpMessageReader.readFile(file.getInputStream());

        Set<String> users = new HashSet<>();

        for (Message message : messages) {
            users.add(message.getUserName());
        }

        return users;
    }

    @GetMapping("/test")
    public String add(@RequestParam("firstNumber") String a, @RequestParam String b) {
        int aNum = Integer.parseInt(a);
        int bNum = Integer.parseInt(b);
        int sum = aNum + bNum;
        String sumString = String.valueOf(sum);
        return sumString;
    }
}
