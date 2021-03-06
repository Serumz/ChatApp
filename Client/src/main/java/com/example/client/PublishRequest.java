package com.example.client;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class PublishRequest extends Request{
    private static final String _class = PublishRequest.class.getSimpleName();
    private final String identity; // Client
    private final String to; // Channel
    private final Message message;

    public PublishRequest(String identity, String to, Message message){
        this.identity = identity;
        this.to = to;
        this.message = message;
    }

    public String getIdentity() { return identity; }
    public String getTo() { return to; }
    public Message getMessage() { return message; }

    @SuppressWarnings("unchecked")
    public Object toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("_class", _class);
        jsonObject.put("identity", identity);
        jsonObject.put("to", to);
        jsonObject.put("message", message.toJSONString());
        return jsonObject;
    }

    // TODO: 22/12/2021 REMOVE FROM METHOD SINCE THE CLIENT DOESNT NEED IT
    public static PublishRequest fromJSON(JSONObject jsonObject){
        String identity = (String) jsonObject.get("identity");
        String to = (String) jsonObject.get("to");
        Message message = Message.fromJSON((JSONObject) JSONValue.parse((String)jsonObject.get("message")));
        return new PublishRequest(identity, to, message);
    }
}