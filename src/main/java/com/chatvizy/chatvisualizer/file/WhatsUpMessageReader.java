package com.chatvizy.chatvisualizer.file;

import com.chatvizy.chatvisualizer.model.Message;
import com.chatvizy.chatvisualizer.model.whatsapp.WhatsUpMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhatsappMessageReader implements InterfaceMessageReader {

    @Override
    public List<Message> readFile(InputStream inputStream) throws FileNotFoundException {

        //creating a variable to store our messages
        List<Message> listOfMessages = new ArrayList<>();
        //reading contents from a text file
        Scanner fileInput = new Scanner(inputStream);

        //as long there is a line to read
        while(fileInput.hasNextLine()) {

            //.nextLine() reads entire line when called
            //Ex: 12/14/22, 6:11 AM - vee: Hey Mr Amparo, long time no speak. How are you 😜
            String messageLine = fileInput.nextLine();

            //continue - skip messageLine if it is blank
            if (messageLine.isBlank()) {
                continue;
            }

            //Separated into 2:
            //12/14/22, 6:11 AM - vee: Hey Mr Amparo, long time no speak. How are you
            //1. 12/14/22, 6:11 AM
            //2.  vee: Hey Mr Amparo, long time no speak. How are you 😜
            String [] arr = messageLine.split("-");

            //Separate by ,
            //1. 12/14/22
            //2.  6:11 AM
            String [] dateTime = arr[0].split(",");

            //took date from dateTime array and trimmed spaces
            String date = dateTime[0].trim();

            //took time from dateTime array and trimmed spaces
            String time = dateTime[1].trim();

            //Separated by :
            //1.  vee:
            //2.  Hey Mr Amparo, long time no speak. How are you 😜
            String [] nameText = arr[1].split(":");

            //took name from nameText array and trimmed spaces
            String name = nameText[0].trim();

            //took text from nameText array and trimmed spaces
            String text = nameText[1].trim();

            //created a Message object and everything we extracted we stored in a list
            Message whatsappMessage = new WhatsUpMessage(date, time, name, text);
            listOfMessages.add(whatsappMessage);
        }

        return listOfMessages;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("test.txt");

        //created object
        WhatsappMessageReader whatsappMessageReader = new WhatsappMessageReader();
        //returns a list of messages
        List<Message> messages = whatsappMessageReader.readFile(new FileInputStream(file) {});
        //return a list of users
        List<String> users = whatsappMessageReader.readFile(new FileInputStream(file) {});

        //iter - shortcut for foreach loop creation
        for (Message message : messages) {
            System.out.println(message.getUserName());
            //System.out.println(message.getText());
            //System.out.println(message.getDate());
            //System.out.println(message.getTime());
        }


    }
}
