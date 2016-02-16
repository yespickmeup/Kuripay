/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.sun.comm.Win32Driver;
import java.io.*;
import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEventListener;

/**
 *
 * @author Guinness
 */
public class JavaApplication1 {

    static SerialPort serialPort;
    static OutputStream outputStream;
    CommPortIdentifier portId = null;

    private void getPorts() {
        System.out.println("getPorts called!!");
        try {

            Win32Driver w32Driver = new Win32Driver();
            w32Driver.initialize();
            Enumeration portList = (Enumeration) CommPortIdentifier.getPortIdentifiers();
            if (portList.hasMoreElements() == false) {
                System.out.println("No ports Available");
            } else {
                System.out.println("Listing ports : ");
            }
            while (portList.hasMoreElements()) {
                portId = (CommPortIdentifier) portList.nextElement();

                System.out.println("Port Name : " + portId.getName());

                // Print the type of the port : 1 - Serial , 2 - Parallel
                //
                if (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
                    System.out.println("\tType : " + portId.getPortType() + " Parallel Port ");

                } else if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    System.out.println("\tType : " + portId.getPortType() + " Serial Port ");
                    if (portId.getName().equals("COM5")) {
                        try {
                            //if (portId.getName().equals("/dev/term/a")) {
                            serialPort = (SerialPort) portId.open("JavaApplication1", 500);
                            
                        } catch (Exception e) {
                            System.out.println("ERRRRRRRRRRRRRRRRRR");
                        }

                    }

                }
                // Print the current owner of the port if Available
                //
                if (portId.isCurrentlyOwned()) {
                    System.out.println("\tOwner : " + portId.getCurrentOwner());
                } else {
                    System.out.println("\tOwner : Not Owned");
                }

                System.out.println();
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
    InputStream inputStream;

    public static void main(String a[]) {
        try {
            new JavaApplication1().getPorts();
            JavaApplication1 j = new JavaApplication1();
            j.getPorts();

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
