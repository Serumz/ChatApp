package com.example.client;

import org.json.simple.JSONAware;

public abstract class Response implements JSONAware {
    public abstract Object toJSON();
    public String toJSONString() { return toJSON().toString(); }
    public String toString() { return toJSONString(); }
}
