package com.example.euroleagueapp_api29.rep;

import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.example.euroleagueapp_api29.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemoteFireStoreRepositoryImpl implements CardSourse {

    private static final String POSTS_COLLECTION = "posts";
    private List<CardData> dataSourse;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(); // создание фаерстора
    CollectionReference collectionReference = firebaseFirestore.collection(POSTS_COLLECTION); // ссылка на коллекцию внутри фаерстора

    public RemoteFireStoreRepositoryImpl(Resources resources){
        dataSourse = new ArrayList<CardData>();
    }

    public RemoteFireStoreRepositoryImpl init(RemoteFireStoreResponse remoteFireStoreResponse) {
        collectionReference.orderBy(PostDataMapping.Fields.TITLE, Query.Direction.ASCENDING).get().addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if ( task.isSuccessful()) {
                            dataSourse = new ArrayList<CardData>(); // обнуление
                            for(QueryDocumentSnapshot queryDocumentSnapshot:task.getResult()){
                                Map<String, Object> document = queryDocumentSnapshot.getData();
                                String id = queryDocumentSnapshot.getId();
                                dataSourse.add(PostDataMapping.toPostData(id,document));
                            }
                        }
                        remoteFireStoreResponse.initialized(RemoteFireStoreRepositoryImpl.this);
                    }
                }
        );
        return this;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<CardData> getAllCardsData() {
        return null;
    }

    @Override
    public CardData getCardData(int position) {
        return null;
    }

    @Override
    public void addCardData(CardData cardData) {

    }

    @Override
    public void makePredict(int position, CardData newCardData) {

    }
}