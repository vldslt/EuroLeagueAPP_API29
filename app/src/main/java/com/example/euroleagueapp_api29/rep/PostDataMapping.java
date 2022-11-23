package com.example.euroleagueapp_api29.rep;

import java.util.HashMap;
import java.util.Map;

public class PostDataMapping {

    public static class Fields {
        public final static String TITLE = "title";
        public final static String PREDICT = "predict";
    }

    public static CardData toPostData(String id, Map<String, Object> doc) {
        CardData answer = new CardData(
                (String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.PREDICT));
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(CardData cardData){
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, cardData.getTitle());
        answer.put(Fields.PREDICT, cardData.getPredict());
        return answer;
    }
}
