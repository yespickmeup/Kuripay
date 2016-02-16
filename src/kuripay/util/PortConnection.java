/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuripay.util;

import com.sun.comm.Win32Driver;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;

/**
 *
 * @author Guinness
 */
public class PortConnection implements SerialPortEventListener,
        CommPortOwnershipListener {

    private static String comPort = "COM8";
    private String messageString = "";
    private CommPortIdentifier portId = null;
    private Enumeration portList;
    private static InputStream inputStream = null;
    private static OutputStream outputStream = null;
    private static SerialPort serialPort;
    public static List<String> list;

    public PortConnection(String comm) {
        PortConnection.comPort = comm;
        PortConnection.list = new CopyOnWriteArrayList();
    }

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        PortConnection.list = list;
    }

    public static void hangup() {
        send("ATH\r\n");
    }

    public static void send(String cmd) {
        try {
            outputStream.write(cmd.getBytes());
//            outputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        portId.removePortOwnershipListener(this);
    }

    public static void sendMessage(String phoneNumber, String message) {
        send("AT+CMGF=1 \r\n");
        send("AT+CMGS=\"" + phoneNumber + "\"\r\n");
        send(message + '\032');
    }
    public static String output = "";

    public static void readMessage() {
        System.out.println("Reading message...");
        send("AT+CMGF=1 \r\n");
        send("AT+CMGL=\"" + "ALL" + "\"\r\n");

    }

    public void checkStatus() {
        System.out.println("Checking status...");
        send("AT+CREG?\r\n");
    }

    public static void deleteMessage(int index) {
        send("AT+CMGD=" + index + " \r\n");
    }
    static boolean ready = false;

    public static void main(String[] args) {
        final PortConnection gsm = new PortConnection(comPort);
        if (gsm.init()) {
            try {
                gsm.connect();
                gsm.checkStatus();
                PortConnection.list.clear();
                PortConnection.readMessage();
                gsm.hangup();

                Thread.sleep(3000);
                System.out.println("-----------start message-----------");
                List<String> datas = PortConnection.list;
                for (String s : datas) {
                    System.out.println(s);
                }
                System.out.println("-----------end message-----------");
                System.exit(1);

//                String phonenumber = "222";
                String phonenumber = "+639261625529";
                String message = "BAL";
//                gsm.sendMessage(phonenumber, message);
//                get_messages();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Can't init this card");
        }
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
                        serialPort = (SerialPort) portId.open("PortConnection", 500);
                    } catch (Exception e) {
                        throw new RuntimeException(e);

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
                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);
            } catch (TooManyListenersException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connected...");
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

                final byte[] readBuffer = new byte[2048];
                String aw = "";

                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);

                    }
//                    System.out.println(new String(readBuffer));
                    List<String> e = new ArrayList();
                    e.add(new String(readBuffer));
                    list.addAll(e);
                } catch (IOException ex) {
                    Logger.getLogger(PortConnection.class.getName()).log(Level.SEVERE, null, ex);
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
//    public static String get_messages() {
//
////        send("AT+CMGF=1 \r\n");
////        String message = send("AT+CMGL=\"" + "ALL" + "\"\r\n");
//        return message;
//    }
}
