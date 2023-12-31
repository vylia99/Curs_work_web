package com.example.demo1711.beans;

import com.example.demo1711.dao.ClientDao;
import com.example.demo1711.dao.PetDao;
import com.example.demo1711.data.Client;
import com.example.demo1711.data.Pet;
import com.example.demo1711.util.CommonUtils;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ClientBean implements Serializable {
    @EJB
    ClientDao clientDao;
    @EJB
    PetDao petDao;
    @Inject
    CommonUtils utils;

    @Getter    @Setter
    private Client client = new Client();
    @Getter    @Setter
    private Pet petForAdd = new Pet();

    @Getter @Setter
    private Client selectedClient;
    @Getter @Setter
    private String petKind;
    @Getter @Setter
    private List<Object[]> clientsByPetKind;

    public List<Client> getClientList() {
        return clientDao.findAll();
    }

    public void add() {
        clientDao.add(client);
        client = new Client();
    }

    public void delete(int id) {
        clientDao.delete(id);
    }

    public String showPets(int clientId) {
        selectedClient = clientDao.find(clientId);
        return "client";
    }

    public String edit(int id) {
        client = clientDao.find(id);
        return "client_edit";
    }

    public String update() {
        clientDao.update(client);
        client = new Client();
        return "index";
    }

    public void addPet() {
      petForAdd.setClient(selectedClient);
     // petDao.findByName(petKind);
      petDao.add(petForAdd);
      petForAdd = new Pet();
      selectedClient = clientDao.find(selectedClient.getId());
        utils.redirectWithGet();
    }
  /*  public void addVisit() {
        visitForAdd.setMedicalService(medicalServiceDao.findByName(medicalServiceStr));
        visitForAdd.setPet(currentPet);
        visitDao.add(visitForAdd);

        currentPet = petDao.find(currentPet.getId());
        currentPet.getVisits().add(visitForAdd);
        visitForAdd = new Visit();
        utils.redirectWithGet();
    }*/
    public List<Pet> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Pet> kindsList = petDao.findAll();

        return kindsList.stream().filter(t -> t.getKind().toLowerCase().startsWith(queryLowerCase)).toList();
    }


    public void searchClientsByPetKind() {
        clientsByPetKind = clientDao.getClientsByPetKind(petKind);
    }
}
