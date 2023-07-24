package org.repository;

import org.entity.Client;
import org.entity.Role;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepositoryClient {
    private final String path = "D:\\It_AcademySpring\\Project\\src\\main\\resources\\ListClient";
    private List<Client> clientList;

    public RepositoryClient() {
        this.clientList = new ArrayList<>();
    }

    public void saveClient(Client client) {
        clientList = loadClient();
        if (loadClient().size() > 0) {
            Optional<Client> optional = loadClient().stream().max(Comparator.comparing(Client::getId));
            client.setId(optional.get().getId() + 1);
            client.setRole(Role.CLIENT);
        } else {
            client.setId(0);
            client.setRole(Role.ADMIN);
        }
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            clientList.add(client);
            stream.writeObject(clientList);
        } catch (Exception e) {

        }
    }

    public List<Client> getClientList() {
        return loadClient();
    }

    private List<Client> loadClient() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            clientList = (List<Client>) objectInputStream.readObject();
        } catch (Exception e) {

        }
        return clientList;
    }
}
