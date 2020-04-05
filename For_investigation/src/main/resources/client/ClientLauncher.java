package java.client;


import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientLauncher {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getByName(args[0]);
            String port = args[1];

            //System.out.println(id);
            Client client = new Client(null, "host", "user", "domain", "pass".toCharArray());
            //Запускаем логику клиента


        } catch (UnknownHostException | NTLMException e) {
            e.printStackTrace();
        }
    }
}