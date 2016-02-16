/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Guinness
 */
import com.sun.comm.Win32Driver;
import java.io.*;
import java.util.*;
import javax.comm.*;

public class GSMConnect implements SerialPortEventListener,
        CommPortOwnershipListener {

    private static String comPort = "COM5";
    private String messageString = "";
    private CommPortIdentifier portId = null;
    private Enumeration portList;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private SerialPort serialPort;

    public GSMConnect(String comm) {
        GSMConnect.comPort = comm;

    }

    public boolean init() {
        Win32Driver w32Driver = new Win32Driver();
        w32Driver.initialize();
        portList = (Enumeration) CommPortIdentifier.getPortIdentifiers();
        if (portList.hasMoreElements() == false) {
            System.out.println("No ports Available");
        } else {
            System.out.println("Listing ports : ");
        }
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();

            System.out.println("Port Name : " + portId.getName());

            if (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
                System.out.println("\tType : " + portId.getPortType() + " Parallel Port ");

            } else if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println("\tType : " + portId.getPortType() + " Serial Port ");
                if (portId.getName().equals("COM5")) {
                    try {

                        serialPort = (SerialPort) portId.open("GSMConnect", 500);

                    } catch (Exception e) {
                        System.out.println("ERRRRRRRRRRRRRRRRRR");
                    }

                }

            }

            if (portId.isCurrentlyOwned()) {
                System.out.println("\tOwner : " + portId.getCurrentOwner());
            } else {
                System.out.println("\tOwner : Not Owned");
            }

            System.out.println();
        }
        return true;
    }

    public void checkStatus() {
        send("AT+CREG?\r\n");
    }

    public void dial(String phoneNumber) {
        try {
            messageString = "ATD" + phoneNumber + ";\n\r";
            outputStream.write(messageString.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String cmd) {
        try {
            outputStream.write(cmd.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readMessage() {
        send("AT+CMGF=1 \r\n");
        send("AT+CMGL=\"" + "ALL" + "\"\r\n");
    }

    public void sendMessage(String phoneNumber, String message) {

        send("AT+CMGF=1 \r\n");
        send("AT+CMGS=\"" + phoneNumber + "\"\r\n");
        send(message + '\032');
    }

    public void hangup() {
        send("ATH\r\n");
    }

    public void connect() throws NullPointerException {
        if (portId != null) {

            portId.addPortOwnershipListener(this);
            try {
            } catch (Exception e) {
            }




            try {
                inputStream = serialPort.getInputStream();
                outputStream = serialPort.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                /**
                 * These are the events we want to know about
                 */
                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);
            } catch (TooManyListenersException e) {
                throw new RuntimeException(e);
            }

//Register to home network of sim card

            send("ATZ\r\n");

        } else {
            throw new NullPointerException("COM Port not found!!");
        }
    }

    @Override
    public void serialEvent(javax.comm.SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            case SerialPortEvent.DATA_AVAILABLE:

                byte[] readBuffer = new byte[2048];
                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);
                    }
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    StringBuilder out = new StringBuilder();
//                    String newLine = System.getProperty("line.separator");
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        out.append(line);
//                        out.append(newLine);
//                    }
//                    System.out.println(out.toString() + " asdasdasdasd");
                    System.out.print(new String(readBuffer));
                } catch (IOException e) {
                }
                break;
        }
    }

    @Override
    public void ownershipChange(int type) {
        switch (type) {
            case CommPortOwnershipListener.PORT_UNOWNED:
                System.out.println(portId.getName() + ": PORT_UNOWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNED:
                System.out.println(portId.getName() + ": PORT_OWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED:
                System.out.println(portId.getName() + ": PORT_INUSED");
                break;
        }

    }

    public void deleteMessage(int index) {
        send("AT+CMGD=" + index + " \r\n");
    }

    public static void main(String args[]) {
        GSMConnect gsm = new GSMConnect(comPort);
        if (gsm.init()) {
            try {
                gsm.connect();
                gsm.checkStatus();
                Thread.sleep(5000);
                gsm.readMessage();
//                String phonenumber = "222";
//                String phonenumber = "+639173697277";
//                String message = "BAL4";
//                gsm.sendMessage(phonenumber, message);
                gsm.hangup();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Can't init this card");
        }
    }
}