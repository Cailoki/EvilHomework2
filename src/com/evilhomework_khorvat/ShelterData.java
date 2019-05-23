package com.evilhomework_khorvat;

import com.evilhomework_khorvat.interfaces.DogsLoadedListener;
import com.evilhomework_khorvat.interfaces.StorageLoadedListener;
import com.evilhomework_khorvat.models.Dog;
import com.evilhomework_khorvat.models.StorageEntry;
import com.evilhomework_khorvat.utilities.DogParser;
import com.evilhomework_khorvat.utilities.FileReader;
import com.evilhomework_khorvat.utilities.StorageParser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShelterData implements DogsLoadedListener, StorageLoadedListener {
    private Integer foodReserve = 0;
    private List<StorageEntry> storage;
    private List<Dog> dogs;
    private Map<String,StorageEntry> shelterMap = new LinkedHashMap<>();
    private String[] paths; //[0]->dogs, [1]->storage

    //Load data(animals/storage)
    public ShelterData loadData(String[] paths){
        this.paths = paths;
        loadDogs();
        return this;
    }

    //Getters
    public List<StorageEntry> getStorage() {
        return storage;
    }
    public List<Dog> getDogs() {
        return dogs;
    }
    public Integer getFoodReserve() {
        return foodReserve;
    }

    //Setters
    public void setFoodReserve(Integer foodReserve) {
        this.foodReserve += foodReserve;
    }

    private void loadDogs(){
        try{
            dogs = new FileReader<>(new DogParser()).readFromFile(paths[0]);
            onDogsLoaded();
        } catch (Exception e){
            onError(e);
        }
    }

    public void onDogsLoaded(){
        System.out.println("Dogs loaded successfully.");
        loadStorage();
    }

    private void onError(Exception e){
        System.out.println("Error reading data from file, please rerun app with correct parameters:\n " + e);
    }

    private void loadStorage(){
        try{
            storage = new FileReader<>(new StorageParser()).readFromFile(paths[1]);
            onStorageLoaded();
        } catch (Exception e){
            onError(e);
        }
    }

    public void onStorageLoaded(){
        System.out.println("Storage loaded successfully.");
        calculateFoodReserves();
        forgeMap();
    }

    private void calculateFoodReserves(){
        for (StorageEntry storageEntry : storage) {
            foodReserve += storageEntry.getFoodReserve();
        }
    }

    private void forgeMap(){
        for (int i=0; i<dogs.size(); i++) {
            shelterMap.put(dogs.get(i).getBreed(), storage.get(i));
        }
    }
}
