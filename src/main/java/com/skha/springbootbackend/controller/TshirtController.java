package com.skha.springbootbackend.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.skha.springbootbackend.model.Tshirt;
import com.skha.springbootbackend.service.ItemService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tshirts" , produces = MediaType.APPLICATION_JSON_VALUE)
public class TshirtController {

  final  String COLLECTION_NAME = "Tshirts";


    @Autowired
    private ItemService tshirtsService;

    List<Tshirt> tshirtsList = new ArrayList<>();

    @GetMapping()
    //@Operation(summary = "Returns A Director Document Corresponding To Providied Id")
    public List<Tshirt> TshirtRetrieveAlHandler() throws ExecutionException, InterruptedException {
        return  tshirtsService.getAllItems(COLLECTION_NAME);
    }
    @GetMapping("/fire")
    public List<Tshirt> retrieveAll(){
        Firestore firestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.get();

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();

            return queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(Tshirt.class))
                    .collect(Collectors.toList());

        } catch (InterruptedException | ExecutionException e) {

        }
        return Collections.<Tshirt>emptyList();

    }
    @GetMapping("/test")
    //@Operation(summary = "Returns A Director Document Corresponding To Providied Id")
    public List<Tshirt> test() throws ExecutionException, InterruptedException {
           ArrayList<String> fotos = new ArrayList<String>();
           fotos.add("foto1");
           fotos.add("foto2");
           Tshirt t1 = new Tshirt("name","brand1","34","34",fotos,"desc");
           Tshirt t2 = new Tshirt("name2","brand2","342","342",fotos,"desc2");

           tshirtsList.add(t1);
           tshirtsList.add(t2);
           return tshirtsList;
    }

    @GetMapping("/hello")
    //@Operation(summary = "Returns A Director Document Corresponding To Providied Id")
    public String sayhello() throws ExecutionException, InterruptedException {
        return  "hello";
    }

   /* @GetMapping()
    //@Operation(summary = "Returns A Director Document Corresponding To Providied Id")
    public List<Tshirt> TshirtRetrieveAlHandler() throws ExecutionException, InterruptedException {
        return  (List<Tshirt>)tshirtsService.getAllItems(COLLECTION_NAME, Tshirt.class);
    }

    @GetMapping(value = "/{tshirtName}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@Operation(summary = "Returns A Director Document Corresponding To Providied Id")
    public ResponseEntity<Tshirt> directorRetreivalHandler(@PathVariable(name = "tshirtName", required = true) final String directorId) {
        return ResponseEntity.ok((Tshirt) tshirtsService.getItemByName(directorId , COLLECTION_NAME, Tshirt.class));
    }


    @PostMapping()
   // @Operation(summary = "Creates A Director Document Inside Firebase And Returns It's Id")
    public Tshirt tshirtCreationHandler(@RequestBody Tshirt tshirt) throws JSONException {
        return (Tshirt) tshirtsService.createItem( tshirt, tshirt.getName(), COLLECTION_NAME );
    }

    @PutMapping(value = "/{tshirtName}" , produces = MediaType.APPLICATION_JSON_VALUE)
    // @Operation(summary = "Creates A Director Document Inside Firebase And Returns It's Id")
    public Tshirt tshirtUpdationHandler(@PathVariable(name = "tshirtName", required = true)final String id,
                                            @RequestBody Tshirt tshirt) throws JSONException {
        return (Tshirt) tshirtsService.updateItem( tshirt, id, COLLECTION_NAME );
    }*/

    @DeleteMapping(value = "/{tshirtName}", produces = MediaType.APPLICATION_JSON_VALUE)
   // @Operation(summary = "Deletes director and corresponding directorMovieMapping documents")
    public ResponseEntity<?> directorDocumentDeletionHandler(
            @PathVariable(required = true, name = "tshirtName") final String tshirtId) throws ExecutionException, InterruptedException {
        tshirtsService.deleteItem(tshirtId, COLLECTION_NAME);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

