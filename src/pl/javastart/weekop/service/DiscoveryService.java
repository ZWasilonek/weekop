package pl.javastart.weekop.service;

import pl.javastart.weekop.dao.DiscoveryDAO;
import pl.javastart.weekop.dao.factory.DAOFactory;
import pl.javastart.weekop.model.Discovery;
import pl.javastart.weekop.model.User;

import java.sql.Timestamp;
import java.util.Date;

public class DiscoveryService {

    public void addDiscovery(String name, String description, String url, User user) {
        Discovery discovery = createDiscovery(name, description, url, user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        DiscoveryDAO discoveryDAO = factory.getDiscoveryDAO();
        discoveryDAO.create(discovery);
    }

    private Discovery createDiscovery(String name, String description, String url, User user) {
        Discovery discovery = new Discovery();
        discovery.setName(name);
        discovery.setDescription(description);
        discovery.setUrl(url);
        User copyUser = new User(user);
        discovery.setUser(copyUser);
        discovery.setTimestamp(new Timestamp(new Date().getTime()));
        return discovery;
    }

}