package com.skha.springbootbackend.service;

import com.google.cloud.firestore.*;


import com.google.firebase.cloud.FirestoreClient;
import com.skha.springbootbackend.model.Tshirt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;



@Service
@AllArgsConstructor
@Slf4j
public  class ItemService {

   // private final Firestore firestore;

   /* public T getItemByName(  final String name ,final String CollectionName, Class<T> clazz) {
        DocumentSnapshot retrievedItem = null;
        try {
            retrievedItem = firestore.collection(CollectionName).document(name).get().get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Unable to retreive director with id {}: {}", name, e);
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
        final var item = retrievedItem.exists() ? retrievedItem.toObject(clazz) : null;
        if (item == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return item;
    }


    public T createItem(T item , final String id ,final String CollectionName) throws JSONException {
        firestore.collection(CollectionName).document(id).set(item);
        return item;
    }

    public T updateItem (T item , final String id ,final String CollectionName) throws JSONException {
        final var response = new JSONObject();
        firestore.collection(CollectionName).document(id).set(item);

        return item;
    }

    public List<T> getAllItems(final String CollectionName , Class<T> clazz) throws ExecutionException, InterruptedException {

        List<T> itemList = new ArrayList<>();

        // Retrieve all products from the "products" collection in Firestore
        CollectionReference itemsCollection = firestore.collection(CollectionName);
        QuerySnapshot querySnapshot = itemsCollection.get().get();

        for (QueryDocumentSnapshot document : querySnapshot) {
            T item = document.toObject(clazz);
            itemList.add(item);
        }

        return itemList;
    }*/


    public List<Tshirt>getAllItems(final String CollectionName ) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        List<Tshirt> itemList = new ArrayList<>();

        // Retrieve all products from the "products" collection in Firestore
        CollectionReference itemsCollection = firestore.collection(CollectionName);
        QuerySnapshot querySnapshot = itemsCollection.get().get();

        for (QueryDocumentSnapshot document : querySnapshot) {
            Tshirt item = document.toObject(Tshirt.class);
            itemList.add(item);
        }

        return itemList;
    }


  /*  public Tshirt getItemByName(String name,final String CollectionName, Class<Tshirt> tshirtClass) {

        ApiFuture<DocumentSnapshot> future = firestore.collection(CollectionName).document(name).get();
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                return document.toObject(Tshirt.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions
        }
        return null;
    }*/


    public void deleteItem(final String ItemId ,final String collectionName) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection(collectionName).document(ItemId).delete();


    }


}



