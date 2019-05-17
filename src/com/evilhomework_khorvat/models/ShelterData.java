package com.evilhomework_khorvat.models;

import com.evilhomework_khorvat.interfaces.DogsLoadedListener;
import com.evilhomework_khorvat.interfaces.StorageLoadedListener;
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

    public Integer getFoodReserve() {
        return foodReserve;
    }

    public void loadDogs(String[] path){
        try{
            dogs = new FileReader(new DogParser()).readFromFile(path[0]);
            onDogsLoaded(path[1]);
        } catch (Exception e){
            onError(e);
        }
    }

    public List<StorageEntry> getStorage() {
        return storage;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void onDogsLoaded(String path){
        System.out.println("Dogs loaded successfully.");
        loadStorage(path);
    }

    private void onError(Exception e){
        System.out.println("Error reading report: " + e);
    }

    private void loadStorage(String path){
        try{
            storage = new FileReader(new StorageParser()).readFromFile(path);
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
        for(int i = 0; i < storage.size(); ++i){
            foodReserve += storage.get(i).getFoodReserve();
        }
    }

    private void forgeMap(){
        for (int i=0; i<dogs.size(); i++) {
            shelterMap.put(dogs.get(i).getBreed(), storage.get(i));
        }
    }

    public void setFoodReserve(Integer foodReserve) {
        this.foodReserve += foodReserve;
    }
}
